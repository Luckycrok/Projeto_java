package projeto.src.main.java.com.mycompany.projeto;

public class Produto {

    private String nome;
    private String descricao;
    private int quantidade;
    private double valor;

    public Produto(String nome, String descricao, int quantidade, double valor) {
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Produto{"
                + "nome='" + nome + '\''
                + ", descricao='" + descricao + '\''
                + ", quantidade=" + quantidade
                + ", valor=" + valor
                + '}';
    }
}
