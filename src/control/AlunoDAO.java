package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;

/**
 * Classe Data Access Object para abstrair e maipular os dados no banco de dados, referente ao objeto Aluno
 * @author Grupo 1
 */
public class AlunoDAO {

	private BD bd;
	private String men, sql;
	
	public AlunoDAO() {
		bd = new BD();
	}
	
	/**
	 * Grava os atributos de Aluno em sua tabela no BD
	 * @param aluno - Objeto que terá seus atributos salvos
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String gravar(Aluno aluno)
	{
		sql = "insert into TBALUNOUSUARIO values (?,?,?,?,?,?,?,?,?)";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, aluno.getCodAlunoUsuario());
			bd.st.setInt(2, aluno.getCodCurso());
			bd.st.setString(3, aluno.getNomeAluno());
			bd.st.setString(4, aluno.getCpfAluno());
			bd.st.setString(5, aluno.getDataNascimentoAluno());
			bd.st.setString(6, aluno.getEmailAluno());
			bd.st.setString(7, aluno.getLoginUsuario());
			bd.st.setString(8, aluno.getSenhaAluno());
			bd.st.setInt(9, aluno.getCodPerfil());
			bd.st.executeUpdate();
			men = "Aluno inserido com sucesso!";
		}
		catch(SQLException erro)
		{
			men = "Falha: "+ erro;
		}
		finally
		{
			bd.close();
		}
		return men;
	}
	
	/**
	 * Altera os atributos de Aluno em sua tabela no BD
	 * @param aluno - Objeto que terá seus atributos alterados
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String alterar(Aluno aluno)
	{
		sql = "update TBALUNOUSUARIO set CODCURSO = ?, NOMEALUNO = ?, CPFALUNO = ?, DATANASCIMENTOALUNO = ?, EMAILALUNO = ?, "
				+ "LOGINUSUARIO = ?, SENHAUSUARIO = ?, CODPERFIL = ? where CODALUNOUSUARIO = ?";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, aluno.getCodCurso());
			bd.st.setString(2, aluno.getNomeAluno());
			bd.st.setString(3, aluno.getCpfAluno());
			bd.st.setString(4, aluno.getDataNascimentoAluno());
			bd.st.setString(5, aluno.getEmailAluno());
			bd.st.setString(6, aluno.getLoginUsuario());
			bd.st.setString(7, aluno.getSenhaAluno());
			bd.st.setInt(8, aluno.getCodPerfil());
			bd.st.setInt(9, aluno.getCodAlunoUsuario());
			bd.st.executeUpdate();
			bd.st.executeUpdate();
			men = "Alteração realizada com sucesso!";
		}
		catch(SQLException e)
		{
			men = "Falha: "+ e;
		}
		finally
		{
			bd.close();
		}
		return men;
	}
	
	/**
	 * Exclui os atributos de Aluno em sua tabela no BD
	 * @param aluno - Objeto que terá seus atributos excluídos
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String excluir(int coda)
	{
		sql = "delete from TBALUNOUSUARIO where CODALUNOUSUARIO = ?";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, coda);
			int n = bd.st.executeUpdate();
			if(n == 1)
			{
				men = "Aluno excluído com sucesso!";
			}
			else
			{
				men = "Aluno não encontrado!";
			}
		}
		catch(SQLException erro)
		{
			men = "Erro" + erro;
		}
		finally
		{
			bd.close();
		}
		return men;
	}
	
	/**
	 * Retorna uma lista de Aluno com base em um comando SELECT
	 * @param sql - Comando SELECT desejado para filtrar os atributos
	 * @return - Lista de objetos selecionados
	 */
	public List<Aluno> get(String sql)
	{
		List<Aluno> lista = new ArrayList<Aluno>();
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) //enquanto existirem registros
			{
				Aluno a = new Aluno();
				a.setCodAluno(bd.rs.getInt("CODALUNOUSUARIO"));
				a.setCodCurso(bd.rs.getInt("CODCURSO"));
				a.setNomeAluno(bd.rs.getString("NOMEALUNO"));
				a.setCpfAluno(bd.rs.getString("CPFALUNO"));
				a.setDataNascimentoAluno(bd.rs.getString("DATANASCIMENTOALUNO"));
				a.setEmailAluno(bd.rs.getString("EMAILALUNO"));
				a.setLoginUsuario(bd.rs.getString("LOGINUSUARIO"));
				a.setSenhaAluno(bd.rs.getString("SENHAUSUARIO"));
				a.setCodPerfil(bd.rs.getInt("CODPERFIl"));
				lista.add(a);
			}
		}
		catch(SQLException erro)
		{
			lista = null;
		}
		finally
		{
			bd.close();
		}
		return lista;
	}
}
