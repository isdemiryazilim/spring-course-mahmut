package tr.com.isdemir.egitim.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ComboDTO implements Serializable {

	private static final long serialVersionUID = -6828012251391550519L;

	private Long id;
	private String value;
	private String kod;

	public ComboDTO() {

	}

	public ComboDTO(Long id, String value) {
		setId(id);
		setValue(value);
	}

	public ComboDTO(Long id, String value, String kod) {
		setId(id);
		setValue(value);
		setKod(kod);
	}

}
