package istack;

public class MyStackTest {
    public static void main(String[] args) {
        IStack<Integer> stack = new MyStack<>();
        // Stack 은 LIFO
        for (int i=0; i<9; i++) {
            stack.push(i+1);
        }
        for (int i=0; i<9; i++) {
            System.out.print(stack.pop() + " ");
        }



    }

}
