import java.util.Random;
/**
 * Escreva a descrição da classe orc aqui.
 * 
 * @author (seu nome) 
 * @version (número de versão ou data)
 */


public class Orc
{
    
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    protected int vida ;
    private Random random = new Random();
    protected Inventario inventario;
    protected Status status = Status.VIVO;
    

    /**
     * COnstrutor para objetos da classe orc
     */
    public Orc(){
        this.inventario = new Inventario();
    }
    
    public Inventario getInventario(){
        return inventario;
    }

    public void recebeDano(int dano) {
        if(possuiItem("Escudo Uruk-Hai")){
            this.vida -= dano/2;
        }else{
            this.vida -= dano;
        }
        if(this.vida < 0){
                this.vida = 0;
            }
        if(this.vida == 0){
                this.status = Status.MORTO;     
        }
    }
    
    public void orcFugindo(){ 
        if(!possuiItem("Flechas") || !possuiItem("Espada")){
            this.status = Status.FUGINDO;
        }
    }
    
    public void atacarDwarf(Dwarf alvo) {
    }
        
    public boolean possuiItem(String item){
        boolean possui = false;
        
        for(int i = 1; i < this.inventario.getListaDeItens().size(); i++){
            possui = this.getInventario().getListaDeItens().get(i).getDescricao().equals(item);
        }
        
        return possui;
    }
}
    
