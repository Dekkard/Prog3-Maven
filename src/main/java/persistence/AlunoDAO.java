package persistence;

import java.util.List;

import model.Aluno;

public interface AlunoDAO {
	public String save(Aluno aluno);
	public String delete(int matricula);
	public String update(Aluno aluno);
	public List<Aluno> list();
	public Aluno findByMatricula(int matricula);
}
