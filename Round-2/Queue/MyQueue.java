import java.util.Stack;

class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public MyQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Push element x to the back of queue
    public void push(int x) {
        stack1.push(x);
    }

    // Removes the element from the front of queue and returns it
    public int pop() {
        moveStack1ToStack2();
        return stack2.pop();
    }

    // Get the front element
    public int peek() {
        moveStack1ToStack2();
        return stack2.peek();
    }

    // Returns whether the queue is empty
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Helper method: move elements from stack1 to stack2
    private void moveStack1ToStack2() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            } 
        }
    }

    // --- Main method to test the queue ---
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        
        myQueue.push(1); // queue: [1]
        myQueue.push(2); // queue: [1, 2]
        
        System.out.println("Peek: " + myQueue.peek()); // should print 1
        System.out.println("Pop: " + myQueue.pop());   // should print 1
        System.out.println("Empty: " + myQueue.empty()); // should print false

        myQueue.push(3); // queue: [2, 3]
        System.out.println("Pop: " + myQueue.pop());   // should print 2
        System.out.println("Peek: " + myQueue.peek()); // should print 3
        System.out.println("Empty: " + myQueue.empty()); // should print false

        myQueue.pop(); // queue is now empty
        System.out.println("Empty after popping all: " + myQueue.empty()); // should print true
    }
}
