package view;

import java.util.List;

import javax.swing.JOptionPane;

import apoio.RegrasDeNegocio;
import control.AlunoDAO;
import model.Aluno;

public class TelaLogin {

	public int codPerfil;
	public String nomeField;
	private String senhaField;
	Aluno l;
	
	public void logar()
	{
		nomeField = JOptionPane.showInputDialog("Usuário: ");
		senhaField = JOptionPane.showInputDialog("Senha: ");

		AlunoDAO dao1 = new AlunoDAO();
		List<Aluno> lista1 = dao1.get("select * from TBALUNOUSUARIO where LOGINUSUARIO ="+"'"+nomeField+"'");
		if(lista1 != null)
		{
			l = lista1.get(0);
			if(l.getLoginUsuario().equals(nomeField) && l.getSenhaAluno().equals(senhaField)) 
			{
				JOptionPane.showMessageDialog(null, "Passando para a tela principal...");
				codPerfil = l.getCodPerfil();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Senha incorreta!");
			}
		}
		else
		{
			System.out.println("Usuário incorreto!");
		}
	}
	
	public void cadastrar()
	{
		int codCurso;
		String nomeAluno, cpfAluno, dataNascimentoAluno, emailAluno, loginUsuario, senhaUsuario;
		
		codCurso = Integer.parseInt(JOptionPane.showInputDialog("COD: "));
		nomeAluno = JOptionPane.showInputDialog("Nome: ");
		cpfAluno = JOptionPane.showInputDialog("CPF: ");
		dataNascimentoAluno = JOptionPane.showInputDialog("Data de Nascimento: ");
		emailAluno = JOptionPane.showInputDialog("E-mail: ");
		loginUsuario = JOptionPane.showInputDialog("Login: ");
		senhaUsuario = JOptionPane.showInputDialog("Senha: ");
		
		RegrasDeNegocio rn = new RegrasDeNegocio();
		if(rn.testeCurso(cpfAluno, codCurso))
		{
			JOptionPane.showMessageDialog(null, "Um aluno não pode estar em mais de um curso em uma mesma instituição!");
		}
		else
		{
			AlunoDAO dao2 = new AlunoDAO();
			int codAlunoUsuario;
			
			List<Aluno> lista2 = dao2.get("select * from TBALUNOUSUARIO");
			codAlunoUsuario = lista2.get(lista2.size()-1).getCodAlunoUsuario();
			
			Aluno a = new Aluno(++codAlunoUsuario,codCurso,nomeAluno,cpfAluno,dataNascimentoAluno,emailAluno,loginUsuario,senhaUsuario,0);
			
			System.out.println(dao2.gravar(a));
		}
	}
}
