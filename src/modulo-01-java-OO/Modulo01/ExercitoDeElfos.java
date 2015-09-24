import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
public class ExercitoDeElfos
{
    private HashMap <String, Elfo> exercito;
    private HashMap<Status, ArrayList<Elfo>> agrupamentoPorStatus;
    
    
    public ExercitoDeElfos(){
        this.exercito = new HashMap<>();
    }
    
    public void alistarElfo(Elfo elfo){
        if(elfo instanceof ElfoNoturno || elfo instanceof ElfoVerde && elfo.getNome() != null){
            exercito.put(elfo.getNome(), elfo);
        }
    }
    
    public HashMap getExercito(){
        return exercito;
    }
    
    public void agruparPorStatus(){
        agrupamentoPorStatus = new HashMap<>();
        for(Elfo elfo : this.exercito.values()){
            if(!this.agrupamentoPorStatus.containsKey(elfo.getStatus())){
                this.agrupamentoPorStatus.put(elfo.getStatus(), new ArrayList<Elfo>());
            }
            this.agrupamentoPorStatus.get(elfo.getStatus()).add(elfo);
        }
    }
    
    public HashMap getAgrupamentoPorStatus(){
        return this.agrupamentoPorStatus;
    }
    
    public Elfo getElfoVivoPorPosicao(int pos){
        return this.agrupamentoPorStatus.get(Status.VIVO).get(pos);
    }
}
