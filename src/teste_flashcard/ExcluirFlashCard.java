package teste_flashcard;

import javax.swing.JOptionPane;

import control.FlashCardDAO;

public class ExcluirFlashCard {

	public static void main(String[] args) {
		
		//Apenas de exemplo, estou listando todos os FlashCards para selecionar qual ser� exclu�do
		ListarFlashCard l = new ListarFlashCard();
		l.listarFL();
		
		FlashCardDAO dao = new FlashCardDAO();
		int codFlashCard = Integer.parseInt(JOptionPane.showInputDialog("C�digo do Flash Card a ser exclu�do: "));
		if(l.toString() != "[]")
		{
				System.out.println(dao.excluir(codFlashCard));
		}
		else
		{
			System.out.println("N�o encontrada nenhum FlashCard");
		}
	}
}
