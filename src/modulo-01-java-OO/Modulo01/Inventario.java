import java.util.ArrayList;

public class Inventario {
    private ArrayList<Item> itens = new ArrayList<Item>();
    
    public void adicionarItem(Item item) {
        this.itens.add(item);
    }
    
    public void perderItem(Item item) {
        this.itens.remove(item);
    }
    
    public ArrayList<Item> getItens() {
        return this.itens;
    }
    
    public String getDescricoesItens() {
        String descricoes = "";
        
        for (Item item : this.itens) {
            descricoes += item.getDescricao() + ",";
        }
        
        return descricoes.substring(0, descricoes.length() - 1);
    }
    
    public void aumentar1000UnidadesEmCadaItem() {
        for (Item item : this.itens) {
            item.aumentar1000Unidades();
        }
    }
    
    public Item getItemComMaiorQuantidade() {
        int indice = 0, maiorQtd = 0;
        
        for (Item item : this.itens) {
            int qtdAtual = item.getQuantidade();
            if (qtdAtual > maiorQtd) {
                indice = this.itens.indexOf(item);
                maiorQtd = qtdAtual;
            }
        }
        
        return this.itens.get(indice);
    }
    
    public boolean equals(Object obj) {
        Inventario outroInventario = (Inventario)obj;
        return this.itens.equals(outroInventario.getItens());
    }
}
