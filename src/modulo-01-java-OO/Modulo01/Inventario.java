import java.util.ArrayList;
public class Inventario
{
   ArrayList<Item> ListaDeItens = new ArrayList<Item>();
   
   public ArrayList<Item> getListaDeItens(){
       return ListaDeItens;
   }
   
   public void adicionarItem(Item item){
       ListaDeItens.add(item);
   }
    
   public void removerItem(Item item){
       ListaDeItens.remove(item);
   }
}