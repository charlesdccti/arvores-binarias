package bst;

import org.junit.Assert;
import org.junit.Test;

public class ArvoreCheiaTest {
    @Test
    public void arvoreCheiaTest() {
        ArvoreBinariaBusca<Integer> arvoreBinariaBusca = new ArvoreBinariaBusca<Integer>();
        arvoreBinariaBusca.inserir(27);
        arvoreBinariaBusca.inserir(3);
        arvoreBinariaBusca.inserir(5);
        arvoreBinariaBusca.inserir(2);

        Assert.assertEquals(false, arvoreBinariaBusca.isArvoreCheia());
        arvoreBinariaBusca.inserir(33);
        Assert.assertEquals(true, arvoreBinariaBusca.isArvoreCheia());
        arvoreBinariaBusca.inserir(45);
        Assert.assertEquals(false, arvoreBinariaBusca.isArvoreCheia());


    }
}
