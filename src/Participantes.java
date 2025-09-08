import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Participantes{
    
    private static String archivo = "participantes.csv";  
    private static String encabezado = "nombre, apellidoP, apellidoM, fecha, edad, correo, numCuenta, facultad, carrera, pokemonCuenta";
    private String nombre;
    private String apellidoP;
    private String apellidoM;  
    private int birthdate;
    private int edad;
    private String[] mails;
    private int numCuenta; //esta va a ser la llave
    private String facultad;
    private String carrera;
    private Cuenta cuenta;

    public Participantes(String nombre, String apellidoP,String apellidoM,
                         int birthdate, int edad, String[]mails,
                         int numCuenta, String facultad,
                         String carrera, Cuenta cuenta){

        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        this.birthdate = birthdate;
        this.edad = edad;
        this.mails = mails;
        this.numCuenta = numCuenta;
        this.facultad = facultad;
        this.carrera = carrera;
        this.cuenta = cuenta;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getApellidoP(){
        return apellidoP;
    }
    public void setApellidoP(String apellidoP){
        this.apellidoP = apellidoP;
    }
    public String getApellidoM(){
        return apellidoM;
    }
    public void setApellidoM(String apellidoM){
        this.apellidoM = apellidoM;
    }
    public int getEdad(){
        return edad;
    }
    public void setEdad(int edad){
        this.edad = edad;
    }
    public String[] getMails(){
        return mails;
    }
    public void setMails(String[] mails) {
        this.mails = mails;
    }
    public int getBirthdate(){
        return birthdate;
    }
    public void setBirthdate(int birthdate){
        this.birthdate = birthdate;
    }
    public int getNumDeCuenta(){
        return numCuenta;
    }
    public void setNumDeCuenta(int numCuenta){
        this.numCuenta = numCuenta;
    }
    public String getFacultad(){
        return facultad;
    }
    public void setFacultad(String facultad){
        this.facultad = facultad;
    }
    public String getCarrera(){
        return carrera;
    }
    public void setCarrera(String carrera){
        this.carrera = carrera;
    }
    public Cuenta getCuenta(){
        return cuenta;
    }
    public void setCuenta(Cuenta cuenta){
        this.cuenta = cuenta;
    }

    @Override
    public String toString() {
        return "Participantes{" +
                "nombre='" + nombre + '\'' +
                ", apellidoP='" + apellidoP + '\'' +
                ", apellidoM='" + apellidoM + '\'' +
                ", birthdate=" + birthdate +
                ", edad=" + edad +
                ", mails=" + Arrays.toString(mails) +
                ", numCuenta=" + numCuenta +
                ", facultad='" + facultad + '\'' +
                ", carrera='" + carrera + '\'' +
                ", cuenta=" + cuenta.getLlaveCodigo() +
                '}';
    }

    public String toCSV() {
        // Convertir array de correos a strings con ;
        String correosStr = String.join(";", mails);
        // obtenemos la llave de la cuenta para guardarla en el archivo
        String cuentaLlave = (cuenta != null) ? cuenta.getLlaveCodigo() : "";
        return String.format("%s,%s,%s,%d,%d,%s,%d,%s,%s,%s",
                nombre, apellidoP, apellidoM, birthdate, edad, 
                correosStr, numCuenta, facultad, carrera, cuentaLlave);
    }

    // Método para agregar participante al archivo
    public static void AddParticipante(Participantes p) {
        try (FileWriter fw = new FileWriter(archivo, true);
             BufferedWriter bw = new BufferedWriter(fw);
             PrintWriter out = new PrintWriter(bw)) {
           
            File file = new File(archivo);
            if (file.length() == 0) {
                out.println(encabezado);
            }
            
            out.println(p.toCSV());
            
        } catch (IOException e) {
            System.err.println("Error al agregar participante: " + e.getMessage());
        }
    }

    // Método para leer todos los participantes del archivo
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

    // Método para parsear una línea CSV a objeto Participantes
    private static Participantes parsearLineaCSV(String linea) {
        try {
            String[] partes = linea.split(",");
            
            if (partes.length < 10) {
                System.err.println("Línea CSV incompleta: " + linea);
                return null;
            }
            
            String nombre = partes[0].trim();
            String apellidoP = partes[1].trim();
            String apellidoM = partes[2].trim();
            int birthdate = Integer.parseInt(partes[3].trim());
            int edad = Integer.parseInt(partes[4].trim());
            
            // Parsear correos a arreglos
            String[] mails = partes[5].trim().split(";");
            
            int numCuenta = Integer.parseInt(partes[6].trim());
            String facultad = partes[7].trim();
            String carrera = partes[8].trim();
            String cuentaLlave = partes[9].trim();
            Cuenta cuenta = null;
            if(!cuentaLlave.isEmpty()){
                cuenta = Cuenta.consultarCuentaI(cuentaLlave);
            }
            return new Participantes(nombre, apellidoP, apellidoM, birthdate, 
                                   edad, mails, numCuenta, facultad, carrera, cuenta);
            
        } catch (Exception e) {
            System.err.println("Error al parsear línea CSV: " + linea);
            e.printStackTrace();
            return null;
        }
    }

    // Método para editar un participante existente
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

    // Método para eliminar un participante
    public static boolean eliminarParticipante(int numCuenta) {
        List<Participantes> participantes = leerParticipantes();
        boolean encontrado = participantes.removeIf(p -> p.getNumDeCuenta() == numCuenta);
        
        if (encontrado) {
            return guardarTodosParticipantes(participantes);
        }
        
        return false;
    }

    // Método para guardar todos los participantes para edición y eliminación
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

    // Método para buscar participante por número de cuenta
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
