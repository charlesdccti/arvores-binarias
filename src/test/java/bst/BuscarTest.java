package bst;

import org.junit.Assert;
import org.junit.Test;

public class BuscarTest {
    @Test
    public void buscarTest() {
        ArvoreBinariaBusca<Integer> arvoreBinariaBusca = new ArvoreBinariaBusca<Integer>();
        arvoreBinariaBusca.inserir(27);
        arvoreBinariaBusca.inserir(33);
        arvoreBinariaBusca.inserir(28);
        arvoreBinariaBusca.inserir(13);
        arvoreBinariaBusca.inserir(10);
        arvoreBinariaBusca.inserir(18);
        arvoreBinariaBusca.inserir(36);

        Assert.assertEquals(36, (int) arvoreBinariaBusca.buscar(36));
        Assert.assertEquals(null, arvoreBinariaBusca.buscar(-1));
    }
}
