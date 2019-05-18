package bst;

import org.junit.Assert;
import org.junit.Test;

public class ArvoreCompletaTest {
    @Test
    public void arvoreCompletaTest() {
        ArvoreBinariaBusca<Integer> arvoreBinariaBusca = new ArvoreBinariaBusca<Integer>();
        Assert.assertEquals(true, arvoreBinariaBusca.isArvoreCompleta());

        arvoreBinariaBusca.inserir(27);
        arvoreBinariaBusca.inserir(33);
        arvoreBinariaBusca.inserir(28);
        arvoreBinariaBusca.inserir(13);
        arvoreBinariaBusca.inserir(10);
        arvoreBinariaBusca.inserir(20);
        arvoreBinariaBusca.inserir(36);

        Assert.assertEquals(true, arvoreBinariaBusca.isArvoreCompleta());

        arvoreBinariaBusca.inserir(5);
        arvoreBinariaBusca.inserir(12);
        Assert.assertEquals(true, arvoreBinariaBusca.isArvoreCompleta());

        arvoreBinariaBusca.inserir(14);
        arvoreBinariaBusca.inserir(26);
        Assert.assertEquals(true, arvoreBinariaBusca.isArvoreCompleta());

        arvoreBinariaBusca.inserir(2);
        arvoreBinariaBusca.inserir(8);
        Assert.assertEquals(false, arvoreBinariaBusca.isArvoreCompleta());

        arvoreBinariaBusca.inserir(11);
        arvoreBinariaBusca.inserir(13);
        Assert.assertEquals(false, arvoreBinariaBusca.isArvoreCompleta());
    }

}
