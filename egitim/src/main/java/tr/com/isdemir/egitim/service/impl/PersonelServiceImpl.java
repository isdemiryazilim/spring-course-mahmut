package tr.com.isdemir.egitim.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tr.com.isdemir.egitim.dto.ComboDTO;
import tr.com.isdemir.egitim.dto.EmpDTO;
import tr.com.isdemir.egitim.dto.mapper.EmpMapper;
import tr.com.isdemir.egitim.entity.Dept;
import tr.com.isdemir.egitim.entity.Emp;
import tr.com.isdemir.egitim.repository.DeptRepository;
import tr.com.isdemir.egitim.repository.EmpRepository;
import tr.com.isdemir.egitim.service.PersonelService;

@Service
@Transactional
@Slf4j
public class PersonelServiceImpl implements PersonelService {

	@Autowired
	private EmpRepository empRepository;

	@Autowired
	private DeptRepository deptRepository;

	@Autowired
	private EmpMapper empMapper;

	@Override
	public List<EmpDTO> personelListe(Long deptno) {
		log.info("personelListe başladı.");
		List<Emp> entityList = empRepository.findAllByDept_DeptnoOrderByEname(deptno);
		
		List<EmpDTO> dtoList = new ArrayList<EmpDTO>();
		if (CollectionUtils.isNotEmpty(entityList)) {
			dtoList = empMapper.mapToDTOs(entityList);
		}
		return dtoList;
	}

	@Override
	public List<ComboDTO> deptListeGetir() {
		List<Dept> list = deptRepository.findAll();
		List<ComboDTO> comboList = new ArrayList<ComboDTO>();
		for (Dept dept : list) {
			ComboDTO dto = new ComboDTO();
			dto.setId(dept.getDeptno());
			dto.setValue(dept.getDname());
			comboList.add(dto);
		}

		return comboList;
	}

	@Override
	public EmpDTO personelKaydet(EmpDTO empDTO) {
		Emp emp = empMapper.mapToEntity(empDTO);
		emp = empRepository.saveAndFlush(emp);
		empDTO = empMapper.mapToDTO(emp);
		return empDTO;
	}

	@Override
	public void personelPersonelSil(EmpDTO empDTO) {
		Emp emp = empMapper.mapToEntity(empDTO);
		//Emp emp = empRepository.getOne(empDTO.getEmpno());
		empRepository.delete(emp);		
	}
}
