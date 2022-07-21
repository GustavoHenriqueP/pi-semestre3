package model;

/**
 * Classe modelo para o objeto Curso
 * @author Grupo 1
 */
public class Curso {

	private int codCurso, codFaculdade;
	private String nomeCurso;
	
	public Curso() {}

	public Curso(int codCurso, String nomeCurso, int codFaculdade) {
		this.codCurso = codCurso;
		this.nomeCurso = nomeCurso;
		this.codFaculdade = codFaculdade;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public int getCodFaculdade() {
		return codFaculdade;
	}

	public void setCodFaculdade(int codFaculdade) {
		this.codFaculdade = codFaculdade;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public void setNomeCurso(String nomeCurso) {
		this.nomeCurso = nomeCurso;
	}

	@Override
	public String toString() {
		return "CODCURSO = " + codCurso + ", nomeCurso=" + nomeCurso + ", codFaculdade=" + codFaculdade;
	}
}
