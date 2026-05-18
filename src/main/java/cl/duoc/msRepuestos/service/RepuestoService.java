package cl.duoc.msRepuestos.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.duoc.msRepuestos.model.Repuesto;
import cl.duoc.msRepuestos.repository.RepuestoRepository;

@Service
public class RepuestoService {

    @Autowired
    private RepuestoRepository repo;

    public List<Repuesto> listarRepuestos() {
        return repo.findAll();
    }

    public Repuesto buscarPorId(Integer id){
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Repuesto no encontrado"));
    }

    public Repuesto buscarPorCodigo(String codigo){
        return repo.findByCodigo(codigo).orElseThrow(() -> new RuntimeException("Repuesto no encontrado"));
    }

    public Repuesto guardarRepuesto(Repuesto repuesto) {
        return repo.save(repuesto);
    }

    public void eliminarRepuesto(Integer id) {
        if (repo.existsById(id)) {
            repo.deleteById(id);
        }
        throw new RuntimeException("Repuesto no encontrado");
    }
}
