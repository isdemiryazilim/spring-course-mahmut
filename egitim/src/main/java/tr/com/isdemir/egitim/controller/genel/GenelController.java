package tr.com.isdemir.egitim.controller.genel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ommg.ortak.api.ResponsePayload;
import com.ommg.ortak.consts.BaseConstants.Response;
import com.ommg.ortak.enumeration.ResponseEnum;

import lombok.extern.slf4j.Slf4j;
import tr.com.isdemir.egitim.dto.ComboDTO;
import tr.com.isdemir.egitim.service.PersonelService;

@CrossOrigin
@RestController
@RequestMapping("/egitim/genel")
@Slf4j
public class GenelController {

	@Autowired
	private PersonelService personelService;

	@PostMapping(value = "/dept-liste", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponsePayload deptListe() {
		log.info("PersonelController.deptListe is started");
		List<ComboDTO> modelList = personelService.deptListeGetir();
		return new ResponsePayload(ResponseEnum.OK, Response.SUCCESS, modelList);
	}

}
