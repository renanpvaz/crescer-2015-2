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
    
    public int getFlechas(){
        return flechas;
    }
    
    public void setFlechas(int flechas){
        this.flechas = flechas;
    }
    
    public void atirarFlecha(){
        experiencia++;
    }
}
    
    
    
    
   