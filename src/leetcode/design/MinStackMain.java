package leetcode.design;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Top Interview Questions[easy]: Min Stack
 */
public class MinStackMain {
    static void main(String[] args) {
        //
    }

    class MinStack {
        Deque<Integer> stack;
        Queue<Integer> minStack;

        MinStack() {
            stack = new ArrayDeque<>();
            minStack = new PriorityQueue<>();
        }

        void push(int value) {
            stack.push(value);
            minStack.offer(value);  // O(log n)
        }

        void pop() {
            int current = stack.pop();
            minStack.remove(current);   // O(n)
        }

        int top() {
            return stack.getFirst();
        }

        int getMin() {
            return minStack.peek();
        }
    }
}
