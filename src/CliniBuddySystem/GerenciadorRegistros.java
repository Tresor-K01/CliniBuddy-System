package CliniBuddySystem;

public class GerenciadorRegistros{
    private Clinica clinica;

    // --- método construtor de registros (histórico e diagnóstico)
    public GerenciadorRegistros(Clinica clinica){
        this.clinica = clinica; 
    }

    //
    public Historico adicionarHistorico(Paciente paciente, String acompanhante, float temperatura){
        String vet = clinica.getVeterinarioResponsavel();
        Historico novoHistorico = new Historico(vet, acompanhante, temperatura);
        paciente.adicionarHistorico(novoHistorico);
        return novoHistorico;
    }

    //
    public Diagnostico adicionarDiagnostico(Paciente paciente, String doenca, String descricao, String tratamento, String riscos){
        String vet = clinica.getVeterinarioResponsavel();
        Diagnostico novoDiagnostico = new Diagnostico(vet, doenca, descricao, tratamento, riscos);
        paciente.adicionarDiagnostico(novoDiagnostico);
        return novoDiagnostico;
    }

    /**
     * Exclui um registro de Histórico de um paciente.
     * (Geralmente para corrigir erros de entrada)
     */
    public void excluirHistorico(Paciente paciente, Historico registro) {
        paciente.removerHistorico(registro);
    }

    /**
     * Exclui um registro de Diagnóstico de um paciente.
     * (Geralmente para corrigir erros de entrada)
     */
    public void excluirDiagnostico(Paciente paciente, Diagnostico registro) {
        paciente.removerDiagnostico(registro);
    }
}
