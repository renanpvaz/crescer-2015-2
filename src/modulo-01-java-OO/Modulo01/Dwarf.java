

public class Dwarf
{
    protected String nome;
    protected int vida = 110;
    protected Status status;
    protected int experiencia = 0;
    protected DataTerceiraEra dataNascimento;
    protected Inventario inventario;
    
    public Dwarf(String nome){
        this(nome, new DataTerceiraEra(1, 1, 1));
    }
    
    public Dwarf(String nome, DataTerceiraEra dataNascimento){
        this.nome = nome;
        this.status = Status.VIVO;
        this.dataNascimento = dataNascimento;
        this.inventario = new Inventario();
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
    
    public int getExperiencia(){
        return experiencia;
    }
    
    public Inventario getInventario(){
        return inventario;
    }
    
    public void recebeDano(){
        double sorte = this.getSorte();
        if(sorte < 0){
            this.experiencia += 2;
        } else if(sorte >= 0 && sorte <= 100){
            return;
        }else{
            this.vida += -10;
            if(this.vida < 0){
                this.vida = 0;
            }
            if(this.vida == 0){
                this.status = Status.MORTO;    
            }
        }
    }
    
    public double getSorte(){
        double retorno = 101;
        if(this.dataNascimento.ehBissexto() && this.vida >= 80 && this.vida <= 90){
                retorno *= -33;
        } 
        if(!this.dataNascimento.ehBissexto() && (this.nome.equals("Seixas") || this.nome.equals("Meireles"))){
                retorno = retorno * 33 % 100;
        }
        return retorno;
    }
    
    public void tentarSorte(){
         if(this.getSorte() == (-3333)){
           this.inventario.adicionar1000TodosItens();
         }    
       }
   }

 

