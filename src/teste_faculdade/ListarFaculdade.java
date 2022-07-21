package teste_faculdade;

import java.util.List;

import control.FaculdadeDAO;
import model.Faculdade;

public class ListarFaculdade {
	
	public void listarF() {

		FaculdadeDAO dao = new FaculdadeDAO();
		
		List<Faculdade> lista = dao.get("select * from TBFACULDADE");
		for(Faculdade f: lista)
		{
			System.out.println(f);
		}
	}
}
