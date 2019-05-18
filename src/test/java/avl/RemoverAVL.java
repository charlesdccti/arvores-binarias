package avl;

import org.junit.Assert;
import org.junit.Test;

public class RemoverAVL {
    @Test
    public void removerTest() {
        ArvoreAVL<Integer> arvoreAVL = new ArvoreAVL<Integer>();

        arvoreAVL.inserir(9);
        arvoreAVL.inserir(5);
        arvoreAVL.inserir(10);
        arvoreAVL.inserir(0);
        arvoreAVL.inserir(6);
        arvoreAVL.inserir(11);
        arvoreAVL.inserir(-1);
        arvoreAVL.inserir(1);
        arvoreAVL.inserir(2);

        Assert.assertEquals("(-1)(0)(1)(2)(5)(6)(9)(10)(11)", arvoreAVL.inorder());

        arvoreAVL.remover(10);
        Assert.assertEquals("(-1)(0)(1)(2)(5)(6)(9)(11)", arvoreAVL.inorder());
    }
}
