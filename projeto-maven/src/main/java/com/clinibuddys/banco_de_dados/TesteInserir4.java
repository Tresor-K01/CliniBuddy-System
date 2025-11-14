package com.clinibuddys.banco_de_dados;

import java.sql.Connection;
import java.time.LocalDateTime;

import com.clinibuddys.CliniBuddySystem.Diagnostico;
import com.clinibuddys.CliniBuddySystem.Historico;
import com.clinibuddys.CliniBuddySystem.Especies.Cachorro;
import com.clinibuddys.CliniBuddySystem.Especies.Gato;
import com.clinibuddys.banco_de_dados.objetosDAO.PacienteDAO;

public class TesteInserir4 {
    public static void main(String[] args) {
        Gato g = new Gato("Snowbell", "Siamês", 1, 8.2);
        g.adicionarDoenas("Gripe Canina");
        g.adicionarDoenas("Sarna");

        g.adicionarSintoma("Febre alta");
        g.adicionarSintoma("Espirros");
        g.adicionarSintoma("Manchas no corpo");

        Diagnostico ds = new Diagnostico("Marcos", "Gripe Canina", "Descrição teste paciente", "Antibiótico", "Sem Riscos", "Observações Teste");
        LocalDateTime ldt = LocalDateTime.of(2025, 11, 7, 13, 25, 39);
        ds.setData(ldt);
        
        Historico hs = new Historico("Marcos", "Felipe", 12.4, "Observação Teste");
        hs.setData(ldt);

        g.adicionarDiagnostico(ds);
        g.adicionarHistorico(hs);

        Connection conn = ConexaoDB.conectar();
        PacienteDAO pacienteDAO = new PacienteDAO(conn);

        pacienteDAO.inserir(g);
    }
    
}