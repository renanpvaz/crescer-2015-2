
/**
 * Write a description of class UrukHaiOrc here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class UrukHaiOrc extends Orc
{
    // instance variables - replace the example below with your own
    public UrukHaiOrc(){
        super();
        this.inventario = new Inventario();
        this.vida = 150;
        this.inventario.adicionarItem(new Item("Escudo Uruk Hai", 1));
        this.inventario.adicionarItem(new Item("Espada", 1));
    }
    
     public void atacarDwarf(Dwarf alvo) {
        if(possuiItem("Espada")){
           alvo.recebeDano(12);
        }
    }
}
