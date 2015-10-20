
/**
 * Write a description of class Cliente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cliente{
   private String nome;
   private String endereco;
   // cuidado com os nomes, neste caso use "numeroTelefone"
   private int numero;
   
   public Cliente(String nome, String endereco, int numero){
        this.nome = nome;
        this.endereco = endereco;
        this.numero = numero;
   }
   
   public String getNome(){
       return this.nome;
   }   
   
   public String getEndereco(){
       return this.endereco;
   }
   
   public int getNumero(){
       return this.numero;
   }
}
