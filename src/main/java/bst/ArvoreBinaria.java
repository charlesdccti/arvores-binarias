package bst;

public interface ArvoreBinaria<T> {
     void inserir(T valor);
     void remover(T chave);
     T buscar(T chave);

     String preorder();
     String inorder();
     String postorder();

     int altura();
     int tamanho();

     T findMin();
     T findMax();

     boolean isArvoreCheia();
     boolean isArvoreCompleta();
     boolean contains(T chave);

     NoArvore<T> getRaiz();
}
