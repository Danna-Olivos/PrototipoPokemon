import java.io.*;
import java.util.*;

public class Cuenta{

    private static String archivo = "cuentas.csv";
    private static String encabezado = "códigoEntreandor,username,nivel,equipo";
    private String llaveCodigo;
    private String username;
    private int nivel;
    private String equipo;

    public Cuenta(String llaveCodigo, String username, int nivel, String equipo){
        this.llaveCodigo = llaveCodigo;
        this.username = username;
        this.nivel = nivel;
        this.equipo = equipo;
    }

    public String getLlaveCodigo(){
        return llaveCodigo;
    }
    public void setLlaveCodigo(String llaveCodigo){
        this.llaveCodigo = llaveCodigo;
    }

    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public int getNivel(){
        return nivel;
    }
    public void setNivel(int nivel){
        this.nivel = nivel;
    }

    public String getEquipo(){
        return equipo;
    }
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

    public static String consultarCuenta(String llaveCodigo){
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
        System.out.println("No se encontró una cuenta con la llave " + llaveCodigo);
        return null;
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
                System.out.println("Esa cuenta ni siquiera estaba reistrada.");
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
