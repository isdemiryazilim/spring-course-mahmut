package tr.com.isdemir.egitim.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "EMP")
@NamedQuery(name = "Emp.findAll", query = "SELECT n FROM Emp n")
@Getter
@Setter
public class Emp implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8478032156817160310L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "emp_seq")
	@SequenceGenerator(sequenceName = "SEQ_EMP", allocationSize = 1, name = "emp_seq")
	@Column(name = "EMPNO")
	private Long empno;

	private String ename;
	private Long mgr;
	private Date hiredate;
	private BigDecimal sal;
	private BigDecimal comm;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "DEPTNO")
	private Dept dept;
}
