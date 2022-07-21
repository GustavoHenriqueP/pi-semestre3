package control;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.FlashCard;

/**
 * Classe Data Access Object para abstrair e maipular os dados no banco de dados, referente ao objeto FlashCard
 * @author Grupo 1
 */
public class FlashCardDAO {

	private BD bd;
	private String men, sql;
	
	public FlashCardDAO() {
		bd = new BD();
	}
	
	/**
	 * Grava os atributos de FlashCard em sua tabela no BD
	 * @param flashCard - Objeto que terá seus atributos salvos
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String gravar(FlashCard flashCard)
	{
		//Melhor escolha para Flash Card é ser Identity
		sql = "insert into TBFLASHCARD values (?,?,?,?,?)";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, flashCard.getCodAlunoUsuario());
			bd.st.setInt(2, flashCard.getCodCursoDisciplina());
			bd.st.setString(3, flashCard.getNomeFlashCard());
			bd.st.setString(4, flashCard.getPerguntaFlashCard());
			bd.st.setString(5, flashCard.getRespostaFlashCard());
			bd.st.executeUpdate();
			men = "FlashCard inserido com sucesso!";
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
	 * Altera os atributos de FlashCard em sua tabela no BD
	 * @param flashCard - Objeto que terá seus atributos alterados
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String alterar(FlashCard flashCard)
	{
		sql = "update TBFLASHCARD set NOMEFLASHCARD = ?, PERGUNTAFLASHCARD = ?, RESPOSTAFLASHCARD = ? where CODFLASHCARD = ?";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setString(1, flashCard.getNomeFlashCard());
			bd.st.setString(2, flashCard.getPerguntaFlashCard());
			bd.st.setString(3, flashCard.getRespostaFlashCard());
			bd.st.setInt(4, flashCard.getCodFlashCard());
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
	 * Exclui os atributos de FlashCard em sua tabela no BD
	 * @param flashCard - Objeto que terá seus atributos excluídos
	 * @return - Uma mensagem informando o sucesso ou falha da operação
	 */
	public String excluir(int codfl)
	{
		sql = "delete from TBFLASHCARD where CODFLASHCARD = ?";
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.st.setInt(1, codfl);
			int n = bd.st.executeUpdate();
			if(n == 1)
			{
				men = "FlashCard excluído com sucesso!";
			}
			else
			{
				men = "FlashCard não encontrado!";
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
	 * Retorna uma lista de FlashCard com base em um comando SELECT
	 * @param sql - Comando SELECT desejado para filtrar os atributos
	 * @return - Lista de objetos selecionados
	 */
	public List<FlashCard> get(String sql)
	{
		List<FlashCard> lista = new ArrayList<FlashCard>();
		bd.getConnection();
		try
		{
			bd.st = bd.con.prepareStatement(sql);
			bd.rs = bd.st.executeQuery();
			while(bd.rs.next()) //enquanto existirem registros
			{
				FlashCard fl = new FlashCard();
				fl.setCodFlashCard(bd.rs.getInt("CODFLASHCARD"));
				fl.setCodAluno(bd.rs.getInt("CODALUNO"));
				fl.setCodCursoDisciplina(bd.rs.getInt("CODCURSODISCIPLINA"));
				fl.setNomeFlashCard(bd.rs.getString("NOMEFLASHCARD"));
				fl.setPerguntaFlashCard(bd.rs.getString("PERGUNTAFLASHCARD"));
				fl.setRespostaFlashCard(bd.rs.getString("RESPOSTAFLASHCARD"));
				lista.add(fl);
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
