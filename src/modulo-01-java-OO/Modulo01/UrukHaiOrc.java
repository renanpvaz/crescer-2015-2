
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
        this.inventario.adicionarItem(new Item(1, "Escudo Uruk Hai"));
        this.inventario.adicionarItem(new Item(1, "Espada"));
    }
    
     public void atacarDwarf(Dwarf alvo) {
        //if(possuiItem("Espada")){
           //alvo.recebeDano(12);
        //}
    }
}
