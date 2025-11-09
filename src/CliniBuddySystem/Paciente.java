package CliniBuddySystem;
import java.util.ArrayList;
import java.util.List;


// reformulação da classe paciente, pois ela se tornou uma classe abstrata
public abstract class Paciente{
    // -> atributos gerais
    protected String nome;
    protected String raca;
    protected int idade;
    protected float peso;

    // -> atributos específicos
    private List<Historico> historico; 
    private List<Diagnostico> diagnostico;
    private List<String> sintomas;
    private List<String> doencas;

    // -> método construtor
    public Paciente(String nome, String raca, int idade, float peso) {
        this.nome = nome;
        this.raca = raca;
        this.idade = idade;
        this.peso = peso;
        
        // -> inicializa todas as listas como vazias
        this.historico = new ArrayList<>();
        this.diagnostico = new ArrayList<>();
        this.sintomas = new ArrayList<>();
        this.doencas = new ArrayList<>();
    }

    // -> métodos para adicionar informações posteriomente
    public void adicionarSintoma(String sintoma) {
        this.sintomas.add(sintoma);
        System.out.println("sintoma " + sintoma + " adicionado para o paciente " + this.nome);
    }

    public void adicionarHistorico(Historico historico) {
        this.historico.add(historico);
        System.out.println("historico adicionado para o paciente " + this.nome);
    }

    public void adicionarDiagnostico(Diagnostico diagnostico){
        this.diagnostico.add(diagnostico);
        System.out.println("diagnostico adicionado para o paciente " + this.nome);
    }

    public void adicionarDoenas(String doenca){
        this.doencas.add(doenca);
        System.out.println("doenca: " + doenca + "para o paciente " + this.nome);
    }

    // -> getters para acessar informações
    public String getNome(){
        return nome;
    }

    public String getRaca(){
        return raca;
    }

    public int getIdade(){
        return idade;
    }
    public float getPeso(){
        return peso;
    }   

    // -> getters para as listas (NECESSÁRIOS PARA O MENU FUNCIONAR)
    public List<Historico> getHistorico() {
        return this.historico;
    }

    public List<Diagnostico> getDiagnostico() {
        return this.diagnostico;
    }

    // -> get abstrato
    public abstract String getEspecie();

    // Método que exibe o cadastro completo do paciente
    public String getInfoCompleta() {
        return "Ficha do paciente:\n" + 
                " - Nome: " + nome + "\n" +
                " - Espécie: " + this.getEspecie() + "\n" +
                " - Raça: " + raca + "\n" +
                " - Idade: " + idade + " anos\n" +
                " - Peso: " + peso + " kg\n" +
                " - Sintomas Registrados: " + (sintomas.isEmpty() ? "Nenhum" : sintomas);
    }
    
    // -> métodos que atualizam o cadastro do paciente com infomações que mudam com o tempo
        //idade
    public void setIdade(int NovaIdade){
        this.idade = NovaIdade;
        System.out.println("Idade de "+ this.nome + " atualizada para " + NovaIdade + " anos");
    }
        //peso
    public void setPeso(float NovoPeso){
        this.peso = NovoPeso;
        System.out.println("Peso de "+ this.nome + " atualizada para " + NovoPeso + " kg");
    }

// -> método toString() atualizado para usar o método abstrato
    @Override
    public String toString(){
        return this.nome + " (" + this.getEspecie() + ")";
    }

// -> método que lista os sintomas atuais do paciente
   public void listarSintomas(){
        System.out.println("--- sintomas do paciente: " +  this.nome + " ---");
        if(this.sintomas.isEmpty()){
            System.out.println("Nenhum sintoma registrado.");
        }
        else{
            for(int i = 0; i < this.sintomas.size(); i++){
                System.out.println("- " + this.sintomas.get(i));
            }
        }
   }
   /**
     * Remove um registro de histórico da lista deste paciente.
     */
    public void removerHistorico(Historico registro) {
        this.historico.remove(registro);
    }

    /**
     * Remove um registro de diagnóstico da lista deste paciente.
     */
    public void removerDiagnostico(Diagnostico registro) {
        this.diagnostico.remove(registro);
    }
}
