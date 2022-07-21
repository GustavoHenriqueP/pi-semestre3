package teste_curso;

import java.util.List;

import control.CursoDAO;
import model.Curso;

public class ListarCurso {
	
	public void listarC() {

		CursoDAO dao = new CursoDAO();
		
		List<Curso> lista = dao.get("select * from TBCURSO");
		for(Curso c: lista)
		{
			System.out.println(c);
		}
	}
}
