package es.kuiko.api_comunidades.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.kuiko.api_comunidades.dto.ComunidadAutonomaCountProvinciasDTO;
import es.kuiko.api_comunidades.dto.ComunidadAutonomaCountProvinciasProjection;
import es.kuiko.api_comunidades.model.ComunidadAutonoma;


@Repository
public interface ComunidadAutonomaRepository extends JpaRepository<ComunidadAutonoma, String> {

	Optional<ComunidadAutonoma> findByCodigoCa(String codigoCa);

	boolean existsByCodigoCa(String codigoCa);

	@Query(value = "SELECT c.codigo_ca AS codigoCa, c.nombre_ca AS nombreCa, CAST(COUNT(p.codigo_provincia) AS INTEGER) AS cantidadProvinciaInComunidad " +
	        "FROM comunidad_autonoma c " +
	        "LEFT JOIN provincia p ON c.codigo_ca = p.codigo_ca " +
	        "WHERE c.codigo_ca = :codigoCa " +
	        "GROUP BY c.codigo_ca, c.nombre_ca", 
	nativeQuery = true)
	Optional<ComunidadAutonomaCountProvinciasProjection> findCantidadProvinciasPorComunidad(@Param("codigoCa") String codigoCa);


}