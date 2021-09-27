import java.util.Stack;

class Solution {
  public int evalRPN(String[] tokens) {
    Stack<String> st = new Stack<>();
    for (int i = 0; i < tokens.length; i++) {
      String s = tokens[i];
      if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
        int a = Integer.valueOf(st.pop());
        int b = Integer.valueOf(st.pop());
        switch (s) {
          case "+":
            st.push(String.valueOf(b + a));
            break;
          case "-":
            st.push(String.valueOf(b - a));
            break;
          case "*":
            st.push(String.valueOf(b * a));
            break;
          case "/":
            st.push(String.valueOf(b / a));
            break;
        }
      } else {
        st.push(s);
      }
    }
    return Integer.valueOf(st.pop());
  }
}
