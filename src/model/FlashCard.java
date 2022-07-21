package model;

/**
 * Classe modelo para o objeto FlashCard
 * @author Grupo 1
 */
public class FlashCard {

	private int codFlashCard, codAlunoUsuario, codCursoDisciplina;
	private String nomeFlashCard, perguntaFlashCard, respostaFlashCard;
	
	public FlashCard() {}

	public FlashCard(/*int codFlashCard,*/ int codAlunoUsuario, int codCursoDisciplina, String nomeFlashCard,
			String perguntaFlashCard, String respostaFlashCard) {
		//this.codFlashCard = codFlashCard;
		this.codAlunoUsuario = codAlunoUsuario;
		this.codCursoDisciplina = codCursoDisciplina;
		this.nomeFlashCard = nomeFlashCard;
		this.perguntaFlashCard = perguntaFlashCard;
		this.respostaFlashCard = respostaFlashCard;
	}

	public int getCodFlashCard() {
		return codFlashCard;
	}

	public void setCodFlashCard(int codFlashCard) {
		this.codFlashCard = codFlashCard;
	}

	public int getCodAlunoUsuario() {
		return codAlunoUsuario;
	}

	public void setCodAluno(int codAlunoUsuario) {
		this.codAlunoUsuario = codAlunoUsuario;
	}

	public int getCodCursoDisciplina() {
		return codCursoDisciplina;
	}

	public void setCodCursoDisciplina(int codCursoDisciplina) {
		this.codCursoDisciplina = codCursoDisciplina;
	}

	public String getNomeFlashCard() {
		return nomeFlashCard;
	}

	public void setNomeFlashCard(String nomeFlashCard) {
		this.nomeFlashCard = nomeFlashCard;
	}

	public String getPerguntaFlashCard() {
		return perguntaFlashCard;
	}

	public void setPerguntaFlashCard(String perguntaFlashCard) {
		this.perguntaFlashCard = perguntaFlashCard;
	}

	public String getRespostaFlashCard() {
		return respostaFlashCard;
	}

	public void setRespostaFlashCard(String respostaFlashCard) {
		this.respostaFlashCard = respostaFlashCard;
	}

	@Override
	public String toString() {
		return "CODFLASHCARD = " + codFlashCard + ", CODALUNO = " + codAlunoUsuario + ", CODCURSODISCIPLINA = "
				+ codCursoDisciplina + ", NOMEFLASHCARD = " + nomeFlashCard + ", PERGUNTAFLASHCARD = " + perguntaFlashCard
				+ ", RESPOSTAFLASHCARD = " + respostaFlashCard;
	}
}
