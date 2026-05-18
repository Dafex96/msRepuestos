package cl.duoc.msRepuestos.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cl.duoc.msRepuestos.model.Repuesto;

@Repository
public interface RepuestoRepository extends JpaRepository<Repuesto, Integer> {

    Optional<Repuesto> findByCodigo(String codigo);
}
