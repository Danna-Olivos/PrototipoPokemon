import java.io.*;

public class Participantes{
    
    private static String archivo = "participantes.csv";  
    private String nombre;
    private String apellidoP;
    private String apellidoM;  
    private int birthdate;
    private int edad;
    private String[] mails;
    private int numCuenta;
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

    public void AddParticipante(Participantes p){
        //glupglup
    }
}
