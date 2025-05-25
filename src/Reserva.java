class Reserva {
    private String nombreCliente;
    private Habitacion habitacion;

    public Reserva(String nombreCliente, Habitacion habitacion) {
        this.nombreCliente = nombreCliente;
        this.habitacion = habitacion;
        habitacion.reservar();
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public int getNumeroHabitacion() {
        return habitacion.getNumero();
    }
}