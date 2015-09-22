

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
    
    public void atacarOrc(Orc alvo){
        alvo.recebeDano(10);
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

 

public class Dwarf {
    private String nome;
    private int vida, experiencia;
    private Status status;
    private DataTerceiraEra dataNascimento;
    private Inventario inventario;

    public Dwarf() {
        this.vida = 110;
        this.status = Status.VIVO;
        this.dataNascimento = new DataTerceiraEra(1,1,1);
        this.inventario = new Inventario();
    }

    public Dwarf(String nome) {
        this();
        this.nome = nome;
    }

    public Dwarf(String nome, DataTerceiraEra dataNascimento) {
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
    
    public void receberAtaqueDoOrc(Orc orc){
        int danoCausado = orc.getDanoDeAtaque();
        this.vida -= danoCausado;
    }
    
    public void atacarOrc(Orc orc){
        orc.levarAtaqueDeAnao();
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
            this.inventario.aumentar1000UnidadesEmCadaItem();
        }
    }
}
