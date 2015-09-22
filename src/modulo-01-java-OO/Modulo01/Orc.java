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
    
    public void atacarElfo(Elfo elfo){
        if(podeAtacarComEspada()){
            elfo.receberAtaqueDoOrc(this);
        }
        else if(podeAtacarComArco()) {
            elfo.receberAtaqueDoOrc(this);
            debitarFlecha();
        }
        else {
            this.status = Status.FUGINDO;
        }
    }
    
    public int getDanoDeAtaque(){
        if(podeAtacarComEspada()){
            return 12;
        }
        
        if(podeAtacarComArco()){
            return 8;
        }
        
        return 0;
    }
    
    public int getVida(){
        return this.vida;
    }
    
    public Inventario getInventario(){
        return this.inventario;
    }
    
    public Status getStatus(){
        return this.status;
    }
    
    private void debitarFlecha() {
        Item flecha = getItem("Flecha");
        
        if(flecha.getQuantidade() == 1){
            this.inventario.perderItem(flecha);
        }
        else {
            flecha.debitarUmaUnidade();
        }
    }
    
    private boolean podeAtacarComEspada() {
        return getItem("Espada") != null;
    }
    
    private boolean podeAtacarComArco(){
        boolean temArco = getItem("Arco") != null;
        Item flecha = getItem("Flecha");
        boolean temFlechaProArco = flecha != null && flecha.getQuantidade() > 0;
        
        return temArco && temFlechaProArco;
    }
    
    private void perderVida(int qtdVidaPerdida) {
        this.vida -= qtdVidaPerdida;
        
        if(vida <= 0){
            vida = 0;
            this.status = Status.MORTO;
        }
        else {
            this.status = Status.FERIDO;
        }
    }
    
    private Item getItem(String descricao){
        return this.inventario.getItemPorDescricao(descricao);
    }
    
    private void gerarInventario() {
        if(this.tipoOrc == TipoOrc.URUKHAI) {
            Item escudoUrukHai = new Item(1, "Escudo Uruk-Hai");
            Item espada = new Item(1, "Espada");
            this.inventario.adicionarItem(escudoUrukHai);
            this.inventario.adicionarItem(espada);
        }
        else if(this.tipoOrc == TipoOrc.SNAGA){
            Item arco = new Item(1, "Arco");
            Item flechas = new Item(5, "Flecha");
            this.inventario.adicionarItem(arco);
            this.inventario.adicionarItem(flechas);
        }
    }
    
    private void gerarVidaInicial() {
        if(this.tipoOrc == TipoOrc.URUKHAI) {
            this.vida = 150;
        }
        else if(this.tipoOrc == TipoOrc.SNAGA){
            this.vida = 70;
        }
    }
    
}
>>>>>>> c61a47d7d28ce057ae620c07422993ef8fc71f3b
