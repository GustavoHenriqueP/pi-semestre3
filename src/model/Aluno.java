package model;

/**
 * Classe modelo para o objeto Aluno
 * @author Grupo 1
 */
public class Aluno {

	private int codAlunoUsuario, codCurso, codPerfil;
	private String nomeAluno, cpfAluno, dataNascimentoAluno, emailAluno, loginUsuario, senhaAluno;
	
	public Aluno() {}

	public Aluno(int codAluno, int codCurso, String nomeAluno, String cpfAluno,
			String dataNascimentoAluno, String emailAluno, String loginUsuario, String senhaAluno, int codPerfil) {
		this.codAlunoUsuario = codAluno;
		this.codCurso = codCurso;
		this.nomeAluno = nomeAluno;
		this.cpfAluno = cpfAluno;
		this.dataNascimentoAluno = dataNascimentoAluno;
		this.emailAluno = emailAluno;
		this.loginUsuario = loginUsuario;
		this.senhaAluno = senhaAluno;
		this.codPerfil = codPerfil;
	}

	public int getCodAluno() {
		return codAlunoUsuario;
	}

	public void setCodAluno(int codAluno) {
		this.codAlunoUsuario = codAluno;
	}

	public int getCodCurso() {
		return codCurso;
	}

	public void setCodCurso(int codCurso) {
		this.codCurso = codCurso;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

	public String getCpfAluno() {
		return cpfAluno;
	}

	public void setCpfAluno(String cpfAluno) {
		this.cpfAluno = cpfAluno;
	}

	public String getDataNascimentoAluno() {
		return dataNascimentoAluno;
	}

	public void setDataNascimentoAluno(String dataNascimentoAluno) {
		this.dataNascimentoAluno = dataNascimentoAluno;
	}

	public String getEmailAluno() {
		return emailAluno;
	}

	public void setEmailAluno(String emailAluno) {
		this.emailAluno = emailAluno;
	}

	public int getCodAlunoUsuario() {
		return codAlunoUsuario;
	}

	public void setCodAlunoUsuario(int codAlunoUsuario) {
		this.codAlunoUsuario = codAlunoUsuario;
	}

	public int getCodPerfil() {
		return codPerfil;
	}

	public void setCodPerfil(int codPerfil) {
		this.codPerfil = codPerfil;
	}

	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getSenhaAluno() {
		return senhaAluno;
	}

	public void setSenhaAluno(String senhaAluno) {
		this.senhaAluno = senhaAluno;
	}

	@Override
	public String toString() {
		return "Aluno [codAlunoUsuario=" + codAlunoUsuario + ", codCurso=" + codCurso + ", codPerfil=" + codPerfil
				+ ", nomeAluno=" + nomeAluno + ", cpfAluno=" + cpfAluno + ", dataNascimentoAluno=" + dataNascimentoAluno
				+ ", emailAluno=" + emailAluno + ", loginUsuario=" + loginUsuario + ", senhaAluno=" + senhaAluno + "]";
	}
}
