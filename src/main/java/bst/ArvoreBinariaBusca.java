package bst;

import java.util.*;

public class ArvoreBinariaBusca<T extends Comparable<T>> implements ArvoreBinaria<T> {
    private NoArvore<T> raiz;

    /**
     * Insere um valor na árvore, se o valor for menor que a raiz
     * da árvore ou subárvore então é inserido do lado esquerdo, caso contrário
     * o valor é inserido no lado direito.
     * @param valor O valor a ser inserido.
     */
    public void inserir(T valor) {
        this.raiz = inserirRecursivamente(this.raiz, valor);
    }

    private NoArvore<T> inserirRecursivamente(NoArvore<T> noArvore, T valor) {
        if (noArvore == null) return new NoArvore<T>(valor);
        if (valor.compareTo(noArvore.getValor()) < 0)
            noArvore.setEsquerda(inserirRecursivamente(noArvore.getEsquerda(), valor));
        else if (valor.compareTo(noArvore.getValor()) > 0)
            noArvore.setDireita(inserirRecursivamente(noArvore.getDireita(), valor));
        return noArvore; // depois de inserirmos a subárvore retornamos a raiz da árvore
    }

    /**
     * Remove um valor da árvore segundo a chave passada por parâmetro.
     * @param chave A chave correspondente ao valor para ser removido.
     */
    public void remover(T chave) {
        remover(this.raiz, chave);
    }

    private NoArvore<T> remover(NoArvore<T> noArvore, T chave) {
        if (noArvore == null) return null;

        if (chave.compareTo(noArvore.getValor()) < 0) noArvore.setEsquerda(remover(noArvore.getEsquerda(), chave));
        else if (chave.compareTo(noArvore.getValor()) > 0) noArvore.setDireita(remover(noArvore.getDireita(), chave));
        else {
            if (noArvore.getEsquerda() == null) {
                NoArvore<T> temp = noArvore.getDireita();
                if (this.raiz == noArvore) {
                    this.raiz = temp;
                }
                return temp;
            } else if (noArvore.getDireita() == null) {
                NoArvore<T> temp = noArvore.getEsquerda();
                if (this.raiz == noArvore) {
                    this.raiz = temp;
                }
                return temp;
            }
            // nó com dois filhos: Obtenha o sucessor, o menor na subárvore direita
            NoArvore<T> temp =  findMin(noArvore.getDireita());
            noArvore.setValor(temp.getValor());
            noArvore.setDireita(remover(noArvore.getDireita(), temp.getValor())); // Apagar o sucessor interno
        }
        return noArvore;
    }

    /**
     * Busca um valor na árvore.
     * @param chave O valor a ser buscado.
     * @return Retorna o valor buscado na árvore, caso não exista retorna null.
     */
    public T buscar(T chave) {
        NoArvore<T> temp = buscar(this.raiz, chave);
        return temp == null ? null : temp.getValor();
    }

    private NoArvore<T> buscar(NoArvore<T> noArvore, T chave) {
        if (noArvore == null || noArvore.getValor().compareTo(chave) == 0)
            return noArvore;
        else if (noArvore.getValor().compareTo(chave) > 0)
            return buscar(noArvore.getEsquerda(), chave);
        else
            return buscar(noArvore.getDireita(), chave);
    }

    /**
     * A travessia pre-order consiste em primeiro visitar a raiz da árvore, depois
     * a subárvore da esquerda e finalmente a subárvore da direita.
     * @return Retorna uma string contendo os valores da árvore na travessia pre-order.
     */
    public String preorder() {
        StringBuilder strArvorePreOrder = new StringBuilder();
        return preorder(this.raiz, strArvorePreOrder);
    }

    private String preorder(NoArvore<T> noArvore, StringBuilder strArvorePreOrder) {
        if (noArvore != null) {
            strArvorePreOrder.append("(");
            strArvorePreOrder.append(noArvore.getValor());
            strArvorePreOrder.append(")");
            preorder(noArvore.getEsquerda(), strArvorePreOrder);
            preorder(noArvore.getDireita(), strArvorePreOrder);
        }
        return strArvorePreOrder.toString();
    }

    /**
     * A travessia in-order consiste em primeiro visitar a subárvore da esquerda,
     * depois a raiz e depois a subárvore da direita.
     * @return Retorna uma string contendo os valores da árvore na travessia in-order.
     */
    public String inorder() {
        StringBuilder strArvoreInOrder = new StringBuilder();
        return inorder(this.getRaiz(), strArvoreInOrder);
    }

    private String inorder(NoArvore<T> noArvore, StringBuilder strArvoreInOrder) {
        if (noArvore != null) {
            inorder(noArvore.getEsquerda(), strArvoreInOrder);
            strArvoreInOrder.append("(");
            strArvoreInOrder.append(noArvore.getValor());
            strArvoreInOrder.append(")");
            inorder(noArvore.getDireita(), strArvoreInOrder);
        }
        return strArvoreInOrder.toString();
    }

    /**
     * A travessia post-order consiste em primeiro visitar a subárvore da esquerda,
     * depois a subárvore da direita e em seguida a raiz.
     * @return Retorna uma string contendo os valores da árvore na travessia post-order.
     */
    public String postorder() {
        StringBuilder strArvorePostOrder = new StringBuilder();
        return postorder(this.raiz, strArvorePostOrder);
    }

