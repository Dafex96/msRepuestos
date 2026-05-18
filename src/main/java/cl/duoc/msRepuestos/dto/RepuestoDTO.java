package cl.duoc.msRepuestos.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RepuestoDTO {

    private Integer id;
    private String codigo;
    private Integer precio;
}
