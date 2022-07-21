package teste_disciplina;

import java.util.List;

import javax.swing.JOptionPane;

import apoio.DadosSimulados;
import control.DisciplinaDAO;
import model.Disciplina;

public class EditarDisciplina {

	public static void main(String[] args) {
		
		DadosSimulados d = new DadosSimulados();
		int codDisciplina, cargaHoraria;
		String nome=null;
		
		if(d.getCodPerfil() == 2)
		{
			//Apenas de exemplo, estou listando todas as disciplinas para selecionar qual ser� alterada
			ListarDisciplina l = new ListarDisciplina();
			l.listarD();
			codDisciplina = Integer.parseInt(JOptionPane.showInputDialog("C�digo da disciplina a ser alterada: "));
			
			DisciplinaDAO dao = new DisciplinaDAO();
			List<Disciplina> lista = dao.get("select * from TBDISCIPLINA where CODDISCIPLINA = "+codDisciplina);
			
			if(lista.toString() != "[]")
			{
				Disciplina ds = lista.get(0);
				nome = JOptionPane.showInputDialog("Alterar nome: ");
				cargaHoraria = Integer.parseInt(JOptionPane.showInputDialog("Carga hor�ria: "));
				if(!nome.equals("0"))
					ds.setNomeDisciplina(nome);
				if(cargaHoraria != 0)
					ds.setCargaHoraria(cargaHoraria);
				System.out.println(dao.alterar(ds));
			}
			else
			{
				System.out.println("N�o encontrado nenhuma disciplina com o c�digo fornecido");
			}
		}
		else if(d.getCodPerfil() != 2)
		{
			//Aba Disciplina fica cinza
			System.out.println("Tela disciplina n�o aparece");
		}
	}

}
