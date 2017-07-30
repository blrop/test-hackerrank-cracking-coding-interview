import java.util.*;
import java.math.*;

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

    public String getContent() {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += items[i] + ", ";
        }
        return result;
    }

    public int size() {
        return size;
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

            if (items[index] > items[smallerChildIndex]) {
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
        Heap maxHeap = new MaxIntHeap();
        Heap minHeap = new MinIntHeap();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a_i=0; a_i < n; a_i++){
            int nextInt = in.nextInt();

            if (minHeap.size() == 0 && maxHeap.size() != 0) { // look to max is enough
                if (nextInt < maxHeap.peek()) {
                    maxHeap.add(nextInt);
                } else {
                    minHeap.add(nextInt);
                }
            } else if (maxHeap.size() == 0 && minHeap.size() != 0) { // look to min is enough
                if (nextInt > minHeap.peek()) {
                    minHeap.add(nextInt);
                } else {
                    maxHeap.add(nextInt);
                }
            } else if (maxHeap.size() == 0 && minHeap.size() == 0) { // both empty - no matter where to add
                maxHeap.add(nextInt);
            } else { // both not empty - normal situation
                if (nextInt > minHeap.peek()) {
                    minHeap.add(nextInt);
                } else {
                    maxHeap.add(nextInt);
                }
            }

            if (Math.abs(minHeap.size() - maxHeap.size()) > 1) {
                if (minHeap.size() > maxHeap.size()) {
                    maxHeap.add(minHeap.poll());
                } else {
                    minHeap.add(maxHeap.poll());
                }
            }

            //System.out.println("min: " + minHeap.getContent());
            //System.out.println("max: " + maxHeap.getContent());

            double result;
            if (minHeap.size() == maxHeap.size()) {
                result = (minHeap.peek() + maxHeap.peek()) / 2d;
            } else {
                if (minHeap.size() > maxHeap.size()) {
                    result = minHeap.peek();
                } else {
                    result = maxHeap.peek();
                }
            }

            result = round(result, 1);
            System.out.println(result);
        }
    }
}
