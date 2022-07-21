package teste_curso;

import javax.swing.JOptionPane;

import apoio.DadosSimulados;
import control.CursoDAO;

public class ExcluirCurso {

	public static void main(String[] args) {

		DadosSimulados d = new DadosSimulados();

		if(d.getCodPerfil() == 2)
		{
			//Apenas de exemplo, estou listando todos os cursos para selecionar qual será excluído
			ListarCurso l = new ListarCurso();
			l.listarC();
			
			CursoDAO dao = new CursoDAO();
			int codCurso = Integer.parseInt(JOptionPane.showInputDialog("Código do curso a ser excluído: "));
			if(l.toString() != "[]")
			{
				//Pergunta se gostaria de excluir, já que isso irá excluir dados de outras tabelas em um DELETE CASCADE
				int escolha = Integer.parseInt(JOptionPane.showInputDialog("Você tem certeza que gostaria de excluir o curso? Todos os alunos vinculados também serão excluídos"
						+ "\n1 - Sim"
						+ "\n2 - Não")) ;
				if(escolha == 1)
				{
					System.out.println(dao.excluir(codCurso));
				}
			}
			else
			{
				System.out.println("Não encontrado nenhum curso com o código fornecido");
			}
		}
		else if(d.getCodPerfil() != 2)
		{
			//Aba Faculdade fica cinza
			System.out.println("Tela de curso não aparece");
		}
	}

}
