package model;

/**
 * Classe modelo para o objeto UsuarioDisciplina
 * @author Grupo 1
 */
public class UsuarioDisciplina {

	private int codUsuarioDisciplina, codAlunoUsuario, codDisciplina;
	
	public UsuarioDisciplina() {}

	public UsuarioDisciplina(int codUsuarioDisciplina, int codAlunoUsuario, int codDisciplina) {
		this.codUsuarioDisciplina = codUsuarioDisciplina;
		this.codAlunoUsuario = codAlunoUsuario;
		this.codDisciplina = codDisciplina;
	}

	public int getCodUsuarioDisciplina() {
		return codUsuarioDisciplina;
	}

	public void setCodUsuarioDisciplina(int codUsuarioDisciplina) {
		this.codUsuarioDisciplina = codUsuarioDisciplina;
	}

	public int getCodAlunoUsuario() {
		return codAlunoUsuario;
	}

	public void setCodAlunoUsuario(int codAlunoUsuario) {
		this.codAlunoUsuario = codAlunoUsuario;
	}

	public int getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(int codDisciplina) {
		this.codDisciplina = codDisciplina;
	}
}
