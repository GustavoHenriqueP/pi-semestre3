package teste_tarefa;

import java.util.List;

import javax.swing.JOptionPane;

import control.TarefaDAO;
import model.Tarefa;

public class ListarTarefa {
	
	private int escolha = 0;
	
	public void listar() 
	{
		TarefaDAO dao = new TarefaDAO();
		
		//O atributo escolha simula se est� na aba privada ou aba p�blica
		escolha = Integer.parseInt(JOptionPane.showInputDialog("0 - Abrir aba privada\n1 - Abrir aba p�blica"));
		
		List<Tarefa> lista = dao.get("select * from TBTAREFA where PUBLICAOUPRIVADA = "+escolha);
		for(Tarefa t: lista)
		{
			System.out.println(t);
		}
	}
	
	public int getEscolha()
	{
		return escolha;
	}
}
