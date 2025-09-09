import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * La clase <code>Participantes</code> modela a un participante del sistema.
 * 
 * Cada participante tiene un nombre, apellidos, fecha de nacimiento, edad, sexo,
 * teléfonos, correos electrónicos, número de cuenta (que funciona como llave),
 * facultad, carrera y una cuenta asociada de tipo {@link Cuenta}.
 * 
 * La información de los participantes se almacena en un archivo CSV.
 */
public class Participantes{
    /** Nombre del archivo CSV donde se almacenan los participantes. */
    private static String archivo = "participantes.csv";  
    /** Encabezado del archivo CSV. */
    private static String encabezado = "nombre, apellidoP, apellidoM, fecha, edad, sexo, telefonos, correo, numCuenta, facultad, carrera, pokemonCuenta";
    /** Nombre del participante. */
    private String nombre;
    /** Apellido paterno del participante. */
    private String apellidoP;
    /** Apellido materno del participante. */
    private String apellidoM;  
    /** Fecha de nacimiento del participante (representada como entero). */
    private int birthdate;
    /** Edad del participante. */
    private int edad;
    /** Sexo del participante. */
    private String sexo;
    /** Números de teléfono del participante. */
    private int[] telefonos;
    /** Correos electrónicos del participante. */
    private String[] mails;
    /** Número de cuenta único (llave primaria). */
    private int numCuenta;
    /** Facultad a la que pertenece el participante. */
    private String facultad;
    /** Carrera que estudia el participante. */
    private String carrera;
    /** Cuenta asociada del participante. */
    private Cuenta cuenta;

    /**
     * Constructor para la clase <code>Participantes</code>.
     *
     * @param nombre nombre
     * @param apellidoP apellido paterno
     * @param apellidoM apellido materno
     * @param birthdate fecha de nacimiento
     * @param edad edad
     * @param sexo sexo
     * @param telefonos teléfonos
     * @param mails correos electrónicos
     * @param numCuenta número de cuenta único
     * @param facultad facultad
     * @param carrera carrera
     * @param cuenta cuenta de Pokémon asociada
     */
    public Participantes(String nombre, String apellidoP,String apellidoM,
                         int birthdate, int edad, String sexo, int[] telefonos, String[]mails,
                         int numCuenta, String facultad,
                         String carrera, Cuenta cuenta){

        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.birthdate = birthdate;
        this.edad = edad;
        this.sexo = sexo;
        this.telefonos = telefonos;
        this.mails = mails;
        this.numCuenta = numCuenta;
        this.facultad = facultad;
        this.carrera = carrera;
        this.cuenta = cuenta;
    }

    /** @return el nombre del participante */
    public String getNombre(){ return nombre; }
    
    /** @param nombre nuevo nombre del participante */
    public void setNombre(String nombre){ this.nombre = nombre; }
    
    /** @return el apellido paterno */
    public String getApellidoP(){ return apellidoP; }
    
    /** @param apellidoP nuevo apellido paterno */
    public void setApellidoP(String apellidoP){ this.apellidoP = apellidoP; }
    
    /** @return el apellido materno */
    public String getApellidoM(){ return apellidoM; }
    
    /** @param apellidoM nuevo apellido materno */
    public void setApellidoM(String apellidoM){ this.apellidoM = apellidoM; }
    
    /** @return la edad */
    public int getEdad(){ return edad; }
    
    /** @param edad nueva edad */
    public void setEdad(int edad){ this.edad = edad; }
    
    /** @return el sexo */
    public String getSexo(){ return sexo; }
    
    /** @param sexo nuevo sexo */
    public void setSexo(String sexo){ this.sexo = sexo; }
    
    /** @return los teléfonos */
    public int[] getTelefonos(){ return telefonos; }
    
    /** @param telefonos nuevos teléfonos */
    public void setTelefonos(int[] telefonos){ this.telefonos = telefonos; }
    
    /** @return los correos electrónicos */
    public String[] getMails(){ return mails; }
    
    /** @param mails nuevos correos electrónicos */
    public void setMails(String[] mails) { this.mails = mails; }
    
