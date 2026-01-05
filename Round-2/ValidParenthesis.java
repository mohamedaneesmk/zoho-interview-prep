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

import java.util.Scanner;
import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputString = scanner.nextLine();
        boolean isTrue = findValidParenthesis(inputString);
        System.out.println(isTrue);
        scanner.close();
    }

    private static boolean findValidParenthesis(String inputString) {
        if(inputString.length()==0)
            return false;

        Stack<Character> stack = new Stack<>();
        for(char ch:inputString.toCharArray()){
            if(ch=='('||ch=='['||ch=='{'){
                stack.push(ch);
            }
            else if(ch==')'){
                if(stack.peek()=='('&& !stack.isEmpty()){
                    stack.pop();
                }
                else return false;
            }
            else if(ch==']'){
                if(stack.peek()=='['&& !stack.isEmpty()){
                    stack.pop();
                }
                else return false;
            }
            else if(ch=='}'){
                if(stack.peek()=='{'&& !stack.isEmpty()){
                    stack.pop(); 
                }
                else return false;
            }
        }

        return stack.isEmpty();
    }
}
