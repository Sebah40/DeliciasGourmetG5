/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo5.taller.restaurantdeliciasgourmet.Servicios;

import grupo5.taller.restaurantdeliciasgourmet.Repositorios.TarjetaCreditoRepository;
import grupo5.taller.restaurantdeliciasgourmet.logica.TarjetaCredito;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author sebas
 */
@Service
public class TarjetaCreditoService {

    @Autowired
    private TarjetaCreditoRepository tarjetaCreditoRepository;

    public TarjetaCredito saveTarjetaCredito(TarjetaCredito tarjetaCredito) {
        return tarjetaCreditoRepository.save(tarjetaCredito);
    }

   @Transactional
    public TarjetaCredito findTarjetaById(Long id) {
        return tarjetaCreditoRepository.findById(id).orElse(null);
    }

    public List<TarjetaCredito> findAll() {
        return tarjetaCreditoRepository.findAll();
    }

    public void deleteById(Long id) {
        tarjetaCreditoRepository.deleteById(id);
    }

    public TarjetaCredito findByNumeroTarjeta(String numeroTarjeta) {
        return tarjetaCreditoRepository.findByNumeroTarjeta(numeroTarjeta);
    }
}