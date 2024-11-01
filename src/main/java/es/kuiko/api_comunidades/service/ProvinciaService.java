package es.kuiko.api_comunidades.service;

import es.kuiko.api_comunidades.dto.ProvinciaDTO;
import es.kuiko.api_comunidades.dto.ProvinciaInfoComunidadDTO;
import es.kuiko.api_comunidades.model.Provincia;
import java.util.List;
import java.util.Optional;

public interface ProvinciaService {
	
    List<Provincia> getAll();
    
    Optional<Provincia> getById(Integer codigoProvincia);
    
    Provincia create(ProvinciaDTO provinciaDTO);
    
    Provincia update(Integer codigoProvincia, ProvinciaDTO provinciaDTO);
    
    void delete(Integer codigoProvincia);

	Optional<ProvinciaInfoComunidadDTO> getProvinciaComunidadInfoById(Integer codigoProvincia);
}
