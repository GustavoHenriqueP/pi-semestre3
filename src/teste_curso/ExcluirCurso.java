package teste_curso;

import javax.swing.JOptionPane;

import apoio.DadosSimulados;
import control.CursoDAO;

public class ExcluirCurso {

	public static void main(String[] args) {

		DadosSimulados d = new DadosSimulados();

		if(d.getCodPerfil() == 2)
		{
			//Apenas de exemplo, estou listando todos os cursos para selecionar qual ser� exclu�do
			ListarCurso l = new ListarCurso();
			l.listarC();
			
			CursoDAO dao = new CursoDAO();
			int codCurso = Integer.parseInt(JOptionPane.showInputDialog("C�digo do curso a ser exclu�do: "));
			if(l.toString() != "[]")
			{
				//Pergunta se gostaria de excluir, j� que isso ir� excluir dados de outras tabelas em um DELETE CASCADE
				int escolha = Integer.parseInt(JOptionPane.showInputDialog("Voc� tem certeza que gostaria de excluir o curso? Todos os alunos vinculados tamb�m ser�o exclu�dos"
						+ "\n1 - Sim"
						+ "\n2 - N�o")) ;
				if(escolha == 1)
				{
					System.out.println(dao.excluir(codCurso));
				}
			}
			else
			{
				System.out.println("N�o encontrado nenhum curso com o c�digo fornecido");
			}
		}
		else if(d.getCodPerfil() != 2)
		{
			//Aba Faculdade fica cinza
			System.out.println("Tela de curso n�o aparece");
		}
	}

}
