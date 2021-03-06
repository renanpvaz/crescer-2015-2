package br.com.cwi.crescer;

import java.util.ArrayList;
import java.util.List;

public class DoublyLinkedList implements LinkableList {

    private Node first, last;

    public DoublyLinkedList() {
    }

    @Override
    public void addFirst(String value) {
        Node node = new Node(value);

        if (isEmpty()) {

            last = node;

        } else {

            node.setNext(first);
            first.setPrevious(node);
        }

        first = node;
    }

    @Override
    public void addLast(String value) {
        Node node = new Node(value);

        if (isEmpty()) {

            first = node;

        } else {

            node.setPrevious(last);
            last.setNext(node);
        }

        last = node;
    }

    @Override
    public String getFirst() {
        return first.getValue();
    }

    @Override
    public String getLast() {
        return last.getValue();
    }

    @Override
    public List<String> list() {
        ArrayList<String> lista = new ArrayList<String>();
        Node node = first;

        while (node != null) {
            lista.add(node.getValue());
            node = node.getNext();
        }

        return lista;
    }

    public List<String> invertedList() {
        ArrayList<String> lista = new ArrayList<String>();
        Node node = last;

        while (node != null) {
            lista.add(node.getValue());
            node = node.getPrevious();
        }

        return lista;
    }

    @Override
    public void removeFirst() {
        first = first.getNext();

        if (first == last) {
            last = last.getPrevious();
        }
    }

    @Override
    public void remove(int index) {
        Node anterior = getNode(index - 1);
        Node proximo =  getNode(index).getNext();

        anterior.setNext(proximo);
    }

    @Override
    public void add(int index, String value) {
        Node anterior = getNode(index - 1);
        Node proximo =  getNode(index);

        anterior.setNext(new Node(value, proximo, anterior));
    }

    public Node getNode(int index) {
        Node node = first;

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    protected class Node {

        private String value;

        private Node next;

        private Node previous;

        public Node(String value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Node(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPrevious() {
            return previous;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }
}
