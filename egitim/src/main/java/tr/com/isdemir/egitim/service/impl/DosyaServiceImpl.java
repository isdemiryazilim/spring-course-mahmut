package tr.com.isdemir.egitim.service.impl;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import lombok.extern.slf4j.Slf4j;
import tr.com.isdemir.egitim.service.DosyaService;


@Service
@Slf4j
public class DosyaServiceImpl implements DosyaService {
	
	@Override
	public String dosyaKaydet(MultipartFile uploadFile, String dosyaAdi) {
		try {	
			File file = new File(System.getProperty("user.home")+"/upload/", dosyaAdi);		
			FileUtils.writeByteArrayToFile(file, uploadFile.getBytes());			
			return file.getPath();
		} catch (IOException e) {
			log.error(e.getMessage(), e);
			return null;
		}
		
	}

	@Override
	public void dosyaGetir(HttpServletResponse response, String dosyaAdi) {
		File file = new File(System.getProperty("user.home")+"/upload/", dosyaAdi);
		try {
			byte[] bytes = FileUtils.readFileToByteArray(file);
			response.setContentType("application/octet-stream; charset=UTF-8");
			response.getOutputStream().write(bytes);
			response.getOutputStream().close();
		} catch (IOException e) {
			log.error("Dosya İndirilirken Hata Oluştu", e.getMessage());
		}
		
	}
}
