package bst;

import org.junit.Assert;
import org.junit.Test;

public class InserirTest {
    @Test
    public void testInserir() {
        ArvoreBinariaBusca<Integer> integerBinarySearchTree = new ArvoreBinariaBusca<Integer>();
        integerBinarySearchTree.inserir(7);
        integerBinarySearchTree.inserir(5);
        integerBinarySearchTree.inserir(11);


        Assert.assertEquals("(7)(5)(11)", integerBinarySearchTree.preorder());
        Assert.assertEquals("(5)(7)(11)", integerBinarySearchTree.inorder());
        Assert.assertEquals("(5)(11)(7)", integerBinarySearchTree.postorder());

    }
}
