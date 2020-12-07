import java.util.Scanner;
public class Main {
	//	분할정복을 위한 histo 함수
	
	static int histo(int[]v, int a, int b) { // 분할정복을 위한 histo 함수
	      if(a==b) {
	         return v[a];
	      } // 입력값이 하나일 때
	      int c = (a+b)/2;
	      
	      int wd = Math.max(histo(v,a,c),histo(v,c+1,b)); //가장 큰 넓이
	      // 재귀함수, 양쪽을 비교해서 더 큰 것을 저장
	      int i = c;  // 가운데 왼쪽값
	      int j = c+1;  // 가운데 오른쪽값
	      // 가운데 값 두개를 기준으로 더 작은 값에 2를 곱한 값이랑, 기존에 있던 직사각형 넓이랑 비교해서 더 큰값을 저장
	      int m = Math.min(v[i], v[j]); 
	      wd = Math.max(wd, m*2);
	      
	      while(a<i || j<b) { // a<i || i<b인 이유는 &&일 경우 둘 중 하나만 맞아도 while문이 종료되기 때문
	         if(a<i && ((b == j) || (v[i-1] > v[j+1]))) {
	            --i;
	            m = Math.min(m, v[i]);
	         }
	         else { // 조건에 b==j가 있으므로 else먼저 실행해서 b==j가 된 다음 if문이 돌아감
	        	 ++j;
		            m = Math.min(m, v[j]);
	         }
	         wd = Math.max(wd, m*(j-i+1));
	      }
	      return wd;
	   }
	static int histo(int[] v, int n) {
		return histo(v, 0, n-1); // histo 함수 실행
	}
	public static void main(String[] args) {
		//	스캐너 오브젝트 생성
		Scanner sc = new Scanner(System.in);
		//	샘플의 수 입력
		int n = sc.nextInt();
		//	도수를 저장할 배열 생성
		int[] v = new int[n];
		//	n개의 도수를 입력받아 배열 v에 저장
		for(int i = 0;i<n; i++) {
			v[i] = sc.nextInt();
		}
		//	가장 큰 직사각형의 넓이 계산
		int r = histo(v, n);
		//	출력
		System.out.println(r);
	}
}