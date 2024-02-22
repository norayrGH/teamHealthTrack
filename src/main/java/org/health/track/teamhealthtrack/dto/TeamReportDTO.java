package org.health.track.teamhealthtrack.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TeamReportDTO {

    private Integer press;
    private Integer lowerBack;
    private Integer glutealRight;
    private Integer glutealLeft;
    private Integer ankleRight;
    private Integer ankleLeft;
    private Integer kneeRight;
    private Integer kneeLeft;
    private Integer tibialisAnteriorRight;
    private Integer tibialisAnteriorLeft;
    private Integer adductorMusRight;
    private Integer adductorMusLeft;
    private Integer calfMuscleRight;
    private Integer calfMuscleLeft;
    private Integer hamstringsRight;
    private Integer hamstringsLeft;
    private Integer quadricepsRight;
    private Integer quadricepsLeft;

}