import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Pessoa> listPessoas = new ArrayList<>();
        ArrayList<Disciplina> listDisciplinas = new ArrayList<>();

        int opcao;
        do {
            System.out.println("\nMenu:");
            System.out.println("1 - Inserir disciplina");
            System.out.println("2 - Inserir professor");
            System.out.println("3 - Inserir atendente");
            System.out.println("4 - Inserir aluno");
            System.out.println("5 - Adicionar disciplina ao professor");
            System.out.println("6 - Mostrar pessoas");
            System.out.println("7 - Mostrar disciplinas");
            System.out.println("8 - Aplicar bonificações");
            System.out.println("9 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.print("Código da disciplina: ");
                    int codigoDisciplina = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nome da disciplina: ");
                    String nomeDisciplina = scanner.nextLine();
                    Disciplina disciplina = new Disciplina(codigoDisciplina, nomeDisciplina);
                    listDisciplinas.add(disciplina);
                    System.out.println("Disciplina adicionada com sucesso!");
                    break;

                case 2:
                    System.out.print("Nome do professor: ");
                    String nomeProfessor = scanner.nextLine();
                    System.out.print("CPF do professor: ");
                    String cpfProfessor = scanner.nextLine();
                    System.out.print("Número do crachá: ");
                    int numCrachaProfessor = scanner.nextInt();
                    System.out.print("Salário: ");
                    double salarioProfessor = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("URL do Lattes: ");
                    String urlLattes = scanner.nextLine();
                    Professor professor = new Professor(nomeProfessor, cpfProfessor, numCrachaProfessor, salarioProfessor, urlLattes);
                    listPessoas.add(professor);
                    System.out.println("Professor adicionado com sucesso!");
                    break;

                case 3:
                    System.out.print("Nome do atendente: ");
                    String nomeAtendente = scanner.nextLine();
                    System.out.print("CPF do atendente: ");
                    String cpfAtendente = scanner.nextLine();
                    System.out.print("Número do crachá: ");
                    int numCrachaAtendente = scanner.nextInt();
                    System.out.print("Salário: ");
                    double salarioAtendente = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Função: ");
                    String funcao = scanner.nextLine();
                    System.out.print("Setor: ");
                    String setor = scanner.nextLine();
                    Atendente atendente = new Atendente(nomeAtendente, cpfAtendente, numCrachaAtendente, salarioAtendente, funcao, setor);
                    listPessoas.add(atendente);
                    System.out.println("Atendente adicionado com sucesso!");
                    break;

                case 4:
                    System.out.print("Nome do aluno: ");
                    String nomeAluno = scanner.nextLine();
                    System.out.print("CPF do aluno: ");
                    String cpfAluno = scanner.nextLine();
                    System.out.print("RA do aluno: ");
                    String raAluno = scanner.nextLine();
                    System.out.print("Disciplina: ");
                    String disciplinaAluno = scanner.nextLine();
                    Aluno aluno = new Aluno(nomeAluno, cpfAluno, raAluno, disciplinaAluno);
                    listPessoas.add(aluno);
                    System.out.println("Aluno adicionado com sucesso!");
                    break;

                case 5:
                    System.out.print("Código da disciplina a ser adicionada: ");
                    int codDisciplina = scanner.nextInt();
                    System.out.print("Número do crachá do professor: ");
                    int crachaProfessor = scanner.nextInt();
                    scanner.nextLine();
                    Disciplina disciplinaSelecionada = null;
                    Professor professorSelecionado = null;

                    for (Disciplina d : listDisciplinas) {
                        if (d.getCodigo() == codDisciplina) {
                            disciplinaSelecionada = d;
                            break;
                        }
                    }

                    for (Pessoa p : listPessoas) {
                        if (p instanceof Professor && ((Professor) p).getNumCracha() == crachaProfessor) {
                            professorSelecionado = (Professor) p;
                            break;
                        }
                    }

                    if (disciplinaSelecionada != null && professorSelecionado != null) {
                        professorSelecionado.adicionarDisciplina(disciplinaSelecionada);
                        System.out.println("Disciplina adicionada ao professor!");
                    } else {
                        System.out.println("Disciplina ou professor não encontrado.");
                    }
                    break;

                case 6:
                    System.out.println("\nLista de pessoas:");
                    for (Pessoa pessoa : listPessoas) {
                        System.out.println(pessoa);
                    }
                    break;

                case 7:
                    System.out.println("\nLista de disciplinas:");
                    for (Disciplina d : listDisciplinas) {
                        System.out.println(d);
                    }
                    break;

                case 8:
                    System.out.print("Número do crachá do funcionário para bonificação: ");
                    int crachaFuncionario = scanner.nextInt();
                    scanner.nextLine();
                    Pessoa funcionarioSelecionado = null;

                    for (Pessoa p : listPessoas) {
                        if (p instanceof Funcionario && ((Funcionario) p).getNumCracha() == crachaFuncionario) {
                            funcionarioSelecionado = p;
                            break;
                        }
                    }

                    if (funcionarioSelecionado != null) {
                        if (funcionarioSelecionado instanceof Professor) {
                            ((Funcionario) funcionarioSelecionado).setSalario(((Funcionario) funcionarioSelecionado).getSalario() * 2);
                            System.out.println("Bonificação de 100% aplicada ao professor!");
                        } else if (funcionarioSelecionado instanceof Atendente) {
                            ((Funcionario) funcionarioSelecionado).setSalario(((Funcionario) funcionarioSelecionado).getSalario() * 1.15);
                            System.out.println("Bonificação de 15% aplicada ao atendente!");
                        } else {
                            ((Funcionario) funcionarioSelecionado).setSalario(((Funcionario) funcionarioSelecionado).getSalario() * 1.10);
                            System.out.println("Bonificação de 10% aplicada ao funcionário!");
                        }
                    } else {
                        System.out.println("Funcionário não encontrado.");
                    }
                    break;

                case 9:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (opcao != 9);

        scanner.close();
    }
}
