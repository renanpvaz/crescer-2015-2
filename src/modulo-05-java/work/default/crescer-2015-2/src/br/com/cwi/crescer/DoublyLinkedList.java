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
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public String getLast() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<String> list() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void removeFirst() {
        // TODO Auto-generated method stub

    }

    @Override
    public void remove(int index) {
        // TODO Auto-generated method stub

    }

    @Override
    public void add(int index, String value) {
        // TODO Auto-generated method stub

    }


    public Node getNode(int index) {
        // TODO Auto-generated method stub
        return null;
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
