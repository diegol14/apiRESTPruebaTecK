package es.kuiko.api_comunidades.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.kuiko.api_comunidades.model.Provincia;
import java.util.List;

@Repository
public interface ProvinciaRepository  extends JpaRepository<Provincia, Integer>{

    Optional<Provincia>  findByCodigoProvincia(Integer codigoProvincia);
    
    //Query para obtener codProvincia, nombreProvincia, codCA, nombreCa para ProvinciaInfoCjomunidadDTO
    @Query("SELECT p FROM Provincia p JOIN FETCH p.comunidadAutonoma WHERE p.codigoProvincia = :codigoProvincia")
    Optional<Provincia> findProvinciaComunidadInfoById(@Param("codigoProvincia") Integer codigoProvincia);
    
}