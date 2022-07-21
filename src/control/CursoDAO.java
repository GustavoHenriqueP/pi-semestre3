package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Curso;

/**
 * Classe Data Access Object para abstrair e maipular os dados no banco de dados, referente ao objeto CursoDAO
 * @author Grupo 1
 */
public class CursoDAO {

	private BD bd;
	private String men, sql;
	
	public CursoDAO() {
		bd = new BD();
	}
	
	/**
	 * Grava os atributos de CursoDAO em sua tabela no BD
	 * @param curso - Objeto que terá seus atributos salvos
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String gravar(Curso curso)
	{
		sql = "insert into TBCURSO values (?,?,?)";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, curso.getCodCurso());
			bd.st.setString(2, curso.getNomeCurso());
			bd.st.setInt(3, curso.getCodFaculdade());
			bd.st.executeUpdate();
			men = "Curso inserido com sucesso!";
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
	 * Altera os atributos de CursoDAO em sua tabela no BD
	 * @param curso - Objeto que terá seus atributos alterados
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String alterar(Curso curso)
	{
		sql = "update TBCURSO set NOMECURSO = ?, CODFACULDADE = ? where CODCURSO = ?";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, curso.getNomeCurso());
			bd.st.setInt(2, curso.getCodFaculdade());
			bd.st.setInt(3, curso.getCodCurso());
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
	 * Exclui os atributos de CursoDAO em sua tabela no BD
	 * @param curso - Objeto que terá seus atributos excluídos
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String excluir(int codc)
	{
		sql = "delete from TBCURSO where CODCURSO = ?";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codc);
			int n = bd.st.executeUpdate();
			if(n == 1)
			{
				men = "Curso excluído com sucesso!";
			}
			else
			{
				men = "Curso não encontrado!";
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
	 * Retorna uma lista de Curso com base em um comando SELECT
	 * @param sql - Comando SELECT desejado para filtrar os atributos
	 * @return - Lista de objetos selecionados
	 */
	public List<Curso> get(String sql)
	{
		List<Curso> lista = new ArrayList<Curso>();
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) //enquanto existirem registros
			{
				Curso c = new Curso();
				c.setCodCurso(bd.rs.getInt("CODCURSO"));
				c.setNomeCurso(bd.rs.getString("NOMECURSO"));
				c.setCodFaculdade(bd.rs.getInt("CODFACULDADE"));
				lista.add(c);
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
