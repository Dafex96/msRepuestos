package cl.duoc.msRepuestos.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import cl.duoc.msRepuestos.model.Repuesto;

@Repository
public interface RepuestoRepository extends JpaRepository<Repuesto, Integer> {

    Optional<Repuesto> findByCodigo(String codigo);

    @Query("SELECT r FROM Repuesto r WHERE r.stockActual <= r.stockMinimo")
    List<Repuesto> findBajoStock();

    List<Repuesto> findByTipoRepuestoId(Integer idTipoRepuesto);
}
