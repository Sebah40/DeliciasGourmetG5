package grupo5.taller.restaurantdeliciasgourmet.logica;

/**
 * Enum que representa los diferentes estados de una reserva en el sistema del restaurante.
 * 
 * Los posibles estados de una reserva son:
 * - CONFIRMADA: La reserva ha sido confirmada.
 * - CANCELADA: La reserva ha sido cancelada.
 * - NO_ASISTIO: El cliente no asistió a la reserva.
 * 
 * @author Grupo5
 */
public enum EstadoReserva {
    CONFIRMADA,  // La reserva ha sido confirmada
    CANCELADA,   // La reserva ha sido cancelada
    NO_ASISTIO;  // El cliente no asistió a la reserva
}

