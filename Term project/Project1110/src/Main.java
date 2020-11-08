import java.util.Scanner;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		Random rd=new Random(100);
		System.out.println("N과 구간 a, b을 차례로 입력 : ");
		int N = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int min=0;
		int max=0;
		int sum=0;
		int [] array = new int [N];
		for(int i=0; i<N; i++) {
			array[i]=rd.nextInt();
			System.out.println(array[i]);
		}
		min=array[a-1];
		max=array[a-1];
		for(int j=a-1;j<b;j++) {
			sum+=array[j];
			if(array[j]<min)
				min=array[j];
			if(array[j]>max) {
				max=array[j];
			}
		}
		System.out.println("max : "+max+"\nmin : "+min);
		System.out.println("sum : "+sum);
	}
}
