package bst;

import org.junit.Assert;
import org.junit.Test;

public class AlturaTest {
    @Test
    public void alturaTest() {
        ArvoreBinariaBusca<Integer> arvoreBinariaBusca = new ArvoreBinariaBusca<Integer>();
        Assert.assertEquals(0, arvoreBinariaBusca.altura());

        arvoreBinariaBusca.inserir(4);
        Assert.assertEquals(0, arvoreBinariaBusca.altura());

        arvoreBinariaBusca.inserir(7);
        Assert.assertEquals(1, arvoreBinariaBusca.altura());

        arvoreBinariaBusca.inserir(3);
        Assert.assertEquals(1, arvoreBinariaBusca.altura());


    }
}
