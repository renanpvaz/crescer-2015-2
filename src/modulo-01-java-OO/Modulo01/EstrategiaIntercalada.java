import java.util.ArrayList;
public class EstrategiaIntercalada implements EstrategiaDeAtaque{
    ArrayList<Elfo> ordemAtaque;
        
        public void atacar(ExercitoDeElfos exercitoDeElfos, ArrayList<Dwarf> dwarves){
        ordemAtaque = new ArrayList<Elfo>();
        exercitoDeElfos.agruparPorStatus();
        ArrayList<Elfo> exercito = exercitoDeElfos.buscar(Status.VIVO);
        Elfo elfoAnterior = new Elfo("");
        int count = 0;
        
            if(exercitoDeElfos.ehMetadeNoturnosEMetadeVerdes()){
                for(Elfo elfo : exercito){
                    if(count == 0 && elfo instanceof ElfoNoturno){
                            elfoAnterior = new ElfoVerde("");
                    }else if(count == 0 && elfo instanceof ElfoVerde){
                            elfoAnterior = new ElfoNoturno("");
                    }
                    
                    if(elfo instanceof ElfoVerde && elfoAnterior instanceof ElfoNoturno){
                            for(Dwarf dwarf : dwarves){
                                elfo.atirarFlecha(dwarf);
                            }
                            elfoAnterior = elfo;
                            ordemAtaque.add(elfo);
                    }else if(elfo instanceof ElfoNoturno && elfoAnterior instanceof ElfoVerde){
                            for(Dwarf dwarf : dwarves){
                                elfo.atirarFlecha(dwarf);
                            }
                            elfoAnterior = elfo;
                            ordemAtaque.add(elfo);
                    }else{
                        continue;
                    }
                    count++;
                }
        }else{
            return;
        }
    }

   public ArrayList<Elfo> getOrdemDoUltimoAtaque(){
       return ordemAtaque;  
   }
}