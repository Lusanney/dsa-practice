package io.algoexpert.easy.removelinkedlistduplicates;

public class Main {
    // This is an input class. Do not edit.
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList) {
        LinkedList visitNode = linkedList;
        while(visitNode != null){
            while(visitNode.next != null && visitNode.next.value == visitNode.value){
                visitNode.next = visitNode.next.next;
            }
            visitNode = visitNode.next;
        }

        return linkedList;
    }

    public static void main(String[] args) {

    }
}
