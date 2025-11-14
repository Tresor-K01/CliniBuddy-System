package com.clinibuddys.CliniBuddySystem.Especies;

import com.clinibuddys.CliniBuddySystem.Paciente;

public class Cachorro extends Paciente{
    private String porte;
    public Cachorro(String nome, String raca, int idade, double peso, String porte){
            super(nome, raca, idade, peso);
            this.porte = porte;
        }
    
    public Cachorro(){
        super(); 
    }
    @Override
    public String getEspecie() {
        return "Cachorro";
    }

    public String getPorte(){
        return porte;
    }   

    // Setters 
    public void setPorte(String porte) {
        this.porte = porte;
    }

}
