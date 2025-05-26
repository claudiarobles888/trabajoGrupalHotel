class Reserva {
    private String nombreCliente;
    private String cedula;
    private Habitacion habitacion;

    public Reserva(String nombreCliente, String cedula, Habitacion habitacion) {
        this.nombreCliente = nombreCliente;
        this.cedula = cedula;
        this.habitacion = habitacion;
        habitacion.reservar();
    }

    public String getNombreCliente() {

        return nombreCliente;
    }

    public String getCedula() {
        return cedula;
    }

    public int getNumeroHabitacion() {

        return habitacion.getNumero();
    }
}