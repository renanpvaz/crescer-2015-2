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
    
    public boolean equals(Object obj) {
        Inventario outroInventario = (Inventario)obj;
        return this.itens.equals(outroInventario.getItens());
    }
}
