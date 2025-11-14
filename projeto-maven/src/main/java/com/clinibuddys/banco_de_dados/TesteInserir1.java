package com.clinibuddys.banco_de_dados;

import java.sql.Connection;
import java.time.LocalDateTime;

import com.clinibuddys.CliniBuddySystem.Diagnostico;
import com.clinibuddys.CliniBuddySystem.Historico;
import com.clinibuddys.CliniBuddySystem.Especies.Cachorro;
import com.clinibuddys.banco_de_dados.objetosDAO.PacienteDAO;

public class TesteInserir1 {
    public static void main(String[] args) {
        Cachorro c = new Cachorro("Spike", "Golden Retriever", 5, 25.3, "Médio");
        c.adicionarDoenas("Gripe Canina");
        c.adicionarDoenas("Sarna");

        c.adicionarSintoma("Febre alta");
        c.adicionarSintoma("Espirros");
        c.adicionarSintoma("Manchas no corpo");

        Diagnostico ds = new Diagnostico("Marcos", "Gripe Canina", "Descrição teste paciente", "Antibiótico", "Sem Riscos", "Observações Teste");
        LocalDateTime ldt = LocalDateTime.of(2025, 11, 7, 13, 25, 39);
        ds.setData(ldt);
        
        Historico hs = new Historico("Marcos", "Felipe", 12.4, "Observação Teste");
        hs.setData(ldt);

        c.adicionarDiagnostico(ds);
        c.adicionarHistorico(hs);

        Connection conn = ConexaoDB.conectar();
        PacienteDAO pacienteDAO = new PacienteDAO(conn);

        pacienteDAO.inserir(c);
    }
    
}
