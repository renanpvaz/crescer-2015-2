
/**
 * Write a description of class IrishDwarf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IrishDwarf extends Dwarf
{
    
    public IrishDwarf(String nome){
        super(nome);
    }
    
    public IrishDwarf(String nome, DataTerceiraEra dataNascimento){ 
        super(nome, dataNascimento);
    }
    
    public void tentarSorte(){
        if(this.getSorte() == (-3333)){
            this.inventario.adicionar1000TodosItensMaisSoma();   
        }
    }
}
