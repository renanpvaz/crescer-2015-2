package br.com.cwi.crescer;

import java.util.List;

public class DoublyLinkedList implements LinkableList {

    private Node first, last;

    public DoublyLinkedList() {
    }

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
            
        } else {
        	
        	node.setNext(first);
        }

        first.setPrevious(node);
        last = node;
    }

    @Override
    public String getFirst() {  
        return first;
    }

    @Override
    public String getLast() {
        return last;
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
    	last.setPrevious(first);
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
    	
    	anterior.setNext(new Node(value, proximo));
    }

    public Node getNode(int index) {
    	Node node = first;

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node;
    }

    public boolean isEmpty() {
        return this.getFirst() == null;
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
