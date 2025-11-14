package com.clinibuddys.CliniBuddySystem.Especies;

import com.clinibuddys.CliniBuddySystem.Paciente;

public class Gato extends Paciente{
    
    static String tipo = "Gato";
    public Gato(String nome, String raca, int idade, float peso) {
        // A primeira linha DEVE ser a chamada ao construtor da superclasse
        super(nome, raca, idade, peso);
        
    }

    public Gato(String nome, String raca, int idade, Double peso) {
        // A primeira linha DEVE ser a chamada ao construtor da superclasse
        super(nome, raca, idade, peso);
        
    }

    public Gato(){}
    @Override
    public String getEspecie() {
        return "Gato";
    }
}

