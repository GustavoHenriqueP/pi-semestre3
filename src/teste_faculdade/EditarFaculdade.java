package teste_faculdade;

import java.util.List;

import javax.swing.JOptionPane;

import apoio.DadosSimulados;
import control.FaculdadeDAO;
import model.Faculdade;

public class EditarFaculdade {

	public static void main(String[] args) {

		DadosSimulados d = new DadosSimulados();
		int numero=0, codFaculdade;
		String nome=null, endereco=null, bairro=null, cidade=null, cep=null;
		
		if(d.getCodPerfil() == 2)
		{
			//Apenas de exemplo, estou listando todas as faculdades para selecionar qual será alterada
			ListarFaculdade l = new ListarFaculdade();
			l.listarF();
			
			codFaculdade = Integer.parseInt(JOptionPane.showInputDialog("Código da faculdade a ser alterada: "));
			
			FaculdadeDAO dao = new FaculdadeDAO();
			List<Faculdade> lista = dao.get("select * from TBFACULDADE where CODFACULDADE = "+codFaculdade);
			
			if(lista.toString() != "[]")
			{
				Faculdade f = lista.get(0);
				nome = JOptionPane.showInputDialog("Alterar nome: ");
				endereco = JOptionPane.showInputDialog("Alterar endereço: ");
				numero = Integer.parseInt(JOptionPane.showInputDialog("Alterar número: "));
				bairro = JOptionPane.showInputDialog("Alterar bairro: ");
				cidade = JOptionPane.showInputDialog("Alterar cidade: ");
				cep = JOptionPane.showInputDialog("Alterar CEP: ");
				if(!nome.equals("0"))
					f.setNomeFaculdade(nome);
				if(!endereco.equals("0"))
					f.setEnderecoFaculdade(endereco);
				if(numero != 0)
					f.setNumeroFaculdade(numero);
				if(!bairro.equals("0"))
					f.setBairroFaculdade(bairro);
				if(!cidade.equals("0"))
					f.setCidadeFaculdade(cidade);
				if(!cep.equals("0"))
					f.setCepFaculdade(cep);
				System.out.println(dao.alterar(f));
			}
			else
			{
				System.out.println("Não encontrado nenhuma faculdade com o código fornecido");
			}
		}
		else if(d.getCodPerfil() != 2)
		{
			//Aba Faculdade fica cinza
			System.out.println("Aba Faculdade não aparece");
		}
	}
}
