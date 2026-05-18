package cl.duoc.msRepuestos.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.msRepuestos.dto.RepuestoDTO;
import cl.duoc.msRepuestos.model.Repuesto;
import cl.duoc.msRepuestos.service.RepuestoService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/repuestos")
public class RepuestoController {

    @Autowired
    private RepuestoService service;

    @GetMapping
    public ResponseEntity<List<Repuesto>> listarRepuestos() {
        if (service.listarRepuestos().isEmpty()){
            return ResponseEntity.noContent().build();
        }else{
            return ResponseEntity.ok(service.listarRepuestos());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Repuesto> obtenerPorId(@PathVariable Integer id) {
        try {
            Repuesto repuesto = service.buscarPorId(id);
            return ResponseEntity.ok(repuesto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/dto/{id}")
    public ResponseEntity<RepuestoDTO> obtenerDTOPorId(@PathVariable Integer id) {
        try {
            RepuestoDTO repuestoDTO = service.buscarDTOPorId(id);
            return ResponseEntity.ok(repuestoDTO);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
    

    @GetMapping("/{codigo}")
    public ResponseEntity<Repuesto> obtenerPorCodigo(@PathVariable String codigo) {
        try {
            Repuesto repuesto = service.buscarPorCodigo(codigo);
            return ResponseEntity.ok(repuesto);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Repuesto> guardarRepuesto(@RequestBody Repuesto repuesto) {
        Repuesto nuevoRepuesto = service.guardarRepuesto(repuesto);
        return ResponseEntity.ok(nuevoRepuesto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRepuesto(@PathVariable Integer id) {
        try {
            service.eliminarRepuesto(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
