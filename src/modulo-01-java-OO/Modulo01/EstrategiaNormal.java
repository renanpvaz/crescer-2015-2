import java.util.*;

public class EstrategiaNormal implements EstrategiaDeAtaque{
    ArrayList<Elfo> ordemAtaque;
    
    public void atacar(ExercitoDeElfos exercitoDeElfos, ArrayList<Dwarf> dwarves){
        ordemAtaque = new ArrayList<Elfo>();
        ArrayList<Elfo> exercito = exercitoDeElfos.buscar(Status.VIVO);
        int count = 0;
        for(Elfo elfo : exercito){
            if(count <= exercito.size() * 0.03){
                return;
            }
            else if(elfo instanceof ElfoNoturno) count++;
            
            for(Dwarf dwarf : dwarves){
                elfo.atirarFlecha(dwarf);
            }
            ordemAtaque.add(elfo);
        }

    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
      return ordemAtaque;  
    }
}
