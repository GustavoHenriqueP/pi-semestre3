package teste_aluno;

import javax.swing.JOptionPane;

import apoio.DadosSimulados;
import control.AlunoDAO;

public class ExcluirAluno {

	public static void main(String[] args) {
		
		DadosSimulados d = new DadosSimulados();

		if(d.getCodPerfil() == 2)
		{
			//Apenas de exemplo, estou listando todos os alunos para selecionar qual ser� exclu�do
			ListarAluno l = new ListarAluno();
			l.listarA();
			
			AlunoDAO dao = new AlunoDAO();
			int codAlunoUsuario = Integer.parseInt(JOptionPane.showInputDialog("C�digo do aluno a ser exclu�do: "));
			if(l.toString() != "[]")
			{
				//Pergunta se gostaria de excluir, j� que isso ir� excluir dados de outras tabelas em um DELETE CASCADE
				int escolha = Integer.parseInt(JOptionPane.showInputDialog("Voc� tem certeza que gostaria de excluir a faculdade? Todos os cursos e alunos vinculados tamb�m ser�o exclu�dos"
						+ "\n1 - Sim"
						+ "\n2 - N�o")) ;
				if(escolha == 1)
				{
					System.out.println(dao.excluir(codAlunoUsuario));
				}
			}
			else
			{
				System.out.println("N�o encontrado nenhum Aluno com o c�digo fornecido");
			}
		}
		
		else if(d.getCodPerfil() != 2)
		{
			//Aba Aluno fica cinza
			System.out.println("Aba Excluir Aluno n�o aparece");
		}
	}
}
