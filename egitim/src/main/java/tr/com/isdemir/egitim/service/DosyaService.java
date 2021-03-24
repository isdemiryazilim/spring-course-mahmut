package tr.com.isdemir.egitim.service;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.multipart.MultipartFile;

public interface DosyaService {
	
	String dosyaKaydet(MultipartFile uploadFile, String dosyaAdi);
	
	void dosyaGetir(HttpServletResponse response, String dosyaAdi);
	
}
