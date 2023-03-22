package in.mk.DTO;

import java.time.LocalDate;

import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Data
public class CitizenAppDTO {

	private String fullName;
	private String email;
	private Long mobileNo;
	private String gender;
	private LocalDate dob;
	private Long ssn;
	private Integer createdBy;
	private Integer updateBy;

		
}
