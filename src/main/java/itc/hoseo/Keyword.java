package itc.hoseo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Keyword {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String keyword;
	private Integer rank; 
	private Date time;
}
