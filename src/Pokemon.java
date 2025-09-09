import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase <code>Pokemon</code> modela un Pokémon dentro del sistema 
 * y lo almacena en un archivo CSV.
 * 
 * Cada Pokémon tiene un identificador único, un nombre, especie, tipo, puntos de combate (CP)
 * peso, sexo y si es o no shiny.
 */
public class Pokemon {

    /** Encabezado del archivo CSV. */
    private static String encabezado = "idPokemon,nombre,especie,tipo,cp,peso,sexo,esShiny";
    /** Identificador / llave del Pokémon. */
    private String idPokemon;
    /** Nombre del Pokémon. */
    private String nombre;
    /** Especie del Pokémon. */
    private String especie;
    /** Tipo del Pokémon. */
    private String tipo;
    /** Puntos de combate (CP) del Pokémon. */
    private int cp;
    /** Peso del Pokémon. */
    private int peso;
    /** Sexo del Pokémon (macho, hembra o indefinido). */
    private String sexo;
    /** Indica si el Pokémon es shiny. */
    private boolean esShiny;

    /**
     * Constructor para la clase <code>Pokemon</code>.
     *
     * @param idPokemon identificador único
     * @param nombre nombre
     * @param especie especie
     * @param tipo tipo
     * @param cp puntos de combate
     * @param peso peso
     * @param sexo sexo
     * @param esShiny indica si el Pokémon es shiny
     */
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

    /** @return el identificador único del Pokémon */
    public String getidPokemon() {
        return idPokemon;
    }
    
    /** @param idPokemon nuevo identificador único */
    public void setidPokemon(String idPokemon) {
        this.idPokemon = idPokemon;
    }
    
    /** @return el nombre del Pokémon */
    public String getNombre() {
        return nombre;
    }
    
    /** @param nombre nuevo nombre del Pokémon */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /** @return la especie del Pokémon */
    public String getEspecie() {
        return especie;
    }
    
    /** @param especie nueva especie del Pokémon */
    public void setEspecie(String especie) {
        this.especie = especie;
    }
    
    /** @return el tipo del Pokémon */
    public String getTipo() {
        return tipo;
    }
    
    /** @param tipo nuevo tipo del Pokémon */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    
    /** @return los puntos de combate (CP) del Pokémon */
    public int getCp() {
        return cp;
    }
    
    /** @param cp nuevos puntos de combate */
    public void setCp(int cp) {
        this.cp = cp;
    }
    
    /** @return el peso del Pokémon */
    public int getPeso() {
        return peso;
    }
    
    /** @param peso nuevo peso del Pokémon */
    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    /** @return el sexo del Pokémon */
    public String getSexo() {
        return sexo;
    }
    
    /** @param sexo nuevo sexo del Pokémon */
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
    /** @return <code>true</code> si el Pokémon es shiny, <code>false</code> en caso contrario */
    public boolean isEsShiny() {
        return esShiny;
    }
    
    /** @param esShiny establece si el Pokémon es shiny */
    public void setEsShiny(boolean esShiny) {
        this.esShiny = esShiny;
    }

    /**
     * Convierte el Pokémon en una representación para el formato CSV.
     *
     * @return una cadena con los atributos separados por comas.
     */
    @Override
    public String toString() {
        return idPokemon + "," + nombre + "," + especie + "," + tipo + "," + cp + "," + peso + "," + sexo + "," + esShiny;
    }

    /**
     * Agrega un Pokémon al archivo CSV.
     * Si el archivo no existe, lo crea con el encabezado.
     *
     * @param p el Pokémon a agregar
     */
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

    /**
     * Consulta un Pokémon por su identificador único.
     *
     * @param idPokemon identificador del Pokémon a buscar
     * @return una cadena con el encabezado y los datos del Pokémon, <code>null</code> si no existe el pokémon.
     */
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

    /**
     * Edita los datos de un Pokémon existente en el archivo CSV.
     * Si el Pokémon no existe, no se modifica el archivo.
     *
     * @param p el Pokémon con los datos actualizados
     */
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

    /**
     * Elimina un Pokémon del archivo CSV por su identificador.
     * Si el pokémon no existe, muestra un mensaje y no se modifica el archivo.
     *
     * @param p el Pokémon a eliminar
     */
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