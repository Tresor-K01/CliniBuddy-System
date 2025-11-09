package CliniBuddySystem;

public class Historico extends Info{
    // atributos únicos da classe histórico
    private String acompanhante;
    private float temperatura;


    // -> método construtor COM observacoes
    public Historico(String veterinarioResponsavel, String acompanhante, float temperatura, String observacoes){
        super(veterinarioResponsavel, observacoes); //corrigir métodos construtores
        this.acompanhante = acompanhante;
        this.temperatura = temperatura;
    }
    
    // -> método construtor auxiliar SEM observações
    public Historico(String veterinarioResponsavel, String acompanhante, float temperatura){
        this(veterinarioResponsavel, acompanhante, temperatura,"");
    }


     // -> método abstrato para exibir apenas seus detalhes
    @Override
    protected void exibirDetalhes() {
        System.out.println("  - Tipo de Registro: Histórico de Consulta");
        System.out.println("  - Acompanhante: " + this.acompanhante);
        System.out.println("  - Temperatura Aferida: " + this.temperatura + "°C");
    }

    // -> método toString() para exibição limpa em listas.
    @Override
    public String toString() {
        return "Consulta em " + super.getDataFormatada();
    }

    // getters especifícos
    public String getAcompanhante(){
        return acompanhante;
    }

    public float getTemperatura(){
        return temperatura;
    }

    // -> sets especifícos
    public void setAcompanhante(String acompanhante) {
        this.acompanhante = acompanhante;
    }

    public void setTemperatura(float temperatura) {
        this.temperatura = temperatura;
    }
}


