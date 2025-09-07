import java.io.*;

public Class Cuenta{

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
        return idCodigo;
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

        try (FileWriter fw = new FileWriter(archivo, true);
            BufferedWriter bw = new BufferedWriter(fw)){
            if (!archivo.exists()) {
                bw.write(encabezado);
                bw.newLine();
            }
            bw.write(c.toString());
            bw.newLine();
        } catch (IOException e){
            System.out.println("Hubo un error u.u");
            e.printStackTrace();
        }
    }

    public static String consultarCuenta(String llaveCodigo){
        File archivo = new File("cuentas.csv");
        if (!archivo.exists()) {
            System.out.println("Aún no hay cuentas almacenadas D:");
            return null;
        }

        try (FileReader fw = new FileReader(archivo);
            BufferedReader br = new BufferedReader(fw)){
            String linea = br.readLine(); // primera linea leida: el encabezado
            while ((linea = br.readLine()) != null) {
                String llaveActual = linea.split(",")[0];
                if (llaveActual.equals(llaveCodigo)) {
                    return encabezado + "\n" + linea; // encontrada, se devuelve la info
                }
            }
        } catch (IOException e) {
            System.out.println("Hubo un error u.u");
            e.printStackTrace();
        }
        System.out.println("No se encontró una cuenta con la llave " + llaveCodigo);
        return null;
    }

    public static void editarCuenta(que se le pone aqui, igual la llave? D:){
        ewoiigfhksijifikskksksksk
    } 

    public static void eliminarCuenta(){
        //TODOS
    }




}
