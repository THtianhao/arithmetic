package com.example.chapter1;

/**
 * Created by toto on 17/3/2.
 */

class SortList {
    public Link mFirst = null;

    public void sortedList(Link[] links) {
        for (int i = 0; i < links.length; i++) {
            Link link = links[i];
            insertLink(link);
        }
    }

    public void insertLink(Link link) {
        Link mCurrent = mFirst;
        Link mPrevious = null;
        while (mCurrent != null && mCurrent.dData < link.dData) {
            mPrevious = mCurrent;
            mCurrent = mCurrent.next;
        }
        if (mPrevious == null) {
            mFirst = link;
            link.next = mCurrent;
        } else {
            mPrevious.next = link;
            link.next = mCurrent;
        }

    }

    public Link remove() {
        if (mFirst == null) {
            return null;
        }
        Link tmp = mFirst;
        mFirst = mFirst.next;
        return tmp;
    }
}

class SortedLinkApp {
    public static void main(String[] args) {
        SortList sortClass = new SortList();
        Link[] list = new Link[8];
        for (int i = 0; i < 8; i++) {
            Link mLinkItem = new Link((long) (Math.random()*100));
            list[i] = mLinkItem;
        }
        sortClass.sortedList(list);
        while (sortClass.mFirst != null) {
            System.out.println(sortClass.remove().dData);
        }

    }
}