    /** @return la fecha de nacimiento */
    public int getBirthdate(){ return birthdate; }
    
    /** @param birthdate nueva fecha de nacimiento */
    public void setBirthdate(int birthdate){ this.birthdate = birthdate; }
    
    /** @return el número de cuenta */
    public int getNumDeCuenta(){ return numCuenta; }
    
    /** @param numCuenta nuevo número de cuenta */
    public void setNumDeCuenta(int numCuenta){ this.numCuenta = numCuenta; }
    
    /** @return la facultad */
    public String getFacultad(){ return facultad; }
    
    /** @param facultad nueva facultad */
    public void setFacultad(String facultad){ this.facultad = facultad; }
    
    /** @return la carrera */
    public String getCarrera(){ return carrera; }
    
    /** @param carrera nueva carrera */
    public void setCarrera(String carrera){ this.carrera = carrera; }
    
    /** @return la cuenta asociada */
    public Cuenta getCuenta(){ return cuenta; }
    
    /** @param cuenta nueva cuenta asociada */
    public void setCuenta(Cuenta cuenta){ this.cuenta = cuenta; }

    /**
     * Convierte al participante en formato CSV.
     *
     * @return una cadena con todos los atributos separados por comas
     */
    public String toCSV() {
        String telefonosStr = Arrays.stream(telefonos)
                               .mapToObj(String::valueOf)
                               .collect(Collectors.joining("/"));
        // Convertir array de correos a strings con ;
        String correosStr = String.join("/", mails);
        // obtenemos la llave de la cuenta para guardarla en el archivo
        String cuentaLlave = (cuenta != null) ? cuenta.getLlaveCodigo() : "";
        return String.format("%s,%s,%s,%d,%d,%s,%s,%s,%d,%s,%s,%s",
                nombre, apellidoP, apellidoM, birthdate, edad, sexo, telefonosStr,
                correosStr, numCuenta, facultad, carrera, cuentaLlave);
    }

    /**
     * Agrega un nuevo participante al archivo CSV.
     * Verifica que no exista previamente un participante con el mismo número de cuenta.
     *
     * @param p el participante a agregar
     */
    public static void AddParticipante(Participantes p) {
        try (FileWriter fw = new FileWriter(archivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
           
            File file = new File(archivo);
            if (file.length() == 0) {
                out.println(encabezado);
            }
            if(existeNumCuenta(p.getNumDeCuenta())){
                System.err.println("El participante que quiere agregar ya exsite");
            }else{
                out.println(p.toCSV());
            }
            
        } catch (IOException e) {
            System.err.println("Error al agregar participante: " + e.getMessage());
        }
    }

    /**
     * Metodo auxiliar para verificar si un número de cuenta ya existe
     * 
     * @param numCuenta el numero de cuenta del participante
     */
    private static boolean existeNumCuenta(int numCuenta) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            boolean primeraLinea = true;
            
            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue; 
                }
                
                // Extraer el número de cuenta de la línea CSV
                String[] partes = linea.split(",");
                if (partes.length >= 12) { 
                    try {
                        int numCuentaActual = Integer.parseInt(partes[8].trim()); 
                        if (numCuentaActual == numCuenta) {
                            return true; 
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Error al parsear número de cuenta: " + partes[8]);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al verificar duplicados: " + e.getMessage());
        }
        
        return false;
    }
    
    /**
     * Lee todos los participantes del archivo CSV.
     *
     * @return la lista de participantes
     */
    public static List<Participantes> leerParticipantes() {
        List<Participantes> participantes = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            boolean primeraLinea = true;
            
            while ((linea = br.readLine()) != null) {
                if (primeraLinea) {
                    primeraLinea = false;
                    continue; 
                }
                
                Participantes p = parsearLineaCSV(linea);
                if (p != null) {
                    participantes.add(p);
                }
            }
            
        } catch (IOException e) {
            System.err.println("Error al leer participantes: " + e.getMessage());
        }
        
