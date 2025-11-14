package com.clinibuddys.banco_de_dados;

import java.sql.Connection;

import com.clinibuddys.CliniBuddySystem.Paciente;
import com.clinibuddys.CliniBuddySystem.Especies.Cachorro;
import com.clinibuddys.CliniBuddySystem.Especies.Gato;
import com.clinibuddys.banco_de_dados.objetosDAO.PacienteDAO;

public class TesteSelectPaciente {
    public static void main(String[] args) {
        Connection conn = ConexaoDB.conectar();
        PacienteDAO pacienteDAO = new PacienteDAO(conn);

        Paciente p = pacienteDAO.consultaPorId(1);

            exibirDadosPaciente(p);
    }
    

    private static void exibirDadosPaciente(Paciente p) {
        if(p instanceof Cachorro) {
            Cachorro c = (Cachorro) p;

            System.out.println("Id: " + c.getId() + "/ Nome: " + c.getNome() + "/ Idade: " + c.getIdade() + "/ Espécie: " + c.getEspecie() + "/ Raça: " + c.getRaca() + "/ Peso: " + c.getPeso() + "/ Porte: " + c.getPorte());
            System.out.println();
            System.out.println("Lista de doenças: " + c.getDoencas());
            System.out.println("Lista de sintomas: " + c.getSintomas());
            System.out.println();
            System.out.println("Lista De diagnosticos: " + c.getDiagnostico());
            System.out.println("Lista de historicos: " + c.getHistorico());
            System.out.println();
            System.out.println(c.getInfoCompleta());
        }
        else if(p instanceof Gato) {
            Gato g = (Gato) p;
            
            System.out.println("Id: " + g.getId() + "/ Nome: " + g.getNome() + "/ Idade: " + g.getIdade() + "/ Espécie: " + g.getEspecie() + "/ Raça: " + g.getRaca() + "/ Peso: " + g.getPeso());
            System.out.println();
            System.out.println("Lista de doenças: " + g.getDoencas());
            System.out.println("Lista de sintomas: " + g.getSintomas());
            System.out.println();
            System.out.println("Lista De diagnosticos: " + g.getDiagnostico());
            System.out.println("Lista de historicos: " + g.getHistorico());
            System.out.println();
            System.out.println(g.getInfoCompleta());
        }
    }
}
