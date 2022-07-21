package control;

import java.sql.*;

/**
 * Realiza a conexão e prepara o Banco de dados para ser manipulado
 * @author Grupo 1
 */
public class BD {
	
	// realiza a conexão ao BD usando o Driver
	public Connection con = null;
	
	// realiza a execuçaõ de instruções SQL
	public PreparedStatement st = null;
	
	// manipula uma tabela em memória
	public ResultSet rs = null;
	
	private final String DRIVER = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private final String DATABASENAME = "DB_PI";
	private final String URL = "jdbc:sqlserver://localhost:1433;databasename="+DATABASENAME;
	private final String LOGIN = "sa";
	private final String PASSWORD = "123456";
	
	/**
	 * Realiza a conexão ao banco de dados
	 * @return - true em caso de sucesso ou false caso contrário
	 */
	public boolean getConnection()
	{
		try
		{
			Class.forName(DRIVER); //carregando o DRIVER
			//System.out.println("Driver carregado com sucesso!");
			con = DriverManager.getConnection(URL,LOGIN,PASSWORD);
			System.out.println("Conectado com sucesso!");
			return true;
		}
		catch(ClassNotFoundException erro)
		{
			System.out.println("Driver não encontrado!");
			return false;
		}
		catch(SQLException erro)
		{
			System.out.println("Falha na conexão " + erro);
			return false;
		}
	}
	
	/**
	 * Encerra a conexão com o banco de dados, fechando todos os objetos utilizados
	 */
	public void close()
	{
		try
		{
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(con!=null)
				{
					con.close();
					System.out.println("Desconectou..");
				}
		}
		catch(SQLException erro) {}
	}
	
	public static void main(String[] args) {
		BD bd = new BD();
		bd.getConnection();
		//executar uma instrução
		bd.close();
	}
}
