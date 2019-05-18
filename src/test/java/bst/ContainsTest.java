package bst;

import org.junit.Assert;
import org.junit.Test;

public class ContainsTest {
    @Test
    public void containsTest() {
        ArvoreBinariaBusca<Integer> arvoreBinariaBusca = new ArvoreBinariaBusca<Integer>();
        arvoreBinariaBusca.inserir(27);
        arvoreBinariaBusca.inserir(33);
        arvoreBinariaBusca.inserir(28);
        arvoreBinariaBusca.inserir(13);
        arvoreBinariaBusca.inserir(10);
        arvoreBinariaBusca.inserir(18);
        arvoreBinariaBusca.inserir(36);

        Assert.assertEquals(true, arvoreBinariaBusca.contains(36));
        Assert.assertEquals(false, arvoreBinariaBusca.contains(-1));
    }
}
