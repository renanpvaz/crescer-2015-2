
/**
 * Write a description of class SnagaOrc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SnagaOrc extends Orc
{
    public SnagaOrc(){
        super();
        this.vida = 70;
        this.inventario.adicionarItem(new Item("Flechas", 5));
        this.inventario.adicionarItem(new Item("Arco", 1));
    }
    
    public void atacarDwarf(Dwarf alvo) {
        if(possuiItem("Arco") && possuiItem("Flechas")){
           alvo.recebeDano(8);
           this.inventario.removerFlecha();
        }
    }
}
