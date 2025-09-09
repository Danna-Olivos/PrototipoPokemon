
import java.util.*;
import java.util.InputMismatchException;


public class SolrockBattleSystem {
    
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * Método principal que inicia la aplicación
     */
    public static void main(String[] args) {
        mostrarMenuPrincipal();
    }
    
    /**
     * Muestra el menú principal del sistema
     */
    public static void mostrarMenuPrincipal() {
        int opcion;
        
        do {
            System.out.println("\n=== SOLROCK BATTLE ASSOCIATION ===");
            System.out.println("1. Gestión de Cuentas");
            System.out.println("2. Gestión de Pokémones");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = leerEntero();
            
            switch (opcion) {
                case 1:
                    menuCuentas();
                    break;
                case 2:
                    menuPokemones();
                    break;
                case 3:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 3);
    }
    
    /**
     * Menú para la gestión de cuentas
     */
    public static void menuCuentas() {
        int opcion;
        
        do {
            System.out.println("\n=== GESTIÓN DE CUENTAS ===");
            System.out.println("1. Agregar cuenta");
            System.out.println("2. Consultar cuenta");
            System.out.println("3. Editar cuenta");
            System.out.println("4. Eliminar cuenta");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            opcion = leerEntero();
            
            switch (opcion) {
                case 1:
                    agregarCuenta();
                    break;
                case 2:
                    consultarCuenta();
                    break;
                case 3:
                    editarCuenta();
                    break;
                case 4:
                    eliminarCuenta();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }
    
    /**
     * Menú para la gestión de pokémones
     */
    public static void menuPokemones() {
        int opcion;
        
        do {
            System.out.println("\n=== GESTIÓN DE POKÉMONES ===");
            System.out.println("1. Agregar pokémon");
            System.out.println("2. Consultar pokémon");
            System.out.println("3. Editar pokémon");
            System.out.println("4. Eliminar pokémon");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            opcion = leerEntero();
            
            switch (opcion) {
                case 1:
                    agregarPokemon();
                    break;
                case 2:
                    consultarPokemon();
                    break;
                case 3:
                    editarPokemon();
                    break;
                case 4:
                    eliminarPokemon();
                    break;
                case 5:
                    System.out.println("Volviendo al menú principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 5);
    }
    
    /**
     * Lee un número entero desde la entrada estándar con manejo de excepciones
     * @return El número entero leído
     */
    private static int leerEntero() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entero.");
                System.out.print("Intente nuevamente: ");
                scanner.next(); // Limpiar el buffer
            }
        }
    }
    
    /**
     * Lee un booleano desde la entrada estándar
     * @return true para "sí", false para "no"
     */
    private static boolean leerBooleano() {
        while (true) {
            System.out.print("¿Es shiny? (sí/no): ");
            String respuesta = scanner.next().toLowerCase();
            if (respuesta.equals("sí") || respuesta.equals("si") || respuesta.equals("s")) {
                return true;
            } else if (respuesta.equals("no") || respuesta.equals("n")) {
                return false;
            } else {
                System.out.println("Respuesta no válida. Use 'sí' o 'no'.");
            }
        }
    }
    
    // CUENTAS 
    
    private static void agregarCuenta() {
        System.out.println("\n--- Agregar Cuenta ---");
        scanner.nextLine(); // Limpiar buffer
        
        try {
            System.out.print("Código de entrenador: ");
            String codigo = scanner.nextLine();
            
            System.out.print("Username: ");
            String username = scanner.nextLine();
            
            System.out.print("Nivel: ");
            int nivel = leerEntero();
            scanner.nextLine(); // Limpiar buffer
            
            System.out.print("Equipo: ");
            String equipo = scanner.nextLine();
            
            Cuenta nuevaCuenta = new Cuenta(codigo, username, nivel, equipo);
            Cuenta.agregarCuenta(nuevaCuenta);
            System.out.println("Cuenta agregada exitosamente.");
            
        } catch (Exception e) {
            System.out.println("Error al agregar cuenta: " + e.getMessage());
        }
    }
    
    private static void consultarCuenta() {
        System.out.println("\n--- Consultar Cuenta ---");
        scanner.nextLine(); // Limpiar buffer
        
        try {
            System.out.print("Ingrese el código de entrenador: ");
            String codigo = scanner.nextLine();
            
            String resultado = Cuenta.consultarCuenta(codigo);
            if (resultado != null) {
                System.out.println("\nDatos de la cuenta:");
                System.out.println(resultado);
            }
            
        } catch (Exception e) {
            System.out.println("Error al consultar cuenta: " + e.getMessage());
        }
    }
    
    private static void editarCuenta() {
        System.out.println("\n--- Editar Cuenta ---");
        scanner.nextLine(); // Limpiar buffer
        
        try {
            System.out.print("Ingrese el código de entrenador a editar: ");
            String codigo = scanner.nextLine();
            
            // Primero consultamos si existe
            String existente = Cuenta.consultarCuenta(codigo);
            if (existente == null) {
                System.out.println("No se puede editar: cuenta no encontrada.");
                return;
            }
            
            System.out.println("Ingrese los nuevos datos:");
            System.out.print("Nuevo username: ");
            String username = scanner.nextLine();
            
            System.out.print("Nuevo nivel: ");
            int nivel = leerEntero();
            scanner.nextLine(); // Limpiar buffer
            
            System.out.print("Nuevo equipo: ");
            String equipo = scanner.nextLine();
            
            Cuenta cuentaEditada = new Cuenta(codigo, username, nivel, equipo);
            Cuenta.editarCuenta(cuentaEditada);
            System.out.println("Cuenta editada exitosamente.");
            
        } catch (Exception e) {
            System.out.println("Error al editar cuenta: " + e.getMessage());
        }
    }
    
    private static void eliminarCuenta() {
        System.out.println("\n--- Eliminar Cuenta ---");
        scanner.nextLine(); // Limpiar buffer
        
        try {
            System.out.print("Ingrese el código de entrenador a eliminar: ");
            String codigo = scanner.nextLine();
            
            // Primero consultamos si existe
            String existente = Cuenta.consultarCuenta(codigo);
            if (existente == null) {
                System.out.println("No se puede eliminar: cuenta no encontrada.");
                return;
            }
            
            // Extraemos los datos para crear el objeto a eliminar
            String[] datos = existente.split("\n")[1].split(",");
            Cuenta cuentaEliminar = new Cuenta(datos[0], datos[1], Integer.parseInt(datos[2]), datos[3]);
            
            Cuenta.eliminarCuenta(cuentaEliminar);
            System.out.println("Cuenta eliminada exitosamente.");
            
        } catch (Exception e) {
            System.out.println("Error al eliminar cuenta: u.u " + e.getMessage());
        }
    }
    
    // POKÉMONES 
    
    private static void agregarPokemon() {
        System.out.println("\n--- Agregar Pokémon ---");
        scanner.nextLine(); // Limpiar buffer
        
        try {
            System.out.print("ID Pokémon: ");
            String idPokemon = scanner.nextLine();
            
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Especie: ");
            String especie = scanner.nextLine();
            
            System.out.print("Tipo: ");
            String tipo = scanner.nextLine();
            
            System.out.print("CP: ");
            int cp = leerEntero();
            
            System.out.print("Peso: ");
            int peso = leerEntero();
            scanner.nextLine(); // Limpiar buffer
            
            System.out.print("Sexo: ");
            String sexo = scanner.nextLine();
            
            boolean esShiny = leerBooleano();
            
            Pokemon nuevoPokemon = new Pokemon(idPokemon, nombre, especie, tipo, cp, peso, sexo, esShiny);
            Pokemon.agregarPokemon(nuevoPokemon);
            System.out.println("Pokémon agregado exitosamente.");
            
        } catch (Exception e) {
            System.out.println("Error al agregar pokémon: " + e.getMessage());
        }
    }
    
    private static void consultarPokemon() {
        System.out.println("\n--- Consultar Pokémon ---");
        scanner.nextLine(); // Limpiar buffer
        
        try {
            System.out.print("Ingrese el ID del Pokémon: ");
            String idPokemon = scanner.nextLine();
            
            String resultado = Pokemon.consultarPokemon(idPokemon);
            if (resultado != null) {
                System.out.println("\nDatos del Pokémon:");
                System.out.println(resultado);
            }
            
        } catch (Exception e) {
            System.out.println("Error al consultar pokémon: " + e.getMessage());
        }
    }
    
    private static void editarPokemon() {
        System.out.println("\n--- Editar Pokémon ---");
        scanner.nextLine(); // Limpiar buffer
        
        try {
            System.out.print("Ingrese el ID del Pokémon a editar: ");
            String idPokemon = scanner.nextLine();
            
            // Primero consultamos si existe
            String existente = Pokemon.consultarPokemon(idPokemon);
            if (existente == null) {
                System.out.println("No se puede editar: Pokémon no encontrado.");
                return;
            }
            
            System.out.println("Ingrese los nuevos datos:");
            System.out.print("Nuevo nombre: ");
            String nombre = scanner.nextLine();
            
            System.out.print("Nueva especie: ");
            String especie = scanner.nextLine();
            
            System.out.print("Nuevo tipo: ");
            String tipo = scanner.nextLine();
            
            System.out.print("Nuevo CP: ");
            int cp = leerEntero();
            
            System.out.print("Nuevo peso: ");
            int peso = leerEntero();
            scanner.nextLine(); // Limpiar buffer
            
            System.out.print("Nuevo sexo: ");
            String sexo = scanner.nextLine();
            
            boolean esShiny = leerBooleano();
            
            Pokemon pokemonEditado = new Pokemon(idPokemon, nombre, especie, tipo, cp, peso, sexo, esShiny);
            Pokemon.editarPokemon(pokemonEditado);
            System.out.println("Pokémon editado exitosamente.");
            
        } catch (Exception e) {
            System.out.println("Error al editar pokémon: " + e.getMessage());
        }
    }
    
    private static void eliminarPokemon() {
        System.out.println("\n--- Eliminar Pokémon ---");
        scanner.nextLine(); // Limpiar buffer
        
        try {
            System.out.print("Ingrese el ID del Pokémon a eliminar: ");
            String idPokemon = scanner.nextLine();
            
            // Primero consultamos si existe
            String existente = Pokemon.consultarPokemon(idPokemon);
            if (existente == null) {
                System.out.println("No se puede eliminar: Pokémon no encontrado.");
                return;
            }
            
            // Extraemos los datos para crear el objeto a eliminar
            String[] datos = existente.split("\n")[1].split(",");
            boolean esShiny = Boolean.parseBoolean(datos[7]);
            Pokemon pokemonEliminar = new Pokemon(
                datos[0], datos[1], datos[2], datos[3], 
                Integer.parseInt(datos[4]), Integer.parseInt(datos[5]), 
                datos[6], esShiny
            );
            
            Pokemon.eliminarPokemon(pokemonEliminar);
            System.out.println("Pokémon eliminado exitosamente.");
            
        } catch (Exception e) {
            System.out.println("Error al eliminar pokémon: " + e.getMessage());
        }
    }
}