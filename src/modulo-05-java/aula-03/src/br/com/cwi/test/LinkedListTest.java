package br.com.cwi.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.cwi.crescer.LinkedList;

public class LinkedListTest {

    @Test
    public void insereTresNodosEverificaQueOUltimoEOPrimeiro() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        assertEquals(linkedList.getFirst(), "terceiro");
        assertEquals(linkedList.getLast(), "primeiro");
    }

    @Test
    public void adicionaTresNodosELista() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        assertEquals(linkedList.list().toString(), "[terceiro, segundo, primeiro]");
    }

    @Test
    public void removeOPrimeiroEVerificaQualONovoPrimeiro() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.removeFirst();
        assertEquals(linkedList.getFirst(), "primeiro");
    }

    @Test
    public void adicionaTresNodosERemoveOSegundo() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        linkedList.remove(1);
        assertEquals(linkedList.list().toString(), "[terceiro, primeiro]");
    }

    @Test
    public void adicionaTresNodosEAdicionaNaSegundaPosicao() {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst("primeiro");
        linkedList.addFirst("segundo");
        linkedList.addFirst("terceiro");
        linkedList.add(1, "segundo");
        assertEquals(linkedList.list().toString(), "[terceiro, segundo, segundo, primeiro]");
    }

}
