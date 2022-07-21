package teste_tarefa;

import java.util.List;

import javax.swing.JOptionPane;

import apoio.DadosSimulados;
import control.TarefaDAO;
import model.Tarefa;

public class EditarTarefa {

	public static void main(String[] args) {
		
		//Listar Tarefa serve apenas para mostrar as atividades e salvar a escolha entre a aba publica ou privada
		ListarTarefa l = new ListarTarefa();
		l.listar();

		//Com a informação se está na aba pública ou privada, de acordo com o código de perfil, é realizada ou não a edição de determinada atividade
		int codAtividade = Integer.parseInt(JOptionPane.showInputDialog("Código da atividade a ser editada: "));

		TarefaDAO dao = new TarefaDAO();
		List<Tarefa> lista = dao.get("select * from TBTAREFA where CODTAREFA = "+codAtividade);

		String nome=null, descricao=null, data=null;
		
		DadosSimulados d = new DadosSimulados();
		if(lista.toString() != "[]" && l.getEscolha() == 0 && (d.getCodPerfil() == 0 || d.getCodPerfil() == 1 || d.getCodPerfil() == 2)) 
		{
			Tarefa t = lista.get(0);
			nome = JOptionPane.showInputDialog("Alterar nome: ");
			descricao = JOptionPane.showInputDialog("Alterar descrição: ");
			data = JOptionPane.showInputDialog("Alterar data: ");
			if(!nome.equals("0"))
				t.setNomeTarefa(nome);
			if(!descricao.equals("0"))
				t.setDescricaoTarefa(descricao);
			if(!data.equals("0"))
				t.setDataEntregaTarefa(data);
			System.out.println(dao.alterar(t));
		}
		else if(lista.toString() != "[]" && l.getEscolha() == 1 && (d.getCodPerfil() == 1 || d.getCodPerfil() == 2))
		{
			Tarefa t = lista.get(0);
			nome = JOptionPane.showInputDialog("Alterar nome: ");
			descricao = JOptionPane.showInputDialog("Alterar descrição: ");
			data = JOptionPane.showInputDialog("Alterar data: ");
			if(!nome.equals("0"))
				t.setNomeTarefa(nome);
			if(!descricao.equals("0"))
				t.setDescricaoTarefa(descricao);
			if(!data.equals("0"))
				t.setDataEntregaTarefa(data);
			System.out.println(dao.alterar(t));
		}
		else if(lista.toString() != "[]" && l.getEscolha() == 1 && d.getCodPerfil() == 0)
		{
			//Botão de excluir fica cinza e não funciona
			System.out.println("Botão não funciona");
		}
		else
		{
			System.out.println("Não encontrado nenhuma atividade com o código fornecido");
		}
	}
}
