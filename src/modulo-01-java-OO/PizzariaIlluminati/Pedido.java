import java.util.ArrayList;

public class Pedido{
   private Cliente cliente;
   private ArrayList<Produto> produtos = new ArrayList<Produto>();
   private double valorTotal;
   private boolean teleEntrega = true;
   private boolean desconto;
   private double troco;
   
   public Pedido(Cliente cliente){
       this.cliente = cliente;
   }
   
   public void adicionarProduto(Produto produto){
       this.produtos.add(produto);
   }
   
   public boolean getTeleEntrega(){
       return this.teleEntrega;
   }
   
   public boolean getDesconto(){
       return this.desconto;
   }
   
   public ArrayList<Produto> getProdutos(){
       return this.produtos;
   }
   
   public double getValorTotal(){
       return this.valorTotal;
   }
   
   public double calcularValor(){
       valorTotal = 4.50;
       for(Produto produto : produtos){
           valorTotal += produto.getPreco();
       }
       
       if(valorTotal >= 60){
           teleEntrega = false;
           valorTotal -= 4.50;
       }
       
       if(valorTotal >= 100){
           desconto = true;
           valorTotal -= valorTotal * 0.1;
       }
       
       return valorTotal;
   }
   
   public double calcularTroco(double valor){
       troco = valor - valorTotal;
       return troco;
   }
   
   public String imprimirComprovante(){
       String listaProdutos = "";
       for(Produto produto : produtos){
           listaProdutos += "\n" + produto.getNome() + ": " + produto.getPreco();
       }
       
       return "Nome do cliente = " + this.cliente.getNome() + 
              "\nEndereço de entrega = " + this.cliente.getEndereco() +
              "\nTelefone = " +  this.cliente.getNumero() +
              "\nValor total = " + this.calcularValor() +
              "\nValor informado pelo cliente = " + troco + this.calcularValor() +
              "\nLista de produtos no pedido = " + listaProdutos +
              "\nTele entrega = " + (teleEntrega ? "Sim" : "Não") +
              "\nDesconto 10% = " + (desconto ? "Sim" : "Não");
       
       /*
       return String.format("Nome do cliente = %s \n "+ 
                            "Endereço de entrega = %s \n " +
                            "Telefone =  %d \n " +
                            "Valor total =  %d \n " +
                            "Valor informado pelo cliente =  %d \n " +
                            "Lista de produtos no pedido =  \n%s " +
                            "Tele entrega =  %s " +
                            "Desconto 10% = %s",
       this.cliente.getNome(),
       this.cliente.getEndereco(),
       this.cliente.getNumero(),
       this.calcularValor(),
       troco + calcularValor(),
       listaProdutos,
       teleEntrega ? "Sim" : "Não",
       desconto ? "Sim" : "Não");
       */
   }
}
