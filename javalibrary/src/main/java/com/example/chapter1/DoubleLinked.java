package com.example.chapter1;

/**
 * Created by toto on 17/3/8.
 */
/*双向列表
双向列表里面有两个节点，分表表示头节点和尾节点，可以理解为它们是头节点和尾节点的Copy
插入头最后替换mFristLinked 插入尾替换mLastLined
*/
public class DoubleLinked {
    BothWayLink mFirstLinked = null;
    BothWayLink mLastLined = null;

    boolean isEmpty() {
        if (mFirstLinked == null) {
            return true;
        }
        return false;
    }

    BothWayLink insertFirst(long insertLinked) {
        BothWayLink mNewLink = new BothWayLink(insertLinked);
        if (mLastLined == null) {
            mLastLined = mNewLink;
        } else {
            mFirstLinked.previous = mNewLink;

        }
        mNewLink.next = mFirstLinked;
        mFirstLinked = mNewLink;
        return mNewLink;
    }

    BothWayLink insertLast(long insertLinked) {
        BothWayLink mNewLink = new BothWayLink(insertLinked);
        if (mLastLined == null) {
            mLastLined = mNewLink;
        } else {

        }
        return mNewLink;
    }
}

class DoubleLinedApp {
    public static void main(String[] args) {
        DoubleLinked doubleLinked = new DoubleLinked();
        doubleLinked.insertFirst(10);
        doubleLinked.insertFirst(10);

    }
}

