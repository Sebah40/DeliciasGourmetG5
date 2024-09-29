/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5.taller.restaurantdeliciasgourmet.Repositorios;

import grupo5.taller.restaurantdeliciasgourmet.logica.TarjetaCredito;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author sebas
 */
@Repository
public interface TarjetaCreditoRepository extends JpaRepository<TarjetaCredito, Long> {    
    List<TarjetaCredito> findByEmisor(String emisor);
}
