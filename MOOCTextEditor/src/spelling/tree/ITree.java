package spelling.tree;

public interface ITree<E> {
    boolean contains(E toFind);

    void insert(E data);

    void preOrder();

    void postOrder();

    void levelOrder();

    boolean delete(E data);
}
