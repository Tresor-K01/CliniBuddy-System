package com.clinibuddys.banco_de_dados;

import java.sql.Connection;
import java.time.LocalDateTime;

import com.clinibuddys.CliniBuddySystem.Diagnostico;
import com.clinibuddys.CliniBuddySystem.Historico;
import com.clinibuddys.CliniBuddySystem.Especies.Cachorro;
import com.clinibuddys.banco_de_dados.objetosDAO.PacienteDAO;

public class TesteInserir3 {
    public static void main(String[] args) {
        Cachorro c = new Cachorro("King", "Pitbull", 3, 42.6, "Grande");
        c.adicionarDoenas("Parasitose");

        c.adicionarSintoma("Fraqueza");
        c.adicionarSintoma("Falta de ar");

        Diagnostico ds = new Diagnostico("Daniel", "Parasitose", "Descrição teste paciente3", "Antiviral", "Riscos médios", "Observações Teste3");
        LocalDateTime ldt = LocalDateTime.of(2025, 12, 21, 19, 30, 2);
        ds.setData(ldt);
        
        Historico hs = new Historico("Daniel", "Mária", 15.12, "Observação Teste3");
        hs.setData(ldt);

        c.adicionarDiagnostico(ds);
        c.adicionarHistorico(hs);

        Connection conn = ConexaoDB.conectar();
        PacienteDAO pacienteDAO = new PacienteDAO(conn);

        pacienteDAO.inserir(c);
    }
    
}
