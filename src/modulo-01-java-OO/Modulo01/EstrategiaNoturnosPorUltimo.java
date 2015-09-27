import java.util.ArrayList;
public class EstrategiaNoturnosPorUltimo implements EstrategiaDeAtaque{
    ArrayList<Elfo> ordemDoUltimoAtaque;
    
    public void atacar(ExercitoDeElfos exercitoDeElfos, ArrayList<Dwarf> dwarves){
        ordemDoUltimoAtaque = new ArrayList<Elfo>();
        exercitoDeElfos.agruparPorStatus();
        ArrayList<Elfo> exercito = exercitoDeElfos.ordenarNoturnosNoFinal();
        for(Elfo elfo : exercito){
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
