public class Funcionario extends Pessoa {
    private int numCracha;
    private double salario;

    public Funcionario() {}

    public Funcionario(String nome, String cpf, int numCracha, double salario) {
        super(nome, cpf);
        this.numCracha = numCracha;
        this.salario = salario;
    }

    public int getNumCracha() {
        return numCracha;
    }

    public void setNumCracha(int numCracha) {
        this.numCracha = numCracha;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public void bonificar() {
        this.salario *= 1.10; // Bonificação de 10%
    }

    @Override
    public String toString() {
        return super.toString() + " Funcionario{" + "numCracha=" + numCracha + ", salario=" + salario + '}';
    }
}
