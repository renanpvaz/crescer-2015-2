import java.util.ArrayList;
public class Pizza extends Produto{
    private TamanhoPizza tamanho;
    private ArrayList<String> sabores;
    
    // O ideal eh separar a pizza em especializacoes,
    // sendo Pizza abstract e ter PizzaPequena, PizzaMedia e PizzaTitanic.
    // Se separar por enum, esse construtor pode ficar gigante uma hora, quando
    // tiver varios tipos de pizza;
    // quando adicionar um tipo novo de pizza, vai ter que alterar aqui, e isso
    // vai impactar em todos os tipos de pizza, o que nao eh bom.
    //
    public Pizza(TamanhoPizza tamanho){
        this.tamanho = tamanho;
        nome = "Pizza " + tamanho.toString();
        
        if(tamanho == TamanhoPizza.PEQUENO){
            precoUnit = 20;
            sabores = new ArrayList<String>(1);
        }
        else if(tamanho == TamanhoPizza.GRANDE)  {
            precoUnit = 40;
            sabores = new ArrayList<String>(2);
        }
        else if(tamanho == TamanhoPizza.TITANIC){
            precoUnit = 100;
            sabores = new ArrayList<String>(6);
        }
    }
    
    public void adicionarSabor(String sabor){
        sabores.add(sabor);
    }
    
    public ArrayList<String> getSabores(){
        return sabores;
    }
}
