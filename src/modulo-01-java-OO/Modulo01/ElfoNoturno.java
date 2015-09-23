
/**
 * Write a description of class ElfoNoturno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ElfoNoturno extends Elfo{
    double vidaDecrescida = (double)vida;
    
    public ElfoNoturno(String nome, int flechas) {
        super(nome, flechas);
        
    }
    
    public ElfoNoturno(String nome) {
        super(nome);
    }
    
    public double getVidaDecrescida(){
        return vidaDecrescida;
    }
    
    public void atirarFlecha(Dwarf dwarf) {
        flechas--;
        experiencia += 3;
        dwarf.receberFlechada();
        vidaDecrescida -= vidaDecrescida * 0.05;
        //experiencia += 1;
        //experiencia = experiencia + 1;
    }
   
    }

