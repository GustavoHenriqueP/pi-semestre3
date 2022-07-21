package teste_disciplina;

import javax.swing.JOptionPane;

import apoio.DadosSimulados;
import control.DisciplinaDAO;
import model.Disciplina;

public class InserirDisciplina {

	public static void main(String[] args) {
		
		Disciplina ds = null;
		DadosSimulados d = new DadosSimulados();
		int codUsuario = d.getCodPerfil();
		int codDisciplina, cargaHoraria;
		String nomeDisciplina;
		
		//Aba de cadastro apenas aparecerá se o usuário for mestre (codPerfil == 2)
		if(codUsuario == 2)
		{
			//Pegar o código apenas para teste, ele será gerado automaticamente
			codDisciplina = Integer.parseInt(JOptionPane.showInputDialog("COD Disciplina: "));
			
			nomeDisciplina = JOptionPane.showInputDialog("Nome da disciplina: ");
			cargaHoraria = Integer.parseInt(JOptionPane.showInputDialog("Carga horária: "));
			
			ds = new Disciplina(codDisciplina,nomeDisciplina,cargaHoraria);
			if(ds != null)
			{
				DisciplinaDAO dao = new DisciplinaDAO();
				System.out.println(dao.gravar(ds));
			}
		}
		else
		{
			//Aba fica cinza
			System.out.println("Aba de cadastro de Disciplina não funciona");
		}
	}
}
