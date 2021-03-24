package tr.com.isdemir.egitim.controller.genel;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ommg.ortak.api.ResponsePayload;
import com.ommg.ortak.consts.BaseConstants.Response;
import com.ommg.ortak.enumeration.ResponseEnum;

import lombok.extern.slf4j.Slf4j;
import tr.com.isdemir.egitim.service.DosyaService;

@CrossOrigin
@RestController
@RequestMapping("/egitim/dosya-islemleri")
@Slf4j
public class DosyaController {
	@Autowired
	private DosyaService dosyaService;

	@PostMapping(value = "/dosya-kaydet/{dosyaAdi}", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public ResponsePayload dysDosyaKaydet(@RequestPart("upload") MultipartFile uploadFile,
			@PathVariable("dosyaAdi") String dosyaAdi) {
		log.info("DosyaController.dysDosyaKaydet başladı. DosyaAdı:" + dosyaAdi);
		dosyaService.dosyaKaydet(uploadFile, dosyaAdi);
		return new ResponsePayload(ResponseEnum.OK, Response.SUCCESS);
	}

	@GetMapping(value = "/dosya-getir/{dosyaAdi}", produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
	public void dokumanIndir(HttpServletResponse response, @PathVariable("dosyaAdi") String dosyaAdi) {
		dosyaService.dosyaGetir(response, dosyaAdi);
	}

}
