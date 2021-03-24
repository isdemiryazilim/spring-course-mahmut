package tr.com.isdemir.egitim.repository;

import org.springframework.stereotype.Repository;

import com.ommg.ortak.repository.BaseRepository;

import tr.com.isdemir.egitim.entity.Dept;

@Repository
public interface DeptRepository extends BaseRepository<Dept, Long> {
}
