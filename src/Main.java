import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel(5); // Hotel con 5 habitaciones

        int opcion;
        do {
            System.out.println("\n--- MENÚ ---");
            System.out.println("1. Crear nueva reserva");
            System.out.println("2. Consultar disponibilidad");
            System.out.println("3. Ver reservas");
            System.out.println("4. Buscar habitacion por cedula");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el nombre del cliente: ");
                    scanner.nextLine();
                    String nombre = scanner.nextLine();
                    System.out.println("Ingrese la cedula del cliente: ");
                    String cedula = scanner.nextLine();
                    System.out.print("Ingrese el número de la habitación: ");
                    int numReserva = scanner.nextInt();

                    boolean reservada = hotel.crearReserva(nombre, cedula, numReserva);
                    if (reservada) {
                        System.out.println("Reserva creada exitosamente.");
                    } else {
                        System.out.println("No se pudo crear la reserva. La habitación no está disponible o no existe.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el número de la habitación: ");
                    int numConsulta = scanner.nextInt();
                    boolean disponible = hotel.consultarDisponibilidad(numConsulta);
                    System.out.println("Habitación " + numConsulta + " está " +
                            (disponible ? "DISPONIBLE." : "NO disponible."));
                    break;

                case 3:
                    hotel.mostrarReservas();
                    break;

                case 4:
                    System.out.println("Ingrese la cedula a buscar: ");
                    scanner.nextLine();
                    cedula = scanner.nextLine();
                    hotel.buscarHabitacionPorCedula(cedula);
                    break;

                case 5:
                    System.out.println("\nSaliendo del sistema...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }

        } while (opcion != 4);

        scanner.close();
    }
}
