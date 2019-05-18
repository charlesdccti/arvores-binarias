package avl;

import bst.ArvoreBinariaBusca;
import bst.NoArvore;

public class ArvoreAVL<T extends Comparable<T>> extends ArvoreBinariaBusca<T> {
    @Override
    public void inserir(T valor) {
        this.setRaiz(this.insert(this.getRaiz(), valor));
    }

    private NoArvore<T> insert(NoArvore<T> noArvore, T valor) {

        if (noArvore == null)
            return new NoArvore<T>(valor);

        if (valor.compareTo(noArvore.getValor()) < 0)
            noArvore.setEsquerda(insert(noArvore.getEsquerda(), valor));
        else if (valor.compareTo(noArvore.getValor()) > 0)
            noArvore.setDireita(insert(noArvore.getDireita(), valor));
        else
            return noArvore;

        noArvore.setAltura(1 + Math.max(altura(noArvore.getEsquerda()),
                altura(noArvore.getDireita())));


        int balanceamento = obterFatorBalanceamento(noArvore);


        if (balanceamento > 1 && valor.compareTo(noArvore.getEsquerda().getValor()) < 0)
            return rotacaoDireita(noArvore);

        if (balanceamento < -1 && valor.compareTo(noArvore.getDireita().getValor()) > 0)
            return rotacaoEsquerda(noArvore);

        if (balanceamento > 1 && valor.compareTo(noArvore.getEsquerda().getValor()) > 0) {
            noArvore.setEsquerda(rotacaoEsquerda(noArvore.getEsquerda()));
            return rotacaoDireita(noArvore);
        }

        if (balanceamento < -1 && valor.compareTo(noArvore.getDireita().getValor()) < 0) {
            noArvore.setDireita(rotacaoDireita(noArvore.getDireita()));
            return rotacaoEsquerda(noArvore);
        }

        return noArvore;
    }

    private NoArvore<T> rotacaoDireita(NoArvore<T> noArvore) {
        NoArvore<T> tempNoArvore = noArvore.getEsquerda();
        NoArvore temp2 = tempNoArvore.getDireita();

        tempNoArvore.setDireita(noArvore);
        noArvore.setEsquerda(temp2);

        noArvore.setAltura(Math.max(altura(noArvore.getEsquerda()), altura(noArvore.getDireita())) + 1);
        tempNoArvore.setAltura(Math.max(altura(tempNoArvore.getEsquerda()), altura(tempNoArvore.getDireita())) + 1);

        return tempNoArvore;
    }

    private NoArvore<T> rotacaoEsquerda(NoArvore<T> noArvore) {
        NoArvore<T> tempNoArvore = noArvore.getDireita();
        NoArvore<T> temp2 = tempNoArvore.getEsquerda();

        tempNoArvore.setEsquerda(noArvore);
        noArvore.setDireita(temp2);

        noArvore.setAltura(Math.max(altura(noArvore.getEsquerda()), altura(noArvore.getDireita())) + 1);
        tempNoArvore.setAltura(Math.max(altura(tempNoArvore.getEsquerda()), altura(tempNoArvore.getDireita())) + 1);

        return tempNoArvore;
    }

    private int obterFatorBalanceamento(NoArvore<T> noArvore) {
        if (noArvore == null)
            return 0;

        return altura(noArvore.getEsquerda()) - altura(noArvore.getDireita());
    }

    @Override
    public void remover(T valor) {
        this.setRaiz(remover(this.getRaiz(), valor));
    }

    private NoArvore<T> remover(NoArvore<T> noArvore, T valor) {
        if (noArvore == null) return null;

        if (valor.compareTo(noArvore.getValor()) < 0) noArvore.setEsquerda(remover(noArvore.getEsquerda(), valor));
        else if (valor.compareTo(noArvore.getValor()) > 0) noArvore.setDireita(remover(noArvore.getDireita(), valor));
        else {
            if (noArvore.getEsquerda() == null) {
                NoArvore<T> temp = noArvore.getDireita();
                if (this.getRaiz() == noArvore) {
                    this.setRaiz(temp);
                }
                return temp;
            } else if (noArvore.getDireita() == null) {
                NoArvore<T> temp = noArvore.getEsquerda();
                if (this.getRaiz() == noArvore) {
                    this.setRaiz(temp);
                }
                return temp;
            }
            // nó com dois filhos: Obtenha o sucessor, o menor na subárvore direita
            NoArvore<T> temp =  findMin(noArvore.getDireita());
            noArvore.setValor(temp.getValor());
            noArvore.setDireita(remover(noArvore.getDireita(), temp.getValor())); // Apagar o sucessor interno
        }

        if (noArvore == null)
            return null;

        noArvore.setAltura(Math.max(altura(noArvore.getEsquerda()), altura(noArvore.getDireita())) + 1);

        int balance = obterFatorBalanceamento(noArvore);

        if (balance > 1 && obterFatorBalanceamento(noArvore.getEsquerda()) >= 0)
            return rotacaoDireita(noArvore);

        if (balance > 1 && obterFatorBalanceamento(noArvore.getEsquerda()) < 0) {
            noArvore.setEsquerda(rotacaoEsquerda(noArvore.getEsquerda()));
            return rotacaoDireita(noArvore);
        }

        if (balance < -1 && obterFatorBalanceamento(noArvore.getDireita()) <= 0)
            return rotacaoEsquerda(noArvore);

        if (balance < -1 && obterFatorBalanceamento(noArvore.getDireita()) > 0) {
            noArvore.setDireita(rotacaoDireita(noArvore.getDireita()));
            return rotacaoEsquerda(noArvore);
        }

        return noArvore;
    }
}
