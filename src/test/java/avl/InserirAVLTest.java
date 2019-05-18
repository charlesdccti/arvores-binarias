package avl;

import avl.ArvoreAVL;
import org.junit.Assert;
import org.junit.Test;

public class InserirAVLTest {
    @Test
    public void inserirAVLTest() {
        ArvoreAVL<Integer> arvoreAVL = new ArvoreAVL<Integer>();

        arvoreAVL.inserir(10);
        arvoreAVL.inserir(20);
        arvoreAVL.inserir(30);
        arvoreAVL.inserir(40);
        arvoreAVL.inserir(50);
        arvoreAVL.inserir(25);

        Assert.assertEquals("(10)(20)(25)(30)(40)(50)", arvoreAVL.inorder());

    }
}
