package es.kuiko.api_comunidades.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="comunidad_autonoma")
public class ComunidadAutonoma {
	
	@Id
    @NotNull(message = "El código de la comunidad no puede ser nulo")
    @NotBlank(message = "El código de la comunidad no puede estar vacío")
	@Column(name = "codigo_ca")
	private String codigoCa;
	
    @NotNull(message = "El nombre de la comunidad no puede ser nulo")
    @NotBlank(message = "El nombre de la comunidad no puede estar vacío")
	private String nombreCa;
    
    @OneToMany(mappedBy = "comunidadAutonoma")
    @JsonManagedReference // Añadido para evitar recursión infinita
    private List<Provincia> provincias;
	
	public String getCodigoCa() {
		return codigoCa;
	}
	public void setCodigoCa(String codigo_ca) {
		this.codigoCa = codigo_ca;
	}
	public String getNombreCa() {
		return nombreCa;
	}
	public void setNombreCa(String nombreCa) {
		this.nombreCa = nombreCa;
	}
	public List<Provincia> getProvincias() {
		return provincias;
	}
	public void setProvincias(List<Provincia> provincias) {
		this.provincias = provincias;
	}
}
