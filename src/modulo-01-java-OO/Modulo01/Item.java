
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
   private String descricao;
   private int quantidade;
   
   public Item(String descricao, int quantidade){
       this.descricao = descricao;
       this.quantidade = quantidade;
   }
   
   public String getDescricao(){
       return descricao;
   }
   
   public int getQuantidade(){
       return quantidade;
   }
}
