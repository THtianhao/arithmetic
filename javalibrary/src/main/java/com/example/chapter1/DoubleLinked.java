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
    BothWayLink mLastLinked = null;

    boolean isEmpty() {
        if (mFirstLinked == null) {
            return true;
        }
        return false;
    }

    //在链表的头插入
    BothWayLink insertFirst(long insertLinked) {
        BothWayLink mNewLink = new BothWayLink(insertLinked);
        if (mLastLinked == null) {
            mLastLinked = mNewLink;
        } else {
            mFirstLinked.previous = mNewLink;

        }
        mNewLink.next = mFirstLinked;
        mFirstLinked = mNewLink;
        return mNewLink;
    }

    //在链表末尾插入
    BothWayLink insertLast(long insertLinked) {
        BothWayLink mNewLink = new BothWayLink(insertLinked);
        if (mFirstLinked == null) {
            mFirstLinked = mNewLink;
        } else {
            mLastLinked.next = mNewLink;
            mNewLink.previous = mLastLinked;
        }
        mLastLinked = mNewLink;
        return mNewLink;
    }

    //删除第一个
    BothWayLink deleteFirst() {
        BothWayLink tmp;
        if (isEmpty()) {
            return null;
        }
        tmp = mFirstLinked;
        mFirstLinked = mFirstLinked.next;
        mFirstLinked.previous = null;
        if (mLastLinked.previous == null) {
            mLastLinked = null;
        }
        return tmp;
    }

    //删除最后一个
    BothWayLink deleteLast() {
        BothWayLink tmp;
        if (isEmpty()) {
            return null;
        }
        tmp = mLastLinked;
        if (mFirstLinked.next == null) {
            mFirstLinked = null;
        } else {
            mLastLinked.previous.next = null;
        }
        mLastLinked = mLastLinked.previous;
        return tmp;
    }

    //在节点之后删除
    void insertAfter(long key, long data) {
        if (isEmpty()) {
            return;
        }
        BothWayLink tempLink = mFirstLinked;
        while (tempLink != null && tempLink.mData != key) {
            tempLink = tempLink.next;
        }
        if (tempLink == null) {
            return;
        }
        BothWayLink newLink = new BothWayLink(data);
        if (tempLink == mLastLinked) {
            mLastLinked = newLink;
        } else {
            tempLink.next.previous = newLink;
            newLink.next = tempLink.next;

        }
        tempLink.next = newLink;
        newLink.previous = tempLink;

    }

    //删除指定的节点
    void deleteKey(long key) {
        if (isEmpty()) {
            return;
        }
        BothWayLink currentLink = mFirstLinked;
        while (currentLink != null && currentLink.mData != key) {
            currentLink = currentLink.next;
        }
        if (currentLink == null) {
            return;
        }
        if (currentLink == mFirstLinked) {
            mFirstLinked = currentLink.next;
            currentLink.next.previous = null;
        } else if (currentLink == mLastLinked) {
            mLastLinked = currentLink.previous;
            currentLink.previous.next = null;
        } else {
            currentLink.previous.next = currentLink.next;
            currentLink.next.previous = currentLink.previous;
        }
    }

    //显示节点
    void display() {
        if (isEmpty()) {
            return;
        }
        BothWayLink mCurrentLink = mFirstLinked;
        while (mCurrentLink != null) {
            mCurrentLink.showLink();
            mCurrentLink = mCurrentLink.next;
        }
    }
}

class DoubleLinedApp {
    public static void main(String[] args) {
        DoubleLinked doubleLinked = new DoubleLinked();
        doubleLinked.insertFirst(22);
        doubleLinked.insertFirst(44);
        doubleLinked.insertFirst(66);

        doubleLinked.insertLast(11);
        doubleLinked.insertLast(33);
        doubleLinked.insertLast(55);

        doubleLinked.display();
        System.out.println("-----------------");

        doubleLinked.deleteFirst();
        doubleLinked.deleteLast();
        doubleLinked.deleteKey(11);

        doubleLinked.display();
        System.out.println("-----------------");
        doubleLinked.insertAfter(22, 77);
        doubleLinked.insertAfter(33, 88);

        doubleLinked.display();

    }
}

