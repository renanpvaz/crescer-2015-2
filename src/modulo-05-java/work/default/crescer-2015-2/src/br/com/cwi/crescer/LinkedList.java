package br.com.cwi.crescer;

import java.util.ArrayList;
import java.util.List;

public class LinkedList implements LinkableList {

    private Node last, first;

    @Override
    public void addFirst(String value) {
        Node node = new Node(value, first);
        
        if (first == null) {
        	
            last = node;
        }
        
        first = node;
    }

    @Override
    public void addLast(String value) {
    	Node node = new Node(value);
    	
        if (first == null) {
        	
            first = node;
        }
        
        last.setNext(node);
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

    @Override
    public void removeFirst() {
        first = first.getNext();
    }

    @Override
    public void remove(int index) {
        getNode(index - 1).setNext(getNode(index).getNext());
    }

    @Override
    public void add(int index, String value) {
        getNode(index - 1).setNext(new Node(value, getNode(index)));
    }

    public Node getNode(int index) {
        Node node = first;

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node;
    }

    protected class Node {

        private String value;

        private Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
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

    }
}
