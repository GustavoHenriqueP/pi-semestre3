package teste_disciplina;

import java.util.List;

import control.DisciplinaDAO;
import model.Disciplina;


public class ListarDisciplina {

	public void listarD() {

		DisciplinaDAO dao = new DisciplinaDAO();
		
		List<Disciplina> lista = dao.get("select * from TBDISCIPLINA");
		for(Disciplina ds: lista)
		{
			System.out.println(ds);
		}
	}
}
