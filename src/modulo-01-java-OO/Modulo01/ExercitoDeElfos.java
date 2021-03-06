
import java.util.*;

public class ExercitoDeElfos
{
    private HashMap <String, Elfo> exercito;
    private HashMap<Status, ArrayList<Elfo>> exercitoAgrupado;
    private EstrategiaDeAtaque estrategia = new EstrategiaNormal();
    
    public ExercitoDeElfos(){
        this.exercito = new HashMap<>();
    }
    
    public void alistarElfo(Elfo elfo){
        if(elfo instanceof ElfoNoturno || elfo instanceof ElfoVerde && elfo.getNome() != null){
            exercito.put(elfo.getNome(), elfo);
        }
    }
    
    public void mudarEstrategia(EstrategiaDeAtaque estrategia){
        this.estrategia = estrategia;
    }
    
    public EstrategiaDeAtaque getEstrategiaDeAtaque(){
        return estrategia;
    }
    
    public HashMap getExercito(){
        return exercito;
    }
    
     public HashMap getExercitoAgrupado(){
        return this.exercitoAgrupado;
    }
    
    public Elfo buscarElfo(String nome){
        return exercito.get(nome);
    }
    
    public void agruparPorStatus(){
        exercitoAgrupado = new HashMap<>();
        exercitoAgrupado.clear();
        for(Map.Entry<String, Elfo> entry : exercito.entrySet()){ //for(Elfo elfo : exercito.values()){
            Elfo elfo = entry.getValue();
            ArrayList<Elfo> temp = exercitoAgrupado.get(elfo.getStatus());
            if(temp == null){    //if(!this.exercitoAgrupado.containsKey(entry.getKey())){
                temp = new ArrayList<Elfo>();
                exercitoAgrupado.put(elfo.getStatus(), temp);  
                //this.exercitoAgrupado.put(elfo.getStatus(), new ArrayList<Elfo>());
            }
            temp.add(elfo);
            //this.buscar(entry.getValue().getStatus()).add(entry.getValue());
        }
    }
    
    public ArrayList<Elfo> ordenarNoturnosNoFinal(){
        ArrayList<Elfo> exercitoOrdenar = buscar(Status.VIVO);
        
        for (int i = 0; i < exercito.size(); i++) {
            for (int j = 0; j < exercito.size() - 1; j++){
                Elfo elfoAtual = exercitoOrdenar.get(j);
                Elfo proximo = exercitoOrdenar.get(j + 1);
                
                boolean precisaTrocar = elfoAtual instanceof ElfoNoturno && proximo instanceof ElfoVerde;
                
                if (precisaTrocar) {
                    exercitoOrdenar.set(j, proximo);
                    exercitoOrdenar.set(j + 1, elfoAtual);
                } 
            }
        }
        
        return exercitoOrdenar;
    }
    
    public boolean ehMetadeNoturnosEMetadeVerdes(){
        ArrayList<Elfo> exercito = buscar(Status.VIVO);
        int countVerdes = 0, countNoturnos = 0;
        for(Elfo elfo : exercito){
            if(elfo instanceof ElfoVerde){
                countVerdes++;
            }else if(elfo instanceof ElfoNoturno){
                countNoturnos++;
            }
        }
        
        if((int)(exercito.size() / 2) == countNoturnos) {
            return true;
        }
        
        return false;
        
    }
    
    public void atacar(ArrayList<Dwarf> alvos) {
        this.estrategia.atacar(this, alvos);
    }
    
    public ArrayList<Elfo> buscar (Status status){
        return exercitoAgrupado.get(status);
    }
    
    public ArrayList<Elfo> getOrdemDoUltimoAtaque() {
        return this.estrategia.getOrdemDoUltimoAtaque();
    }
}
