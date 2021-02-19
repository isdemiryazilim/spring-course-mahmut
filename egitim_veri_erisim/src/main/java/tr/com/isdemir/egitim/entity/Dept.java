package tr.com.isdemir.egitim.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.Setter;

@Entity
@NamedQuery(name = "Dept.findAll", query = "SELECT n FROM Dept n")
@Getter
@Setter
public class Dept implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8478032156817160310L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dept_seq")
	@SequenceGenerator(sequenceName = "SEQ_DEPT", allocationSize = 1, name = "dept_seq")
	@Column(name = "DEPTNO")
	private Long deptno;

	private String dname;
	private String loc;
}
