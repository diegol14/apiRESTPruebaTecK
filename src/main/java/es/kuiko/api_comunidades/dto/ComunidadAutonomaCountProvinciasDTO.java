package es.kuiko.api_comunidades.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class ComunidadAutonomaCountProvinciasDTO  implements ComunidadAutonomaCountProvinciasProjection{
	
    @NotBlank
    @Size(max = 10)  // Límite sugerido, no tenemos requisitos dados mas que los de DB
    private String codigoCa;
    
    @NotBlank
    @Size(max = 50)  // Límite sugerido, no tenemos requisitos dados mas que los de DB
    private String nombreCa;
    
    @NotNull
    @Min(1)  
    @Max(9999)  // Límite sugerido, no tenemos requisitos dados mas que los de DB
    private Integer cantidadProvinciaInComunidad;

	public ComunidadAutonomaCountProvinciasDTO(@NotBlank @Size(max = 10) String codigoCa,
			@NotBlank @Size(max = 50) String nombreCa,
			@NotNull @Min(1) @Max(9999) Integer cantidadProvinciaInComunidad) {
		this.codigoCa = codigoCa;
		this.nombreCa = nombreCa;
		this.cantidadProvinciaInComunidad = cantidadProvinciaInComunidad;
	}

	public String getCodigoCa() {
		return codigoCa;
	}

	public void setCodigoCa(String codigoCa) {
		this.codigoCa = codigoCa;
	}

	public String getNombreCa() {
		return nombreCa;
	}

	public void setNombreCa(String nombreCa) {
		this.nombreCa = nombreCa;
	}

	public Integer getCantidadProvinciaInComunidad() {
		return cantidadProvinciaInComunidad;
	}

	public void setCantidadProvinciaInComunidad(Integer cantidadProvinciaInComunidad) {
		this.cantidadProvinciaInComunidad = cantidadProvinciaInComunidad;
	}
    
    

}
