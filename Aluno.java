public class Aluno extends Pessoa {
    private String RA;
    private String disciplina;

    public Aluno() {}

    public Aluno(String nome, String cpf, String RA, String disciplina) {
        super(nome, cpf);
        this.RA = RA;
        this.disciplina = disciplina;
    }

    public String getRA() {
        return RA;
    }

    public void setRA(String RA) {
        this.RA = RA;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    @Override
    public String toString() {
        return super.toString() + " Aluno{" + "RA='" + RA + '\'' + ", disciplina='" + disciplina + '\'' + '}';
    }
}
