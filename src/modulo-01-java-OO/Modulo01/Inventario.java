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
   
   public String getDescricoesItens(){
      int index = this.getListaDeItens().size();
      String descricoes = "";
      for(int i = 0; i < index; i++){
          if(i == index - 1){
              descricoes += this.getListaDeItens().get(i).getDescricao();
          }else{
              descricoes += this.getListaDeItens().get(i).getDescricao() + ",";
          }
      }
      return descricoes;
    }
    
   public void adicionar1000TodosItens(){
    int i = 0;
    while (i < this.ListaDeItens.size()){
        this.ListaDeItens.get(i).adicionar1000();
        i++;
    }
   }
   
   public Item getItemComMaiorQuantidade(){
       Item itemComMaiorQuantidade = this.ListaDeItens.get(0);
       int qntMaior = 0;
       for(int i = 0; i < this.ListaDeItens.size(); i++){
           if(this.ListaDeItens.get(i).getQuantidade() > qntMaior){
               qntMaior = this.ListaDeItens.get(i).getQuantidade();
               itemComMaiorQuantidade = this.ListaDeItens.get(i);
            }
        } 
       return itemComMaiorQuantidade;
   }
   /* TO DO:
   public void ordenarItens(){
       int maiorPosicao = ListaDeItens.size() - 1;
       Item comp;
        for(int i = 0; i <= maiorPosicao; i++){
            for(int ii = 0; i <= maiorPosicao; i++){
                if(ListaDeItens.get(ii).getQuantidade() <= ListaDeItens.get(i).getQuantidade()){
                    ListaDeItens.set(i, ListaDeItens.get(ii));
                       
                    }
                }
            }
   } */
       
   }

