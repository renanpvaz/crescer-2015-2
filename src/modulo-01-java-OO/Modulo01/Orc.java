

public class Orc
{
    protected int vida;
    protected Inventario inventario;
    protected Status status;
    protected TipoOrc tipoOrc;

    public Orc() {
    }
    
    public Orc(TipoOrc tipoOrc)
    {
        this.inventario = new Inventario();
        this.tipoOrc = tipoOrc;
        gerarVidaInicial();
        gerarInventario();
        this.status = Status.VIVO;
    }
    
    public void levarAtaqueDeAnao() {
        
        if(getItem("Escudo Uruk-Hai") == null){
            perderVida(10);
        }
        else {
            perderVida(5);
        }
    }
    
    public void levarAtaqueDeElfo() {
        perderVida(8);
    }
    
    public void atacarAnao(Dwarf anao){
        if(podeAtacarComEspada()){
            anao.receberAtaqueDoOrc(this);
        }
        else if(podeAtacarComArco()) {
            anao.receberAtaqueDoOrc(this);
            debitarFlecha();
        }
        else {
            this.status = Status.FUGINDO;
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
    
    public void recebeDano(int dano) {
        this.vida -= dano;
    }
    
    private void debitarFlecha() {
        Item flecha = getItem("Flecha");
        
        if(flecha.getQuantidade() == 1){
            this.inventario.removerItem(flecha);
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
