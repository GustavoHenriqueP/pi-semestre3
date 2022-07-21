package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Tarefa;

/**
 * Classe Data Access Object para abstrair e maipular os dados no banco de dados, referente ao objeto Tarefa
 * @author Grupo 1
 */
public class TarefaDAO {

	private BD bd;
	private String men, sql;
	
	public TarefaDAO() {
		bd = new BD();
	}
	
	/**
	 * Grava os atributos de TarefaDAO em sua tabela no BD
	 * @param tarefa - Objeto que terá seus atributos salvos
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String gravar(Tarefa tarefa)
	{
		//Melhor escolha para Flash Card é ser Identity
		sql = "insert into TBTAREFA values (?,?,?,?,?,?)";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, tarefa.getCodCursoDisciplina());
			bd.st.setString(2, tarefa.getNomeTarefa());
			bd.st.setString(3, tarefa.getDescricaoTarefa());
			bd.st.setString(4, tarefa.getDataEntregaTarefa());
			bd.st.setInt(5, tarefa.getStatusTarefa());
			bd.st.setInt(6, tarefa.getPublicaOuPrivada());
			bd.st.executeUpdate();
			men = "Tarefa inserida com sucesso!";
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
	 * Altera os atributos de TarefaDAO em sua tabela no BD
	 * @param tarefa - Objeto que terá seus atributos alterados
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String alterar(Tarefa tarefa)
	{
		sql = "update TBTAREFA set NOMETAREFA = ?, DESCRICAOTAREFA = ?, DATAENTREGATAREFA = ? where CODTAREFA = ?";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, tarefa.getNomeTarefa());
			bd.st.setString(2, tarefa.getDescricaoTarefa());
			bd.st.setString(3, tarefa.getDataEntregaTarefa());
			bd.st.setInt(4, tarefa.getCodTarefa());
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
	 * Exclui os atributos de TarefaDAO em sua tabela no BD
	 * @param tarefa - Objeto que terá seus atributos excluídos
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String excluir(int codt)
	{
		sql = "delete from TBTAREFA where CODTAREFA = ?";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codt);
			int n = bd.st.executeUpdate();
			if(n == 1)
			{
				men = "Tarefa excluída com sucesso!";
			}
			else
			{
				men = "Tarefa não encontrada!";
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
	 * Retorna uma lista de Tarefa com base em um comando SELECT
	 * @param sql - Comando SELECT desejado para filtrar os atributos
	 * @return - Lista de objetos selecionados
	 */
	public List<Tarefa> get(String sql)
	{
		List<Tarefa> lista = new ArrayList<Tarefa>();
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) //enquanto existirem registros
			{
				Tarefa t = new Tarefa();
				t.setCodTarefa(bd.rs.getInt("CODTAREFA"));
				t.setCodCursoDisciplina(bd.rs.getInt("CODCURSODISCIPLINA"));
				t.setNomeTarefa(bd.rs.getString("NOMETAREFA"));
				t.setDescricaoTarefa(bd.rs.getString("DESCRICAOTAREFA"));
				t.setDataEntregaTarefa(bd.rs.getString("DATAENTREGATAREFA"));
				t.setStatusTarefa(bd.rs.getInt("STATUSTAREFA"));
				t.setPublicaOuPrivada(bd.rs.getInt("PUBLICAOUPRIVADA"));
				lista.add(t);
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
