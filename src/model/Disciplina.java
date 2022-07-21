package model;

/**
 * Classe modelo para o objeto Disciplina
 * @author Grupo 1
 */
public class Disciplina {

	private int codDisciplina, cargaHoraria;
	private String nomeDisciplina;
	
	public Disciplina() {}

	public Disciplina(int codDisciplina, String nomeDisciplina, int cargaHoraria) {
		this.codDisciplina = codDisciplina;
		this.nomeDisciplina = nomeDisciplina;
		this.cargaHoraria = cargaHoraria;
	}

	public int getCodDisciplina() {
		return codDisciplina;
	}

	public void setCodDisciplina(int codDisciplina) {
		this.codDisciplina = codDisciplina;
	}

	public int getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(int cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	@Override
	public String toString() {
		return "CODDISCIPLINA = " + codDisciplina + ", NOMEDISCIPLINA = " + nomeDisciplina + ", CARGAHORARIA = " + cargaHoraria;
	}
}
