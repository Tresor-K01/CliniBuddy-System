package com.clinibuddys.CliniBuddySystem;

import java.util.List;
import java.util.Scanner;
import com.clinibuddys.CliniBuddySystem.Especies.*;
import java.util.ArrayList; 
import java.time.LocalDate;
import java.time.LocalTime; 
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Menu{
    private Scanner entrada;
    private List<Paciente> listaDePacientes;
    private List<Agendamento> listaDeAgendamentos;
    private String veterinarioResponsavel;

    public Menu(List<Paciente> ListaDePacientes){
        this.entrada = new Scanner(System.in);
        this.listaDePacientes = ListaDePacientes;
        this.listaDeAgendamentos = new ArrayList<>();
    }
    
    /* ------ MENU E LÓGICA PRINCIPAL ------ */
    public void exibir(){
        boolean flag = true;
        System.out.println("--- Iniciando... ---\n" + "\n" +
                             " ------------------------------------\n" +
                             " |  Bem-vindo ao CliniBuddy System  |\n" +
                             " ------------------------------------\n" );

        System.out.println(" -> Nome do veterinario responsavel: ");
        this.veterinarioResponsavel = entrada.nextLine();
        while(flag){
            System.out.println("\n--- Menu CliniBuddy ---");            
            System .out.println("Digite o número para acessar uma aba: \n" +
                    "-> 1. Pacientes \n" +
                    "-> 2. Históricos\n" +
                    "-> 3. Diagnósticos\n" +
                    "-> 4. Agendamentos\n" +
                    "-> 5. Sair \n");

        int menu = lerInteiroComLimite("Sua opção: ", 1, 5);
        switch(menu){
            case(1):
                gerenciarPacientes();
                break;
            case(2):
                gerenciarHistorico();
                break;                            
            case(3):
                gerenciarDiagnostico();
                break;
            case(4):
                gerenciarAgendamentos();
                break;
            case(5):
                System.out.println("--- Encerrando... ---");
                flag = false;
                break;                  
        }
    }
    entrada.close();
}
    /*------ lista de métodos para gerenciamento geral -------*/

    //método privado para a aba de histórico
    private void gerenciarHistorico(){
        System.out.println("\n--- Histórico ---\n");
         boolean flag = true;
            while(flag){
            System.out.print("Digite o número para acessar uma aba: \n" +
                               " -> 0. Voltar \n" + 
                               " -> 1. Cadastrar novo histórico \n" +
                               " -> 2. Exibir históricos \n");
            int subMenu = lerInteiroComLimite("Sua opção: ", 0, 2);
            switch(subMenu){
                case 0:
                    flag = false;
                    break;
                case 1:
                    adicionarHistorico();
                    flag = false;
                    break;
                case 2:
                    exibirHistorico();
                    flag = false;
                    break;                
            }
        }
    }

    // método privado para a aba de diagnóstico
    private void gerenciarDiagnostico(){
         System.out.println("\n--- Diagnóstico ---\n");
         boolean flag = true;
            while(flag){
            System.out.print("Digite o número para acessar uma aba: \n" +
                               " -> 0. Voltar \n" + 
                               " -> 1. Cadastrar novo diagnóstico \n" +
                               " -> 2. Exibir diagnóstico \n");
            int subMenu = lerInteiroComLimite("Sua opção: ", 0, 2);
            switch (subMenu){
                case 0:
                    flag = false;
                    break;
                case 1:
                    adicionarDiagnostico();
                    flag = false;
                    break;
                case 2:
                    exibirDiagnostico();
                    flag = false;
                    break;
            }
        }
    }
    
    //método privado para a aba de pacientes
    private void gerenciarPacientes(){
        System.out.println("\n--- Gerenciamento de pacientes ---\n");
        boolean flag = true;
        while(flag){
            System.out.print("Digite o número para acessar uma aba: \n" +
                               " -> 0. Voltar \n" + 
                               " -> 1. Cadastrar novo paciente \n" +
                               " -> 2. Exibir cadastros \n");
            int subMenu = lerInteiroComLimite("Sua opção: ", 0, 2);
            switch (subMenu){
                case 0:
                    flag = false;
                    break;
                case 1:
                    realizarCadastro();
                    flag = false;
                    break;
                case 2:
                    exibirCadastro();
                    flag = false;
                    break;
            }
        }
    }
  
    //método privado para a aba de agendamentos
    private void gerenciarAgendamentos(){
        System.out.println("\n--- Gerenciamento de Agendamentos ---\n");
        boolean flag = true;
        while(flag){
            System.out.print("Digite o número para acessar uma aba: \n" +
                               " -> 0. Voltar \n" + 
                               " -> 1. Cadastrar novo agendamento \n" +
                               " -> 2. Exibir agendamentos \n");
            int subMenu = lerInteiroComLimite("Sua opção: ", 0, 2);
            switch (subMenu){
                case 0:
                    flag = false;
                    break;
                case 1:
                    adicionarAgendamento();
                    flag = false;
                    break;
                case 2:
                    exibirAgendamentos();
                    flag = false;
                    break;
            }
        }
    }

    // -> método privado geral para a lógica de cadastro
  private void realizarCadastro(){
        System.out.println("\n--- Cadastro de novo paciente ---");
        
        System.out.print("--- Digite o nome do paciente: ");
        String nome = entrada.nextLine();
        
        System.out.print("--- Digite a raça: ");
        String raca = entrada.nextLine();

        System.out.print("--- Digite a idade (anos): ");
        int idade = lerInteiro("");

        System.out.print("--- Digite o peso (kg): ");
        float peso = lerFloat("");

        boolean flag = true;
        Paciente novoPaciente = null;
        
        while(flag){
            System.out.print("--- Qual a espécie do paciente? : \n -> 1. Gato \n -> 2. Cachorro\n");
            int temp = lerInteiroComLimite("Sua opção: ", 1, 2);
            switch (temp){
                case 1:
                    // Os dados já foram lidos
                    novoPaciente = new Gato(nome, raca, idade, peso);
                    flag = false;
                    break;
                case 2:
                    System.out.print("--- Qual o porte do cachorro? (Pequeno/Médio/Grande) \n");
                    String porte = entrada.nextLine();
                    novoPaciente = new Cachorro(nome, raca, idade, peso, porte);
                    flag = false;
                    break;
                }
            }        
        System.out.println("Especie selecionada: " + novoPaciente.getEspecie() + "\n");
        listaDePacientes.add(novoPaciente);
        System.out.println("\n--- Paciente: " + nome + " cadastrado com sucesso! --- \n");
  }

    //método para exibir cadastros    
    private void exibirCadastro(){
        System.out.println("\n--- Pacientes cadastrados ---\n");
        Paciente PacienteSelecionado = selecionarPaciente();
        if(PacienteSelecionado != null){
            System.out.println(PacienteSelecionado.getInfoCompleta() + "\n");
        }            
    }
    
    // -> método AUXILIAR para escolher um paciente da lista
    private Paciente selecionarPaciente(){
        if (listaDePacientes.isEmpty()) {
            System.out.println("\n-> Nenhum paciente encontrado. Cadastre um primeiro.\n");
            return null;
        }

        System.out.println("\nSelecione um paciente:");
        for (int i = 0; i < listaDePacientes.size(); i++) {
            System.out.println("-> " + (i + 1) + ". " + listaDePacientes.get(i));
        }

        int id = lerInteiroComLimite("Digite o número do paciente: ", 1, listaDePacientes.size());
        return listaDePacientes.get(id - 1);
        }


    // --- métodos para adicionar ---
    
    private void adicionarDiagnostico(){
        System.out.println("--- Cadastro de Diagnostico ---");
        Paciente paciente = selecionarPaciente();
        if(paciente != null){
            System.out.print("Informe a doença: ");
            String doença = entrada.nextLine();

            System.out.print("Faça uma breve descrição da doença: ");
            String descricao = entrada.nextLine();

            System.out.print("Tratamento Sugerido: ");
            String tratamento = entrada.nextLine();
            
            System.out.print("Quais são os riscos: ");
            String riscos = entrada.nextLine();

            Diagnostico Novodiagnostico = new Diagnostico(this.veterinarioResponsavel, doença, descricao, tratamento, riscos);
            paciente.adicionarDiagnostico(Novodiagnostico);
        }
    }

    private void adicionarHistorico(){
        System.out.println("--- Adicionar histórico ---\n");
        Paciente paciente = selecionarPaciente();
        if(paciente != null){

            System.out.print(" ->Nome do acompanhante: ");
            String acomp = entrada.nextLine();
            
            System.out.print(" ->Temperatura aferida (°C): ");
            float temp = lerFloat("");
            
            Historico novoHistorico = new Historico(this.veterinarioResponsavel, acomp, temp);
            paciente.adicionarHistorico(novoHistorico);
            System.out.println("--- Registro adicionado ao histórico de " + paciente.getNome() + " ---\n");
        }
    }

    private void adicionarAgendamento(){
        System.out.println("--- Adicionar agendamento ---\n");
        Paciente paciente = selecionarPaciente();
        if(paciente != null){
            System.out.print("Informe o motivo do agendamento: ");
            String motivo = entrada.nextLine();

            LocalDate data = lerData("Informe a data (dd/MM/yyyy): ");
            LocalTime horario = lerHorario("Informe o horário (HH:mm): ");

            System.out.print("Informe o status (Ex: Agendado, Confirmado): ");
            String status = entrada.nextLine();

            // Cria o agendamento
            Agendamento novoAgendamento = new Agendamento(paciente, data, horario, this.veterinarioResponsavel, motivo, status);
            
            // Adiciona à lista de agendamentos
            this.listaDeAgendamentos.add(novoAgendamento);
            System.out.println("\n--- Agendamento para " + paciente.getNome() + " cadastrado com sucesso! --- \n");
        }
    }

    // --- métodos de exibição
     private void exibirHistorico(){
        Paciente paciente = selecionarPaciente();
        if(paciente != null){
        List<Historico> HistoricoPaciente = paciente.getHistorico(); 
        if (HistoricoPaciente.isEmpty()) {
            System.out.println(" -> Nenhum histórico encontrado. Cadastre um primeiro.\n");
            return;
        }
        System.out.println("Selecione um registro histórico: ");
        for (int i = 0; i < HistoricoPaciente.size(); i++) {
            System.out.println("    -> " + (i + 1) + ". " + HistoricoPaciente.get(i) + "( " + HistoricoPaciente.get(i).getDataFormatada() + " )");
        }

        System.out.print("Digite o número do histórico: ");
        int id = lerInteiro("");

        // validando a entrada e ajustando o índice
        if (id > 0 && id <= HistoricoPaciente.size()) {
            Historico atual = HistoricoPaciente.get(id - 1);
            atual.exibir();
        } else {
            System.out.println("--- Número de paciente inválido. ---\n");
            return;
            }
        }
    }
    private void exibirDiagnostico(){
        Paciente paciente = selecionarPaciente();
        if(paciente != null){
        List<Diagnostico> DiagnosticosPaciente = paciente.getDiagnostico(); 
        if (DiagnosticosPaciente.isEmpty()) {
            System.out.println(" -> Nenhum diagnóstico encontrado. Cadastre um primeiro.\n");
            return;
        }

        System.out.println("Selecione um registro histórico: ");
        for (int i = 0; i < DiagnosticosPaciente.size(); i++) {
            System.out.println("-> " + (i + 1) + ". " + DiagnosticosPaciente.get(i));
        }

        int id = lerInteiro("Digite o número do histórico: \"");

        // validando a entrada e ajustando o índice
        if (id > 0 && id <= DiagnosticosPaciente.size()) {
            DiagnosticosPaciente.get(id - 1).exibir();
            }
        }
    }

    private void exibirAgendamentos(){
        if (this.listaDeAgendamentos.isEmpty()) {
            System.out.println("\n-> Nenhum agendamento encontrado.\n");
            return;
        }

        System.out.println("\n--- Agendamentos Registrados ---");
        for (int i = 0; i < this.listaDeAgendamentos.size(); i++) {
            // Usa o toString() do Agendamento
            System.out.println("-> " + (i + 1) + ". " + this.listaDeAgendamentos.get(i));
        }

        System.out.println("---------------------------------");
        System.out.print("Digite o número do agendamento para ver detalhes (ou 0 para voltar): ");
        int id = lerInteiroComLimite("", 0, this.listaDeAgendamentos.size());

        if (id > 0) {
            Agendamento selecionado = this.listaDeAgendamentos.get(id - 1);
            selecionado.exibir(); // Usa o método exibir() da classe Info
        }
    }
    // --- métodos auxiliares de leitura segura ---

    /**
     * lê um número inteiro do usuário, garantindo que a entrada seja válida.
     * continua pedindo até que um número inteiro seja digitado.
     * @param mensagem A mensagem a ser exibida para o usuário.
     * @return O número inteiro lido.
     */
    private int lerInteiro(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                return Integer.parseInt(entrada.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("--- Erro: Por favor, digite um número inteiro válido. ---");
            }
        }
    }

    /**
     * Lê um número float do usuário, garantindo que a entrada seja válida.
     * Continua pedindo até que um número seja digitado (ex: 10 ou 10.5).
     * @param mensagem A mensagem a ser exibida para o usuário.
     * @return O número float lido.
     */

    private float lerFloat(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                // Substitui vírgula por ponto para aceitar ambos os formatos
                return Float.parseFloat(entrada.nextLine().replace(',', '.'));
            } catch (NumberFormatException e) {
                System.err.println("--- Erro: Por favor, digite um número válido. ---");
            }
        }
    }

    /**
     * Lê um número inteiro dentro de um intervalo específico (min e max).
     * Continua pedindo até que um número válido dentro do intervalo seja digitado.
     * @param mensagem A mensagem para o usuário.
     * @param min O valor mínimo aceitável.
     * @param max O valor máximo aceitável.
     * @return O número inteiro lido e validado.
     */
    private int lerInteiroComLimite(String mensagem, int min, int max) {
        while (true) {
            int numero = lerInteiro(mensagem);
            if (numero >= min && numero <= max) {
                return numero;
            } else {
                System.err.println("--- Erro: O número deve estar entre " + min + " e " + max + ". ---");
            }
        }
    }

    // --- método auxiliar para ler data ---
    /**
     * Lê uma string em formato de data e verifica se está formatada
     * @param mensagem a mensagem para o usuário
     * @return um objeto formatado que representa uma data 
     */
    private LocalDate lerData(String mensagem) {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        while (true) {
            System.out.print(mensagem);
            String texto = entrada.nextLine();
            try {
                return LocalDate.parse(texto, formatador);
            } catch (DateTimeParseException e) {
                System.err.println("--- Erro: Formato de data inválido. Use dd/MM/yyyy (ex: 01/10/2025) ---");
            }
        }
    }

    // --- método auxiliar para ler hora ---
    /**
     * Lê uma string em formato de data e verifica se está formatada
     * @param mensagem a mensagem para o usuário
     * @return um objeto formatado que representa um horario
     */
    private LocalTime lerHorario(String mensagem) {
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("HH:mm");
        while (true) {
            System.out.print(mensagem);
            String texto = entrada.nextLine();
            try {
                return LocalTime.parse(texto, formatador);
            } catch (DateTimeParseException e) {
                System.err.println("--- Erro: Formato de hora inválido. Use HH:mm (ex: 14:30) ---");
            }
        }
    }
}
