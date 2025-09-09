import java.io.*;
import java.util.*;

/**
 * La clase <code>Cuenta</code> modela una cuenta de entrenador de Pokémon Go
 * que se almacena en un archivo CSV. 
 * 
 * Cada cuenta tiene un código único de entrenador (la llave), un username,
 * un nivel y un equipo.
 */
public class Cuenta{
    /**
     * Nombre del archivo CSV donde se almacenan las cuentas.
     */
    private static String archivo = "cuentas.csv";
    /**
     * Encabezado del archivo CSV.
     */
    private static String encabezado = "códigoEntrenador,username,nivel,equipo";
    /**
     * Código de entrenador (llave de la cuenta).
     */
    private String llaveCodigo;
    /**
     * Nombre de usuario asociado a la cuenta.
     */
    private String username;
    /**
     * Nivel del entrenador.
     */
    private int nivel;
    /**
     * Equipo del entrenador (sabiduría, instinto o valor).
     */
    private String equipo;

    /**
     * Constructor para la clase <code>Cuenta</code>.
     *
     * @param llaveCodigo código de entrenador
     * @param username nombre de usuario
     * @param nivel nivel de entrenador
     * @param equipo equipo de entrenador
     */
    public Cuenta(String llaveCodigo, String username, int nivel, String equipo){
        this.llaveCodigo = llaveCodigo;
        this.username = username;
        this.nivel = nivel;
        this.equipo = equipo;
    }

    /** @return el código de entrenador de la cuenta */
    public String getLlaveCodigo(){
        return llaveCodigo;
    }
    /** @param llaveCodigo el nuevo código de entrenador */
    public void setLlaveCodigo(String llaveCodigo){
        this.llaveCodigo = llaveCodigo;
    }
    /** @return el username de la cuenta */
    public String getUsername(){
        return username;
    }
    /** @param username el nuevo username */
    public void setUsername(String username){
        this.username = username;
    }
    /** @return el nivel de la cuenta */
    public int getNivel(){
        return nivel;
    }
    /** @param nivel el nuevo nivel de la cuenta */
    public void setNivel(int nivel){
        this.nivel = nivel;
    }
    /** @return el equipo de la cuenta */
    public String getEquipo(){
        return equipo;
    }
    /** @param equipo el nuevo equipo de la cuenta */
    public void setEquipo(String equipo){
        this.equipo = equipo;
    }

    @Override
    public String toString(){
        return llaveCodigo + "," + username + "," + nivel + "," + equipo;
    }

    public static void agregarCuenta(Cuenta c){
        File archivo = new File("cuentas.csv");
        boolean yaExiste = archivo.exists();

        if(yaExiste && (buscarCuentaPorLlave(c.getLlaveCodigo()) != null)){
            System.out.println("Esa cuenta ya está registrada");
            return;
        }
        
        try (FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw)){
            if(!yaExiste){
                bw.write(encabezado);
                bw.newLine();
            }
            bw.write(c.toString());
            bw.newLine();
        } catch(IOException e){
            System.out.println("Hubo un error u.u");
            e.printStackTrace();
        }
    }

    private static String buscarCuentaPorLlave(String llaveCodigo) {
        File archivo = new File("cuentas.csv");
        if(!archivo.exists()){
            System.out.println("Aún no hay cuentas almacenadas D:");
            return null;
        }

        try (FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr)){
            String linea = br.readLine(); // primera linea leida: el encabezado
            while((linea = br.readLine()) != null){
                String llaveActual = linea.split(",")[0];
                if(llaveActual.equals(llaveCodigo)){
                    return encabezado + "\n" + linea; // encontrada, se devuelve la info
                }
            }
        } catch(IOException e){
            System.out.println("Hubo un error u.u");
            e.printStackTrace();
        }
        return null;
    }
    
    public static String consultarCuenta(String llaveCodigo){
        String resultado = buscarCuentaPorLlave(llaveCodigo);
        if (resultado == null) {
            System.out.println("No se encontró una cuenta con la llave " + llaveCodigo);
        }
        return resultado;
    }

    public static void editarCuenta(Cuenta c){
        File archivo = new File("cuentas.csv");
        if(!archivo.exists()){
            System.out.println("Aún no hay cuentas almacenadas D:");
            return;
        }

        List<String> listaLineas = new ArrayList<>(); // la creamos pq cuando tendremos q volver a escribir todo el csv

        try (FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr)){
            listaLineas.add(br.readLine()); // primera linea leida: el encabezado
            String linea;
            while((linea = br.readLine()) != null){
                String llaveActual = linea.split(",")[0];
                if(llaveActual.equals(c.getLlaveCodigo())){
                    listaLineas.add(c.toString());
                } else{
                    listaLineas.add(linea);
                }
            }
        } catch(IOException e){
            System.out.println("Hubo un error u.u");
            e.printStackTrace();
        }

        try (FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw)){
            for(String linea : listaLineas){
                bw.write(linea);
                bw.newLine();
            }
        } catch(IOException e){
            System.out.println("Hubo un error u.u");
            e.printStackTrace();
        }
    } 

    public static void eliminarCuenta(Cuenta c){
        File archivo = new File("cuentas.csv");
        if(!archivo.exists()){
            System.out.println("Aún no hay cuentas almacenadas D:");
            return;
        }

        List<String> listaLineas = new ArrayList<>(); // la creamos pq cuando tendremos q volver a escribir todo el csv

        try (FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr)){
            boolean encontrada = false;
            listaLineas.add(br.readLine()); // primera linea leida: el encabezado
            String linea;
            while((linea = br.readLine()) != null){
                String llaveActual = linea.split(",")[0];
                if(llaveActual.equals(c.getLlaveCodigo())){
                    encontrada = true;
                } else{
                    listaLineas.add(linea);
                }
            }

            if(!encontrada){
                System.out.println("Esa cuenta ni siquiera estaba registrada.");
                return;
            }

        } catch(IOException e){
            System.out.println("Hubo un error u.u");
            e.printStackTrace();
        }

        try (FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw)){
            for(String linea : listaLineas){
                bw.write(linea);
                bw.newLine();
            }
        } catch(IOException e){
            System.out.println("Hubo un error u.u");
            e.printStackTrace();
        }
    }




}
