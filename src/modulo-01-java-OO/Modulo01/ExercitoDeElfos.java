import java.util.HashMap;
public class ExercitoDeElfos
{
    HashMap <String, Elfo> exercito;
    
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
}
