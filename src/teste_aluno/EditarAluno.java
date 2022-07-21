package teste_aluno;

import java.util.List;

import javax.swing.JOptionPane;

import apoio.DadosSimulados;
import control.AlunoDAO;
import model.Aluno;

public class EditarAluno {

	public static void main(String[] args) {
		
		DadosSimulados d = new DadosSimulados();
		int codAlunoUsuario, codCurso, codPerfil;
		String nomeAluno, cpfAluno, dataNascimentoAluno, emailAluno, loginUsuario, senhaUsuario;
		
		if(d.getCodPerfil() == 2)
		{
			//Apenas de exemplo, estou listando todos os alunos para selecionar qual será alterado
			ListarAluno l = new ListarAluno();
			l.listarA();
			
			codAlunoUsuario = Integer.parseInt(JOptionPane.showInputDialog("Código do aluno / usuário a ser alterado: "));
			
			AlunoDAO dao = new AlunoDAO();
			List<Aluno> lista = dao.get("select * from TBALUNOUSUARIO where CODALUNOUSUARIO = "+codAlunoUsuario);
			
			if(lista.toString() != "[]")
			{
				Aluno a = lista.get(0);
				codCurso = Integer.parseInt(JOptionPane.showInputDialog("Alterar Curso: "));
				nomeAluno = JOptionPane.showInputDialog("Alterar Nome: ");
				cpfAluno = JOptionPane.showInputDialog("Alterar CPF: ");
				dataNascimentoAluno = JOptionPane.showInputDialog("Alterar Data de Nascimento: ");
				emailAluno = JOptionPane.showInputDialog("Alterar E-mail: ");
				loginUsuario = JOptionPane.showInputDialog("Alterar Login: ");
				senhaUsuario = JOptionPane.showInputDialog("Alterar Senha: ");
				codPerfil = Integer.parseInt(JOptionPane.showInputDialog("Alterar Perfil: "));
				if(codCurso != 0)
					a.setCodCurso(codCurso);
				if(!nomeAluno.equals("0"))
					a.setNomeAluno(nomeAluno);
				if(!cpfAluno.equals("0"))
					a.setCpfAluno(cpfAluno);
				if(!dataNascimentoAluno.equals("0"))
					a.setDataNascimentoAluno(dataNascimentoAluno);
				if(!emailAluno.equals("0"))
					a.setEmailAluno(emailAluno);
				if(!loginUsuario.equals("0"))
					a.setLoginUsuario(loginUsuario);
				if(!senhaUsuario.equals("0"))
					a.setSenhaAluno(senhaUsuario);
				if(codPerfil != 0)
					a.setCodPerfil(codPerfil);
				System.out.println(dao.alterar(a));
			}
			else
			{
				System.out.println("Não encontrado nenhum aluno com o código fornecido");
			}
		}
		else if(d.getCodPerfil() != 2)
		{
			//Aba Aluno fica cinza
			System.out.println("Aba Editar Aluno não aparece");
		}
	}
}
