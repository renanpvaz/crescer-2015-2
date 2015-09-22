
public class Dwarf extends Personagem
{
    protected String nome;
    protected int vida = 110;
    protected Status status;
    protected int experiencia = 0;
    protected DataTerceiraEra dataNascimento;
    protected Inventario inventario;

    public Dwarf()  {
        this.dataNascimento = new DataTerceiraEra(1,1,1);
    }
    
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

    public void atacarOrc(Orc alvo){
        alvo.recebeDano(10);
    }
    
    public void receberAtaqueDoOrc(Orc orc){
        int danoCausado = orc.getDanoDeAtaque();
        this.vida -= danoCausado;
    }

    public void recebeDano(int dano){
        double sorte = this.getSorte();
        if(sorte < 0){
            this.experiencia += 2;
        } else if(sorte >= 0 && sorte <= 100){
            return;
        }else{
            this.vida -= dano;
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