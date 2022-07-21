package teste_flashcard;

import java.util.List;

import javax.swing.JOptionPane;

import control.FlashCardDAO;
import model.FlashCard;

public class EditarFlashCard {

	public static void main(String[] args) {
		
		String nome, pergunta, resposta;
		
		//Apenas de exemplo, estou listando todos os FlashCards para selecionar qual será alterado
		ListarFlashCard l = new ListarFlashCard();
		l.listarFL();
		
		int codFlashCard = Integer.parseInt(JOptionPane.showInputDialog("Código do Flash Card a ser alterado: "));
		FlashCardDAO dao = new FlashCardDAO();
		List<FlashCard> lista = dao.get("select * from TBFLASHCARD where CODFLASHCARD = "+codFlashCard);
		
		if(lista.toString() != "[]")
		{
			FlashCard fl = lista.get(0);
			nome = JOptionPane.showInputDialog("Nome: ");
			pergunta = JOptionPane.showInputDialog("Pergunta: ");
			resposta = JOptionPane.showInputDialog("Resposta: ");
			if(!nome.equals("0"))
				fl.setNomeFlashCard(nome);
			if(!pergunta.equals("0"))
				fl.setPerguntaFlashCard(pergunta);
			if(!resposta.equals("0"))
				fl.setRespostaFlashCard(resposta);
			System.out.println(dao.alterar(fl));
		}
		else
		{
			System.out.println("Não encontrado nenhum FlashCard com o código fornecido");
		}
	}
}
