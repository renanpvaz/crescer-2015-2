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
        for(Map.Entry<String, Elfo> entry : exercito.entrySet()){ //Elfo elfo : exercito.values();
            Elfo elfo = entry.getValue();
            ArrayList<Elfo> temp = agrupamentoPorStatus.get(elfo.getStatus());
            //if(!this.agrupamentoPorStatus.containsKey(entry.getKey())){
            if(temp == null){    
                temp = new ArrayList<Elfo>();
                agrupamentoPorStatus.put(elfo.getStatus(), temp);            
            }
            temp.add(elfo);
            //this.agrupamentoPorStatus.put(elfo.getStatus(), new ArrayList<Elfo>());
            //this.buscar(entry.getValue().getStatus()).add(entry.getValue());
        }
    }

    public ArrayList<Elfo> buscar (Status status){
        return agrupamentoPorStatus.get(status);
    }
}
