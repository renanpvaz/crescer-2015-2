import java.util.*;

public class EstrategiaNormal implements EstrategiaDeAtaque{
    ArrayList<Elfo> ordemAtaque;
    
    public void atacar(ExercitoDeElfos exercitoDeElfos, ArrayList<Dwarf> dwarves){
        ordemAtaque = new ArrayList<Elfo>();
        exercitoDeElfos.agruparPorStatus();
        ArrayList<Elfo> exercito = exercitoDeElfos.buscar(Status.VIVO);
        for(Elfo elfo : exercito){
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
