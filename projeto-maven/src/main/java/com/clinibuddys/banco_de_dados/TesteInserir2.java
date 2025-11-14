package com.clinibuddys.banco_de_dados;

import java.sql.Connection;
import java.time.LocalDateTime;

import com.clinibuddys.CliniBuddySystem.Diagnostico;
import com.clinibuddys.CliniBuddySystem.Historico;
import com.clinibuddys.CliniBuddySystem.Especies.Cachorro;
import com.clinibuddys.banco_de_dados.objetosDAO.PacienteDAO;

public class TesteInserir2 {
    public static void main(String[] args) {
        Cachorro c = new Cachorro("Jake", "labrador", 2, 18.2, "Médio");
        c.adicionarDoenas("Parvovirose");
        c.adicionarDoenas("Otite");

        c.adicionarSintoma("Vomitos");
        c.adicionarSintoma("Convulsões");

        Diagnostico ds = new Diagnostico("Luiz Felipe", "Parvorirose", "Descrição teste paciente2", "Internação", "Risco Médio", "Observações Teste2");
        LocalDateTime ldt = LocalDateTime.of(2025, 11, 7, 13, 25, 39);
        ds.setData(ldt);
        
        Historico hs = new Historico("Luiz Felipe", "João Victor", 18.2, "Observação Teste2");
        hs.setData(ldt);

        c.adicionarDiagnostico(ds);
        c.adicionarHistorico(hs);

        Connection conn = ConexaoDB.conectar();
        PacienteDAO pacienteDAO = new PacienteDAO(conn);

        pacienteDAO.inserir(c);
    }
    
}

