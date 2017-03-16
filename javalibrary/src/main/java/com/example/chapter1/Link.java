package com.example.chapter1;

/**
 * Created by toto on 17/2/25.
 */

class Link {
    public long dData;
    public Link next;

    public Link(long dData) {
        this.dData = dData;
    }

    public void displayLink() {
        System.out.println("dData = " + dData);
    }
}

class LinkList {
    private Link mFirst;

    LinkList() {
        mFirst = null;
    }

    public Link getFirst() {
        return mFirst;
    }

    public boolean isEmpty() {
        return mFirst == null;
    }

    public void insertFirst(int menber) {
        Link newLink = new Link(menber);
        newLink.next = mFirst;
        mFirst = newLink;
    }

    public Link deleteFirst() {
        Link temp = mFirst;
        mFirst = mFirst.next;
        return temp;
    }

    public void displayLinkList() {
        if (!isEmpty()) {
            Link current = mFirst;
            while (current != null) {
                current.displayLink();
                current = current.next;
            }
        }
    }

    public ListIterator getIterator() {
        return new ListIterator();
    }

    public Link find(int key) {
        Link currentItem = mFirst;
        while (currentItem != null) {
            if (currentItem.dData == key) {
                return currentItem;
            }
            currentItem = currentItem.next;
        }
        return null;
    }

    public Link delete(int key) {
        Link previousLink = mFirst;
        Link currentLink = mFirst;
        while (currentLink != null) {
            if (currentLink.dData == key) {
                if (currentLink == mFirst) {
                    mFirst = mFirst.next;
                    return currentLink;
                } else {
                    previousLink.next = currentLink.next;
                    return currentLink;
                }
            }
            previousLink = currentLink;
            currentLink = currentLink.next;
        }
        return null;
    }

    public void setFirst(Link first) {
        this.mFirst = first;
    }
}

class LinkListApp {
    public static void main(String[] args) {
        LinkList newList = new LinkList();
        newList.insertFirst(5);
        newList.insertFirst(6);
        newList.insertFirst(7);
        newList.displayLinkList();

        System.out.println("delete is " + newList.delete(7).dData);
        newList.displayLinkList();


//        while (!newList.isEmpty()) {
//            System.out.println("delete is " + newList.deleteFirst().dData);
//        }
    }
}
