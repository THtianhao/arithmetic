package com.example.chapter1;

import java.io.IOException;

/**
 * Created by toto on 17/2/24.
 */

public class PriorityQueue {
    public static final int maxSize = 15;
    public long[] mPriorityQueue;
    public int mItemCount;

    public PriorityQueue() {
        mPriorityQueue = new long[maxSize];
        mItemCount = 0;
    }

    void insert(long insert) {
        if (mItemCount == 0) {
            mPriorityQueue[mItemCount++] = insert;
        } else {
            if (isFull()) {
                return;
            }
            int i;
            for (i = mItemCount; i > 0; i--) {

                if (insert > mPriorityQueue[i - 1]) {
                    mPriorityQueue[i] = mPriorityQueue[i - 1];
                } else {
                    break;
                }
            }
            mPriorityQueue[i] = insert;
            mItemCount++;
        }
    }

    long remove() {
        return mPriorityQueue[--mItemCount];
    }

    boolean isFull() {
        return mItemCount == maxSize - 1;
    }


}

class mainMethod {
    public static void main(String[] args) throws IOException {
        PriorityQueue mQueue = new PriorityQueue();
        mQueue.insert(30);
        mQueue.insert(10);
        mQueue.insert(20);
        mQueue.insert(50);
        mQueue.insert(40);
        int count=mQueue.mItemCount;
        for (int i = 0; i < count; i++) {
            long item = mQueue.remove();
            System.out.println(item);
        }
    }
}
