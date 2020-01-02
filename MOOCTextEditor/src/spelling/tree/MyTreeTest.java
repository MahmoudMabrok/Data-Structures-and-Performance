package spelling.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MyTreeTest {

    MyTree<Integer> tree;

    @Before
    public void setUp() throws Exception {
        tree = new MyTree<>();
        tree.insert(10);
        tree.insert(5);
        tree.insert(15);
        tree.insert(9);
    }

    @Test
    public void contains() {
        tree.insert(10);
        tree.insert(5);

        boolean res = tree.contains(10);
        assertTrue(res);
        res = tree.contains(7);
        assertFalse(res);
    }

    @Test
    public void deleteLeaf() {
        tree.delete(15); // a leaf node
        boolean res = tree.contains(15);
        assertFalse(res);
        tree.postOrder();

    }

    @Test
    public void deleteHasChild() {
        tree.delete(5);  // node with one child
        boolean res = tree.contains(5);
        assertFalse(res);
        tree.postOrder();
    }

    @Test
    public void deleteHasTwoChild() {
        tree.delete(10); // node with 2 children
        boolean res = tree.contains(10);
        assertFalse(res);
        tree.postOrder();
    }

    @Test
    public void insert() {
    }

    @Test
    public void preOrder() {
    }

    @Test
    public void levelOrder() {
    }
}