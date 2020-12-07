import java.util.Scanner;
public class Main {
	//	���������� ���� histo �Լ�
	
	static int histo(int[]v, int a, int b) { // ���������� ���� histo �Լ�
	      if(a==b) {
	         return v[a];
	      } // �Է°��� �ϳ��� ��
	      int c = (a+b)/2;
	      
	      int wd = Math.max(histo(v,a,c),histo(v,c+1,b)); //���� ū ����
	      // ����Լ�, ������ ���ؼ� �� ū ���� ����
	      int i = c;  // ��� ���ʰ�
	      int j = c+1;  // ��� �����ʰ�
	      // ��� �� �ΰ��� �������� �� ���� ���� 2�� ���� ���̶�, ������ �ִ� ���簢�� ���̶� ���ؼ� �� ū���� ����
	      int m = Math.min(v[i], v[j]); 
	      wd = Math.max(wd, m*2);
	      
	      while(a<i || j<b) { // a<i || i<b�� ������ &&�� ��� �� �� �ϳ��� �¾Ƶ� while���� ����Ǳ� ����
	         if(a<i && ((b == j) || (v[i-1] > v[j+1]))) {
	            --i;
	            m = Math.min(m, v[i]);
	         }
	         else { // ���ǿ� b==j�� �����Ƿ� else���� �����ؼ� b==j�� �� ���� if���� ���ư�
	        	 ++j;
		            m = Math.min(m, v[j]);
	         }
	         wd = Math.max(wd, m*(j-i+1));
	      }
	      return wd;
	   }
	static int histo(int[] v, int n) {
		return histo(v, 0, n-1); // histo �Լ� ����
	}
	public static void main(String[] args) {
		//	��ĳ�� ������Ʈ ����
		Scanner sc = new Scanner(System.in);
		//	������ �� �Է�
		int n = sc.nextInt();
		//	������ ������ �迭 ����
		int[] v = new int[n];
		//	n���� ������ �Է¹޾� �迭 v�� ����
		for(int i = 0;i<n; i++) {
			v[i] = sc.nextInt();
		}
		//	���� ū ���簢���� ���� ���
		int r = histo(v, n);
		//	���
		System.out.println(r);
	}
}