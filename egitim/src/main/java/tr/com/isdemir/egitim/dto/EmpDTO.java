package tr.com.isdemir.egitim.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class EmpDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -48285683992498528L;
	private Long empno;
	private String ename;
	private Long mgr;
	private Date hiredate;
	private BigDecimal sal;
	private BigDecimal comm;	
	private DeptDTO dept;
}
