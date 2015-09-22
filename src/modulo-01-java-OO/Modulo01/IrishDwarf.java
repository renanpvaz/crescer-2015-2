
/**
 * Write a description of class IrishDwarf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class IrishDwarf extends Dwarf
{
    
    public IrishDwarf(String nome){
        super(nome);
    }
    
    public IrishDwarf(String nome, DataTerceiraEra dataNascimento){ 
        super(nome, dataNascimento);
    }
    
    public void tentarSorte(){
        if(this.getSorte() == (-3333)){
            this.inventario.adicionar1000TodosItensMaisSoma();   
        }
    }
}
public class IrishDwarf {
    private String nome;
    private int vida, experiencia;
    private Status status;
    private DataTerceiraEra dataNascimento;
    private Inventario inventario;

    public IrishDwarf() {
        this.vida = 110;
        this.status = Status.VIVO;
        this.dataNascimento = new DataTerceiraEra(1,1,1);
        this.inventario = new Inventario();
    }

    public IrishDwarf(String nome) {
        this();
        this.nome = nome;
    }

    public IrishDwarf(String nome, DataTerceiraEra dataNascimento) {
        this(nome);
        this.dataNascimento = dataNascimento;
    }

    public void receberFlechada() {

        double numero = this.gerarNumero();

        if (numero < 0) {
            this.experiencia += 2;
        } else if (numero > 100) {

            int dano = 10, vidaAposFlechada = this.vida-dano;
            if (vidaAposFlechada == 0) {
                this.status = Status.MORTO;
            } 

            if (vida > 0) {
                this.vida = vidaAposFlechada;
            }
        }
    }

    public int getVida() {
        return this.vida;
    }

    public Status getStatus() {
        return this.status;
    }

    public int getExperiencia() {
        return this.experiencia;
    }

    public String getNome() {
        return this.nome;
    }

    public DataTerceiraEra getDataNascimento() {
        return this.dataNascimento;
    }

    public double gerarNumero() {
        double resultado = 101.;

        if (dataNascimento.ehBissexto() && this.vida >= 80 && this.vida <= 90) {
            resultado *= -33.0;
        }

        if (!dataNascimento.ehBissexto() &&
        this.nome != null &&
        (this.nome.equals("Seixas") || this.nome.equals("Meireles"))) {
            resultado = resultado * 33 % 100;
        }

        return resultado;
    }
    
    public void adicionarItem(Item item) {
        this.inventario.adicionarItem(item);
    }
    
    public void perderItem(Item item) {
        this.inventario.perderItem(item);
    }
    
    public Inventario getInventario() {
        return this.inventario;
    }
    
    public void tentarSorte() {
        double numero = gerarNumero();
        
        if (numero == -3333.0) {
            this.inventario.aumentarUnidadesComSomatorio();
        }
    }
}
