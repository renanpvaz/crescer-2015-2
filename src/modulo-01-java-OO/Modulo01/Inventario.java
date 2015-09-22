import java.util.ArrayList;
import java.util.Random;
public class Inventario
{
    ArrayList<Item> ListaDeItens = new ArrayList<Item>();
    Random r = new Random();

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
        String descricoes = "";

        for(Item item : this.ListaDeItens){
            descricoes += item.getDescricao() + ",";
        }
        return descricoes.substring(0, descricoes.length() - 1);
    }

    public void adicionar1000TodosItens(){
        int i = 0;
        for(Item item : this.ListaDeItens){
            this.ListaDeItens.get(i).adicionar1000();
            i++;
        }
    }
    
    public void adicionar1000TodosItensMaisSoma(){
        int i = 0;
        for(Item item : this.ListaDeItens){
            this.ListaDeItens.get(i).adicionar1000MaisSoma();
            i++;
        }
    }

    public Item getItemComMaiorQuantidade(){
        Item itemComMaiorQuantidade = this.ListaDeItens.get(0);
        int qntMaior = 0;
        for(Item item : this.ListaDeItens){
            if(item.getQuantidade() > qntMaior){
                qntMaior = item.getQuantidade();
                itemComMaiorQuantidade = item;
            }
        } 
        return itemComMaiorQuantidade;
    }

    public void ordenarItens(){
        Item maior;
        for(int i = 1; i < ListaDeItens.size(); i++){
            for(int ii = 0; ii < ListaDeItens.size(); ii++){
                if(ListaDeItens.get(ii).getQuantidade() > ListaDeItens.get(i).getQuantidade()){
                    maior = ListaDeItens.get(ii);
                    ListaDeItens.set(ii, ListaDeItens.get(i));
                    ListaDeItens.set(i, maior);
                }
            }
        }
    }
    
    public Inventario gerarInventarioRandom(){
        Inventario inventario = new Inventario();
        int d = r.nextInt(5), numFlechas = r.nextInt(30)+5;
        Item arco = new Item("Arco", 1);
        Item escudoUrukHai = new Item("Escudo Uruk Hai", 1);
        Item flechas = new Item("Flechas", numFlechas);
        
        switch(d){
            case 0:
                inventario.adicionarItem(arco);
                break;
            case 1:
                inventario.adicionarItem(flechas);
                break;
            case 2:
                inventario.adicionarItem(escudoUrukHai);
                break;
            case 3:
                inventario.adicionarItem(escudoUrukHai);
                inventario.adicionarItem(flechas);
                break;    
            case 4:
                inventario.adicionarItem(arco);
                inventario.adicionarItem(flechas);
                break;
            case 5:
                inventario.adicionarItem(escudoUrukHai);
                inventario.adicionarItem(escudoUrukHai);
                break;    
        }
        
        return inventario;
    }
    
    public void perderFlecha(){
        for(Item item : ListaDeItens){
            if(item.getDescricao() == "Flechas"){
                item.perderUmaFlecha();
            }
        }
    }
}     

