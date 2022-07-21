package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.CursoDisciplina;

/**
 * Classe Data Access Object para abstrair e maipular os dados no banco de dados, referente ao objeto CursoDisciplina
 * @author Grupo 1
 */
public class CursoDisciplinaDAO {

	private BD bd;
	private String men, sql;
	
	public CursoDisciplinaDAO() {
		bd = new BD();
	}
	
	/**
	 * Grava os atributos de CursoDisciplina em sua tabela no BD
	 * @param cursoDisciplina - Objeto que terá seus atributos salvos
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String gravar(CursoDisciplina cursoDisciplina)
	{
		sql = "insert into TBCURSODISCIPLINA values (?,?)";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, cursoDisciplina.getCodCurso());
			bd.st.setInt(2, cursoDisciplina.getCodDisciplina());
			bd.st.executeUpdate();
			men = "CursoDisciplina inserida com sucesso!";
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
	 * Altera os atributos de CursoDisciplina em sua tabela no BD
	 * @param cursoDisciplina - Objeto que terá seus atributos alterados
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String alterar(CursoDisciplina cursoDisciplina)
	{
		sql = "update TBCURSODISCIPLINA set CODCURSO = ?, CODDISCIPLINA = ? where CODCURSODISCIPLINA = ?";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, cursoDisciplina.getCodCurso());
			bd.st.setInt(2, cursoDisciplina.getCodDisciplina());
			bd.st.setInt(3, cursoDisciplina.getCodCursoDisciplina());
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
	 * Exclui os atributos de CursoDisciplina em sua tabela no BD
	 * @param cursoDisciplina - Objeto que terá seus atributos excluídos
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String excluir(int codcd)
	{
		sql = "delete from TBCURSODISCIPLINA where CODCURSODISCIPLINA = ?";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codcd);
			int n = bd.st.executeUpdate();
			if(n == 1)
			{
				men = "CursoDisciplina excluída com sucesso!";
			}
			else
			{
				men = "CursoDisciplina não encontrada!";
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
	 * Retorna uma lista de CursoDisciplina com base em um comando SELECT
	 * @param sql - Comando SELECT desejado para filtrar os atributos
	 * @return - Lista de objetos selecionados
	 */
	public List<CursoDisciplina> get(String sql)
	{
		List<CursoDisciplina> lista = new ArrayList<CursoDisciplina>();
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) //enquanto existirem registros
			{
				CursoDisciplina cd = new CursoDisciplina();
				cd.setCodCursoDisciplina(bd.rs.getInt("CODCURSODISCIPLINA"));
				cd.setCodCurso(bd.rs.getInt("CODCURSO"));
				cd.setCodDisciplina(bd.rs.getInt("CODDISCIPLINA"));
				lista.add(cd);
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
