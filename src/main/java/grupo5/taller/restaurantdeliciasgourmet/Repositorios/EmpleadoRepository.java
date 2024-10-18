
package grupo5.taller.restaurantdeliciasgourmet.Repositorios;


import grupo5.taller.restaurantdeliciasgourmet.logica.Empleado;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends JpaRepository<Empleado, Integer> {

    public Optional<Empleado> findByCorreoElectronicoAndContrasenia(String correoElectronico, String contrasenia);

    public Object findByCorreoElectronico(String correo);

    @Query("SELECT e FROM Empleado e")
    public List<Empleado> obtenerTodosLosEmpleados();

    
}
