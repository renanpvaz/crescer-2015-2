public class Dwarf {
    private int vida = 115;
    
    public void receberFlechada() {
        this.vida -= 10;
    }
    
    public int getVida() {
        return this.vida;
    }
}