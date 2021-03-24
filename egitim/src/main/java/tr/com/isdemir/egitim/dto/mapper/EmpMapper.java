package tr.com.isdemir.egitim.dto.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.ommg.ortak.mapper.BaseMapper;

import tr.com.isdemir.egitim.dto.EmpDTO;
import tr.com.isdemir.egitim.entity.Emp;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface EmpMapper extends BaseMapper<Emp, EmpDTO> {

}
