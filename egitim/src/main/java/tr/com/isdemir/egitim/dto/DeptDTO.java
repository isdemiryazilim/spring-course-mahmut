package tr.com.isdemir.egitim.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeptDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2576094626405523959L;
	private Long deptno;
	private String dname;
	private String loc;
}
