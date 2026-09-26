package leetcode.design;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Top Interview Questions[easy]: Min Stack
 */
public class MinStackMain_v2 {
    static void main(String[] args) {
        //
    }

    class MinStack {
        Deque<Integer> stack;
        Deque<Integer> minStack;

        MinStack() {
            stack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
        }

        void push(int value) {
            stack.push(value);

            if(minStack.isEmpty() || value <= minStack.peek()) {
                minStack.push(value);
            }
        }

        void pop() {
            int current = stack.pop();
            if(current == minStack.peek()) {
                minStack.pop();
            }
        }

        int top() {
            return stack.peek();
        }

        int getMin() {
            return minStack.peek();
        }
    }
}
