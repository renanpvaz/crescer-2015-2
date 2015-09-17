/**
 * Representa objetos do tipo Elfo.
 */
public class Elfo {
    private final String nome;
    
    private int flechas, experiencia;
    
    /* Type initializer
     * Executa antes de cada construtor
    {
        flechas = 42;
    }
    */
    public Elfo(String nome, int flechas) {
        this.nome = nome;
        this.flechas = flechas;
    }
    
    public Elfo(String nome, Integer flechas) {
        this(nome);
        if (flechas != null) {
            this.flechas = flechas;
        }
    }
    
    public Elfo(String nome) {
        this(nome, 42);
    }
    
    public int getFlechas(){
        return flechas;
    }
   
    
    public String getNome(){
        return nome;
    }
    
    public int getExperiencia(){
        return experiencia;
    }
    
    /* PascalCase (C#, VB.NET)
     *      public void AtirarFlechaDeFogo
     * camelCase (Java, JavaScript)
     *      public void atirarFlechaDeFogo
    */
   
    public void atirarFlecha(Dwarf alvo) {  
        flechas--;
        experiencia++;
        alvo.setVida(alvo.getVida() - 10);

        //experiencia += 1;
        //experiencia = experiencia + 1;
    }
    
    /*
     * 
     * public atirarFlechaRefactory(this.flechas, this.experiencia){
     *     if(boolean acertar == true){
     *         flechas--;
     *         experiencia++;
     *      }else{
     *          flechas--;
     *      }
     *  }
     */
    public void atirarFlechaRefactory(){
        boolean acertar = true;
        if (acertar) {
            experiencia++;
        }
        flechas--;
    }
    
    public String info(){
        
        String info = "";
        
        info = this.nome + " possui " + this.flechas + " flechas e " 
            + this.experiencia + " níveis de experiência.";
            
            return info;
          
        }    
}
