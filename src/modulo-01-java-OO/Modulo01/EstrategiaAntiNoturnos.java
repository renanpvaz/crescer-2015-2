import java.util.*;
public class EstrategiaAntiNoturnos implements EstrategiaDeAtaque{
    
    //TO DO:
    public void atacar(ExercitoDeElfos exercitoDeElfos, ArrayList<Dwarf> orcs){
        exercitoDeElfos.ordenarDeixandoElfosNoturnosPorUltimo();
        ArrayList<Elfo> exercito = exercitoDeElfos.buscar(Status.VIVO);
        for(Elfo elfo : exercito){    
            for(Dwarf dwarf : orcs){
                    elfo.atirarFlecha(dwarf);
                }
        }
    }
}
