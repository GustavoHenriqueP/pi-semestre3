package teste_faculdade;

import javax.swing.JOptionPane;

import apoio.DadosSimulados;
import control.FaculdadeDAO;
import model.Faculdade;

public class InserirFaculdade {

	public static void main(String[] args) {
		
		Faculdade f = null;
		DadosSimulados d = new DadosSimulados();
		int codUsuario = d.getCodPerfil();
		int codFaculdade, numeroFaculdade;
		String nomeFaculdade, enderecoFaculdade, bairroFaculdade, cidadeFaculdade, cepFaculdade;
		
		//Aba de cadastro apenas aparecer� se o usu�rio for mestre (codPerfil == 2)
		if(codUsuario == 2)
		{
			//Pegar o c�digo apenas para teste, ele ser� gerado automaticamente
			codFaculdade = Integer.parseInt(JOptionPane.showInputDialog("COD: "));
			
			nomeFaculdade = JOptionPane.showInputDialog("Nome da Institui��o: ");
			enderecoFaculdade = JOptionPane.showInputDialog("Endere�o: ");
			numeroFaculdade = Integer.parseInt(JOptionPane.showInputDialog("N�mero: "));
			bairroFaculdade = JOptionPane.showInputDialog("Bairro: ");
			cidadeFaculdade = JOptionPane.showInputDialog("Cidade: ");
			cepFaculdade = JOptionPane.showInputDialog("CEP: ");
			f = new Faculdade(codFaculdade,nomeFaculdade,enderecoFaculdade,numeroFaculdade,bairroFaculdade,cidadeFaculdade,cepFaculdade);
			if(f != null)
			{
				FaculdadeDAO dao = new FaculdadeDAO();
				System.out.println(dao.gravar(f));
			}
		}
		else
		{
			//Aba fica cinza
			System.out.println("Aba de cadastro de Institui��o n�o funciona");
		}
	}
}
