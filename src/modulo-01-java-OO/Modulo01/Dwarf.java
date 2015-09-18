

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
    
    public DataTerceiraEra getDataNascimento(){
        return dataNascimento;
    }
    
    public void recebeDano(){
        if(this.getSorte() < 0){
            this.experiencia += 2;
        } else if(this.getSorte() > 0 && this.getSorte() < 100){
            return;
        }else{
            this.vida += -10;
            if(this.vida < 0){
                this.vida = 0;
            }
            if(this.vida == 0){
            status = this.status.MORTO;    
            }
        }
    }
    
    public double getSorte(){
        if(this.dataNascimento.ehBissexto() && this.vida >= 80 && this.vida <= 90){
                return 101.0 * -33;
        }else if(!this.dataNascimento.ehBissexto() && this.nome.equals("Seixas") ||!this.dataNascimento.ehBissexto() && this.nome.equals("Meireles")){
                return (101.0 * 33) % 100;
        }
        return 101.0;
    }     
}
 

