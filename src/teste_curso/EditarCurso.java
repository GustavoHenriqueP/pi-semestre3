package teste_curso;

import java.util.List;

import javax.swing.JOptionPane;

import apoio.DadosSimulados;
import control.CursoDAO;
import model.Curso;
import teste_faculdade.ListarFaculdade;

public class EditarCurso {

	public static void main(String[] args) {
		
		DadosSimulados d = new DadosSimulados();
		int codCurso, faculdade;
		String nome=null;
		
		if(d.getCodPerfil() == 2)
		{
			//Apenas de exemplo, estou listando todos os cursos para selecionar qual será alterado
			ListarCurso l = new ListarCurso();
			l.listarC();
			
			codCurso = Integer.parseInt(JOptionPane.showInputDialog("Código do curso a ser alterado: "));
			
			CursoDAO dao = new CursoDAO();
			List<Curso> lista = dao.get("select * from TBCURSO where CODCURSO = "+codCurso);
			
			if(lista.toString() != "[]")
			{
				Curso c = lista.get(0);
				nome = JOptionPane.showInputDialog("Alterar nome: ");
				
				//Listar as faculdades cadastradas apenas como exemplo
				ListarFaculdade lf = new ListarFaculdade();
				lf.listarF();
				faculdade = Integer.parseInt(JOptionPane.showInputDialog("Alterar faculdade: "));
				
				if(!nome.equals("0"))
					c.setNomeCurso(nome);
				if(faculdade != 0)
					c.setCodFaculdade(faculdade);
				System.out.println(dao.alterar(c));
			}
			else
			{
				System.out.println("Não encontrado nenhum curso com o código fornecido");
			}
		}
		else if(d.getCodPerfil() != 2)
		{
			//Aba Curso fica cinza
			System.out.println("Tela curso não aparece");
		}
	}

}
