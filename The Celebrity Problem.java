class Solution {
  int celebrity(int M[][], int n) {
    Stack<Integer> st = new Stack<>();
    for (int i = 0; i < n; i++) {
      st.push(i);
    }
    while (st.size() > 1) {
      int a = st.pop();
      int b = st.pop();
      if (M[a][b] == 1) {
        st.push(b);
      } else {
        st.push(a);
      }
    }
    int e = st.pop();
    for (int i = 0; i < n; i++) {
      if (M[e][i] == 1) {
        return -1;
      }
    }
    for (int i = 0; i < n; i++) {
      if (i != e) {
        if (M[i][e] == 0) {
          return -1;
        }
      }
    }
    return e;
  }
}
