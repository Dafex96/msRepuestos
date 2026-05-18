package cl.duoc.msRepuestos.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import cl.duoc.msRepuestos.model.Repuesto;
import cl.duoc.msRepuestos.repository.RepuestoRepository;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner initDatabase(RepuestoRepository repuestoRepo) {
        return args -> {

            if (repuestoRepo.count() > 0) {
                System.out.println("Datos ya existen, no se cargan nuevamente...");
                
            }else{

                Repuesto repuesto1 = new Repuesto(null, "1017276", "Filtro de aire", "MANN FILTER", 9000);
                Repuesto repuesto2 = new Repuesto(null, "121304", "Filtro de aceite", "DGP", 4000);
                Repuesto repuesto3 = new Repuesto(null, "109547", "Disco de Freno", "GTX", 44000);
                Repuesto repuesto4 = new Repuesto(null, "123007", "Bujia de niquel", "NGK", 2500);
                Repuesto repuesto5 = new Repuesto(null, "120792", "Catalizador", "GREENFLOW", 42000);

                repuestoRepo.save(repuesto1);
                repuestoRepo.save(repuesto2);
                repuestoRepo.save(repuesto3);
                repuestoRepo.save(repuesto4);
                repuestoRepo.save(repuesto5);

                System.out.println("Datos cargados con exito...");
            };
        };
    }
}
