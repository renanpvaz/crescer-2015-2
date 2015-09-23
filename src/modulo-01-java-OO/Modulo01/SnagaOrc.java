
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
        this.inventario.adicionarItem(new Item(5, "Flechas"));
        this.inventario.adicionarItem(new Item(1, "Arco"));
    }
    
    public void atacarDwarf(Dwarf alvo) {
        //if(possuiItem("Arco") && possuiItem("Flechas")){
           //alvo.recebeDano(8);
           //this.inventario.removerFlecha();
        //}
    }
}
