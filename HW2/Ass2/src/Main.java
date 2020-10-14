import java.util.Scanner;
public class Main {
	
	public static boolean isValid(String str) {
		char[] stack = new char[1024];
		int top = -1;
		
		for(int i = 0; i < str.length(); i++ ) {
			char ch = str.charAt(i);
			if(ch == '(') {
				stack[++top] = ch;
			}
			else if(ch == ')') {
				if(top == -1 || stack[top] != '(') 
					return false;
				top--;
			}
		}
		return top ==-1;
	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = scan.nextInt();
		int YN [] = new int [n];
		
		for(int i = 0; i < n; i++) {
			String abc = scan.next();
			if(isValid(abc)) 
				YN[i]= 1;
			else 
				YN[i]=2;
		}
	
		for(int j = 0;j<YN.length;j++) {
			if (YN[j]==1)
				System.out.println("Yes");
			else
				System.out.println("No");
		}
	}
	

}
