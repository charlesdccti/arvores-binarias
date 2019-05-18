package bst;

import org.junit.Assert;
import org.junit.Test;

public class RemoverTest {
    @Test
    public void removerTest() {
        ArvoreBinariaBusca<Integer> arvoreBinariaBusca = new ArvoreBinariaBusca<Integer>();
        arvoreBinariaBusca.remover(34);

        arvoreBinariaBusca.inserir(27);
        arvoreBinariaBusca.inserir(3);
        arvoreBinariaBusca.inserir(5);
        arvoreBinariaBusca.inserir(2);

        arvoreBinariaBusca.remover(27);
        Assert.assertEquals("(2)(3)(5)", arvoreBinariaBusca.inorder());

        arvoreBinariaBusca.remover(2);
        Assert.assertEquals("(3)(5)", arvoreBinariaBusca.inorder());

    }
}
