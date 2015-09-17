public class Dwarf {
    private int vida = 110;
    private Status status = Status.VIVO;
    
    public void receberFlechada() {
        
        int dano = 10, vidaAposFlechada = this.vida-dano;
        
        if (vidaAposFlechada == 0) {
            this.status = Status.MORTO;
        } 
        
        if (vida > 0) {
            this.vida = vidaAposFlechada;
        }
    }
    
    public int getVida() {
        return this.vida;
    }
    
    public Status getStatus() {
        return this.status;
    }
}