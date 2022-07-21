package model;

/**
 * Classe modelo para o objeto CursoDisciplina
 * @author Grupo 1
 */
public class CursoDisciplina {

	private int codCursoDisciplina, codCurso, codDisciplina;
	
	public CursoDisciplina() {}

	public CursoDisciplina(int codCursoDisciplina, int codCurso, int codDisciplina) {
		this.codCursoDisciplina = codCursoDisciplina;
		this.codCurso = codCurso;
		this.codDisciplina = codDisciplina;
	}

	public int getCodCursoDisciplina() {
		return codCursoDisciplina;
	}

	public void setCodCursoDisciplina(int codCursoDisciplina) {
		this.codCursoDisciplina = codCursoDisciplina;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public int getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(int codDisciplina) {
		this.codDisciplina = codDisciplina;
	}
}
