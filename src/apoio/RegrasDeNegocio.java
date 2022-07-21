package apoio;

import java.util.List;

import javax.swing.JOptionPane;

import control.DisciplinaDAO;
import control.FaculdadeDAO;
import model.Disciplina;
import model.Faculdade;

/**
 * Armazena os m�todos que testar�o a conformidade das regras de n�gocio do projeto
 * @author Grupo 1
 */
public class RegrasDeNegocio {

	private final int MAXCHSEMANAL = 20;
	
	/**
	 * Testa a conformidade da RN01, que n�o permite o aluno se cadastrar em mais mat�rias do que cursa no semestre
	 * @param codUsuario - Recebe o c�digo do usu�rio que est� alocando as disciplinas no semestre
	 * @return - Retorna se o teste detectou alguma incorformidade (false para se n�o, true para se sim)
	 */
	public boolean testeCargaHoraria(int codUsuario)
	{
		boolean teste = false;
		int soma=0;
		
		DisciplinaDAO dao = new DisciplinaDAO();
		List<Disciplina> lista = dao.get("select CARGAHORARIA from TBDISCIPLINA join TBUSUARIO on (TBDISCIPLINA.CODDISCIPLINA = TBUSUARIO.CODDISCIPLINA)"
				+ "where CODUSUARIO = "+codUsuario);
		for(Disciplina ds: lista)
		{
			soma = soma + ds.getCargaHoraria();
		}
		if(soma > MAXCHSEMANAL)
		{
			JOptionPane.showMessageDialog(null, "Por favor selecione um n�mero m�ximo de disciplinas permitidas por semestre! (Carga hor�ria menor que 20)");
			teste = true;
		}
		else
		{
			teste = false;
		}
		
		return teste;
	}
	
	/**
	 * Testa a conformidade da RN02, que n�o permite o aluno se cadastrar em mais de um curso na mesma institui��o
	 * @param cpfAluno - Recebe o CPF do aluno que est� sendo cadastrado
	 * @param faculdade - Recebe a faculdade que ser� vinculada ao aluno
	 * @return - Retorna se o teste detectou alguma incorformidade (false para se n�o, true para se sim)
	 */
	public boolean testeCurso(String cpfAluno, int curso)
	{
		boolean teste = false;
		
		FaculdadeDAO dao = new FaculdadeDAO();
		List<Faculdade> lista1 = dao.get("select TBFACULDADE.CODFACULDADE, NOMEFACULDADE, ENDERECOFACULDADE, "
				+ "NUMEROFACULDADE, BAIRROFACULDADE, CIDADEFACULDADE, CEPFACULDADE from TBFACULDADE "
				+ "join TBCURSO on (TBFACULDADE.CODFACULDADE = TBCURSO.CODFACULDADE)"
				+ "where TBCURSO.CODCURSO = "+curso);

		List<Faculdade> lista2 = dao.get("select TBFACULDADE.CODFACULDADE, NOMEFACULDADE, ENDERECOFACULDADE, "
				+ "NUMEROFACULDADE, BAIRROFACULDADE, CIDADEFACULDADE, CEPFACULDADE from TBFACULDADE "
				+ "join TBCURSO on (TBFACULDADE.CODFACULDADE = TBCURSO.CODFACULDADE)"
				+ "join TBALUNOUSUARIO on (TBCURSO.CODCURSO = TBALUNOUSUARIO.CODCURSO)"
				+ "where CPFALUNO = "+"'"+cpfAluno+"'");
		
		if(lista1 != null && lista2 != null)
		{
			Faculdade f1 = lista1.get(0);
			String faculdade = f1.getNomeFaculdade();
			Faculdade f2 = lista2.get(0);
			if(f2.getNomeFaculdade().equals(faculdade))
			{
				teste = true;
			}
		}
		else
		{
			teste = false;
		}
		
		return teste;
	}
}
