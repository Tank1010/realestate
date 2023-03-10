package datn.realestate.models;

import java.util.Date;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User extends BaseEntity{
	private String userName;
	private String mail;
	private Date dateOfBirth;
	private String address;
	private String gmail;
	private String phoneNumber;
	private String firstName;
	private String lastName;
	private int postNumber;
	private String profilePhoto;
	private boolean enable;
	private String verificationCode;
	private String passwd;
}
