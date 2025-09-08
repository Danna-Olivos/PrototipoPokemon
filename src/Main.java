public class Main {
    public static void main (String args[]){
        //para hacer pruebitas lol
        Cuenta c1 = new Cuenta("abcd", "bananita", 4, "banono");
        Cuenta c2 = new Cuenta("qwt", "pompin", 1, "dragqueen");
        Cuenta c3 = new Cuenta("aaaaa", "web",3,"blip");
        String cor1[] = {"max@gmail.com", "max2@gmail.com"};
        Participantes p1 = new Participantes("max", "lechuga", "hervert", 1, 20, cor1, 321, "ciencias", "cc", c1);
        Participantes p2 = new Participantes("max1", "lechuga", "hervert", 1, 20, cor1, 321300, "ciencias", "cc", c2);
        Participantes p3 = new Participantes("max2", "lechuga", "hervert", 1, 20, cor1, 321300193, "ciencias", "cc", c3);
        
        Cuenta.agregarCuenta(c3);
        Cuenta.agregarCuenta(c2);
        Cuenta.agregarCuenta(c1);
        Participantes.AddParticipante(p1);
        Participantes.AddParticipante(p2);
        Participantes.AddParticipante(p3);

        System.out.println(Participantes.leerParticipantes());
    }
    
    
}
