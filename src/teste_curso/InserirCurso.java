package teste_curso;

import javax.swing.JOptionPane;

import apoio.DadosSimulados;
import control.CursoDAO;
import model.Curso;
import teste_faculdade.ListarFaculdade;

public class InserirCurso {

	public static void main(String[] args) {
		
		Curso c = null;
		DadosSimulados d = new DadosSimulados();
		int codUsuario = d.getCodPerfil();
		int codCurso, codFaculdade;
		String nomeCurso;
		
		//Aba de cadastro apenas aparecerá se o usuário for mestre (codPerfil == 2)
		if(codUsuario == 2)
		{
			//Pegar o código apenas para teste, ele será gerado automaticamente
			codCurso = Integer.parseInt(JOptionPane.showInputDialog("COD Curso: "));
			
			nomeCurso = JOptionPane.showInputDialog("Nome do curso: ");
			
			//Listar as faculdades cadastradas apenas como exemplo
			ListarFaculdade l = new ListarFaculdade();
			l.listarF();
			codFaculdade = Integer.parseInt(JOptionPane.showInputDialog("COD Faculdade: "));
			
			c = new Curso(codCurso,nomeCurso,codFaculdade);
			if(c != null)
			{
				CursoDAO dao = new CursoDAO();
				System.out.println(dao.gravar(c));
			}
		}
		else
		{
			//Aba fica cinza
			System.out.println("Aba de cadastro de Curso não funciona");
		}
	}
}