        return participantes;
    }

    /**
     * Metodo auxiliar para parsear una línea CSV a objeto Participantes
     * @param linea linea a parsear
     * @return el participante
     */
    private static Participantes parsearLineaCSV(String linea) {
        try {
            String[] partes = linea.split(",");
            
            if (partes.length < 12) {
                System.err.println("Línea CSV incompleta: " + linea);
                return null;
            }
            
            String nombre = partes[0].trim();
            String apellidoP = partes[1].trim();
            String apellidoM = partes[2].trim();
            int birthdate = Integer.parseInt(partes[3].trim());
            int edad = Integer.parseInt(partes[4].trim());
            String sexo = partes[5].trim();
            //Parsear telefonos a arreglos
            String[] telefonosStr = partes[6].trim().split("/");
            int[] telefonos = Arrays.stream(telefonosStr).map(String::trim).mapToInt(Integer::parseInt).toArray();
            // Parsear correos a arreglos
            String[] mails = partes[7].trim().split("/");
            
            int numCuenta = Integer.parseInt(partes[8].trim());
            String facultad = partes[9].trim();
            String carrera = partes[10].trim();
            String cuentaLlave = partes[11].trim();
            Cuenta cuenta = null;
            if(!cuentaLlave.isEmpty()){
                cuenta = Cuenta.consultarCuentaI(cuentaLlave);
            }
            return new Participantes(nombre, apellidoP, apellidoM, birthdate, 
                                   edad,sexo,telefonos, mails, numCuenta, facultad, carrera, cuenta);
            
        } catch (Exception e) {
            System.err.println("Error al parsear línea CSV: " + linea);
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Edita un participante existente identificado por su número de cuenta.
     *
     * @param numCuenta número de cuenta del participante a editar
     * @param nuevo objeto participante con los nuevos datos
     * @return <code>true</code> si se editó correctamente, <code>false</code> si no se encontró
     */
    public static boolean editarParticipante(int numCuenta, Participantes nuevo) {
        List<Participantes> participantes = leerParticipantes();
        boolean encontrado = false;
        
        for (int i = 0; i < participantes.size(); i++) {
            if (participantes.get(i).getNumDeCuenta() == numCuenta) {
                participantes.set(i, nuevo);
                encontrado = true;
                break;
            }
        }
        
        if (encontrado) {
            return guardarTodosParticipantes(participantes);
        }
        
        return false;
    }

    /**
     * Elimina un participante del archivo CSV.
     *
     * @param numCuenta número de cuenta del participante a eliminar
     * @return <code>true</code> si se eliminó, <code>false</code> si no se encontró
     */
    public static boolean eliminarParticipante(int numCuenta) {
        List<Participantes> participantes = leerParticipantes();
        boolean encontrado = participantes.removeIf(p -> p.getNumDeCuenta() == numCuenta);
        
        if (encontrado) {
            return guardarTodosParticipantes(participantes);
        }
        
        return false;
    }

    /**
     * Método auxiliar para guardar todos los participantes para edición y eliminación
     * @param participantes la lista de participantes
     * @return <code>true</code> si se guardaron los participantes, <code>false</code> en caso contrario.
     */
    private static boolean guardarTodosParticipantes(List<Participantes> participantes) {
        try (PrintWriter out = new PrintWriter(new FileWriter(archivo))) {
            out.println(encabezado);
            
            for (Participantes p : participantes) {
                out.println(p.toCSV());
            }
            
            return true;
            
        } catch (IOException e) {
            System.err.println("Error al guardar participantes: " + e.getMessage());
            return false;
        }
    }

    /**
     * Busca un participante por número de cuenta en el archivo CSV.
     *
     * @param numCuenta número de cuenta del participante
     * @return el participante si se encuentra, <code>null</code> en caso contrario
     */
    public static Participantes buscarPorNumCuenta(int numCuenta) {
        List<Participantes> participantes = leerParticipantes();
        
        for (Participantes p : participantes) {
            if (p.getNumDeCuenta() == numCuenta) {
                return p;
            }
        }
        
        return null;
    }
}