import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Pokemon {

    private static String encabezado = "idPokemon,nombre,especie,tipo,cp,peso,sexo,esShiny";
    private String idPokemon;
    private String nombre;
    private String especie;
    private String tipo;
    private int cp;
    private int peso;
    private String sexo;
    private boolean esShiny;

    public Pokemon(String idPokemon, String nombre, String especie, String tipo, int cp, int peso,String sexo, boolean esShiny) {
        this.idPokemon = idPokemon;
        this.nombre = nombre;
        this.especie = especie;
        this.tipo = tipo;
        this.cp = cp;
        this.peso = peso;
        this.sexo = sexo;
        this.esShiny = esShiny;

    }

    public String getidPokemon() {
        return idPokemon;
    }
    
    public void setidPokemon(String idPokemon) {
        this.idPokemon = idPokemon;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getEspecie() {
        return especie;
    }
    
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
    public String getTipo() {
        return tipo;
    }
    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    public int getCp() {
        return cp;
    }
    
    public void setCp(int cp) {
        this.cp = cp;
    }
    
    public int getPeso() {
        return peso;
    }
    
    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    public String getSexo() {
        return sexo;
    }
    
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    public boolean isEsShiny() {
        return esShiny;
    }
    
    public void setEsShiny(boolean esShiny) {
        this.esShiny = esShiny;
    }

    @Override
    public String toString() {
        return idPokemon + "," + nombre + "," + especie + "," + tipo + "," + cp + "," + peso + "," + sexo + "," + esShiny;
    }

    public static void agregarPokemon(Pokemon p) {
        File archivo = new File("pokemon.csv");

        try (FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw)){
            if (!archivo.exists() || archivo.length() == 0) {
                bw.write(encabezado);
                bw.newLine();
            }
            bw.write(p.toString());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Error al guardar el pokemon: " + e.getMessage());
        }
    }


    public static String consultarPokemon(String idPokemon) {
        File archivo = new File("pokemon.csv");
        if (!archivo.exists() || archivo.length() == 0) {
            System.out.println("Aún no hay pokemons almacenados");
            return null;
        }

        try (FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr)) {

            String linea = br.readLine();
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String llaveActual = linea.split(",")[0];
                if (llaveActual.equals(idPokemon)) return encabezado + "\n" + linea;
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
        System.out.println("No se encontró el pokemon con el ID " + idPokemon);
        return null;
    }




    public static void editarPokemon(Pokemon p){
        File archivo = new File("pokemon.csv");
        if (!archivo.exists()) {
            System.out.println("Aún no hay pokemons almacenados");
            return;
        }

        List<String> listaLineas = new ArrayList<>();

        try (FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr)) {
            listaLineas.add(br.readLine());
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String llaveActual = linea.split(",")[0];
                if(llaveActual.equals(p.getidPokemon()))
                    listaLineas.add(p.toString());
                else 
                    listaLineas.add(linea);
            }
        } catch(IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        try (FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw)) {
            for (String linea : listaLineas) {
                bw.write(linea);
                bw.newLine();
            }
        } catch(IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    } 



    public static void eliminarPokemon(Pokemon p){
        File archivo = new File("pokemon.csv");
        if (!archivo.exists()) {
            System.out.println("Aún no hay pokemons almacenados");
            return;
        }

        List<String> listaLineas = new ArrayList<>();

        try (FileReader fr = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fr)) {
            boolean encontrado = false;
            listaLineas.add(br.readLine());
            String linea;

            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;
                String llaveActual = linea.split(",")[0];
                if (llaveActual.equals(p.getidPokemon())) 
                    encontrado = true;
                else
                    listaLineas.add(linea);   
            }

            if(!encontrado){
                System.out.println("Este pokemon no esta registrado.");
                return;
            }

        } catch(IOException e){
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        try (FileWriter fw = new FileWriter(archivo);
            BufferedWriter bw = new BufferedWriter(fw)){
            for(String linea : listaLineas){
                bw.write(linea);
                bw.newLine();
            }
        } catch(IOException e){
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        }
    }

    
}








