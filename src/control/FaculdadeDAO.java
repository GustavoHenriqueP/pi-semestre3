package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Faculdade;

/**
 * Classe Data Access Object para abstrair e maipular os dados no banco de dados, referente ao objeto Faculdade
 * @author Grupo 1
 */
public class FaculdadeDAO {

	private BD bd;
	private String men, sql;
	
	public FaculdadeDAO() {
		bd = new BD();
	}
	
	/**
	 * Grava os atributos de Faculdade em sua tabela no BD
	 * @param faculdade - Objeto que terá seus atributos salvos
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String gravar(Faculdade faculdade)
	{
		sql = "insert into TBFACULDADE values (?,?,?,?,?,?,?)";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, faculdade.getCodFaculdade());
			bd.st.setString(2, faculdade.getNomeFaculdade());
			bd.st.setString(3, faculdade.getEnderecoFaculdade());
			bd.st.setInt(4, faculdade.getNumeroFaculdade());
			bd.st.setString(5, faculdade.getBairroFaculdade());
			bd.st.setString(6, faculdade.getCidadeFaculdade());
			bd.st.setString(7, faculdade.getCepFaculdade());
			bd.st.executeUpdate();
			men = "Faculdade inserida com sucesso!";
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
	 * Altera os atributos de Faculdade em sua tabela no BD
	 * @param faculdade - Objeto que terá seus atributos alterados
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String alterar(Faculdade faculdade)
	{
		sql = "update TBFACULDADE set NOMEFACULDADE = ?, ENDERECOFACULDADE = ?, NUMEROFACULDADE = ?, BAIRROFACULDADE = ?, CIDADEFACULDADE = ?, CEPFACULDADE = ? where CODFACULDADE = ?";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, faculdade.getNomeFaculdade());
			bd.st.setString(2, faculdade.getEnderecoFaculdade());
			bd.st.setInt(3, faculdade.getNumeroFaculdade());
			bd.st.setString(4, faculdade.getBairroFaculdade());
			bd.st.setString(5, faculdade.getCidadeFaculdade());
			bd.st.setString(6, faculdade.getCepFaculdade());
			bd.st.setInt(7, faculdade.getCodFaculdade());
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
	 * Exclui os atributos de Faculdade em sua tabela no BD
	 * @param faculdade - Objeto que terá seus atributos excluídos
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String excluir(int codf)
	{
		sql = "delete from TBFACULDADE where CODFACULDADE = ?";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codf);
			int n = bd.st.executeUpdate();
			if(n == 1)
			{
				men = "Faculdade excluída com sucesso!";
			}
			else
			{
				men = "Faculdade não encontrada!";
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
	 * Retorna uma lista de Faculdade com base em um comando SELECT
	 * @param sql - Comando SELECT desejado para filtrar os atributos
	 * @return - Lista de objetos selecionados
	 */
	public List<Faculdade> get(String sql)
	{
		List<Faculdade> lista = new ArrayList<Faculdade>();
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) //enquanto existirem registros
			{
				Faculdade f = new Faculdade();
				f.setCodFaculdade(bd.rs.getInt("CODFACULDADE"));
				f.setNomeFaculdade(bd.rs.getString("NOMEFACULDADE"));
				f.setEnderecoFaculdade(bd.rs.getString("ENDERECOFACULDADE"));
				f.setNumeroFaculdade(bd.rs.getInt("NUMEROFACULDADE"));
				f.setBairroFaculdade(bd.rs.getString("BAIRROFACULDADE"));
				f.setCidadeFaculdade(bd.rs.getString("CIDADEFACULDADE"));
				f.setCepFaculdade(bd.rs.getString("CEPFACULDADE"));
				lista.add(f);
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
