package org.health.track.teamhealthtrack.config;

import lombok.experimental.UtilityClass;
import org.health.track.teamhealthtrack.dto.TeamReportDTO;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class ReflectionExample {


    public static List<String> getAllFields(Class<?> clazz) {
        // Use reflection to get all declared fields
        Field[] fieldsArray = clazz.getDeclaredFields();

        // Convert the array to a list using Java streams
        List<String> fieldsList = Arrays.stream(fieldsArray).map(Field::getName).collect(Collectors.toList());

        return fieldsList;
    }

}