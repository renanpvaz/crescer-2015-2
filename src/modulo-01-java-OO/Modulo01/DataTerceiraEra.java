
/**
 * Write a description of class DataTerceiraEra here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class DataTerceiraEra
{
    int dia, mes, ano;
    
    public DataTerceiraEra (int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }
    
    public int getDia(){
        return dia;
    }
    public int getMes(){
        return mes;
    }
    public int getAno(){
        return ano;
    }
    
    public boolean ehBissexto(){
        if(this.dia == 29 && this.mes == 2){
            return true;
        }else{
            return false;
        }
    }
}