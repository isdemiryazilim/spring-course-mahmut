package tr.com.isdemir.egitim.dto.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Generated;

import org.springframework.stereotype.Component;

import tr.com.isdemir.egitim.dto.DeptDTO;
import tr.com.isdemir.egitim.dto.mapper.DeptMapper;
import tr.com.isdemir.egitim.entity.Dept;

@Generated(value = "org.mapstruct.ap.MappingProcessor")
@Component
public class DeptMapperImpl implements DeptMapper {

	@Override
	public DeptDTO mapToDTO(Dept entity) {
		if (entity == null) {
			return null;
		}

		DeptDTO deptDTO = new DeptDTO();

		deptDTO.setDeptno(entity.getDeptno());
		deptDTO.setDname(entity.getDname());
		deptDTO.setLoc(entity.getLoc());
		return deptDTO;
	}

	@Override
	public Dept mapToEntity(DeptDTO dto) {
		if (dto == null) {
			return null;
		}

		Dept dept = new Dept();

		dept.setDeptno(dto.getDeptno());
		dept.setDname(dto.getDname());
		dept.setLoc(dto.getLoc());
		return dept;
	}

	@Override
	public List<DeptDTO> mapToDTOs(List<Dept> entities) {
		if (entities == null) {
			return null;
		}

		List<DeptDTO> list = new ArrayList<DeptDTO>(entities.size());
		for (Dept tanim : entities) {
			list.add(mapToDTO(tanim));
		}

		return list;
	}

	@Override
	public List<Dept> mapToEntities(List<DeptDTO> dtos) {
		if (dtos == null) {
			return null;
		}

		List<Dept> list = new ArrayList<Dept>(dtos.size());
		for (DeptDTO tanimDTO : dtos) {
			list.add(mapToEntity(tanimDTO));
		}

		return list;
	}
}
