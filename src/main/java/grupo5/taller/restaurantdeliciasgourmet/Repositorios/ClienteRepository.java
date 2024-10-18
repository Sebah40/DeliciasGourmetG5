/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5.taller.restaurantdeliciasgourmet.Repositorios;

/**
 *
 * @author sebas
 */
import grupo5.taller.restaurantdeliciasgourmet.logica.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    Optional<Cliente> findByEmailAndContrasenia(String email, String contrasenia);
    
    @Query("SELECT c FROM Cliente c WHERE c.email = :email")
    Cliente ClientByEmail(@Param("email")String email);
}
