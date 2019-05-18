package bst;

public class NoArvore<T> {
    private T valor;
    private NoArvore<T> esquerda;
    private NoArvore<T> direita;
    private int altura;

    public NoArvore(T valor) {
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public NoArvore<T> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(NoArvore<T> esquerda) {
        this.esquerda = esquerda;
    }

    public NoArvore<T> getDireita() {
        return direita;
    }

    public void setDireita(NoArvore<T> direita) {
        this.direita = direita;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
