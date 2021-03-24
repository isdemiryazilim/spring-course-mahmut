package tr.com.isdemir.egitim.controller.personel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ommg.ortak.api.ResponsePayload;
import com.ommg.ortak.enumeration.ResponseEnum;
import com.ommg.ortak.utils.EntityUtils;

import lombok.extern.slf4j.Slf4j;
import tr.com.isdemir.egitim.dto.EmpDTO;
import tr.com.isdemir.egitim.service.PersonelService;

@CrossOrigin
@RestController
@RequestMapping("/egitim/personel-yonetimi")
@Slf4j
public class PersonelController {

	@Autowired
	private PersonelService personelService;

	@PostMapping(value = "/personel-liste/{deptno}", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponsePayload personelListeByDepartmentNo(@PathVariable("deptno") Long deptno) {
		log.info("personelListeByDepartmentNo is started");
		List<EmpDTO> dtoList = personelService.personelListe(deptno);
		return new ResponsePayload(ResponseEnum.OK, "personelListeByDepartmentNo.basarili", dtoList);
	}

	@PostMapping(value = "/personel-kaydet", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponsePayload personelKaydet(@RequestBody EmpDTO empDTO) {
		log.info("personelKaydet başladı: " + EntityUtils.java2JSON(empDTO));
		EmpDTO dto = personelService.personelKaydet(empDTO);
		return new ResponsePayload(ResponseEnum.OK, dto);
	}
	
	@PostMapping(value = "/personel-sil", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponsePayload nakliyeciKaydet(@RequestBody EmpDTO empDTO) {
		log.info("nakliyeciKaydet başladı: " + EntityUtils.java2JSON(empDTO));
		personelService.personelPersonelSil(empDTO);
		return new ResponsePayload(ResponseEnum.OK);
	}

}
