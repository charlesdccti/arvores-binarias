package bst;

import org.junit.Assert;
import org.junit.Test;

public class TamanhoTest {
    @Test
    public void tamanhoTest() {
        ArvoreBinariaBusca<Integer> arvoreBinariaBusca = new ArvoreBinariaBusca<Integer>();
        arvoreBinariaBusca.inserir(27);
        arvoreBinariaBusca.inserir(3);
        arvoreBinariaBusca.inserir(5);
        arvoreBinariaBusca.inserir(2);

        Assert.assertEquals(4, arvoreBinariaBusca.tamanho());

        arvoreBinariaBusca.remover(3);
        Assert.assertEquals(3, arvoreBinariaBusca.tamanho());
    }
}
