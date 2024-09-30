package entidades;

import java.util.ArrayList;
import java.util.List;

public class disciplina {
	private List<disciplina> listaDisciplinas = new ArrayList<disciplina>();
	List<professor> listaProfessores;
	private professor professorAtual = null;
	private String professorResponsavel;
	private int id = 0;
	private String nome;
	private String cargaHoraria;
	private double creditos;
	private int idProfessor;

	public disciplina(List<professor> listaProfessores) {
		this.listaProfessores = listaProfessores;

	}

	public disciplina(String professorResponsavel, String nome, String cargaHoraria, double creditos) {
		this.professorResponsavel = professorResponsavel;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.creditos = creditos;
	}

	public disciplina(int id, String nome, String cargaHoraria, double creditos, String professorResponsavel) {
		this.professorResponsavel = professorResponsavel;
		this.id = id;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.creditos = creditos;
	}

	public disciplina(int id, String nome, String cargaHoraria, double creditos, professor professorAtual) {
		this.id = id;
		this.nome = nome;
		this.cargaHoraria = cargaHoraria;
		this.creditos = creditos;
		this.professorAtual = professorAtual;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(String cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	public int getId() {
		return id;
	}

	public double getCreditos() {
		return creditos;
	}

	public void setCreditos(double creditos) {
		this.creditos = creditos;
	}

	public professor getProfessorAtual() {
		return professorAtual;
	}

	public List<disciplina> getListaDisciplinas() {
		return listaDisciplinas;
	}

	public void adicionarDisciplina(String nome, String cargaHoraria, double creditos, int idProfessor) {

		for (professor procurarProfessor : listaProfessores) {
			if (procurarProfessor.getId() == idProfessor) {
				professorAtual = procurarProfessor;
				break;
			}
		}
		if (professorAtual != null) {
			professorResponsavel = professorAtual.getNome();
			id++;
			disciplina disciplinaNova = new disciplina(id, nome, cargaHoraria, creditos, professorResponsavel);
			if (listaDisciplinas.add(disciplinaNova)) {
				System.out.println("Nova Disciplina Adicionada!");
				System.out.println();
			}

		} else {
			System.out.println("professor não encontrado!");
		}
	}

	public void exibirDisciplinas(List<disciplina> listaDisciplinas) {
		if (listaDisciplinas.isEmpty()) {
			System.out.println("Lista Vazia!");
		}
		for (disciplina exibirDisciplinas : listaDisciplinas) {
			System.out.println(exibirDisciplinas);
		}
	}

	@Override
	public String toString() {
		return "disciplina [id->" + id + "\nnome->" + nome + "\ncargaHoraria->" + cargaHoraria + "\ncreditos->"
				+ creditos + "\nprofessor Responsavel->" + professorResponsavel + "]\n";
	}

}
