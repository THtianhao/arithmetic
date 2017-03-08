package com.example.chapter1;

/**
 * Created by toto on 17/2/28.
 */

public class SortedList {

    public Link mFirstList = null;

    public void insert(long value) {
        Link newLink = new Link(value);
        Link current = mFirstList;
        Link mPrevious = null;
        while (current != null && current.dData < newLink.dData) {
            mPrevious = current;
            current = current.next;
        }
        if (mPrevious == null) {
            mFirstList = newLink;
            newLink.next = current;
        } else {
            mPrevious.next = newLink;
            newLink.next = current;
        }
    }


    public boolean isEmpty() {
        return mFirstList == null;
    }

    public void show() {
        Link tmp = mFirstList;
        while (tmp != null) {
            System.out.println(tmp.dData);
            tmp = tmp.next;
        }
    }
}

class SortedListApp {
    public static void main(String[] args) {
        SortedList sortedList = new SortedList();
        sortedList.insert(14);
        sortedList.insert(6);
        sortedList.insert(9);
        sortedList.insert(18);
        sortedList.insert(46);
        sortedList.insert(38);
        sortedList.show();
    }
}
