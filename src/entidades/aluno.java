package entidades;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class aluno {
	final int MAX_MATRICULA = 100;
	Random random = new Random();
	List<aluno> listaAlunos = new ArrayList<aluno>();
	protected int id = 0;
	protected String nome;
	protected int idade;
	protected String email;
	protected String telefone;
	protected String endereco;
	private LocalDate dataCadastro = LocalDate.now();
	private int matricula;
	private int faltas;
	private double media;

	public aluno() {
	}

	public aluno(int id, String nome, int idade, String email, String telefone, String endereco) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
	}

	public aluno(int id, String nome, int idade, String email, String telefone, String endereco, int matricula,
			double media, int faltas, LocalDate dataCadastro) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
		this.email = email;
		this.telefone = telefone;
		this.endereco = endereco;
		this.matricula = matricula;
		this.media = media;
		this.faltas = faltas;
		this.dataCadastro = dataCadastro;

	}

	public List<aluno> getListaAlunos() {
		return listaAlunos;
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getMatricula() {
		return matricula;
	}

	public int getFaltas() {
		return faltas;
	}

	public void setFaltas(int faltas) {
		this.faltas = faltas;
	}

	public double getMedia() {
		return media;
	}

	public void setMedia(double media) {
		this.media = media;
	}

	public void adicionarAluno(String nome, int idade, String email, String telefone, String endereco, int faltas,
			double media) {
		id++;
		Set<Integer> matriculasUsadas = new HashSet<Integer>();
		while (matriculasUsadas.size() < MAX_MATRICULA) {
			matricula = random.nextInt(1000);
			matriculasUsadas.add(matricula);
		}
		aluno novoAluno = new aluno(id, nome, idade, email, telefone, endereco, matricula, media, faltas, dataCadastro);
		if (listaAlunos.add(novoAluno)) {
			System.out.println("Novo Aluno Adicionado!");
			System.out.println();
		} else {
			System.out.println("Erro ao Adicionar Aluno!");
			id--;
		}
	}

	public void exibirAlunos(List<aluno> listaAlunos) {
		if (listaAlunos.isEmpty()) {
			System.out.println("Lista Esta Vazia!");
			return;
		}
		for (aluno exibir : listaAlunos) {
			System.out.println(exibir);
		}

	}

	public void exibirAprovadosReprovados(List<aluno> listaAlunos) {
		for (aluno exibir : listaAlunos) {
			if (exibir.getMedia() <= 7) {
				System.out.println("ID-> " + exibir.getId());
				System.out.println("Nome-> " + exibir.getNome());
				System.out.println("Média-> " + exibir.getMedia() + " Reprovado!");
				System.out.println();
			} else {
				System.out.println("ID-> " + exibir.getId());
				System.out.println("Nome-> " + exibir.getNome());
				System.out.println("Média-> " + exibir.getMedia() + " Aprovado!");
				System.out.println();
			}

		}

	}

	public void verificarFaltas(List<aluno> listaAlunos) {
		int quantidadeAulas = 16;
		aluno alunoAtual = null;
		for (aluno exibir : listaAlunos) {
			alunoAtual = exibir;
			int aulasPresente = quantidadeAulas - alunoAtual.getFaltas();
			if (aulasPresente < 12) {
				System.out.println("ID-> " + alunoAtual.getId());
				System.out.println("Nome-> " + alunoAtual.getNome());
				System.out.println("Faltas-> " + alunoAtual.getFaltas() + " Atenção quantidade de faltas Elevada!");
				System.out.println();

			} else {
				System.out.println("ID-> " + alunoAtual.getId());
				System.out.println("Nome-> " + alunoAtual.getNome());
				System.out.println("Faltas-> " + alunoAtual.getFaltas() + " Faltas Dentro do esperado");
				System.out.println();
			}

		}
	}

	@Override
	public String toString() {
		return "aluno [id->" + id + "\nnome->" + nome + "\nidade->" + idade + "\nemail->" + email + "\ntelefone->"
				+ telefone + "\nendereco->" + endereco + "\nfaltas->" + faltas + "\nmedia->" + media + "\nmatricula->"
				+ matricula + "\nData do Cadastro->" + dataCadastro + "]\n";
	}

}
