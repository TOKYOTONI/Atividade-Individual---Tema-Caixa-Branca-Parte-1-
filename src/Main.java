package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            // Conecta ao banco
            conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test", // troque 'test' pelo nome do seu banco
                "root", // usuário
                "1234"  // senha
            );

            System.out.println("✅ Conexão bem-sucedida!");

            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM usuarios"); // troque 'usuarios' pelo nome da sua tabela

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") + " | Nome: " + rs.getString("nome"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (st != null) st.close(); } catch (Exception e) {}
            try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
    }
}
