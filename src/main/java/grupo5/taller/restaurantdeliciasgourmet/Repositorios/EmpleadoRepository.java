
package grupo5.taller.restaurantdeliciasgourmet.Repositorios;


import grupo5.taller.restaurantdeliciasgourmet.logica.Empleado;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    public Optional<Empleado> findByCorreoElectronicoAndContrasenia(String correoElectronico, String contrasenia);

    
}
