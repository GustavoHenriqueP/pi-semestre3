package view;

import java.util.List;

import javax.swing.JOptionPane;

import apoio.DadosSimulados;
import control.AlunoDAO;
import control.TarefaDAO;
import model.Aluno;
import model.Tarefa;

public class TelaTarefa {

	private int escolha = 0;
	Tarefa t = null;
	int visibilidade = 0;
	String nomeAtividade, descAtividade, dataAtividade;
	TelaLogin tl = new TelaLogin();
	int codPerfil = tl.codPerfil;
	int codCurso=0;
	
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
	
	public void gravarTarefa()
	{	
		nomeAtividade = JOptionPane.showInputDialog("Nome da Atividade: ");
		descAtividade = JOptionPane.showInputDialog("Descri��o: ");
		dataAtividade = JOptionPane.showInputDialog("Data de Entrega: ");
		
		//Se o usu�rio � ADM, aparecer� uma op��o de escolha entre atividade p�blica ou privada
		if(codPerfil == 1 || codPerfil == 2)
		{
			visibilidade = Integer.parseInt(JOptionPane.showInputDialog("0 - Atividade privada \n1 - Atividade p�blica"));
		}
		
		AlunoDAO daoa = new AlunoDAO();
		List<Aluno> l1 = daoa.get("select * from TBALUNOUSUARIO where LOGINUSUARIO ="+"'"+tl.nomeField+"'");
		
		if(l1 != null)
		{
			Aluno a = l1.get(0);
			codCurso = a.getCodCurso();
		}
		
		t = new Tarefa(codCurso,nomeAtividade,descAtividade,dataAtividade,0,visibilidade);
		
		TarefaDAO dao = new TarefaDAO();
		System.out.println(dao.gravar(t));
	}
	
	public void excluirTarefa()
	{
		int codAtividade = Integer.parseInt(JOptionPane.showInputDialog("C�digo da atividade a ser exclu�da: "));
		
		TarefaDAO dao = new TarefaDAO();
		
		List<Tarefa> lista = dao.get("select * from TBTAREFA where CODTAREFA = "+codAtividade);
		
		
		if(lista.toString() != "[]" && getEscolha() == 0 && (codPerfil == 0 || codPerfil == 1 || codPerfil == 2)) 
		{
			System.out.println(dao.excluir(codAtividade));
		}
		else if(lista.toString() != "[]" && getEscolha() == 1 && (codPerfil == 1 || codPerfil == 2))
		{
			System.out.println(dao.excluir(codAtividade));
		}
		else if(lista.toString() != "[]" && getEscolha() == 1 && codPerfil == 0)
		{
			//Bot�o de excluir fica cinza e n�o funciona
			System.out.println("Bot�o n�o funciona");
		}
	}
	
	public void alterarTarefa()
	{
		//Com a informa��o se est� na aba p�blica ou privada, de acordo com o c�digo de perfil, � realizada ou n�o a edi��o de determinada atividade
		int codAtividade = Integer.parseInt(JOptionPane.showInputDialog("C�digo da atividade a ser editada: "));

		TarefaDAO dao = new TarefaDAO();
		List<Tarefa> lista = dao.get("select * from TBTAREFA where CODTAREFA = "+codAtividade);

		String nome=null, nomeField=null, descricao=null, descricaoField=null, data=null, dataField=null;

		if(lista.toString() != "[]" && getEscolha() == 0 && (codPerfil == 0 || codPerfil == 1 || codPerfil == 2)) 
		{
			Tarefa t = lista.get(0);
			nomeField = t.getNomeTarefa();
			descricaoField = t.getDescricaoTarefa();
			dataField = t.getDataEntregaTarefa();
			nome = JOptionPane.showInputDialog("Alterar nome: ");
			descricao = JOptionPane.showInputDialog("Alterar descri��o: ");
			data = JOptionPane.showInputDialog("Alterar data: ");
			if(!nome.equals(nomeField))
				t.setNomeTarefa(nome);
			if(!descricao.equals(descricaoField))
				t.setDescricaoTarefa(descricao);
			if(!data.equals(dataField))
				t.setDataEntregaTarefa(data);
			System.out.println(dao.alterar(t));
		}
		else if(lista.toString() != "[]" && getEscolha() == 1 && (codPerfil == 1 || codPerfil == 2))
		{
			Tarefa t = lista.get(0);
			nomeField = t.getNomeTarefa();
			descricaoField = t.getDescricaoTarefa();
			dataField = t.getDataEntregaTarefa();
			nome = JOptionPane.showInputDialog("Alterar nome: ");
			descricao = JOptionPane.showInputDialog("Alterar descri��o: ");
			data = JOptionPane.showInputDialog("Alterar data: ");
			if(!nome.equals(nomeField))
				t.setNomeTarefa(nome);
			if(!descricao.equals(descricaoField))
				t.setDescricaoTarefa(descricao);
			if(!data.equals(dataField))
				t.setDataEntregaTarefa(data);
			System.out.println(dao.alterar(t));
		}
		else if(lista.toString() != "[]" && getEscolha() == 1 && codPerfil == 0)
		{
			//Bot�o de excluir fica cinza e n�o funciona
			System.out.println("Bot�o n�o funciona");
		}
	}
}
