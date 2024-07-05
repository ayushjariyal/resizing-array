import java.util.*;

public class ResizingArrayStackOfStrings {

    private String[] s;
    private int N = 0;

    public ResizingArrayStackOfStrings() {
        s = new String[1];
    }

    public void push(String item) {
        if (N == s.length) {
            resize (2 * s.length);
        }
        s[N++] = item;

        System.out.println("\nLength of Stack: " + s.length);
    }

    private void resize(int capacity) {
        String[] copy = new String[capacity];
        for (int i = 0; i < N; i++) {
            copy[i] = s[i];
        }
        s = copy;
    }

    public void pop() {
        String item = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length/4) {
            resize(s.length/2);
        }
        System.out.println(item);
        System.out.println("\nLength of Stack: " + s.length);
        
    }

    public void printStack() {
        for (int i = s.length - 1; i >= 0; i--) {
            System.out.println(s[i]);
        }
    }

    public static void main(String[] args) {
        ResizingArrayStackOfStrings stack = new ResizingArrayStackOfStrings();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to add item to Stack(Yes/No): ");
        String item = scanner.nextLine();

        while (item.equals("yes") || item.equals("Yes")) {

            Scanner x = new Scanner(System.in);
            System.out.print("Enter item: ");
            String string = x.nextLine();

            stack.push(string);
            System.out.println("Total items present in the stack: " + stack.N + "\n");

            Scanner n = new Scanner(System.in);
            System.out.print("Do you want to add item to Stack(Yes/No): ");
            item = n.nextLine();
           
        }
        
        System.out.println("\nItems in Stack: ");
        stack.printStack();
        System.out.println();

        Scanner newScanner = new Scanner(System.in);
        System.out.print("Do you want to pop items from stack(Yes/No): ");
        String b = newScanner.nextLine();

        while (b.equals("Yes") || b.equals("yes")) {
            if(stack.N <= 0) {
                System.out.println("Stack is empty.");
                break;

            }
            else {
                stack.pop();
                System.out.println("Total items present in the stack: " + stack.N + "\n");
                
            }
            Scanner y = new Scanner(System.in);
            System.out.print("Do you want to pop items from stack(Yes/No): ");
            b = y.nextLine();
        }

        System.out.println("\nItems in Stack: ");
        stack.printStack();
        scanner.close();
    }
}