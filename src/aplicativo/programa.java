package aplicativo;

import entidades.aluno;
import entidades.disciplina;
import entidades.matricula;
import entidades.professor;
import entidades.status;

public class programa {

	public static void main(String[] args) {
		aluno aluno = new aluno();
		professor professor = new professor();
		disciplina disciplina = new disciplina(professor.getListaProfessores());
		matricula matricula = new matricula(aluno.getListaAlunos(), disciplina.getListaDisciplinas());

	}

}
