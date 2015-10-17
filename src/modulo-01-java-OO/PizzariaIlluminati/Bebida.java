
/**
 * Write a description of class Bebida here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bebida extends Produto{
    private TamanhoBebida tamanho;
    private MarcaBebida marca;
   
    public Bebida(TamanhoBebida tamanho, MarcaBebida marca){
        this.tamanho = tamanho;
        this.marca = marca;
        nome = marca.toString() + " " + tamanho.toString();
        
        if(tamanho == TamanhoBebida.LATA){
            precoUnit = 3.50;
        }
        else if(tamanho == TamanhoBebida.GARRAFA){
            precoUnit = 7;
        }
    }
}
