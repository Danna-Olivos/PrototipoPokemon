public class Main {
    public static void main (String args[]){
        //para hacer pruebitas lol
        Cuenta c1 = new Cuenta("abcd", "bananita", 4, "banono");
        Cuenta c2 = new Cuenta("qwt", "pompin", 1, "dragqueen");
        Cuenta c3 = new Cuenta("aaaaa", "web",3,"blip");
        String cor1[] = {"max@gmail.com", "dd", "ww"};
        String cor2[] = {"yo@gmail.com"};
        int tel1[]={55927,111};
        int tel2[]={1,222,6666};
        Participantes p1 = new Participantes("max", "lechuga", "hervert", 1, 20,"boy", tel1,cor1, 321, "ciencias", "cc", c1);
        Participantes p2 = new Participantes("danna", "olivos", "noriega", 1, 20,"girl",tel2, cor1, 321300, "ciencias", "cc", c2);
        Participantes p3 = new Participantes("liz", "tapia", "figueroa", 1, 20,"girl",tel2 ,cor2, 321300193, "ciencias", "cc", c3);
        
        // Cuenta.agregarCuenta(c3);
        // Cuenta.agregarCuenta(c2);
        // Cuenta.agregarCuenta(c1);
        Participantes.AddParticipante(p3);
        // Participantes.AddParticipante(p2);
        // Participantes.AddParticipante(p3);
    }
    
    
}
