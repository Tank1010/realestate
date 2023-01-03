package datn.realestate.models;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Image extends BaseEntity{
	private String url;
	
	@ManyToOne 
	@JoinColumn(name = "property_id")
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	private Province province;
}
