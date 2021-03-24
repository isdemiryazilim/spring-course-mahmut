package tr.com.isdemir.egitim.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tr.com.isdemir.egitim.dto.EmpDTO;
import tr.com.isdemir.egitim.entity.Emp;
import tr.com.isdemir.egitim.repository.EmpRepository;
import tr.com.isdemir.egitim.service.PersonelService;


@Service
@Transactional
@Slf4j
public class PersonelServiceImpl implements PersonelService {
	
	@Autowired
	private EmpRepository empRepository;
	
	@Override
	public List<EmpDTO> personelListe(Long deptno) {
		log.info("personelListe başladı.");
		// not implemented
		return null;
	}
}
