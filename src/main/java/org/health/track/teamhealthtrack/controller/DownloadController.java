package org.health.track.teamhealthtrack.controller;

import lombok.RequiredArgsConstructor;
import org.apache.commons.io.output.ByteArrayOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.health.track.teamhealthtrack.config.ReflectionExample;
import org.health.track.teamhealthtrack.dto.TeamReportDTO;
import org.health.track.teamhealthtrack.entity.AppUser;
import org.health.track.teamhealthtrack.entity.ManagerUser;
import org.health.track.teamhealthtrack.entity.TeamReport;
import org.health.track.teamhealthtrack.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class DownloadController {

	private final UserService userService;
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	@GetMapping("/downloadExcel")
	public ResponseEntity<byte[]> downloadExcelFile(Authentication authentication) throws IOException {
		byte[] excelFileContent = generateExcelContent(authentication.getName());

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "example.xlsx");

		return new ResponseEntity<>(excelFileContent, headers, HttpStatus.OK);
	}

	public byte[] generateExcelContent(String name) throws IOException {
		var managerByUserName = userService.getManagerByUserName(name);

		try (Workbook workbook = new XSSFWorkbook()) {
			CellStyle cellStyle = workbook.createCellStyle();
			CellStyle headerStyle = workbook.createCellStyle();
			Font boldFont = workbook.createFont();
			boldFont.setBold(true);
			headerStyle.setFont(boldFont);
			headerStyle.setAlignment(HorizontalAlignment.CENTER);
			cellStyle.setAlignment(HorizontalAlignment.CENTER);

			Sheet sheet = workbook.createSheet("TeamReports");
			List<String> allFields = ReflectionExample.getAllFields(TeamReportDTO.class);
			Map<String, List<TeamReport>> groupedReports = managerByUserName.getTeammates()
					.stream()
					.flatMap(appUser -> appUser.getUserReports().stream())
					.collect(Collectors.groupingBy(report -> report.getAppUser().getUsername()));

			final int[] headerCellIndex = {1};
			final int[] headerRowIndex = {1};
			final int[] rowIndexStart = {1};
			final int[] cellIndexStart = {1};
			final int[] rowIndex = {rowIndexStart[0]};
			Row headerRow = sheet.createRow(0);
			for (String fieldName : allFields) {
				Row row = Objects.nonNull(sheet.getRow(headerRowIndex[0])) ? sheet.getRow(headerRowIndex[0]) :
						sheet.createRow(headerRowIndex[0]);
				Cell cell = row.createCell(0);
				cell.setCellStyle(headerStyle);
				cell.setCellValue(fieldName);
				headerRowIndex[0]++;

			}
			groupedReports.forEach((userName, teamReports) -> {
				for (int i = headerCellIndex[0]; i < headerCellIndex[0] + teamReports.size(); i++) {
					headerRow.createCell(i);
				}
				Cell headerCell = headerRow.getCell(headerCellIndex[0]);
				headerCell.setCellStyle(headerStyle);
				headerCell.setCellValue(userName);
				if (teamReports.size() > 1) {
					sheet.addMergedRegion(new CellRangeAddress(0, 0, headerCellIndex[0],
							headerCellIndex[0] + teamReports.size() - 1));
				}

				for (TeamReport report : teamReports) {
					for (String fieldName : allFields) {
						Row row = Objects.nonNull(sheet.getRow(rowIndex[0])) ? sheet.getRow(rowIndex[0]) :
								sheet.createRow(rowIndex[0]);
						Cell cell = row.createCell(cellIndexStart[0]);
						cell.setCellValue(report.getMapOfReport().get(fieldName));
						cell.setCellStyle(cellStyle);
						rowIndex[0]++;
					}
					cellIndexStart[0]++;
					rowIndex[0] = rowIndexStart[0];
				}

				headerCellIndex[0] += teamReports.size();
			});

			ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
			workbook.write(outputStream);
			return outputStream.toByteArray();

		} catch (IOException e) {
			e.printStackTrace(); // Handle the exception appropriately
			return new byte[0];
		}
	}

}