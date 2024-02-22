package org.health.track.teamhealthtrack.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TeamReport {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "user_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	private AppUser appUser;
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
	private LocalTime createdDate;

	public Map<String, Integer> getMapOfReport(){
		 Map<String, Integer> sad = new HashMap<>();
		sad.put("press",this.getPress());
		sad.put("lowerBack",this.getLowerBack());
		sad.put("glutealRight",this.getGlutealRight());
		sad.put("glutealLeft",this.getGlutealLeft());
		sad.put("ankleRight",this.getAnkleRight());
		sad.put("ankleLeft",this.getAnkleLeft());
		sad.put("kneeRight",this.getKneeRight());
		sad.put("kneeLeft",this.getKneeLeft());
		sad.put("tibialisAnteriorRight",this.getTibialisAnteriorRight());
		sad.put("tibialisAnteriorLeft",this.getTibialisAnteriorLeft());
		sad.put("adductorMusRight",this.getAdductorMusRight());
		sad.put("adductorMusLeft",this.getAdductorMusLeft());
		sad.put("calfMuscleRight",this.getCalfMuscleRight());
		sad.put("calfMuscleLeft",this.getCalfMuscleLeft());
		sad.put("hamstringsRight",this.getHamstringsRight());
		sad.put("hamstringsLeft",this.getHamstringsLeft());
		sad.put("quadricepsRight",this.getQuadricepsRight());
		sad.put("quadricepsLeft",this.getQuadricepsLeft());
		 return sad;
	}

}
