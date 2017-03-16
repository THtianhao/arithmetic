package com.example.chapter1;

/**
 * Created by toto on 17/3/16.
 */

public class ListIterator {
    private Link previous;
    private Link current;
    private LinkList linkList;

    public void reset() {
        current = linkList.getFirst();
        previous = null;
    }

    public void nextLink() {
        previous = current;
        current = current.next;
    }

    public boolean atEnd() {
        return current.next == null;
    }

    public void insetAfter(long data) {
        Link newLink = new Link(data);
        if (linkList.isEmpty()) {
            linkList.setFirst(newLink);
            current = newLink;
        } else {
            newLink.next = current.next;
            current.next = newLink;
            previous = current;
            current = newLink;

        }
    }

    public void insertBefore(long data) {
        Link newLink = new Link(data);
        if (previous == null) {
            newLink.next = linkList.getFirst();
            linkList.setFirst(newLink);
            reset();
        } else {
            newLink.next = current;
            previous.next = newLink;
            current = newLink;
        }
    }

    public long deleteCurrent() {
        long data = current.dData;
        if (current == linkList.getFirst()) {
            linkList.setFirst(current.next);
            reset();
        } else {
            previous.next = current.next;
            if (atEnd()) {
                reset();
            } else {
                current = current.next;
            }
        }
        return data;
    }

}

class ListIteratorApp {
    public static void main(String[] args) {

    }
}
