package teste_disciplina;

import javax.swing.JOptionPane;

import apoio.DadosSimulados;
import control.DisciplinaDAO;

public class ExcluirDisciplina {

	public static void main(String[] args) {
		
		DadosSimulados d = new DadosSimulados();

		if(d.getCodPerfil() == 2)
		{
			//Apenas de exemplo, estou listando todas as disciplinas para selecionar qual será excluída
			ListarDisciplina l = new ListarDisciplina();
			l.listarD();
			
			DisciplinaDAO dao = new DisciplinaDAO();
			int codDisciplina = Integer.parseInt(JOptionPane.showInputDialog("Código da disciplina a ser excluída: "));
			if(l.toString() != "[]")
			{
					System.out.println(dao.excluir(codDisciplina));
			}
			else
			{
				System.out.println("Não encontrada nenhuma disciplina");
			}
		}
		else if(d.getCodPerfil() != 2)
		{
			//Aba Disciplina fica cinza
			System.out.println("Tela de disciplina não aparece");
		}
	}

}
