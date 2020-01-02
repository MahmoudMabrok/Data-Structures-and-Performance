package spelling.tree;

public class Test {
    public static void main(String[] args) {
        MyTree<Integer> integerMyTree = new MyTree<>();

        integerMyTree.insert(10);
        integerMyTree.insert(5);
        integerMyTree.insert(15);
        integerMyTree.insert(9);

        System.out.println("integerMyTree.contains(10) = " + integerMyTree.contains(10));
        System.out.println("integerMyTree.contains(10) = " + integerMyTree.contains(12));
        System.out.println("integerMyTree.contains(10) = " + integerMyTree.contains(14));

        /*integerMyTree.preOrder();
        System.out.println("integerMyTree = " + integerMyTree);
        */
        integerMyTree.postOrder();
        integerMyTree.delete(9);
        integerMyTree.postOrder();

    }
}