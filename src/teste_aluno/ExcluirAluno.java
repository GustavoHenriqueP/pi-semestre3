package teste_aluno;

import javax.swing.JOptionPane;

import apoio.DadosSimulados;
import control.AlunoDAO;

public class ExcluirAluno {

	public static void main(String[] args) {
		
		DadosSimulados d = new DadosSimulados();

		if(d.getCodPerfil() == 2)
		{
			//Apenas de exemplo, estou listando todos os alunos para selecionar qual será excluído
			ListarAluno l = new ListarAluno();
			l.listarA();
			
			AlunoDAO dao = new AlunoDAO();
			int codAlunoUsuario = Integer.parseInt(JOptionPane.showInputDialog("Código do aluno a ser excluído: "));
			if(l.toString() != "[]")
			{
				//Pergunta se gostaria de excluir, já que isso irá excluir dados de outras tabelas em um DELETE CASCADE
				int escolha = Integer.parseInt(JOptionPane.showInputDialog("Você tem certeza que gostaria de excluir a faculdade? Todos os cursos e alunos vinculados também serão excluídos"
						+ "\n1 - Sim"
						+ "\n2 - Não")) ;
				if(escolha == 1)
				{
					System.out.println(dao.excluir(codAlunoUsuario));
				}
			}
			else
			{
				System.out.println("Não encontrado nenhum Aluno com o código fornecido");
			}
		}
		
		else if(d.getCodPerfil() != 2)
		{
			//Aba Aluno fica cinza
			System.out.println("Aba Excluir Aluno não aparece");
		}
	}
}
