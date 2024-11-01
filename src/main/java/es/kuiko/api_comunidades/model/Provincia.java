package es.kuiko.api_comunidades.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "provincia")
public class Provincia {

	@Id
    @NotNull(message = "El código de la provincia no puede ser nulo")
	@Positive(message = "El código de la provincia tiene que ser mayor de cero")
    @Column(name = "codigo_provincia")
    private Integer codigoProvincia;
	
	
    @NotNull(message = "El nombre de la provincia no puede ser nulo")
    @NotBlank(message = "El nombre de la provincia no puede estar vacío")
    @Column(name = "nombre_provincia")
	private String nombreProvincia;
    
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "codigo_ca", nullable = false,updatable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)  // Borrado en cascada en base de datos
    @JsonBackReference // Añadido para evitar recursión infinita con Com Autonoma
    private ComunidadAutonoma comunidadAutonoma;
    
	public Integer getCodigoProvincia() {
		return codigoProvincia;
	}

	public void setCodigoProvincia(Integer codigoProvincia) {
		this.codigoProvincia = codigoProvincia;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombre_provincia) {
		this.nombreProvincia = nombre_provincia;
	}
	

	public ComunidadAutonoma getComunidadAutonoma() {
		return comunidadAutonoma;
	}

	public void setComunidadAutonoma(ComunidadAutonoma comunidadAutonoma) {
		this.comunidadAutonoma = comunidadAutonoma;
	}
}

