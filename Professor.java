import java.util.ArrayList;

public class Professor extends Funcionario {
    private String urlattes;
    private ArrayList<Disciplina> disciplinas;

    public Professor() {}

    public Professor(String nome, String cpf, int numCracha, double salario, String urlattes) {
        super(nome, cpf, numCracha, salario);
        this.urlattes = urlattes;
        this.disciplinas = new ArrayList<>();
    }

    public String getUrlattes() {
        return urlattes;
    }

    public void setUrlattes(String urlattes) {
        this.urlattes = urlattes;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void adicionarDisciplina(Disciplina disciplina) {
        disciplinas.add(disciplina);
    }

    public void removerDisciplina(Disciplina disciplina) {
        disciplinas.remove(disciplina);
    }

    @Override
    public void bonificar() {
        this.setSalario(this.getSalario() * 2); // Bonificação de 100%
    }

    @Override
    public String toString() {
        return super.toString() + " Professor{" + "urlattes='" + urlattes + '\'' + ", disciplinas=" + disciplinas + '}';
    }
}
