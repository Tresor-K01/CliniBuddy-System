package CliniBuddySystem.Especies;

import CliniBuddySystem.Paciente;

public class Cachorro extends Paciente{
    String porte;
    public Cachorro(String nome, String raca, int idade, float peso, String porte){
            super(nome, raca, idade, peso);
            this.porte = porte;
        }

    @Override
    public String getEspecie() {
        return "Cachorro";
    }

    public String getPorte(){
        return porte;
    }
}