    private String postorder(NoArvore<T> noArvore, StringBuilder strArvorePostOrder) {
        if (noArvore != null) {
            postorder(noArvore.getEsquerda(), strArvorePostOrder);
            postorder(noArvore.getDireita(), strArvorePostOrder);
            strArvorePostOrder.append("(");
            strArvorePostOrder.append(noArvore.getValor());
            strArvorePostOrder.append(")");
        }
        return strArvorePostOrder.toString();
    }

    /**
     * A altura de uma árvore binária é o número de arestas entre a raiz da árvore ou subárvore
     * e sua folha mais distante.
     * A raiz está no nível 0; o último nível da árvore é altura da árvore
     * @return Retorna a altura da árvore.
     */
    public int altura() {
        return altura(this.raiz);
    }

    protected int altura(NoArvore<T> noArvore) {
        int alturaEsquerda, alturaDireita;

        if (noArvore == null) return 0;

        if (noArvore.getEsquerda() != null) alturaEsquerda = altura(noArvore.getEsquerda());
        else alturaEsquerda = -1;

        if (noArvore.getDireita() != null) alturaDireita = altura(noArvore.getDireita());
        else alturaDireita = -1;

        return 1 + Math.max(alturaEsquerda, alturaDireita);
    }

    /**
     * Obtém o tamanho da árvore, isto é, a quantidade de nós na árvore.
     * @return Retorna a quantidade de nós na árvore.
     */
    public int tamanho() {
        return tamanho(this.raiz);
    }

    private int tamanho(NoArvore<T> noArvore) {
        return noArvore == null ? 0 : (
                1 + tamanho(noArvore.getEsquerda()) + tamanho(noArvore.getDireita())
                );
    }

    /**
     * Encontra o menor valor na árvore.
     * @return Retorna o menor valor da árvore.
     */
    public T findMin() {
        NoArvore<T> temp = findMin(this.raiz);
        return temp != null ? temp.getValor() : null;
    }

    protected NoArvore<T> findMin(NoArvore<T> noArvore) {
        if (noArvore == null) return null;
        if (noArvore.getEsquerda() == null) return noArvore;
        return findMin(noArvore.getEsquerda());
    }

    /**
     * Encontra o maior valor na árvore.
     * @return Retorna o maior valor da árvore.
     */
    public T findMax() {
        NoArvore<T> temp = findMax(this.raiz);
        return temp != null ? temp.getValor() : null;
    }

    protected NoArvore<T> findMax(NoArvore<T> noArvore) {
        if (noArvore == null) return null;
        if (noArvore.getDireita() == null) return noArvore;
        return findMax(noArvore.getDireita());
    }

    /**
     *  Uma árvore binária cheia é uma árvore binária na qual cada nó tem
     * 	exatamente zero ou dois filhos.
     * @return Retorna true caso a árvore seja cheia, false caso contrário.
     */
    public boolean isArvoreCheia() {
        return isArvoreCheia(this.raiz);
    }

    private boolean isArvoreCheia(NoArvore<T> noArvore) {
        if (noArvore == null) return true;
        if (noArvore.getEsquerda() == null && noArvore.getDireita() == null) return true;
        if ((noArvore.getEsquerda() != null) && (noArvore.getDireita() != null))
            return isArvoreCheia(noArvore.getEsquerda()) && isArvoreCheia(noArvore.getDireita());

        return false;
    }

    /**
     *  Uma árvore binária completa é uma árvore binária cujos todos os níveis, exceto o último nível, estão
     * 	comletamente cheios e todas as folhas no último nível estão todas para o lado esquerdo.
     * @return Retorna true se a árvore é completa, caso contrário retorna false
     */
    public boolean isArvoreCompleta() {
        return isArvoreCompleta(this.raiz);
    }

    private boolean isArvoreCompleta(NoArvore<T> noArvore) {
        if (noArvore == null) return true;
        Queue<NoArvore<T>> queue = new LinkedList<NoArvore<T>>();

        boolean flag = false;
        // Vamos fazer uma travessia level order usando uma fila
        queue.add(noArvore);
        while (!queue.isEmpty()) {
            NoArvore<T> tempNode = queue.remove();
            if (tempNode.getEsquerda() != null) {
                if (flag) return false;
                queue.add(tempNode.getEsquerda());
            } else flag = true;

            if (tempNode.getDireita() != null) {
                if (flag) return false;
                queue.add(tempNode.getDireita());
            } else flag = true;
        }

        return true;
    }

    /**
     * Verifica se a árvore contém o valor passado por parâmetro.
     * @param chave O valor a ser procurado.
     * @return Retorna true caso o valor se encontre na árvore, false caso contrário.
     */
    public boolean contains(T chave) {
        return contains(this.raiz, chave);
    }

    private boolean contains(NoArvore<T> noArvore, T chave) {
        if (noArvore == null) {
            return false;
        } else {
            return noArvore.getValor().compareTo(chave) == 0 ||
                    contains(noArvore.getEsquerda(), chave) ||
                    contains(noArvore.getDireita(), chave);
        }
    }

    public NoArvore<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }
}
