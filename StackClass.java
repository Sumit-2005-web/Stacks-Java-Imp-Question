import java.util.*;

public class StackClass{

    // Q.1: Push at the bottom of the stack {Amazon}
    public static void pushBottom(Stack<Integer> st, int data){
     if(st.isEmpty()){
        st.push(data);
        return;
     }

     int top = st.pop();
     pushBottom(st, data);
     st.push(top);
    }

    // Q.2. Reverse a striing using stack {Microsoft, Adobe, Amazon, Paytm, Flipkart}
    public static String reverseString(String str){
        Stack<Character> s = new Stack<>();
        int idx = 0;
     while(idx < str.length()){
        s.push(str.charAt(idx));
        idx++;
     }    

      StringBuilder result = new StringBuilder();
      while(!s.isEmpty()){
        char curr = s.pop();
        result.append(curr);
      }

      return result.toString();
      }

      // Q.3.Reverse a stack 
      public static void reverseStack(Stack<Integer> st){
         if(st.isEmpty()){
            return;
         }

         int top = st.pop();
         reverseStack(st);
         pushBottom(st, top);
      }

      // Q.4. Stock Span Problem {Adobe, Samsung, Microsoft, Flipkart}
      public static void stockSpan(int stocks[], int span[]){
         Stack<Integer> st = new Stack<>();
         span[0] = 1; // Always span 0th index will be 1
         st.push(0);

         for(int i = 1; i < stocks.length; i++){
            int currPrice = stocks[i];
            while(!st.isEmpty() && currPrice > stocks[st.peek()]){
               st.pop();
            } 

            if(st.isEmpty()){
               span[i] = i+1;
            } else {
               int prevHigh = st.peek();
               span[i] = i - prevHigh;
            }

            st.push(i);
         }
      }

      // Q.5. Next Greater Element - Classical Imp Question
      public static void nxtGreaterEle(int arr[], int nxtGreaterArr[]){
         Stack<Integer> st = new Stack<>();
         for(int i = arr.length-1; i >= 0; i--){
            // To check
            while(!st.isEmpty() && arr[st.peek()] <= arr[i]){
               st.pop();
            }

            // 
            if(st.isEmpty()){
               nxtGreaterArr[i] = -1;
            } else {
               nxtGreaterArr[i] = arr[st.peek()];
            }

            // To push the element
            st.push(i);
         }
      }
      

    public static void main(String args[]){
      // Stack<Integer> st = new Stack<>();
      //  st.push(1);
      //  st.push(2);
      //  st.push(3);
      // int stocks[] = {100, 80, 60, 70, 60, 85, 100};
      // int span[] = new int[stocks.length]; 
      // stockSpan(stocks, span);

      // for(int i = 0; i < span.length; i++){
      //    System.out.println(span[i]);
      // }

      int arr[] = {6, 8, 0, 1, 3};
      int nxtGreaterArr[] = new int[arr.length];
      nxtGreaterEle(arr, nxtGreaterArr);
      for(int i = 0; i < nxtGreaterArr.length; i++){
         System.out.print(nxtGreaterArr[i] + " , ");
      }

     
       
    //    pushBottom(st, 4);
   //  String str = "cba";
   //  System.out.println(reverseString(str));
   // reverseStack(st);

   // while(!st.isEmpty()){
   //    System.out.println(st.pop());
   // }

    }
}