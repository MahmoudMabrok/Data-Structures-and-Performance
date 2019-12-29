package textgen;

import java.util.AbstractList;

/**
 * A class that implements a doubly linked list
 *
 * @author UC San Diego Intermediate Programming MOOC team
 *
 * @param <E> The type of the elements stored in the list
 */
public class MyLinkedList<E> extends AbstractList<E> {

    ListNode<E> head;
    ListNode<E> tail;
    int size;

    /**
     * Create a new empty LinkedList
     */
    public MyLinkedList() {
        head = new ListNode<>(null);
        tail = new ListNode<>(null);
        // link head and tail
        head.next = tail;
        tail.prev = head;
    }

    /**
     * Appends an element to the end of the list
     *
     * @param element The element to add
     */
    public boolean add(E element) {
        ListNode<E> current = new ListNode<>(element);
        // empty list
        if (size == 0) {
            link(head, current, tail);
        } else {
            // first get last node then link them 
            ListNode<E> left = tail.prev;
            link(left, current, tail);
        }
        size++;
        return true;
    }

    private void link(ListNode<E> left, ListNode<E> current, ListNode<E> right) {
        current.next = left.next;
        current.prev = left;
        left.next = current;

        right.prev = current;

    }

    /**
     * Get the element at position index
     *
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E get(int index) {
        if (size == 0 || index < 0 || index > size) {
            throw new IndexOutOfBoundsException("invalid get");
        } else {
            ListNode<E> temp = head;
            while (index > 0 && temp != null) {
                temp = temp.next;
                index--;
            }
            return temp.data;
        }
    }

    /**
     * Add an element to the list at the specified index
     *
     * @param The index where the element should be added
     * @param element The element to add
     */
    public void add(int index, E element) {
        // TODO: Implement this method
    }

    /**
     * Return the size of the list
     */
    public int size() {
        // TODO: Implement this method
        return -1;
    }

    /**
     * Remove a node at the specified index and return its data element.
     *
     * @param index The index of the element to remove
     * @return The data element removed
     * @throws IndexOutOfBoundsException If index is outside the bounds of the
     * list
     *
     */
    public E remove(int index) {
        // TODO: Implement this method
        return null;
    }

    /**
     * Set an index position in the list to a new element
     *
     * @param index The index of the element to change
     * @param element The new element
     * @return The element that was replaced
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public E set(int index, E element) {
        // TODO: Implement this method
        return null;
    }
}

class ListNode<E> {

    ListNode<E> prev;
    ListNode<E> next;
    E data;

    // TODO: Add any other methods you think are useful here
    // E.g. you might want to add another constructor
    public ListNode(E e) {
        this.data = e;
        this.prev = null;
        this.next = null;
    }

}
