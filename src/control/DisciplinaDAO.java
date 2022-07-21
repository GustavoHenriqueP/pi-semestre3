package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Disciplina;

/**
 * Classe Data Access Object para abstrair e maipular os dados no banco de dados, referente ao objeto Disciplina
 * @author Grupo 1
 */
public class DisciplinaDAO {

	private BD bd;
	private String men, sql;
	
	public DisciplinaDAO() {
		bd = new BD();
	}
	
	/**
	 * Grava os atributos de Disciplina em sua tabela no BD
	 * @param disciplina - Objeto que terá seus atributos salvos
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String gravar(Disciplina disciplina)
	{
		sql = "insert into TBDISCIPLINA values (?,?,?)";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, disciplina.getCodDisciplina());
			bd.st.setString(2, disciplina.getNomeDisciplina());
			bd.st.setInt(3, disciplina.getCargaHoraria());
			bd.st.executeUpdate();
			men = "Disciplina inserida com sucesso!";
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
	 * Altera os atributos de Disciplina em sua tabela no BD
	 * @param disciplina - Objeto que terá seus atributos alterados
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String alterar(Disciplina disciplina)
	{
		sql = "update TBDISCIPLINA set NOMEDISCIPLINA = ?, CARGAHORARIA = ? where CODDISCIPLINA = ?";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, disciplina.getNomeDisciplina());
			bd.st.setInt(2, disciplina.getCargaHoraria());
			bd.st.setInt(3, disciplina.getCodDisciplina());
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
	 * Exclui os atributos de Disciplina em sua tabela no BD
	 * @param disciplina - Objeto que terá seus atributos excluídos
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String excluir(int codd)
	{
		sql = "delete from TBDISCIPLINA where CODDISCIPLINA = ?";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codd);
			int n = bd.st.executeUpdate();
			if(n == 1)
			{
				men = "Disciplina excluída com sucesso!";
			}
			else
			{
				men = "Disciplina não encontrada!";
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
	 * Retorna uma lista de Disciplina com base em um comando SELECT
	 * @param sql - Comando SELECT desejado para filtrar os atributos
	 * @return - Lista de objetos selecionados
	 */
	public List<Disciplina> get(String sql)
	{
		List<Disciplina> lista = new ArrayList<Disciplina>();
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) //enquanto existirem registros
			{
				Disciplina d = new Disciplina();
				d.setCodDisciplina(bd.rs.getInt("CODDISCIPLINA"));
				d.setNomeDisciplina(bd.rs.getString("NOMEDISCIPLINA"));
				d.setCargaHoraria(bd.rs.getInt("CARGAHORARIA"));
				lista.add(d);
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