
/**
 * Write a description of class Produto here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Produto{
    protected double precoUnit;
    protected String nome;
    
    // se precoUnit e nome são obrigatórios para todos
    // os produtos, deverão estar no construtor dessa
    // classe.
    
    public double getPreco(){
        return precoUnit;
    }
    
    public String getNome(){
        return nome;
    }
}
