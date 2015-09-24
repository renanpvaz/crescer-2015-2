import java.util.*;

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
    
     public HashMap getAgrupamentoPorStatus(){
        return this.agrupamentoPorStatus;
    }
    
    public void agruparPorStatus(){
        agrupamentoPorStatus = new HashMap<>();
        for(Map.Entry<String, Elfo> entry : exercito.entrySet()){
            if(!this.agrupamentoPorStatus.containsKey(entry.getKey())){
                this.agrupamentoPorStatus.put(entry.getValue().getStatus(), new ArrayList<Elfo>());
            }
            this.buscar(entry.getValue().getStatus()).add(entry.getValue());
        }
    }

    public ArrayList<Elfo> buscar (Status status){
        return agrupamentoPorStatus.get(status);
    }
}
