public class Atendente extends Funcionario {
    private String funcao;
    private String setor;

    public Atendente() {}

    public Atendente(String nome, String cpf, int numCracha, double salario, String funcao, String setor) {
        super(nome, cpf, numCracha, salario);
        this.funcao = funcao;
        this.setor = setor;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    @Override
    public void bonificar() {
        this.setSalario(this.getSalario() * 1.15); // Bonificação de 15%
    }

    @Override
    public String toString() {
        return super.toString() + " Atendente{" + "funcao='" + funcao + '\'' + ", setor='" + setor + '\'' + '}';
    }
}
