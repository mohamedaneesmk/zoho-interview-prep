import java.util.Stack;

public class DecodeString {

    public static void main(String[] args) {
        String str = "3[a]2[bc]";
        System.out.println(decodeString(str)); // aaabcbc
    }

    private static String decodeString(String s) {
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> stringStack = new Stack<>();

        StringBuilder curr = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0'); // handle multi-digit
            }
            else if (ch == '[') {
                countStack.push(num);
                stringStack.push(curr);
                curr = new StringBuilder();
                num = 0;
            }
            else if (ch == ']') {
                int repeat = countStack.pop();
                StringBuilder prev = stringStack.pop();

                for (int i = 0; i < repeat; i++) {
                    prev.append(curr);
                }
                curr = prev;
            }
            else {
                curr.append(ch);
            }
        }

        return curr.toString();
    }
}