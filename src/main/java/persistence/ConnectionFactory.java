package persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import model.Aluno;

public class ConnectionFactory {
	public static Connection getConnection() {
		String driver = "org.postgresql.Driver";
		String user = "postgres";// Coloque o usuário criado para acesso ao banco
		String senha = "12345";// Coloque a senha para acesso ao banco
		String url = "jdbc:postgresql://localhost:5432/EscolaDB";// Coloque o servidor onde está instalado o banco
		Connection con = null;

		try {
			Class.forName(driver);
			con = (Connection) DriverManager.getConnection(url, user, senha);
//			System.out.println("Conexão realizada com sucesso.");
		} catch (ClassNotFoundException ex) {
			System.err.print(ex.getMessage());
		} catch (SQLException e) {
			System.err.print("Senha Incorreta");
		}
		return con;
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
		}
	}

	public static void main(String[] argson) {
		Connection con = ConnectionFactory.getConnection();
		if (con != null) {
			System.out.println("¡OK!");
			ConnectionFactory.close(con);
		}
	}
}