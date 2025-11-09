package CliniBuddySystem;

public class Diagnostico extends Info{
    private String doenca;
    private String descricao;
    private String tratamentoSugerido;
    private String riscos;

    // -> método construtor COM observações
    public Diagnostico(String veterinarioResponsavel, String doenca, String descricao, String tratamentoSugerido, String riscos, String observacoes){
        super(veterinarioResponsavel, observacoes);
        this.doenca = doenca;
        this.descricao = descricao;
        this.tratamentoSugerido = tratamentoSugerido;
        this.riscos = riscos;
    }

    // -> método construtor auxiliar SEM observações
    public Diagnostico(String veterinarioResponsavel, String doenca, String descricao, String tratamentoSugerido, String riscos){
        this(veterinarioResponsavel, doenca, descricao, tratamentoSugerido, riscos, "");
    }
    
    // -> método toString() para facilitar a visualização em listas.
    @Override
    public String toString() {
        return "Diagnóstico: " + this.doenca + "(em: "+ super.getDataFormatada() + ")";
    }

   // -> método abstrato para exibir apenas seus detalhes
    @Override
    protected void exibirDetalhes() {
        System.out.println("  - Tipo de Registro: Diagnóstico Clínico");
        System.out.println("  - Doença: " + this.doenca);
        System.out.println("  - Descrição: " + this.descricao);
        System.out.println("  - Tratamento Sugerido: " + this.tratamentoSugerido);
        System.out.println("  - Riscos Associados: " + this.riscos);
    }
}