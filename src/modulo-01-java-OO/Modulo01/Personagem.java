
/**
 * Write a description of class Personagem here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Personagem
{
    protected Inventario inventario;
    protected int experiencia;
    protected int vida;
    protected Status status;
    
    public Personagem(){
        this.inventario = new Inventario();
        this.experiencia = 0;
        this.status = Status.VIVO;

    }
    
    public Inventario getInventario(){
        return inventario;
    }
    
    public void adicionarItem(Item item){
        this.inventario.adicionarItem(item);
    }
    
    public void removerItem(Item item){
        this.inventario.removerItem(item);
    }
    
    public void serAtacado(){
    }
}

