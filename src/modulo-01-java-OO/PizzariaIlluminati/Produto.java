
/**
 * Write a description of class Produto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Produto{
    protected double precoUnit;
    protected String nome;
    
    public double getPreco(){
        return precoUnit;
    }
    
    public String getNome(){
        return nome;
    }
}
