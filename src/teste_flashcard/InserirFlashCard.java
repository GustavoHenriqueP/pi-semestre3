package teste_flashcard;

import javax.swing.JOptionPane;

import apoio.DadosSimulados;
import control.FlashCardDAO;
import model.FlashCard;

public class InserirFlashCard {

	public static void main(String[] args) {
		
		FlashCard fl = null;
		DadosSimulados d = new DadosSimulados();
		int codAluno = d.getCodAluno();
		int codCurso = d.getCodCursoDisciplina();
		String nomeFlashCard, perguntaFlashCard, respostaFlashCard;
		
		nomeFlashCard = JOptionPane.showInputDialog("Nome do FlashCard: ");
		perguntaFlashCard = JOptionPane.showInputDialog("Pergunta: ");
		respostaFlashCard = JOptionPane.showInputDialog("Resposta: ");

		fl = new FlashCard(codAluno,codCurso,nomeFlashCard,perguntaFlashCard,respostaFlashCard);
		
		FlashCardDAO dao = new FlashCardDAO();
		System.out.println(dao.gravar(fl));
	}
}
