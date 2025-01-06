class Queue {
    private int[] queue; 
    private int front,capacity,size;
    public Queue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.front = 0;
        this.size = 0;
    }
    public void enqueue(int data) {
        if (size == capacity) {
            System.out.println("Queue is full");
            return;
        }
        queue[front + size] = data;
        size++;
    }
    public void dequeue() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }

        // Shift all elements to the left by one position
        for (int i = 1; i < size; i++) {
            queue[i - 1] = queue[i];
        }

        // Reduce the size
        size--;
    }

    // Method to display the queue elements
    public void display() {
        if (size == 0) {
            System.out.println("Queue is empty");
            return;
        }

        // Print all elements
        for (int i = 0; i < size; i++) {
            System.out.print(queue[i] + " <- ");
        }
        System.out.println();
    }

    // Method to print the front element of the queue
    public void getFront() {
        if (size == 0) {
            System.out.println("Queue is empty");
        } else {
            System.out.println("Front Element is: " + queue[front]);
        }
    }
}

public class queue1 {
    public static void main(String[] args) {
        // Create a queue with capacity 4
        Queue q = new Queue(4); 

        q.display(); 

        q.enqueue(20); 
        q.enqueue(30);
        q.enqueue(40);
        q.enqueue(50);

        q.display();

        q.enqueue(60);

        q.display();
      
        // Delete elements
        q.dequeue(); 
        q.dequeue();
        System.out.println("After two node deletions:");

        q.display();
      
        // Get the front element
        q.getFront();
    }
}
