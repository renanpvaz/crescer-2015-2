package br.com.cwi.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.cwi.crescer.DoublyLinkedList;

public class DoublyLinkedListTest {

    @Test
    public void insereTresNodosEverificaQueOUltimoEOPrimeiro() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        assertEquals(linkedList.getFirst(), "terceiro");
        assertEquals(linkedList.getLast(), "primeiro");
    }

    @Test
    public void adicionaTresNodosELista() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        assertEquals(linkedList.list().toString(), "[terceiro, segundo, primeiro]");
    }

    @Test
    public void adicionaTresNodosEListaInvertidamente() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        assertEquals(linkedList.invertedList().toString(), "[primeiro, segundo, terceiro]");
    }

    @Test
    public void removeOPrimeiroEVerificaQualONovoPrimeiro() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.removeFirst();
        assertEquals(linkedList.getFirst(), "primeiro");
    }

    @Test
    public void adicionaTresNodosERemoveOSegundo() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        linkedList.remove(1);
        assertEquals(linkedList.list().toString(), "[terceiro, primeiro]");
    }

    @Test
    public void adicionaTresNodosEAdicionaNaSegundaPosicao() {
        DoublyLinkedList linkedList = new DoublyLinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        linkedList.add(1, "segundo");
        assertEquals(linkedList.list().toString(), "[terceiro, segundo, segundo, primeiro]");
    }


}
