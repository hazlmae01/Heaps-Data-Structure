public class DumdumHeap {
    private int[] heap;     // Array to store heap elements
    private int size;       // Current number of elements in the heap
    private int capacity;   // Maximum capacity of the heap

    // Constructor to initialize the heap with a given capacity
    public DumdumHeap(int capacity) {
        this.capacity = capacity;
        this.heap = new int[capacity];
        this.size = 0;
    }

    // Helper method to get the parent index
    private int parent(int index) {
        return (index - 1) / 2;
    }

    // Helper method to get the left child index
    private int leftChild(int index) {
        return 2 * index + 1;
    }

    // Helper method to get the right child index
    private int rightChild(int index) {
        return 2 * index + 2;
    }

    // Swap two elements in the heap
    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    // Insert a new value into the heap
    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert " + value);
            return;
        }
        // Place the value at the end of the heap
        heap[size] = value;
        size++;
        // Restore the heap property by bubbling up
        bubbleUp(size - 1);
    }

    // Restore the heap property by bubbling up
    private void bubbleUp(int index) {
        int parentIndex = parent(index);
        while (index > 0 && heap[index] > heap[parentIndex]) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = parent(index);
        }
    }

    // Delete and return the maximum value (root of the heap)
    public int deleteMax() {
        if (size == 0) {
            System.out.println("Heap is empty.");
            return -1;  // Indicate failure
        }
        int max = heap[0];
        heap[0] = heap[size - 1];  // Replace root with the last element
        size--;
        // Restore the heap property by heapifying down
        heapifyDown(0);
        return max;
    }

    // Restore the heap property by heapifying down
    private void heapifyDown(int index) {
        int largest = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }
        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }
        if (largest != index) {
            swap(index, largest);
            heapifyDown(largest);
        }
    }

    // Peek at the maximum value (root) without removing it
    public int peek() {
        if (size == 0) {
            System.out.println("Heap is empty.");
            return -1;
        }
        return heap[0];
    }

    // Print the heap elements
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }

    // Main method to demonstrate heap operations
    public static void main(String[] args) {
        DumdumHeap heap = new DumdumHeap(10);

        System.out.println("Inserting values into the heap...");
        heap.insert(15);
        heap.insert(10);
        heap.insert(30);
        heap.insert(5);
        heap.insert(20);

        System.out.println("Heap elements:");
        heap.printHeap();

        System.out.println("Max value (peek): " + heap.peek());

        System.out.println("Deleting max value: " + heap.deleteMax());
        System.out.println("Heap after deleting max:");
        heap.printHeap();

        System.out.println("Deleting max value: " + heap.deleteMax());
        System.out.println("Heap after deleting max:");
        heap.printHeap();
    }
}
