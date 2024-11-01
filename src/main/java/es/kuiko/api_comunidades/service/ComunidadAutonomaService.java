package es.kuiko.api_comunidades.service;

import es.kuiko.api_comunidades.dto.ComunidadAutonomaCountProvinciasDTO;
import es.kuiko.api_comunidades.model.ComunidadAutonoma;
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.query.Param;

public interface ComunidadAutonomaService {
	
    List<ComunidadAutonoma> getAll();
    
    Optional<ComunidadAutonoma> getById(String codigoCa);
    
	Optional<ComunidadAutonomaCountProvinciasDTO> getCantidadProvinciasByComunidad(@Param("codigoCa") String codigoCa);
    
    ComunidadAutonoma create(ComunidadAutonoma comunidadAutonoma);
    
    ComunidadAutonoma update(String codigoCa, ComunidadAutonoma comunidadAutonoma);
    
    void delete(String codigoCa);  
}
