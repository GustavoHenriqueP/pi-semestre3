package teste_aluno;

import java.util.List;

import control.AlunoDAO;
import model.Aluno;

public class ListarAluno {

	public void listarA()
	{
		AlunoDAO dao = new AlunoDAO();
		
		List<Aluno> lista = dao.get("select * from TBALUNOUSUARIO");
		for(Aluno a: lista)
		{
			System.out.println(a);
		}
	}
}
