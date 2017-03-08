package com.example.chapter1;

/**
 * Created by toto on 17/3/8.
 */

class BothWayLink {
    public long mData;
    public BothWayLink previous;
    public BothWayLink next;

    BothWayLink(long insertLinked) {
        mData = insertLinked;
    }

    void showLink() {
        System.out.println("current item is = " + mData);
    }

}

