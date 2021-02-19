package tr.com.isdemir.egitim.repository;

import org.springframework.stereotype.Repository;

import com.ommg.ortak.repository.BaseRepository;

import tr.com.isdemir.egitim.entity.Emp;

@Repository
public interface EmpRepository extends BaseRepository<Emp, Long> {
	//List<Emp> findAllByDept_DeptnoOrderByEname(Long deptno);
}
