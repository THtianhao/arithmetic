package com.example.chapter1;

/**
 * Created by toto on 17/2/22.
 */

// bubbleSort.java
// demonstrates bubble sort
// to run this program: C>java BubbleSortApp
////////////////////////////////////////////////////////////////
class ArrayBub {
    private long[] a;                 // ref to array a
    private int nElems;               // number of data items

    //--------------------------------------------------------------
    public ArrayBub(int max)          // constructor
    {
        a = new long[max];                 // create the array
        nElems = 0;                        // no items yet
    }

    //--------------------------------------------------------------
    public void insert(long value)    // put element into array
    {
        a[nElems] = value;             // insert it
        nElems++;                      // increment size
    }

    //--------------------------------------------------------------
    public void display()             // displays array contents
    {
        for (int j = 0; j < nElems; j++)       // for each element,
            System.out.print(a[j] + " ");  // display it
        System.out.println("");
    }

    //--------------------------------------------------------------
    public void bubbleSort() {
        int out, in;

        for (out = nElems - 1; out > 1; out--) {  // outer loop (backward)
            for (in = 0; in < out; in++) {        // inner loop (forward)
                if (a[in] > a[in + 1])       // out of order?
                    swap(in, in + 1);          // swap them
            }
        }
    }  // end bubbleSort()

    public void bubbleSort2() {
        for (int out = nElems - 1; out > 1; out--) {
            for (int in = 0; in < out; in++) {
                if (a[in] > a[in + 1]) {
                    long tmp = a[in + 1];
                    a[in + 1] = a[in];
                    a[in] = tmp;
                }
            }

        }
    }

    public void selectSort() {
        int min = 0;
        for (int out = 0; out < nElems - 1; out++) {
            min = out;
            for (int in = out + 1; in < nElems; in++) {
                if (a[in] < a[min]) {
                    min = in;
                }
            }
            long tmp = a[min];
            a[min] = a[out];
            a[out] = tmp;
        }
    }

    public void insertSort() {
        long tmp = 0;
        int in = 0;
        for (int out = 1; out < nElems; out++) {
            tmp = a[out];
            for ( in = out; in > 0; in--) {
                if (tmp <= a[in-1]) {
                    a[in] = a[in-1];
                } else {
                    break;
                }
            }
            a[in]=tmp;
        }
    }

    //--------------------------------------------------------------
    private void swap(int one, int two) {
        long temp = a[one];
        a[one] = a[two];
        a[two] = temp;
    }
}

////////////////////////////////////////////////////////////////
class BubbleSortApp {
    public static void main(String[] args) {
        int maxSize = 100;            // array size
        ArrayBub arr;                 // reference to array
        arr = new ArrayBub(maxSize);  // create the array

        arr.insert(77);               // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
        arr.display();                // display items
        arr.insertSort();             // bubble sort them
        arr.display();                // display them again
    }  // end main()

//N*(N-1)/2    正常 ，大约是／4
}  // end class BubbleSortApp
////////////////////////////////////////////////////////////////