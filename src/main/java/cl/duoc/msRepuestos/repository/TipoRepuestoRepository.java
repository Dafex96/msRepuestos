package cl.duoc.msRepuestos.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import cl.duoc.msRepuestos.model.TipoRepuesto;

@Repository
public interface TipoRepuestoRepository extends JpaRepository<TipoRepuesto, Integer>{

    Optional<TipoRepuesto> findByNombre(String nombre);
}
