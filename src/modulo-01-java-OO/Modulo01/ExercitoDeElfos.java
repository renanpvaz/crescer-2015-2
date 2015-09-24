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
    
    public Elfo buscarElfo(String nome){
        return exercito.get(nome);
    }
    
    public void agruparPorStatus(){
        agrupamentoPorStatus = new HashMap<>();
        agrupamentoPorStatus.clear();
        for(Map.Entry<String, Elfo> entry : exercito.entrySet()){ //for(Elfo elfo : exercito.values()){
            Elfo elfo = entry.getValue();
            ArrayList<Elfo> temp = agrupamentoPorStatus.get(elfo.getStatus());
            if(temp == null){    //if(!this.agrupamentoPorStatus.containsKey(entry.getKey())){
                temp = new ArrayList<Elfo>();
                agrupamentoPorStatus.put(elfo.getStatus(), temp);  
                //this.agrupamentoPorStatus.put(elfo.getStatus(), new ArrayList<Elfo>());
            }
            temp.add(elfo);
            //this.buscar(entry.getValue().getStatus()).add(entry.getValue());
        }
    }

    public ArrayList<Elfo> buscar (Status status){
        return agrupamentoPorStatus.get(status);
    }
}
