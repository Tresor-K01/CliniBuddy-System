package com.clinibuddys.banco_de_dados;

import java.sql.Connection;
import java.util.List;

import com.clinibuddys.CliniBuddySystem.Paciente;
import com.clinibuddys.banco_de_dados.objetosDAO.PacienteDAO;

public class TesteDeletarPorId {
    public static void main(String[] args) {
        Connection conn = ConexaoDB.conectar();
        PacienteDAO pacienteDAO = new PacienteDAO(conn);

        pacienteDAO.deletarPorId(1);

        List<Paciente> ps = pacienteDAO.listarTodos();

        for(Paciente p : ps) {
            System.out.println(" - ID: " + p.getId());
            System.out.println(p.getInfoCompleta());
            System.out.println(p.getDiagnostico());
            System.out.println(p.getHistorico());
            System.out.println();
        }
    }
    
}
