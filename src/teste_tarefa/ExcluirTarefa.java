package teste_tarefa;

import java.util.List;

import javax.swing.JOptionPane;

import apoio.DadosSimulados;
import control.TarefaDAO;
import model.Tarefa;

public class ExcluirTarefa {

	public static void main(String[] args) {
		
		//Listar Tarefa serve apenas para mostrar as atividades e salvar a escolha entre a aba publica ou privada
		ListarTarefa l = new ListarTarefa();
		l.listar();
		
		//Com a informa��o se est� na aba p�blica ou privada, de acordo com o c�digo de perfil, � realizada ou n�o a exclus�o de determinada atividade
		int codAtividade = Integer.parseInt(JOptionPane.showInputDialog("C�digo da atividade a ser exclu�da: "));
		
		TarefaDAO dao = new TarefaDAO();
		List<Tarefa> lista = dao.get("select * from TBTAREFA where CODTAREFA = "+codAtividade);
		
		DadosSimulados d = new DadosSimulados();
		if(lista.toString() != "[]" && l.getEscolha() == 0 && (d.getCodPerfil() == 0 || d.getCodPerfil() == 1 || d.getCodPerfil() == 2)) 
		{
			System.out.println(dao.excluir(codAtividade));
		}
		else if(lista.toString() != "[]" && l.getEscolha() == 1 && (d.getCodPerfil() == 1 || d.getCodPerfil() == 2))
		{
			System.out.println(dao.excluir(codAtividade));
		}
		else if(lista.toString() != "[]" && l.getEscolha() == 1 && d.getCodPerfil() == 0)
		{
			//Bot�o de excluir fica cinza e n�o funciona
			System.out.println("Bot�o n�o funciona");
		}
		else
		{
			System.out.println("N�o encontrado nenhuma atividade com o c�digo fornecido");
		}
	}
}
