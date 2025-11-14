package com.clinibuddys.CliniBuddySystem;

public class Historico extends Info{
    // atributos únicos da classe histórico
    private String acompanhante;
    private double temperatura;


    // -> método construtor COM observacoes
    public Historico(String veterinarioResponsavel, String acompanhante, double temperatura, String observacoes){
        super(veterinarioResponsavel, observacoes); //corrigir métodos construtores
        this.acompanhante = acompanhante;
        this.temperatura = temperatura;
    }
    
    // -> método construtor auxiliar SEM observações
    public Historico(String veterinarioResponsavel, String acompanhante, double temperatura){
        this(veterinarioResponsavel, acompanhante, temperatura,"");
    }

    public Historico(){}

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

    public double getTemperatura(){
        return temperatura;
    }

    // -> sets especifícos
    public void setAcompanhante(String acompanhante) {
        this.acompanhante = acompanhante;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }
}


