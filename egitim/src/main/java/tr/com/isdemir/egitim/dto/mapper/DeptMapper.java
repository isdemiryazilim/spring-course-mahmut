package tr.com.isdemir.egitim.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.ommg.ortak.mapper.BaseMapper;

import tr.com.isdemir.egitim.dto.DeptDTO;
import tr.com.isdemir.egitim.entity.Dept;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface DeptMapper extends BaseMapper<Dept, DeptDTO> {

}
