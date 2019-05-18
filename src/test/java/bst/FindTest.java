package bst;

import org.junit.Assert;
import org.junit.Test;

public class FindTest {
    @Test
    public void findMinTest() {
        ArvoreBinariaBusca<Integer> arvoreBinariaBusca = new ArvoreBinariaBusca<Integer>();
        Assert.assertEquals(null, arvoreBinariaBusca.findMin());

        arvoreBinariaBusca.inserir(27);
        arvoreBinariaBusca.inserir(3);
        arvoreBinariaBusca.inserir(5);
        arvoreBinariaBusca.inserir(2);
        Assert.assertEquals(2, (int) arvoreBinariaBusca.findMin());
    }

    @Test
    public void findMaxTest() {
        ArvoreBinariaBusca<Integer> arvoreBinariaBusca = new ArvoreBinariaBusca<Integer>();
        Assert.assertEquals(null, arvoreBinariaBusca.findMax());

        arvoreBinariaBusca.inserir(27);
        arvoreBinariaBusca.inserir(3);
        arvoreBinariaBusca.inserir(5);
        arvoreBinariaBusca.inserir(2);
        Assert.assertEquals(27, (int) arvoreBinariaBusca.findMax());
    }
}
