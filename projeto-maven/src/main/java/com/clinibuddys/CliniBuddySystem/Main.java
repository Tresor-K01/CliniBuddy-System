package com.clinibuddys.CliniBuddySystem;

import java.util.ArrayList;
import java.util.List;

public class Main{
    public static void main(String[] args) {
        //lista vazia onde os pacientes serão registrados
        List<Paciente> bancoDeDadosPets = new ArrayList<>();
        
        //criação da instância do menu
        Menu meuMenu = new Menu(bancoDeDadosPets);

        //inicia e exibe o menu
        meuMenu.exibir();
    }
}