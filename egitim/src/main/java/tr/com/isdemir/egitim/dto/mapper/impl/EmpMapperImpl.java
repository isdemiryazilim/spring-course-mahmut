package tr.com.isdemir.egitim.dto.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import tr.com.isdemir.egitim.dto.DeptDTO;
import tr.com.isdemir.egitim.dto.EmpDTO;
import tr.com.isdemir.egitim.dto.mapper.EmpMapper;
import tr.com.isdemir.egitim.entity.Dept;
import tr.com.isdemir.egitim.entity.Emp;

@Generated(value = "org.mapstruct.ap.MappingProcessor")
@Component
public class EmpMapperImpl implements EmpMapper {

	@Override
	public EmpDTO mapToDTO(Emp entity) {
		if (entity == null) {
			return null;
		}

		EmpDTO empDTO = new EmpDTO();

		empDTO.setEmpno(entity.getEmpno());
		empDTO.setEname(entity.getEname());
		empDTO.setComm(entity.getComm());
		empDTO.setHiredate(entity.getHiredate());
		empDTO.setMgr(entity.getMgr());
		empDTO.setSal(entity.getSal());
		empDTO.setDept(deptToToDeptDTO(entity.getDept()));

		return empDTO;
	}

	@Override
	public Emp mapToEntity(EmpDTO dto) {
		if (dto == null) {
			return null;
		}

		Emp entity = new Emp();

		entity.setEmpno(dto.getEmpno());
		entity.setEname(dto.getEname());
		entity.setComm(dto.getComm());
		entity.setHiredate(dto.getHiredate());
		entity.setMgr(dto.getMgr());
		entity.setSal(dto.getSal());
		entity.setDept(deptDTOToDept(dto.getDept()));

		return entity;
	}

	@Override
	public List<EmpDTO> mapToDTOs(List<Emp> entities) {
		if (entities == null) {
			return null;
		}

		List<EmpDTO> list = new ArrayList<EmpDTO>(entities.size());
		for (Emp tanim : entities) {
			list.add(mapToDTO(tanim));
		}

		return list;
	}

	@Override
	public List<Emp> mapToEntities(List<EmpDTO> dtos) {
		if (dtos == null) {
			return null;
		}

		List<Emp> list = new ArrayList<Emp>(dtos.size());
		for (EmpDTO tanimDTO : dtos) {
			list.add(mapToEntity(tanimDTO));
		}

		return list;
	}

	protected DeptDTO deptToToDeptDTO(Dept entity) {
		if (entity == null) {
			return null;
		}

		DeptDTO deptDTO = new DeptDTO();

		deptDTO.setDeptno(entity.getDeptno());
		deptDTO.setDname(entity.getDname());
		deptDTO.setLoc(entity.getLoc());
		return deptDTO;
	}

	protected Dept deptDTOToDept(DeptDTO dto) {
		if (dto == null) {
			return null;
		}

		Dept dept = new Dept();

		dept.setDeptno(dto.getDeptno());
		dept.setDname(dto.getDname());
		dept.setLoc(dto.getLoc());
		return dept;
	}

}
