
/**
 * Write a description of class ElfoNoturno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfoNoturno extends Elfo{
    public ElfoNoturno(String nome, int flechas) {
        super(nome, flechas);
        
    }
    
    public ElfoNoturno(String nome) {
        super(nome);
    }
    
    public void atirarFlecha(Dwarf dwarf) {
        if(vida < 1){
            vida = 0;
            status = Status.MORTO;
        }else {
            flechas--;
            experiencia += 3;
            dwarf.receberFlechada();
            vida -= vida * 0.05;
        }
        //experiencia += 1;
        //experiencia = experiencia + 1;
    }
}

