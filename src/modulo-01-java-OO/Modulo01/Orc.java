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
    protected Inventario inventario = new Inventario();
    private Status status = Status.VIVO;
    

    /**
     * COnstrutor para objetos da classe orc
     */
    public Orc()
    {
        this.vida = random.nextInt(130) + 30;
        this.inventario = inventario.gerarInventarioRandom(); 
    }
    
    public Inventario getInventario(){
        return inventario;
    }
	
    
	public void recebeDanoDeElfo() {
		vida -= 8;
	}
	
	public void recebeDanoDeDwarf() {
		if(possuiItem("Escudo Uruk Hai")){
			vida -= 5;
		}else{
		    vida -= 10;
        }
	}
    
	/*
    public void adicionarNovoItem(Item i) {
        
        if(i.getDescricao() == "Escudo UrukHai") {
            this.EscudoUrukHai = i;
        }
        else if(i.getDescricao().indexOf("Flecha") >= 0) {
			
			if(i.getDescricao() == "Flecha1")
				this.Flecha1 = i;
			if(i.getDescricao() == "Flecha2")
				this.Flecha2 = i;
			if(i.getDescricao() == "Flecha3")
				this.Flecha3 = i;
			else
				this.Arco = new Item("Arco  Uruk Hay", 1);
				this.Flecha1 = new Item("Flecha", 1);
        }
        else {
            this.Arco = i;
        }
        
    }*/
    
    
    public void atacarDwarf(Dwarf alvo) {
        if(possuiItem("Arco") && possuiItem("Flechas")){
           alvo.recebeDano();
           this.inventario.perderFlecha();
        }
        
        
        /*
        for (Item item : this.getListaDeItens()) {
            
			ArrayList<int> numeroDeFlechas = new ArrayList<int>();
			numeroDeFlechas.add(1);
			numeroDeFlechas.add(2);
			numeroDeFlechas.add(3);
			
			for(int i = 0; i <= 3; i++) {
				
				if(item.getDescricao() == "Flecha" + i) {
					this.novosItens.remove(item);
				}
			}
			*/
        }
        
    public boolean possuiItem(String item){
        boolean possui = false;
        
        for(int i = 1; i < this.inventario.getListaDeItens().size(); i++){
            possui = this.getInventario().getListaDeItens().get(i).getDescricao() == item;
        }
        
        return possui;
    }
}
    
