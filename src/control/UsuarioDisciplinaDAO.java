package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.UsuarioDisciplina;

/**
 * Classe Data Access Object para abstrair e maipular os dados no banco de dados, referente ao objeto UsuarioDisciplina
 * @author Grupo 1
 */
public class UsuarioDisciplinaDAO {

	private BD bd;
	private String men, sql;
	
	public UsuarioDisciplinaDAO() {
		bd = new BD();
	}
	
	/**
	 * Grava os atributos de UsuarioDisciplina em sua tabela no BD
	 * @param usuarioDisciplina - Objeto que terá seus atributos salvos
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String gravar(UsuarioDisciplina usuarioDisciplina)
	{
		sql = "insert into TBUSUARIODISCIPLINA values (?,?)";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, usuarioDisciplina.getCodAlunoUsuario());
			bd.st.setInt(2, usuarioDisciplina.getCodDisciplina());
			bd.st.executeUpdate();
			men = "UsuarioDisciplina inserida com sucesso!";
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
	 * Altera os atributos de UsuarioDisciplina em sua tabela no BD
	 * @param usuarioDisciplina - Objeto que terá seus atributos alterados
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String alterar(UsuarioDisciplina usuarioDisciplina)
	{
		sql = "update TBUSUARIODISCIPLINA set CODALUNOUSUARIO = ?, CODCURSODISCIPLINA = ? where CODUSUARIODISCIPLINA = ?";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, usuarioDisciplina.getCodAlunoUsuario());
			bd.st.setInt(2, usuarioDisciplina.getCodDisciplina());
			bd.st.setInt(3, usuarioDisciplina.getCodUsuarioDisciplina());
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
	 * Exclui os atributos de UsuarioDisciplina em sua tabela no BD
	 * @param usuarioDisciplina - Objeto que terá seus atributos excluídos
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String excluir(int codud)
	{
		sql = "delete from TBUSUARIODISCIPLINA where CODUSUARIODISCIPLINA = ?";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codud);
			int n = bd.st.executeUpdate();
			if(n == 1)
			{
				men = "UsuarioDisciplina excluída com sucesso!";
			}
			else
			{
				men = "UsuarioDisciplina não encontrada!";
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
	 * Retorna uma lista de UsuarioDisciplina com base em um comando SELECT
	 * @param sql - Comando SELECT desejado para filtrar os atributos
	 * @return - Lista de objetos selecionados
	 */
	public List<UsuarioDisciplina> get(String sql)
	{
		List<UsuarioDisciplina> lista = new ArrayList<UsuarioDisciplina>();
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) //enquanto existirem registros
			{
				UsuarioDisciplina ud = new UsuarioDisciplina();
				ud.setCodUsuarioDisciplina(bd.rs.getInt("CODUSUARIODISCIPLINA"));
				ud.setCodAlunoUsuario(bd.rs.getInt("CODALUNOUSUARIO"));
				ud.setCodDisciplina(bd.rs.getInt("CODCURSODISCIPLINA"));
				lista.add(ud);
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
