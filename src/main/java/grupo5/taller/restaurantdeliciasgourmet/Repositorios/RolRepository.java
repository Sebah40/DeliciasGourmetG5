package grupo5.taller.restaurantdeliciasgourmet.Repositorios;


import grupo5.taller.restaurantdeliciasgourmet.logica.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Long>{
    
}
