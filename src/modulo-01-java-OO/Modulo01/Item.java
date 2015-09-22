
/**
 * Write a description of class Item here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Item
{
    private String descricao;
    private int quantidade;

    public Item(String descricao, int quantidade){
        this.descricao = descricao;
        this.quantidade = quantidade;
    }

    public String getDescricao(){
        return descricao;
    }

    public int getQuantidade(){
        return quantidade;
    }

    public void adicionar1000MaisSoma(){
        /*int n = this.quantidade;
        n = (n * (n + 1))/2;
        this.quantidade += n + n * 1000;
         */

        /*Original:
         * int pa = this.quantidade * ++this.quantidade / 2;
         * this.quantidade = (1000 + this.quantidade * pa);
         * 
         * Correção:
         * int pa = (this.quantidade * (this.quantidade + 1)) / 2;
         * this.quantidade += (pa + pa) * 1000;
         */
        int pa = (this.quantidade * (this.quantidade + 1)) / 2;
        this.quantidade += pa + pa * 1000;
    }

    public void adicionar1000(){
        this.quantidade += 1000;
    }
    
    public void perderUmaFlecha(){
        this.quantidade -= 1;
    }
    
    
    /**
     * Cria um item de inventário com a quantidade e descrição informadas
     * 
     * @param quantidade Quantidade de unidades no inventário
     * @param descricao Descrição do item
     */
    public Item(int quantidade, String descricao) {
        this.quantidade = quantidade;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public int getQuantidade() {
        return this.quantidade;
    }
    
    public void debitarUmaUnidade(){
        if(this.quantidade > 0){
            this.quantidade--;
        }
    }

    public void aumentar1000Unidades() {
        this.quantidade += 1000;
    }

    public void aumentarQuantidadesComSomatorio() {
        int pa = this.quantidade * (this.quantidade+1) / 2;
        this.quantidade += 1000 * pa;
    }

    /*
     * Exercício de refatoração:
    public void shimbalaie() {
        int pa = this.quantidade * (this.quantidade+1) / 2;
        this.quantidade += 1000*pa;
    }
    */

    public boolean equals(Object obj) {
        Item outro = (Item)obj;
        return this.descricao.equals(outro.getDescricao()) && this.quantidade == outro.getQuantidade();
    }
}
