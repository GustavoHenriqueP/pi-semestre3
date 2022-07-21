package teste_flashcard;

import javax.swing.JOptionPane;

import control.FlashCardDAO;

public class ExcluirFlashCard {

	public static void main(String[] args) {
		
		//Apenas de exemplo, estou listando todos os FlashCards para selecionar qual será excluído
		ListarFlashCard l = new ListarFlashCard();
		l.listarFL();
		
		FlashCardDAO dao = new FlashCardDAO();
		int codFlashCard = Integer.parseInt(JOptionPane.showInputDialog("Código do Flash Card a ser excluído: "));
		if(l.toString() != "[]")
		{
				System.out.println(dao.excluir(codFlashCard));
		}
		else
		{
			System.out.println("Não encontrada nenhum FlashCard");
		}
	}
}
