import java.util.*;

/**
 * Clase principal del sistema de batalla Solrock.
 * 
 * Permite la gestión de participantes, cuentas y Pokémones,
 * incluyendo operaciones de agregar, consultar, editar y eliminar.
 * Maneja la interacción con el usuario mediante menús en consola.
 */
public class SolrockBattleSystem {
    
    private static Scanner scanner = new Scanner(System.in);
    
    /**
     * Método principal que inicia la aplicación
     */
    public static void main(String[] args) {
        mostrarMenuPrincipal();
    }
    
    /**
     * Muestra el menú principal del sistema con opciones para:
     * 1. Gestión de Participantes
     * 2. Gestión de Cuentas
     * 3. Gestión de Pokémones
     * 4. Salir
     */
    public static void mostrarMenuPrincipal() {
        int opcion;
        
        do {
            System.out.println("\n=== SOLROCK BATTLE ASSOCIATION ===");
            System.out.println("1. Gestión de Participantes");
            System.out.println("2. Gestión de Cuentas");
            System.out.println("3. Gestión de Pokémones");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            
            opcion = leerEntero();
            
            switch (opcion) {
                case 1:
                    menuParticipantes();
                    break;
                case 2:
                    menuCuentas();
                    break;
                case 3:
                    menuPokemones();
                    break;
                case 4:
                    System.out.println("¡Hasta pronto!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 4);
    }
    
    /**
     * Muestra el menú de gestión de cuentas y permite:
     * Agregar, consultar, editar y eliminar cuentas.
     * Incluye validaciones de entradas del usuario.
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
     * Muestra el menú de gestión de Pokémones y permite:
     * Agregar, consultar, editar y eliminar Pokémones.
     * Incluye validaciones de entradas del usuario.
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
     * Muestra el menú de gestión de participantes y permite:
     * Agregar, consultar, editar y eliminar participantes.
     * Incluye validaciones de entradas del usuario.
     */
    private static void menuParticipantes() {
        int opcion;
        
        do {
            System.out.println("\n=== GESTIÓN DE PARTICIPANTES ===");
            System.out.println("1. Agregar participante");
            System.out.println("2. Consultar participante");
            System.out.println("3. Editar participante");
            System.out.println("4. Eliminar participante");
            System.out.println("5. Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            
            opcion = leerEntero();
            
            switch (opcion) {
                case 1:
                    agregarParticipante();
                    break;
                case 2:
                    consultarParticipante();
                    break;
                case 3:
                    editarParticipante();
                    break;
                case 4:
                    eliminarParticipante();
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

    /** Agrega una nueva cuenta al sistema con validaciones de entrada. */
    private static void agregarCuenta() {
        System.out.println("\n--- Agregar Cuenta ---");
        scanner.nextLine(); // Limpiar buffer
        
        try {
            // Validar código (no vacío)
            String codigo;
            while (true) {
                System.out.print("Código de entrenador: ");
                codigo = scanner.nextLine().trim();
                if (!codigo.isEmpty()) {
                    break;
                } else {
                    System.out.println("Error: El código no puede estar vacío.");
                }
            }
            
            // Validar username (no vacío)
            String username;
            while (true) {
                System.out.print("Username: ");
                username = scanner.nextLine().trim();
                if (!username.isEmpty()) {
                    break;
                } else {
                    System.out.println("Error: El username no puede estar vacío.");
                }
            }
            
            System.out.print("Nivel: ");
            int nivel = leerEntero();
            scanner.nextLine(); // Limpiar buffer
            
            // Validar que el equipo sea uno de los tres permitidos
            String equipo;
            while (true) {
                System.out.print("Equipo (sabiduría/instinto/valor): ");
                equipo = scanner.nextLine().toLowerCase().trim();
                
                if (equipo.equals("sabiduría") || equipo.equals("instinto") || equipo.equals("valor")) {
                    break;
                } else {
                    System.out.println("Error: Solo se permiten 'sabiduría', 'instinto' o 'valor'.");
                }
            }
            
            Cuenta nuevaCuenta = new Cuenta(codigo, username, nivel, equipo);
            Cuenta.agregarCuenta(nuevaCuenta);
            
        } catch (Exception e) {
            System.out.println("Error al agregar cuenta: " + e.getMessage());
        }
    }
    
    /** Consulta una cuenta existente por código de entrenador. */
    private static void consultarCuenta() {
        System.out.println("\n--- Consultar Cuenta ---");
        scanner.nextLine(); // Limpiar buffer
        
        try {
            // Validar código (no vacío)
            String codigo;
            while (true) {
                System.out.print("Ingrese el código de entrenador: ");
                codigo = scanner.nextLine().trim();
                if (!codigo.isEmpty()) {
                    break;
                } else {
                    System.out.println("Error: El código no puede estar vacío.");
                }
            }
            
            String resultado = Cuenta.consultarCuenta(codigo);
            if (resultado != null) {
                System.out.println("\nDatos de la cuenta:");
                System.out.println(resultado);
            }
            
        } catch (Exception e) {
            System.out.println("Error al consultar cuenta: " + e.getMessage());
        }
    }
    
    /** Edita una cuenta existente, solicitando nuevos datos al usuario. */
    private static void editarCuenta() {
        System.out.println("\n--- Editar Cuenta ---");
        scanner.nextLine(); // Limpiar buffer
        
        try {
            // Validar código (no vacío)
            String codigo;
            while (true) {
                System.out.print("Ingrese el código de entrenador a editar: ");
                codigo = scanner.nextLine().trim();
                if (!codigo.isEmpty()) {
                    break;
                } else {
                    System.out.println("Error: El código no puede estar vacío.");
                }
            }
            
            // Primero consultamos si existe
            String existente = Cuenta.consultarCuenta(codigo);
            if (existente == null) {
                System.out.println("No se puede editar: cuenta no encontrada.");
                return;
            }
            
            System.out.println("Ingrese los nuevos datos:");
            
            // Validar username (no vacío)
            String username;
            while (true) {
                System.out.print("Nuevo username: ");
                username = scanner.nextLine().trim();
                if (!username.isEmpty()) {
                    break;
                } else {
                    System.out.println("Error: El username no puede estar vacío.");
                }
            }
            
            System.out.print("Nuevo nivel: ");
            int nivel = leerEntero();
            scanner.nextLine(); // Limpiar buffer
            
            // Validar que el equipo sea uno de los tres permitidos
            String equipo;
            while (true) {
                System.out.print("Nuevo equipo (sabiduría/instinto/valor): ");
                equipo = scanner.nextLine().toLowerCase().trim();
                
                if (equipo.equals("sabiduría") || equipo.equals("instinto") || equipo.equals("valor")) {
                    break;
                } else {
                    System.out.println("Error: Solo se permiten 'sabiduría', 'instinto' o 'valor'.");
                }
            }
            
            Cuenta cuentaEditada = new Cuenta(codigo, username, nivel, equipo);
            Cuenta.editarCuenta(cuentaEditada);
            System.out.println("Cuenta editada exitosamente.");
            
        } catch (Exception e) {
            System.out.println("Error al editar cuenta: " + e.getMessage());
        }
    }
    
    /** Elimina una cuenta existente del sistema por código de entrenador. */
    private static void eliminarCuenta() {
        System.out.println("\n--- Eliminar Cuenta ---");
        scanner.nextLine(); // Limpiar buffer
        
        try {
            // Validar código (no vacío)
            String codigo;
            while (true) {
                System.out.print("Ingrese el código de entrenador a eliminar: ");
                codigo = scanner.nextLine().trim();
                if (!codigo.isEmpty()) {
                    break;
                } else {
                    System.out.println("Error: El código no puede estar vacío.");
                }
            }
            
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
            System.out.println("Error al eliminar cuenta: " + e.getMessage());
        }
    }
    
    // POKÉMONES 
    
    /** Agrega un nuevo Pokémon al sistema con validación de datos. */
    private static void agregarPokemon() {
        System.out.println("\n--- Agregar Pokémon ---");
        scanner.nextLine();
        
        try {
            // Generar ID automáticamente (ya que la clase lo hace)
            String idPokemon = Pokemon.generarID();
            System.out.println("ID generado automáticamente: " + idPokemon);
            
            String nombre;
            while (true) {
                System.out.print("Nombre: ");
                nombre = scanner.nextLine().trim();
                if (!nombre.isEmpty()) {
                    break;
                } else {
                    System.out.println("Error: El nombre no puede estar vacío.");
                }
            }
            
            String especie;
            while (true) {
                System.out.print("Especie: ");
                especie = scanner.nextLine().trim();
                if (!especie.isEmpty()) {
                    break;
                } else {
                    System.out.println("Error: La especie no puede estar vacía.");
                }
            }
            
            String tipo;
            while (true) {
                System.out.print("Tipo: ");
                tipo = scanner.nextLine().trim();
                if (!tipo.isEmpty()) {
                    break;
                } else {
                    System.out.println("Error: El tipo no puede estar vacío.");
                }
            }
            
            System.out.print("CP: ");
            int cp = leerEntero();
            
            System.out.print("Peso: ");
            int peso = leerEntero();
            scanner.nextLine(); // Limpiar buffer
            
            // Validar sexo (solo hembra, macho o desconocido)
            String sexo;
            while (true) {
                System.out.print("Sexo (macho/hembra/desconocido): ");
                sexo = scanner.nextLine().toLowerCase().trim();
                
                if (sexo.equals("macho") || sexo.equals("hembra") || sexo.equals("desconocido")) {
                    break;
                } else {
                    System.out.println("Error: Solo se permiten 'macho', 'hembra' o 'desconocido'.");
                }
            }
            
            boolean esShiny = leerBooleano();
            
            Pokemon nuevoPokemon = new Pokemon(nombre, especie, tipo, cp, peso, sexo, esShiny);
            Pokemon.agregarPokemon(nuevoPokemon);
            // El mensaje de éxito lo muestra la clase Pokemon
            
        } catch (Exception e) {
            System.out.println("Error al agregar pokémon: " + e.getMessage());
        }
    }
    
    /** Consulta un Pokémon existente por su ID. */
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
    
    /** Edita un Pokémon existente, solicitando nuevos datos al usuario. */
    private static void editarPokemon() {
        System.out.println("\n--- Editar Pokémon ---");
        scanner.nextLine(); // Limpiar buffer
        
        try {
            System.out.print("Ingrese el ID del Pokémon a editar: ");
            String idPokemon = scanner.nextLine().trim();
            
            // Primero consultamos si existe
            String existente = Pokemon.consultarPokemon(idPokemon);
            if (existente == null) {
                System.out.println("No se puede editar: Pokémon no encontrado.");
                return;
            }
            
            System.out.println("Ingrese los nuevos datos:");
            
            
            String nombre;
            while (true) {
                System.out.print("Nuevo nombre: ");
                nombre = scanner.nextLine().trim();
                if (!nombre.isEmpty()) {
                    break;
                } else {
                    System.out.println("Error: El nombre no puede estar vacío.");
                }
            }
            
            String especie;
            while (true) {
                System.out.print("Nueva especie: ");
                especie = scanner.nextLine().trim();
                if (!especie.isEmpty()) {
                    break;
                } else {
                    System.out.println("Error: La especie no puede estar vacía.");
                }
            }
            
            
            String tipo;
            while (true) {
                System.out.print("Nuevo tipo: ");
                tipo = scanner.nextLine().trim();
                if (!tipo.isEmpty()) {
                    break;
                } else {
                    System.out.println("Error: El tipo no puede estar vacío.");
                }
            }
            
            System.out.print("Nuevo CP: ");
            int cp = leerEntero();
            
            System.out.print("Nuevo peso: ");
            int peso = leerEntero();
            scanner.nextLine();
            
            // Validar sexo (solo hembra, macho o desconocido)
            String sexo;
            while (true) {
                System.out.print("Nuevo sexo (macho/hembra/desconocido): ");
                sexo = scanner.nextLine().toLowerCase().trim();
                
                if (sexo.equals("macho") || sexo.equals("hembra") || sexo.equals("desconocido")) {
                    break;
                } else {
                    System.out.println("Error: Solo se permiten 'macho', 'hembra' o 'desconocido'.");
                }
            }
            
            boolean esShiny = leerBooleano();
            
            Pokemon pokemonEditado = new Pokemon(nombre, especie, tipo, cp, peso, sexo, esShiny);
            pokemonEditado.setidPokemon(idPokemon); 
            
            Pokemon.editarPokemon(pokemonEditado);
            System.out.println("Pokémon editado exitosamente.");
            
        } catch (Exception e) {
            System.out.println("Error al editar pokémon: " + e.getMessage());
        }
    }
    
    /** Elimina un Pokémon existente por su ID. */
    private static void eliminarPokemon() {
        System.out.println("\n--- Eliminar Pokémon ---");
        scanner.nextLine(); 
        
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
            
            // Crear el Pokémon con el nuevo constructor
            Pokemon pokemonEliminar = new Pokemon(
                datos[1],  // nombre
                datos[2],  // especie
                datos[3],  // tipo
                Integer.parseInt(datos[4]),  // cp
                Integer.parseInt(datos[5]),  // peso
                datos[6],  // sexo
                esShiny    // esShiny
            );
            
            // Forzar el ID que queremos eliminar (porque el constructor genera uno nuevo)
            pokemonEliminar.setidPokemon(idPokemon);
            
            Pokemon.eliminarPokemon(pokemonEliminar);
            System.out.println("Pokémon eliminado exitosamente.");
            
        } catch (Exception e) {
            System.out.println("Error al eliminar pokémon: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    // PARTICIPANTES

    /** Agrega un nuevo participante al sistema con todas las validaciones necesarias. */
    private static void agregarParticipante() {
        System.out.println("\n--- Agregar Participante ---");
        scanner.nextLine(); // Limpiar buffer
        
        try {
            // Validar nombre (no vacío)
            String nombre;
            while (true) {
                System.out.print("Nombre: ");
                nombre = scanner.nextLine().trim();
                if (!nombre.isEmpty()) {
                    break;
                } else {
                    System.out.println("Error: El nombre no puede estar vacío.");
                }
            }
            
            // Validar apellido paterno (no vacío)
            String apellidoP;
            while (true) {
                System.out.print("Apellido paterno: ");
                apellidoP = scanner.nextLine().trim();
                if (!apellidoP.isEmpty()) {
                    break;
                } else {
                    System.out.println("Error: El apellido paterno no puede estar vacío.");
                }
            }
            
            // Validar apellido materno (no vacío)
            String apellidoM;
            while (true) {
                System.out.print("Apellido materno: ");
                apellidoM = scanner.nextLine().trim();
                if (!apellidoM.isEmpty()) {
                    break;
                } else {
                    System.out.println("Error: El apellido materno no puede estar vacío.");
                }
            }
            
            // Validar fecha de nacimiento (número)
            int birthdate;
            while (true) {
                System.out.print("Año de nacimiento (4 dígitos): ");
                try {
                    birthdate = Integer.parseInt(scanner.nextLine().trim());
                    if (birthdate >= 1900 && birthdate <= 2023) {
                        break;
                    } else {
                        System.out.println("Error: El año debe estar entre 1900 y 2023.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un número válido.");
                }
            }
            
            // Validar edad (número)
            int edad;
            while (true) {
                System.out.print("Edad: ");
                try {
                    edad = Integer.parseInt(scanner.nextLine().trim());
                    if (edad > 0 && edad < 120) {
                        break;
                    } else {
                        System.out.println("Error: La edad debe ser entre 1 y 119 años.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un número válido.");
                }
            }
            
            // Validar sexo (solo opciones válidas)
            String sexo;
            while (true) {
                System.out.print("Sexo (hombre/mujer/otro): ");
                sexo = scanner.nextLine().toLowerCase().trim();
                if (sexo.equals("hombre") || sexo.equals("mujer") || sexo.equals("otro")) {
                    break;
                } else {
                    System.out.println("Error: Solo se permiten 'hombre', 'mujer' u 'otro'.");
                }
            }
            
            // Validar teléfonos (al menos uno)
            int[] telefonos;
            while (true) {
                System.out.print("Teléfonos (separados por coma): ");
                String telefonosStr = scanner.nextLine().trim();
                if (!telefonosStr.isEmpty()) {
                    try {
                        String[] telArray = telefonosStr.split(",");
                        telefonos = new int[telArray.length];
                        for (int i = 0; i < telArray.length; i++) {
                            telefonos[i] = Integer.parseInt(telArray[i].trim());
                        }
                        break;
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Los teléfonos deben ser números válidos.");
                    }
                } else {
                    System.out.println("Error: Debe ingresar al menos un teléfono.");
                }
            }
            
            // Validar correos (al menos uno)
            String[] mails;
            while (true) {
                System.out.print("Correos electrónicos (separados por coma): ");
                String mailsStr = scanner.nextLine().trim();
                if (!mailsStr.isEmpty()) {
                    mails = mailsStr.split(",");
                    for (int i = 0; i < mails.length; i++) {
                        mails[i] = mails[i].trim();
                    }
                    break;
                } else {
                    System.out.println("Error: Debe ingresar al menos un correo electrónico.");
                }
            }
            
            // Validar número de cuenta (número único)
            int numCuenta;
            while (true) {
                System.out.print("Número de cuenta: ");
                try {
                    numCuenta = Integer.parseInt(scanner.nextLine().trim());
                    // Verificar si ya existe
                    if (Participantes.buscarPorNumCuenta(numCuenta) != null) {
                        System.out.println("Error: Este número de cuenta ya está registrado.");
                    } else {
                        break;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un número válido.");
                }
            }
            
            // Validar facultad (no vacío)
            String facultad;
            while (true) {
                System.out.print("Facultad: ");
                facultad = scanner.nextLine().trim();
                if (!facultad.isEmpty()) {
                    break;
                } else {
                    System.out.println("Error: La facultad no puede estar vacía.");
                }
            }
            
            // Validar carrera (no vacío)
            String carrera;
            while (true) {
                System.out.print("Carrera: ");
                carrera = scanner.nextLine().trim();
                if (!carrera.isEmpty()) {
                    break;
                } else {
                    System.out.println("Error: La carrera no puede estar vacía.");
                }
            }
            
            // Opcional: Asociar cuenta existente
            Cuenta cuenta = null;
            System.out.print("¿Desea asociar una cuenta existente? (sí/no): ");
            String respuesta = scanner.nextLine().toLowerCase().trim();
            if (respuesta.equals("sí") || respuesta.equals("si") || respuesta.equals("s")) {
                System.out.print("Código de la cuenta a asociar: ");
                // Aquí deberías tener un método para buscar cuenta por código
                // cuenta = Cuenta.buscarPorCodigo(codigoCuenta);
                if (cuenta == null) {
                    System.out.println("Cuenta no encontrada. Se creará sin cuenta asociada.");
                }
            }
            
            Participantes nuevoParticipante = new Participantes(
                nombre, apellidoP, apellidoM, birthdate, edad, sexo, 
                telefonos, mails, numCuenta, facultad, carrera, cuenta
            );
            
            Participantes.AddParticipante(nuevoParticipante);
            System.out.println("Participante agregado exitosamente.");
            
        } catch (Exception e) {
            System.out.println("Error al agregar participante: " + e.getMessage());
            e.printStackTrace();
        }
    }

    /** Consulta un participante por su número de cuenta y muestra sus datos. */
    private static void consultarParticipante() {
        System.out.println("\n--- Consultar Participante ---");
        scanner.nextLine(); // Limpiar buffer
        
        try {
            // Validar número de cuenta (no vacío)
            int numCuenta;
            while (true) {
                System.out.print("Ingrese el número de cuenta del participante: ");
                try {
                    numCuenta = Integer.parseInt(scanner.nextLine().trim());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un número válido.");
                }
            }
            
            Participantes participante = Participantes.buscarPorNumCuenta(numCuenta);
            if (participante != null) {
                System.out.println("\n=== DATOS DEL PARTICIPANTE ===");
                System.out.println("Nombre: " + participante.getNombre() + " " + 
                                 participante.getApellidoP() + " " + participante.getApellidoM());
                System.out.println("Edad: " + participante.getEdad() + " años");
                System.out.println("Sexo: " + participante.getSexo());
                System.out.println("Teléfonos: " + Arrays.toString(participante.getTelefonos()));
                System.out.println("Correos: " + Arrays.toString(participante.getMails()));
                System.out.println("Número de cuenta: " + participante.getNumDeCuenta());
                System.out.println("Facultad: " + participante.getFacultad());
                System.out.println("Carrera: " + participante.getCarrera());
                if (participante.getCuenta() != null) {
                    System.out.println("Cuenta asociada: " + participante.getCuenta().getLlaveCodigo());
                } else {
                    System.out.println("Cuenta asociada: Ninguna");
                }
            } else {
                System.out.println("No se encontró participante con número de cuenta: " + numCuenta);
            }
            
        } catch (Exception e) {
            System.out.println("Error al consultar participante: " + e.getMessage());
        }
    }
    
    /** Edita un participante existente, permitiendo mantener datos actuales si se deja en blanco. */
    private static void editarParticipante() {
        System.out.println("\n--- Editar Participante ---");
        scanner.nextLine(); // Limpiar buffer
        
        try {
            // Validar número de cuenta (no vacío)
            int numCuenta;
            while (true) {
                System.out.print("Ingrese el número de cuenta del participante a editar: ");
                try {
                    numCuenta = Integer.parseInt(scanner.nextLine().trim());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un número válido.");
                }
            }
            
            // Primero consultamos si existe
            Participantes existente = Participantes.buscarPorNumCuenta(numCuenta);
            if (existente == null) {
                System.out.println("No se puede editar: participante no encontrado.");
                return;
            }
            
            System.out.println("Ingrese los nuevos datos (deje en blanco para mantener el actual):");
            
            // Nombre
            System.out.print("Nuevo nombre [" + existente.getNombre() + "]: ");
            String nombre = scanner.nextLine().trim();
            if (nombre.isEmpty()) nombre = existente.getNombre();
            
            // Apellido paterno
            System.out.print("Nuevo apellido paterno [" + existente.getApellidoP() + "]: ");
            String apellidoP = scanner.nextLine().trim();
            if (apellidoP.isEmpty()) apellidoP = existente.getApellidoP();
            
            // Apellido materno
            System.out.print("Nuevo apellido materno [" + existente.getApellidoM() + "]: ");
            String apellidoM = scanner.nextLine().trim();
            if (apellidoM.isEmpty()) apellidoM = existente.getApellidoM();
            
            // Edad
            System.out.print("Nueva edad [" + existente.getEdad() + "]: ");
            String edadStr = scanner.nextLine().trim();
            int edad = edadStr.isEmpty() ? existente.getEdad() : Integer.parseInt(edadStr);
            
            // Resto de los campos similares...
            // (Aquí deberías agregar validaciones para todos los campos como en agregar)
            
            // Crear participante editado (simplificado)
            Participantes editado = new Participantes(
                nombre, apellidoP, apellidoM, existente.getBirthdate(), edad,
                existente.getSexo(), existente.getTelefonos(), existente.getMails(),
                numCuenta, existente.getFacultad(), existente.getCarrera(), existente.getCuenta()
            );
            
            if (Participantes.editarParticipante(numCuenta, editado)) {
                System.out.println("Participante editado exitosamente.");
            } else {
                System.out.println("Error al editar participante.");
            }
            
        } catch (Exception e) {
            System.out.println("Error al editar participante: " + e.getMessage());
        }
    }
    
    /** Elimina un participante del sistema por su número de cuenta. */
    private static void eliminarParticipante() {
        System.out.println("\n--- Eliminar Participante ---");
        scanner.nextLine(); // Limpiar buffer
        
        try {
            // Validar número de cuenta (no vacío)
            int numCuenta;
            while (true) {
                System.out.print("Ingrese el número de cuenta del participante a eliminar: ");
                try {
                    numCuenta = Integer.parseInt(scanner.nextLine().trim());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Error: Debe ingresar un número válido.");
                }
            }
            
            if (Participantes.eliminarParticipante(numCuenta)) {
                System.out.println("Participante eliminado exitosamente.");
            } else {
                System.out.println("No se encontró participante con número de cuenta: " + numCuenta);
            }
            
        } catch (Exception e) {
            System.out.println("Error al eliminar participante: " + e.getMessage());
        }
    }
}