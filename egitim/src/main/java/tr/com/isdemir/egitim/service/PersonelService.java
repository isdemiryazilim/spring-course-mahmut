package tr.com.isdemir.egitim.service;

import java.util.List;

import tr.com.isdemir.egitim.dto.ComboDTO;
import tr.com.isdemir.egitim.dto.EmpDTO;

public interface PersonelService {
	
	List<EmpDTO> personelListe(Long deptno);

	List<ComboDTO> deptListeGetir();

	EmpDTO personelKaydet(EmpDTO empDTO);

	void personelPersonelSil(EmpDTO empDTO);	
	
}
