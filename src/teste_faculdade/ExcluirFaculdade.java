package teste_faculdade;

import javax.swing.JOptionPane;

import apoio.DadosSimulados;
import control.FaculdadeDAO;

public class ExcluirFaculdade {

	public static void main(String[] args) {
		
		DadosSimulados d = new DadosSimulados();

		if(d.getCodPerfil() == 2)
		{
			//Apenas de exemplo, estou listando todas as faculdades para selecionar qual será excluída
			ListarFaculdade l = new ListarFaculdade();
			l.listarF();
			
			FaculdadeDAO dao = new FaculdadeDAO();
			int codFaculdade = Integer.parseInt(JOptionPane.showInputDialog("Código da faculdade a ser excluída: "));
			if(l.toString() != "[]")
			{
				//Pergunta se gostaria de excluir, já que isso irá excluir dados de outras tabelas em um DELETE CASCADE
				int escolha = Integer.parseInt(JOptionPane.showInputDialog("Você tem certeza que gostaria de excluir a faculdade? Todos os cursos e alunos vinculados também serão excluídos"
						+ "\n1 - Sim"
						+ "\n2 - Não")) ;
				if(escolha == 1)
				{
					System.out.println(dao.excluir(codFaculdade));
				}
			}
			else
			{
				System.out.println("Não encontrado nenhuma faculdade com o código fornecido");
			}
		}
		
		else if(d.getCodPerfil() != 2)
		{
			//Aba Faculdade fica cinza
			System.out.println("Aba Faculdade não aparece");
		}
	}
}
