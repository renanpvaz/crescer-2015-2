public class Elfo {
    private String nome;
    private Integer flechas;
    private int experiencia = 0;
    
    public Elfo(String n, Integer flech) {
        nome = n;
        flechas = flech;
        if(flech == null){
            flechas = 42;
        }
    }
    
    public void atirarFlecha(){
        experiencia++;
        flechas--;
    }
}
    
    
    
    
   