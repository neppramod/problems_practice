/*
Infix to Postfix

a + b * c + d

a b  c  * d + +

Scan the characters of the infix expression
If the operator precedence is greater or stack is empty than that in the stack push it
Else pop the characters to screen until a smaller precedence operator is found.
If the scanned operator is '(' push it to the stack.
If the scanned operator is ')' pop all operators from stack until '(' is found .
Pop all operators from stack at end when scan is finished.
*/
String infixToPostFix(String infix)
{
    Stack<Character> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < infix.length(); i++) {
        char c = infix.charAt(i);
        if (c == '(') {
            stack.push(c);
        } else if (c == ')') {
            while (!stack.isEmpty() &&(char s = stack.pop()) != '(') {
                sb.append(s);
            }
        } else if (isOperator(c)) {
            // for '(' in the stack, next operator is not of higher precedence, so we can push
            // Another version has operator pop until less than equal to. Here pop until less.
            while (!stack.isEmpty() && isHigherPrecedence((char s = stack.peek()), c)) {
                sb.append(stack.pop());
            }
            stack.push(c);
        } else {
            sb.append(c);
        }
    }

    while (!stack.isEmpty()) {
        sb.append(stack.pop());
    }

    return sb.toString();
}

boolean isOperator(char c)
{
    if (c == '*' || c == '-' || c == '+')
        return true;
}

// does a have higher precedence than b
// did not include / and ^, but idea is same
// also include for equality, so that all values that are bigger or equal precedence can be popped.
boolean isHigherPrecedence(char a, char b)
{
    if (a == b) {
        return false;
    } else if (a == '*') {
        return true;
    } else {   // - , + are of same precedence, but scanned from left to right
        return false;
    }
}
