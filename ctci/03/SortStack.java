import java.util.*;

public class SortStack
{
    public static Stack sort(Stack s1)
    {
        Stack<Integer> s2 = new Stack<>();

        while (!s1.isEmpty()) {
            int item = (int)s1.pop();

            while(!s2.isEmpty() && s2.peek() > item) {
                s1.push(s2.pop());
            }

            s2.push(tmp);



        }

        while(!s1.isEmpty()) {
            s2.push((int)s1.pop());
        }

        return s2;
    }

    public static void main(String[] args)
    {
        Stack<Integer> s1 = new Stack<Integer>();
        s1.push(7);
        s1.push(3);
        s1.push(8);
        s1.push(2);
        s1.push(4);

        Stack s2 = sort(s1);

        while (!s2.isEmpty()) {
            System.out.println(s2.pop());
        }
    }
}
