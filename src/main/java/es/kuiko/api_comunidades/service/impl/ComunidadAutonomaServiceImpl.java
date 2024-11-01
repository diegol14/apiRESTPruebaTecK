package es.kuiko.api_comunidades.service.impl;

import es.kuiko.api_comunidades.dto.ComunidadAutonomaCountProvinciasDTO;
import es.kuiko.api_comunidades.model.ComunidadAutonoma;
import es.kuiko.api_comunidades.repository.ComunidadAutonomaRepository;
import es.kuiko.api_comunidades.repository.ProvinciaRepository;
import es.kuiko.api_comunidades.service.ComunidadAutonomaService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class ComunidadAutonomaServiceImpl implements ComunidadAutonomaService {

    private final ComunidadAutonomaRepository comunidadAutonomaRepository;

    public ComunidadAutonomaServiceImpl(ComunidadAutonomaRepository comunidadAutonomaRepository) {
        this.comunidadAutonomaRepository = comunidadAutonomaRepository;
    }

    @Override
    public List<ComunidadAutonoma> getAll() {
        return comunidadAutonomaRepository.findAll();
    }

    @Override
    public Optional<ComunidadAutonoma> getById(String codigoCa) {
        validateCodigoCa(codigoCa);  
        return comunidadAutonomaRepository.findById(codigoCa);
    }
    
    public Optional<ComunidadAutonomaCountProvinciasDTO> getCantidadProvinciasByComunidad(String codigoCa) {
        validateCodigoCa(codigoCa);
        ensureComunidadExists(codigoCa);

        // Llama al repositorio y convierte la interfaz en el DTO
        return comunidadAutonomaRepository.findCantidadProvinciasPorComunidad(codigoCa)
            .map(projection -> new ComunidadAutonomaCountProvinciasDTO(
                projection.getCodigoCa(),
                projection.getNombreCa(),
                projection.getCantidadProvinciaInComunidad()
            ));
    }

    @Override
    public ComunidadAutonoma create(ComunidadAutonoma comunidadAutonoma) {
        validateCodigoCa(comunidadAutonoma);
        if (doesComunidadExist(comunidadAutonoma.getCodigoCa())) {
            throw new IllegalArgumentException("Ya existe una ComunidadAutonoma con el código " + comunidadAutonoma.getCodigoCa());
        }
        return comunidadAutonomaRepository.save(comunidadAutonoma);
    }

    @Override
    public ComunidadAutonoma update(String codigoCa, ComunidadAutonoma comunidadAutonoma) {
    	validateCodigoCa(codigoCa);
    	ensureComunidadExists(codigoCa);
        comunidadAutonoma.setCodigoCa(codigoCa);
        return comunidadAutonomaRepository.save(comunidadAutonoma);
    }

    @Override
    public void delete(String codigoCa) {
    	validateCodigoCa(codigoCa);
        ensureComunidadExists(codigoCa);
        comunidadAutonomaRepository.deleteById(codigoCa);
    }

    // Métodos internos de validacion para evitar duplicación (DRY)
    private void validateCodigoCa(ComunidadAutonoma comunidadAutonoma) {
        validateCodigoCa(comunidadAutonoma.getCodigoCa());
    }

    private void validateCodigoCa(String codigoCa) {
        if (codigoCa == null || codigoCa.isBlank()) {
            throw new IllegalArgumentException("El código de la Comunidad no puede ser nulo ni estar vacío");
        }
        if (!codigoCa.matches("[A-Za-z0-9]+")) {
            throw new IllegalArgumentException("El código de la Comunidad contiene caracteres no válidos");
        }
    }
    
    private void ensureComunidadExists(String codigoCa) {
        if (!doesComunidadExist(codigoCa)) {
            throw new RuntimeException("Comunidad Autónoma no encontrada");
        }
    }

    private boolean doesComunidadExist(String codigoCa) {
        return comunidadAutonomaRepository.existsById(codigoCa);
    }
}
