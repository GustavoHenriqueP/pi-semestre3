package teste_tarefa;

import javax.swing.JOptionPane;

import apoio.DadosSimulados;
import control.TarefaDAO;
import model.Tarefa;

public class InserirTarefa {

	public static void main(String[] args) {
		
		Tarefa t = null;
		DadosSimulados d = new DadosSimulados();
		int codUsuario = d.getCodPerfil();
		int codCurso = d.getCodCursoDisciplina();
		int visibilidade = 0;
		String nomeAtividade, descAtividade, dataAtividade;
		
		nomeAtividade = JOptionPane.showInputDialog("Nome da Atividade: ");
		descAtividade = JOptionPane.showInputDialog("Descrição: ");
		dataAtividade = JOptionPane.showInputDialog("Data de Entrega: ");
		
		//Se o usuário é ADM, aparecerá uma opção de escolha entre atividade pública ou privada
		if(codUsuario == 1 || codUsuario == 2)
		{
			visibilidade = Integer.parseInt(JOptionPane.showInputDialog("0 - Atividade privada \n1 - Atividade pública"));
		}
		
		t = new Tarefa(codCurso,nomeAtividade,descAtividade,dataAtividade,0,visibilidade);
		
		TarefaDAO dao = new TarefaDAO();
		System.out.println(dao.gravar(t));
	}
}
