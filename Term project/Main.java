import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Random rd=new Random(100);
		System.out.print("N 입력 : ");
		int N = sc.nextInt();
		System.out.print("K 입력 : ");
		int K = sc.nextInt();
		System.out.println();
		
		long START = System.currentTimeMillis();
		
		int s = 0;
		int st = 0, ed = 0;
		int [] arr = new int [N];
		
		for(int i=0;i<N;i++) {
			arr[i]=rd.nextInt();
		}
		
		for(int j=0;j<K;j++) {
			int a = (int)(Math.random()*N);
			int b = (int)(Math.random()*N);
			
			if(a>b) {
				st=b;
				ed=a;
			}
			else {
				st=a;
				ed=b;
			}
			int min = arr[st];
			int max = arr[st];
			long sum = 0;
			for(int p=st; p<=ed;p++) {
				
				sum+=arr[p];
				if(arr[p]<min) {
					min=arr[p];
				}
				if(arr[p]>max) {
					max=arr[p];
				}
			}
			s++;
			System.out.println("< "+s+"번째 >");
			System.out.println("min = "+min);
			System.out.println("max = "+max);
			System.out.println("sum = "+sum);
		}
		long END = System.currentTimeMillis();
		System.out.println();
		System.out.println("걸리는 시간 : "+ (END-START) +"ms");
	}
}
