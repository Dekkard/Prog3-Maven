package controller;

import java.util.List;

import javax.faces.bean.ManagedBean;

import model.Aluno;
import persistence.AlunoDAOImp;

@ManagedBean
public class AlunoController {
	private Integer matricula;
	private String nome;
	private String ra;
	private Aluno aluno;
	private String mensagem;
	
	public void addAluno() {
		Aluno aluno = new Aluno();
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setRa(ra);
		AlunoDAOImp ad = new AlunoDAOImp();
		setMensagem(ad.save(aluno));
		aluno = new Aluno();
	}

	public void editAluno() {
		Aluno aluno = new Aluno();
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		aluno.setRa(ra);
		AlunoDAOImp ad = new AlunoDAOImp();
		setMensagem(ad.update(aluno));
	}

	public void deleteAluno(int matricula) {
		AlunoDAOImp ad = new AlunoDAOImp();
		setMensagem(ad.delete(matricula));
	}

	public List<Aluno> getAlunos() {
		AlunoDAOImp ad = new AlunoDAOImp();
		return ad.list();
	}

	public void findAluno() {
		AlunoDAOImp ad = new AlunoDAOImp();
		Aluno aluno = ad.findByMatricula(matricula);
		if(aluno==null)
		{
			setMensagem("Matricula inexistente!");
			return;
		}
		setMensagem("Aluno procurado: \nNome: "+aluno.getNome()+" RA: "+aluno.getRa());
	}
	//get/set
	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public String getMensagem() {
		return mensagem;
	}
	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRa() {
		return ra;
	}

	public void setRa(String ra) {
		this.ra = ra;
	}
	
}
