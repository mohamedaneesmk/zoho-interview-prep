/*
    * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    Every close bracket has a corresponding open bracket of the same type.
    

    Example 1:

    Input: s = "()"

    Output: true

    Example 2:

    Input: s = "()[]{}"

    Output: true

    Example 3:

    Input: s = "(]"

    Output: false

    Example 4:

    Input: s = "([])"

    Output: true

    Example 5:

    Input: s = "([)]"

    Output: false
*/

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "([])";
        System.out.println(isValid(s));
    }

    private static boolean isValid(String s) {
        if (s.length() % 2 == 0) {
            return false;
        }

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if ((c == ')' && top != '(') ||
                        (c == '}' && top != '{') ||
                        (c == ']' && top != '[')) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}