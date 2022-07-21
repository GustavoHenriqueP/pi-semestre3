package model;

/**
 * Classe modelo para o objeto Tarefa
 * @author Grupo 1
 */
public class Tarefa {

	private int codTarefa, codCursoDisciplina, statusTarefa, publicaOuPrivada = 0;
	private String nomeTarefa, descricaoTarefa, dataEntregaTarefa;
	
	public Tarefa() {}

	public Tarefa(/*int codTarefa*/int codCursoDisciplina, String nomeTarefa,
			String descricaoTarefa, String dataEntregaTarefa, int statusTarefa, int publicaOuPrivada) {
		///this.codTarefa = codTarefa;
		this.codCursoDisciplina = codCursoDisciplina;
		this.nomeTarefa = nomeTarefa;
		this.descricaoTarefa = descricaoTarefa;
		this.dataEntregaTarefa = dataEntregaTarefa;
		this.statusTarefa = statusTarefa;
		this.publicaOuPrivada = publicaOuPrivada;
	}

	public int getCodTarefa() {
		return codTarefa;
	}

	public void setCodTarefa(int codTarefa) {
		this.codTarefa = codTarefa;
	}

	public int getCodCursoDisciplina() {
		return codCursoDisciplina;
	}

	public void setCodCursoDisciplina(int codCursoDisciplina) {
		this.codCursoDisciplina = codCursoDisciplina;
	}

	public int getStatusTarefa() {
		return statusTarefa;
	}

	public void setStatusTarefa(int statusTarefa) {
		this.statusTarefa = statusTarefa;
	}

	public int getPublicaOuPrivada() {
		return publicaOuPrivada;
	}

	public void setPublicaOuPrivada(int publicaOuPrivada) {
		this.publicaOuPrivada = publicaOuPrivada;
	}

	public String getNomeTarefa() {
		return nomeTarefa;
	}

	public void setNomeTarefa(String nomeTarefa) {
		this.nomeTarefa = nomeTarefa;
	}

	public String getDescricaoTarefa() {
		return descricaoTarefa;
	}

	public void setDescricaoTarefa(String descricaoTarefa) {
		this.descricaoTarefa = descricaoTarefa;
	}

	public String getDataEntregaTarefa() {
		return dataEntregaTarefa;
	}

	public void setDataEntregaTarefa(String dataEntregaTarefa) {
		this.dataEntregaTarefa = dataEntregaTarefa;
	}

	@Override
	public String toString() {
		return "CODTAREFA = " + codTarefa + ", CODCURSODISCIPLINA = " + codCursoDisciplina + ", NOMETAREFA = " + nomeTarefa + ", DESCRICAOTAREFA = " + descricaoTarefa +
				", DATAENTREGATAREFA = " + dataEntregaTarefa + ", STATUSTAREFA = " + statusTarefa + ", PUBLICAOUPRIVADA = " + publicaOuPrivada;
	}
}
