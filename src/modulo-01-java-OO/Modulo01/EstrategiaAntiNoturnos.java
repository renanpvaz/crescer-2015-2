import java.util.*;
public class EstrategiaAntiNoturnos implements EstrategiaDeAtaque{
     ArrayList<Elfo> ordemDoUltimoAtaque;
    public void atacar(ExercitoDeElfos exercitoDeElfos, ArrayList<Dwarf> dwarves){
        ordemDoUltimoAtaque = new ArrayList<Elfo>();
        exercitoDeElfos.agruparPorStatus();
        ArrayList<Elfo> exercito = exercitoDeElfos.buscar(Status.VIVO);
        int count = 0;
        for(Elfo elfo : exercito){
            if(elfo instanceof ElfoNoturno){
                count++; 
                if(count >= (int)(exercito.size() * dwarves.size()) * 0.3){
                    continue;
                }
            }
            for(Dwarf dwarf : dwarves){
                    elfo.atirarFlecha(dwarf);
             }
            ordemDoUltimoAtaque.add(elfo);
        }
    }
 
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return this.ordemDoUltimoAtaque;
    }  
}
