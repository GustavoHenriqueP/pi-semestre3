package model;

/**
 * Classe modelo para o objeto AlunoTarefa
 * @author Grupo 1
 */
public class AlunoTarefa {

	private int codAlunoTarefa, codAlunoUsuario, codTarefa, statusAlunoTarefa;
	
	public AlunoTarefa() {}

	public AlunoTarefa(int codAlunoTarefa, int codAlunoUsuario, int codTarefa, int statusAlunoTarefa) {
		this.codAlunoTarefa = codAlunoTarefa;
		this.codAlunoUsuario = codAlunoUsuario;
		this.codTarefa = codTarefa;
		this.statusAlunoTarefa = statusAlunoTarefa;
	}

	public int getCodAlunoTarefa() {
		return codAlunoTarefa;
	}

	public void setCodAlunoTarefa(int codAlunoTarefa) {
		this.codAlunoTarefa = codAlunoTarefa;
	}

	public int getCodAlunoUsuario() {
		return codAlunoUsuario;
	}

	public void setCodAlunoUsuario(int codAlunoUsuario) {
		this.codAlunoUsuario = codAlunoUsuario;
	}

	public int getCodTarefa() {
		return codTarefa;
	}

	public void setCodTarefa(int codTarefa) {
		this.codTarefa = codTarefa;
	}

	public int getStatusAlunoTarefa() {
		return statusAlunoTarefa;
	}

	public void setStatusAlunoTarefa(int statusAlunoTarefa) {
		this.statusAlunoTarefa = statusAlunoTarefa;
	}
}
