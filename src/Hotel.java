import java.util.ArrayList;
import java.util.List;

class Hotel {
    private List<Habitacion> habitaciones;
    private List<Reserva> reservas;

    public Hotel(int cantidadHabitaciones) {
        habitaciones = new ArrayList<>();
        reservas = new ArrayList<>();

        for (int i = 1; i <= cantidadHabitaciones; i++) {
            habitaciones.add(new Habitacion(i));
        }
    }

    public boolean consultarDisponibilidad(int numero) {
        for (Habitacion h : habitaciones) {
            if (h.getNumero() == numero) {
                return h.estaDisponible();
            }
        }
        return false;
    }

    public boolean crearReserva(String nombreCliente, int numeroHabitacion) {
        for (Habitacion h : habitaciones) {
            if (h.getNumero() == numeroHabitacion && h.estaDisponible()) {
                Reserva nueva = new Reserva(nombreCliente, h);
                reservas.add(nueva);
                return true;
            }
        }
        return false;
    }

    public void mostrarReservas() {
        for (Reserva r : reservas) {
            System.out.println("Cliente: " + r.getNombreCliente() +
                    " - Habitación: " + r.getNumeroHabitacion());
        }
    }
}