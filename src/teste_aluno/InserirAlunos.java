package teste_aluno;

import javax.swing.JOptionPane;

import control.AlunoDAO;
import model.Aluno;

public class InserirAlunos {

	public static void main(String[] args) {
		
		int codAlunoUsuario, codCurso;
		String nomeAluno, cpfAluno, dataNascimentoAluno, emailAluno, loginUsuario, senhaUsuario;
		
		//Será gerado automaticamente mas estou dando de exemplo
		codAlunoUsuario = Integer.parseInt(JOptionPane.showInputDialog("COD: "));
		
		codCurso = Integer.parseInt(JOptionPane.showInputDialog("Curso: "));
		nomeAluno = JOptionPane.showInputDialog("Nome: ");
		cpfAluno = JOptionPane.showInputDialog("CPF: ");
		dataNascimentoAluno = JOptionPane.showInputDialog("Data de Nascimento: ");
		emailAluno = JOptionPane.showInputDialog("E-mail: ");
		loginUsuario = JOptionPane.showInputDialog("Login: ");
		senhaUsuario = JOptionPane.showInputDialog("Senha: ");
		
		Aluno a = new Aluno(codAlunoUsuario,codCurso,nomeAluno,cpfAluno,dataNascimentoAluno,emailAluno,loginUsuario,senhaUsuario,0);
		
		AlunoDAO dao = new AlunoDAO();
		System.out.println(dao.gravar(a));
	}
}
