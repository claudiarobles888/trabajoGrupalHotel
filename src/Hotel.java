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

    public boolean crearReserva(String nombreCliente, String cedula, int numeroHabitacion) {
        for (Habitacion h : habitaciones) {
            if (h.getNumero() == numeroHabitacion && h.estaDisponible()) {
                Reserva nueva = new Reserva(nombreCliente,cedula, h);
                reservas.add(nueva);
                return true;
            }
        }
        return false;
    }

    public void buscarHabitacionPorCedula(String cedula){
        boolean existe = false;
        for (Reserva r : reservas){
            if (r.getCedula().equals(cedula)){
                System.out.println("---Detalles de habitacion reservada---\nNombre del cliente: "+r.getNombreCliente()+"\nNumero de habitacion: "+r.getNumeroHabitacion());
                existe = true;
            }
        }
        if (!existe){
            System.out.println("No se encontro una habitacion reservada con la cedula ingresada");
        }
    }

    public boolean tieneReservas(){
        return !reservas.isEmpty();
    }

    public void mostrarReservas() {
        for (Reserva r : reservas) {
            System.out.println("Cliente: " + r.getNombreCliente() +
                    "\nCedula: "+r.getCedula()+"\nHabitación: " + r.getNumeroHabitacion());
        }
    }
}