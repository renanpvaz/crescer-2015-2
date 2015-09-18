

public class Dwarf
{
    private String nome;
    private int vida = 110;
    private Status status;
    private int experiencia = 0;
    public DataTerceiraEra dataNascimento;
    
    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this.nome = nome;
        this.status = Status.VIVO;
        this.dataNascimento = dataNascimento;
    }
    
    public Dwarf(String nome){
        this(nome, new DataTerceiraEra(1, 1, 1));
    }
    
    public String getNome(){
        return nome;
    }
    
    public int getVida(){
        return vida;
    }
    
    public void setVida(int vida){
        this.vida = vida;
    }
    
    public Status getStatus(){
        return status;
    }
    
    public void recebeDano(){
        this.vida += -10;
        if(this.vida < 0){
                this.vida = 0;
            }
         if(this.vida == 0){
            status = this.status.MORTO;    
        }
    }
}
