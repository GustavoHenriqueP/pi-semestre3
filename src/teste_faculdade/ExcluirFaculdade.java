package teste_faculdade;

import javax.swing.JOptionPane;

import apoio.DadosSimulados;
import control.FaculdadeDAO;

public class ExcluirFaculdade {

	public static void main(String[] args) {
		
		DadosSimulados d = new DadosSimulados();

		if(d.getCodPerfil() == 2)
		{
			//Apenas de exemplo, estou listando todas as faculdades para selecionar qual ser� exclu�da
			ListarFaculdade l = new ListarFaculdade();
			l.listarF();
			
			FaculdadeDAO dao = new FaculdadeDAO();
			int codFaculdade = Integer.parseInt(JOptionPane.showInputDialog("C�digo da faculdade a ser exclu�da: "));
			if(l.toString() != "[]")
			{
				//Pergunta se gostaria de excluir, j� que isso ir� excluir dados de outras tabelas em um DELETE CASCADE
				int escolha = Integer.parseInt(JOptionPane.showInputDialog("Voc� tem certeza que gostaria de excluir a faculdade? Todos os cursos e alunos vinculados tamb�m ser�o exclu�dos"
						+ "\n1 - Sim"
						+ "\n2 - N�o")) ;
				if(escolha == 1)
				{
					System.out.println(dao.excluir(codFaculdade));
				}
			}
			else
			{
				System.out.println("N�o encontrado nenhuma faculdade com o c�digo fornecido");
			}
		}
		
		else if(d.getCodPerfil() != 2)
		{
			//Aba Faculdade fica cinza
			System.out.println("Aba Faculdade n�o aparece");
		}
	}
}
