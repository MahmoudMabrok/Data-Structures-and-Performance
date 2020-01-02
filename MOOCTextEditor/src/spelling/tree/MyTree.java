package spelling.tree;

public class MyTree<E extends Comparable<? super E>> implements ITree<E> {

    int size;
    private TreeNode<E> root;

    public MyTree() {
        root = new TreeNode<>();
    }

    @Override
    public boolean contains(E toFind) {

        TreeNode<E> curr = root;
        int cmp = 0;
        while (curr != null) {
            cmp = toFind.compareTo(curr.data);
            if (cmp > 0) {
                curr = curr.right;
            } else if (cmp < 0) {
                curr = curr.left;
            } else {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(E data) {
        if (size == 1 && contains(data)) {
            root = null;
            size = 0;
            return true;
        } else if (!contains(data)) {
            throw new IndexOutOfBoundsException();
        }

        TreeNode<E> curr = root; // will hold last
        int cmp = 0;
        while (curr != null) {
            cmp = data.compareTo(curr.data);
            if (cmp > 0) {
                curr = curr.right;
            } else if (cmp < 0) {
                curr = curr.left;
            } else { // found
                if (curr.left == null && curr.right == null) { // leaf node
                    System.out.println("leaf = ");
                    removeParentLink(curr, null);

                } else if (curr.left == null) // has only right child
                {
                    curr.right.parent = curr.parent;
                    removeParentLink(curr, curr.right);

                } else if (curr.right == null) // has only left child
                {
                    curr.left.parent = curr.parent;
                    removeParentLink(curr, curr.left);
                } else { // has two children

                }
                size--;
                return true;
            }
        }

        return false;
    }

    private void removeParentLink(TreeNode<E> curr, TreeNode<E> newNode) {
        // remove link from parent node to current node
        if (curr.parent.isLeft(curr)) {
            curr.parent.left = newNode;
        } else {
            curr.parent.right = newNode;
        }

    }

    @Override
    public void insert(E data) {
        if (size == 0) {    // empty tree
            root = new TreeNode<>(null, data);
        } else {
            TreeNode<E> curr = root; // will hold last
            TreeNode<E> temp = curr; // will hold parent
            int cmp = 0;
            while (curr != null) {
                temp = curr;
                cmp = data.compareTo(curr.data);
                if (cmp > 0) {
                    curr = curr.right;
                } else if (cmp < 0) {
                    curr = curr.left;
                } else {
                    // no handle now
                    return;
                }
            }
            if (cmp > 0) {
                temp.addRightChild(data);
            } else {
                temp.addLeftChild(data);
            }
        }
        size++;
    }

    public void preOrder(TreeNode<E> start) {
        if (start != null) {
            start.visit();
            preOrder(start.left);
            preOrder(start.right);
        }
    }

    @Override
    public void preOrder() {
        preOrder(root);
    }

    @Override
    public void postOrder() {
        postOrder(root);
    }

    public void postOrder(TreeNode<E> start) {
        if (start != null) {
            preOrder(start.left);
            preOrder(start.right);
            start.visit();

        }
    }

    @Override
    public void levelOrder() {
        levelOrder(root);
    }

    public void levelOrder(TreeNode<E> start) {
    }
}

class TreeNode<E> {

    TreeNode<E> parent;
    TreeNode<E> left;
    TreeNode<E> right;
    E data;

    public TreeNode() {
    }

    public TreeNode(TreeNode<E> parent, E data) {
        this.parent = parent;
        this.data = data;
    }

    public void addLeftChild(E val) {
        this.left = new TreeNode<>(this, val);
    }

    public void addRightChild(E val) {
        this.right = new TreeNode<>(this, val);
    }

    public void visit() {
        System.out.println(data.toString());
    }

    public boolean isLeft(TreeNode<E> curr) {
        return left == curr;
    }


}
