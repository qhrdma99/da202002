import java.util.Scanner;

class Stack<E> {
   E[] data;
   int top;
   Stack() {
      data = (E[]) new Object[1024];
      top = -1;
   }
   public void push(E v) {
      top++;
      data[top] = v;
   }
   public void pop() {
      data[top] = null;
      top --;
   } 
   public E top() {
      return data[top];
   }
}

public class Main {

   public static void main(String[] args) {
      Scanner sc=new Scanner(System.in);
      int max = 0;
      int n =sc.nextInt();
      Stack<Integer> st = new Stack();
      int mc [] = new int[n];
      char sb []= new char[1024];
      int dex=0;
      boolean x=true;
      
      for(int i=0; i<n; i++) {
         int num = sc.nextInt();
         mc[i] = num;
         
         if(st.top == -1 ) {
            for(int j=1; j<=num; j++) {
               st.push(j);
               dex++;
               sb[dex]='+';
            }
            st.pop();
            dex++;
            sb[dex]='-';
         }
         else if(st.top() == num) {
            st.pop();
            dex++;
            sb[dex]='-';
         }
         else if(st.top() < num) {
            if(num > max) {
               for(int k = max+1; k<=num; k++) {
                  st.push(k);
                  dex++;
                  sb[dex]='+';
               }
            }
            st.pop();
            dex++;
            sb[dex]='-';
         }
         else {
            x = false;
         }
         for(int l=0; l<mc.length; l++) {
            if(mc[l] > max) {
               max = mc[l];
            }
         }
         
         
      }
      if(x == true) {
         for(int f=0; f<=dex;f++) {
                System.out.println(sb[f]);
             }
      }
      else {
         System.out.println("NO");
      }

   }

}