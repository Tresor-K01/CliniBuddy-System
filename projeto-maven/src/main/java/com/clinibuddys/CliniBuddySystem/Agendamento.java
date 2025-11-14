package com.clinibuddys.CliniBuddySystem;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;
import java.time.LocalTime;

public class Agendamento extends Info {
    private Paciente paciente;
    private String motivo;
    private LocalDate data;
    private LocalTime horario;
    private String status;

    public Agendamento(Paciente paciente, LocalDate data, LocalTime horario, String veterinarioResponsavel, String motivo, String status) {
        super(veterinarioResponsavel, "");
        this.paciente = paciente;
        this.data = data;
        this.horario = horario;
        this.motivo = motivo;
        this.status = status;
    }


    //método que exibe detalhes do agendamento
    @Override
    protected void exibirDetalhes(){
        System.out.println(" ----- Agendamento ------ ");
        System.out.println(" Paciente: " + paciente.getNome() + " | "
                + paciente.getEspecie() + " | "
                + paciente.getRaca());
        System.out.println(" Data: " + data + " | Horário: " + horario);
        System.out.println(" Motivo: " + motivo);
        System.out.println(" Status: " + status);
    }

    // -> getters
    public Paciente getPaciente(){
        return paciente;
    }
    
    public String getMotivo(){
        return motivo; 
    }
    
    public LocalTime getHorario(){
        return horario;
    }
    
    public String getStatus(){
        return status;
    }

    public LocalDate getData(){
        return data;
    }

    // -> setters
    public void setData(LocalDate data){
        this.data = data;
    }

    public void setHorario(LocalTime horario){
        this.horario = horario;
    }
    
    public void setStatus(String status){
        this.status = status;
    }

    public void setPaciente(Paciente paciente){
        this.paciente = paciente;
    }
    
    public void setMotivo(String motivo){
        this.motivo = motivo;
    }

    @Override
    public String toString() {
        return "AGENDADO para " + data + " às " + horario +
                " | Paciente: " + paciente.getNome() +
                " | Espécie: " + paciente.getEspecie() +
                " | Raça: " + paciente.getRaca() +
                " | Motivo: " + motivo +
                " | Status: " + status;
    }
}
