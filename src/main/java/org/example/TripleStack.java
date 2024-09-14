/*
The "Three in One" problem involves implementing a data structure that simulates three stacks using a single array. Each stack should operate independently, and we need to ensure that operations on one stack do not interfere with the others.

Here's how you can approach the problem:

Define the Array Structure:

Use a single array to represent the storage for three stacks.
Maintain separate pointers (or indices) for each stack to keep track of the top of each stack.
Stack Operations:

Push: Add an element to the top of a specified stack.
Pop: Remove an element from the top of a specified stack.
Peek: View the top element of a specified stack without removing it.
Is Empty: Check if a specified stack is empty.
Java Implementation
Here's a detailed Java implementation of the "Three in One" problem:
*/

public class TripleStack {
    private int[] stackArray;   // The array to hold the stacks
    private int[] stackSizes;   // Array to keep track of the sizes of each stack
    private int stackCapacity;  // Capacity of each stack

    // Initialize the triple stack
    public TripleStack(int stackSize) {
        stackCapacity = stackSize;
        stackArray = new int[stackSize * 3];
        stackSizes = new int[3];
    }

    // Push an element onto the specified stack
    public void push(int stackNum, int value) {
        if (stackNum < 0 || stackNum >= 3) {
            throw new IllegalArgumentException("Invalid stack number.");
        }
        
        // Check if the stack has reached its capacity
        if (stackSizes[stackNum] >= stackCapacity) {
            throw new StackOverflowError("Stack " + stackNum + " is full.");
        }
        
        // Calculate the index in the array for the stack
        int index = stackNum * stackCapacity + stackSizes[stackNum];
        stackArray[index] = value;
        stackSizes[stackNum]++;
    }

    // Pop an element from the specified stack
    public int pop(int stackNum) {
        if (stackNum < 0 || stackNum >= 3) {
            throw new IllegalArgumentException("Invalid stack number.");
        }
        
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        
        // Calculate the index in the array for the stack
        int index = stackNum * stackCapacity + stackSizes[stackNum] - 1;
        int value = stackArray[index];
        stackArray[index] = 0;  // Clear the value (optional)
        stackSizes[stackNum]--;
        return value;
    }

    // Peek the top element of the specified stack
    public int peek(int stackNum) {
        if (stackNum < 0 || stackNum >= 3) {
            throw new IllegalArgumentException("Invalid stack number.");
        }
        
        if (isEmpty(stackNum)) {
            throw new EmptyStackException();
        }
        
        // Calculate the index in the array for the stack
        int index = stackNum * stackCapacity + stackSizes[stackNum] - 1;
        return stackArray[index];
    }

    // Check if the specified stack is empty
    public boolean isEmpty(int stackNum) {
        if (stackNum < 0 || stackNum >= 3) {
            throw new IllegalArgumentException("Invalid stack number.");
        }
        return stackSizes[stackNum] == 0;
    }

    // Main method for testing
    public static void main(String[] args) {
        TripleStack tripleStack = new TripleStack(5);

        // Test stack 0
        tripleStack.push(0, 1);
        tripleStack.push(0, 2);
        System.out.println(tripleStack.peek(0)); // Should print 2
        System.out.println(tripleStack.pop(0));  // Should print 2
        System.out.println(tripleStack.peek(0)); // Should print 1

        // Test stack 1
        tripleStack.push(1, 10);
        tripleStack.push(1, 20);
        System.out.println(tripleStack.peek(1)); // Should print 20
        System.out.println(tripleStack.pop(1));  // Should print 20
        System.out.println(tripleStack.peek(1)); // Should print 10

        // Test stack 2
        tripleStack.push(2, 100);
        tripleStack.push(2, 200);
        System.out.println(tripleStack.peek(2)); // Should print 200
        System.out.println(tripleStack.pop(2));  // Should print 200
        System.out.println(tripleStack.peek(2)); // Should print 100
    }
}
