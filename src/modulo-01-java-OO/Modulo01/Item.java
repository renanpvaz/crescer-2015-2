
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
}
