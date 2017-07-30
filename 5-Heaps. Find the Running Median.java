import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

abstract class Heap {
    protected int capacity = 10;
    protected int size = 0;

    int[] items = new int[capacity];

    protected int getLeftChildIndex(int parentIndex) { return 2 * parentIndex + 1; }
    protected int getRightChildIndex(int parentIndex) { return 2 * parentIndex + 2; }
    protected int getParentIndex(int childIndex) { return (childIndex - 1) / 2; }

    protected boolean hasLeftChild(int index) { return getLeftChildIndex(index) < size; }
    protected boolean hasRightChild(int index) { return getRightChildIndex(index) < size; }
    protected boolean hasParent(int index) { return getParentIndex(index) >= 0; }

    protected int leftChild(int index) { return items[getLeftChildIndex(index)]; }
    protected int rightChild(int index) { return items[getRightChildIndex(index)]; }
    protected int parent(int index) { return items[getParentIndex(index)]; }

    protected void swap(int indexOne, int indexTwo) {
        int temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    protected void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0) { throw new IllegalStateException(); }
        return items[0];
    }

    public int poll() {
        if (size == 0) { throw new IllegalStateException(); }
        int item = items[0];
        items[0] = items[size - 1];
        size--;
        heapifyDown();
        return item;
    }

    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item;
        size++;
        heapifyUp();
    }

    abstract protected void heapifyUp();

    abstract protected void heapifyDown();
}

class MinIntHeap extends Heap {
    protected void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    protected void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }
}

class MaxIntHeap extends Heap {
    protected void heapifyUp() {
        int index = size - 1;
        while (hasParent(index) && parent(index) < items[index]) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    protected void heapifyDown() {
        int index = 0;
        while (hasLeftChild(index)) {
            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) > leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (items[index] < items[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }
            index = smallerChildIndex;
        }
    }
}

public class Solution {

    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static void main(String[] args) {
        Heap heap = new MaxIntHeap();
        heap.add(4);
        heap.add(10);
        heap.add(2);
        heap.add(20);
        heap.add(3);
        heap.add(5);
        heap.add(6);
        heap.add(1);

        for (int i = 0; i < heap.items.length; i++) {
            System.out.println(heap.items[i]);
        }
    }
}
