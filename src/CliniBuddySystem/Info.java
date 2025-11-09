package CliniBuddySystem;

import  java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Info{
    // atributos comuns
    private static int proximoID = 1;
    private static final DateTimeFormatter FORMATADOR = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    protected final int id; //identificador único e imutável
    protected LocalDateTime data; 
    protected String veterinarioResponsavel; 
    protected String observacoes; //campo genérico para anotações gerais;

// -> métodos construtores

    // -> construtor principal: permite que a subclasse defina a data.
public Info(LocalDateTime data, String veterinarioResponsavel, String observacoes){
    this.id = proximoID++;
    this.data = data;
    this.veterinarioResponsavel = veterinarioResponsavel;
    this.observacoes = observacoes;
}

    // -> construtor secundáiro: para registros que ocorrem no "agora"
    public Info(String veterinarioResponsavel, String observacoes){
        this(LocalDateTime.now(), veterinarioResponsavel, observacoes);
    }

    // --- Métodos ---

    /**
     * exibe as informações do registro usando um template.
     * este método não pode ser sobrescrito (final).
     */
    public final void exibir() {
        System.out.println("\n--- Ficha de Registro (ID: " + this.id + ") ---");
        System.out.println("  - Data do Registro: " + this.data);
        System.out.println("  - Veterinário Responsável: " + this.veterinarioResponsavel);
        
        // chamada para o método que exibe os detalhes específicos de cada subclasse
        exibirDetalhes(); 
        
        if (observacoes != null && !observacoes.trim().isEmpty()) {
            System.out.println("  - Observações Adicionais: " + this.observacoes);
        }
        System.out.println("------------------------------------");
    }

    /**
     * método abstrato que força as subclasses a implementarem a exibição
     * de seus próprios detalhes.
     */
    protected abstract void exibirDetalhes();

    // -> getters
    public int getId() {
        return id;
    }

    public String getDataFormatada(){
        return this.data.format(FORMATADOR);
    }
    
    public String getVeterinarioResponsavel() {
        return veterinarioResponsavel;
    }

    public String getObservacoes() {
        return observacoes;
    }
    
    @Override
    public String toString() {
        // fornece uma representação útil para listas
        return "Registro #" + id + " (" + data + ")";
    }
}
