package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AlunoTarefa;

/**
 * Classe Data Access Object para abstrair e maipular os dados no banco de dados, referente ao objeto AlunoTarefa
 * @author Grupo 1
 */
public class AlunoTarefaDAO {

	private BD bd;
	private String men, sql;
	
	public AlunoTarefaDAO() {
		bd = new BD();
	}
	
	/**
	 * Grava os atributos de AlunoTarefa em sua tabela no BD
	 * @param alunoTarefa - Objeto que terá seus atributos salvos
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String gravar(AlunoTarefa alunoTarefa)
	{
		sql = "insert into TBALUNOTAREFA values (?,?,?)";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, alunoTarefa.getCodAlunoUsuario());
			bd.st.setInt(2, alunoTarefa.getCodTarefa());
			bd.st.setInt(3, alunoTarefa.getStatusAlunoTarefa());
			bd.st.executeUpdate();
			men = "AlunoTarefa inserida com sucesso!";
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
	 * Altera os atributos de AlunoTarefa em sua tabela no BD
	 * @param alunoTarefa - Objeto que terá seus atributos alterados
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String alterar(AlunoTarefa alunoTarefa)
	{
		sql = "update TBALUNOTAREFA set CODALUNOUSUARIO = ?, CODTAREFA = ?, STATUSALUNOTAREFA = ? where CODALUNOTAREFA = ?";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, alunoTarefa.getCodAlunoUsuario());
			bd.st.setInt(2, alunoTarefa.getCodTarefa());
			bd.st.setInt(3, alunoTarefa.getStatusAlunoTarefa());
			bd.st.setInt(4, alunoTarefa.getCodAlunoTarefa());
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
	 * Exclui os atributos de AlunoTarefa em sua tabela no BD
	 * @param alunoTarefa - Objeto que terá seus atributos excluídos
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String excluir(int codat)
	{
		sql = "delete from TBALUNOTAREFA where CODALUNOTAREFA = ?";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codat);
			int n = bd.st.executeUpdate();
			if(n == 1)
			{
				men = "AlunoTarefa excluída com sucesso!";
			}
			else
			{
				men = "AlunoTarefa não encontrada!";
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
	 * Retorna uma lista de AlunoTarefa com base em um comando SELECT
	 * @param sql - Comando SELECT desejado para filtrar os atributos
	 * @return - Lista de objetos selecionados
	 */
	public List<AlunoTarefa> get(String sql)
	{
		List<AlunoTarefa> lista = new ArrayList<AlunoTarefa>();
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) //enquanto existirem registros
			{
				AlunoTarefa at = new AlunoTarefa();
				at.setCodAlunoTarefa(bd.rs.getInt("CODALUNOTAREFA"));
				at.setCodAlunoUsuario(bd.rs.getInt("CODALUNOUSUARIO"));
				at.setCodTarefa(bd.rs.getInt("CODTAREFA"));
				at.setStatusAlunoTarefa(bd.rs.getInt("STATUSALUNOTAREFA"));
				lista.add(at);
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
