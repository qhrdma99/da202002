import java.util.Random;
import java.util.Scanner;

public class Main{

	static long tree[]; // 구간합
    static int treeMin[];// 구간 최소 트리
    static int treeMax[];// 구간 최대
    public static void main(String[] args) {
      
        Random rd = new Random(100);
        Scanner sc=new Scanner(System.in);
       
		System.out.print("N 입력 : ");
		int N = sc.nextInt();
		System.out.print("K 입력 : ");
		int K = sc.nextInt();
		System.out.println();
		
		int [] arr = new int [N];
		
		for(int i=0;i<N;i++) {
			arr[i]=rd.nextInt();
		}
		
        tree = new long[N*4];
        treeMin=new int[N*4];
        treeMax = new int[N*4];
        
        int[] start = new int[K];
        int[] end = new int[K];
        for(int h=0;h<K;h++) {
        	int a=(int)(Math.random()*N);
        	int b=(int)(Math.random()*N);
        	if(a>b) {
				start[h]=b;
				end[h]=a;
			}
			else {
				start[h]=a;
				end[h]=b;
			}
      
        }
        long START = System.currentTimeMillis();
        init(arr, tree, 1, 0, N-1);
    	init_min(arr, treeMin, 1, 0, N-1);
    	init_max(arr, treeMax,  1, 0, N-1 );
 
    	
        long[] sumArr = new long[K];
        int[] minArr = new int[K];
        int[] maxArr = new int[K];
        for(int j=0; j<K;j++) {
			sumArr[j]=sum_num(tree, 0,N-1,1, start[j], end[j]);
        	minArr[j]=min_num(treeMin,1,0,N-1, start[j], end[j]);
        	maxArr[j]=max_num(treeMax, 1,0,N-1, start[j], end[j]);
        
        }  
        long END = System.currentTimeMillis();
        Print(K,START,END, sumArr, minArr, maxArr);
    }
    public static void Print(int K, long START, long END, long[] sumArr, int[] minArr, int[] maxArr) {
    	for(int i=0;i<K;i++) {
    		System.out.println("<"+(i+1)+"번째>");
    		System.out.println("합계 : "+sumArr[i]);
    		System.out.println("최소 : "+minArr[i]);
    		System.out.println("최대 : "+maxArr[i]);
    	}
    	System.out.println("걸리는 시간 : "+ (END-START) +"ms");
    }
    public static long init(int[] arr, long[] tree, int node, int start, int end) {
        if(start == end) { // 리프노드이거나 자식노드들이 구간합이 모두구해졌을 경우 
            return tree[node] = arr[start]; // 구간합 트리에 넣어준다 
        }
        // 반씩 나눠서  재귀적으로 자식노드들의 구간합을 구해준다 
        int mid = (start+end)/2;
        return tree[node] = init(arr, tree, node*2, start, mid) + init(arr, tree, node*2+1, mid+1, end);
    }
    static long sum_num(long[] tree, int start, int end, int node, int left, int right) {
        if(left>end || right < start) {
            return 0;
        }
        if(left <=start && end <=right) {
            return tree[node];
        }
        // 필요한 구간마다 밑에서부터 구간합을 가지고 올라온다 
        int mid = (start+end)/2;
        return sum_num(tree, start, mid, node*2, left, right) + sum_num(tree, mid+1, end, node*2+1, left, right);
    }
    static int init_min(int[] arr, int[] treeMin, int node, int start, int end){
		if(start == end){
			return treeMin[node]=arr[start];
		}
		
		int mid = (start+end)/2;
		
		return treeMin[node]= Math.min(init_min(arr, treeMin, node*2, start, mid) , init_min(arr, treeMin, node*2+1, mid+1, end));
	}
    static int min_num(int[] treeMin, int node, int start, int end, int left, int right){
		if(start>right || end<left){
			return Integer.MAX_VALUE;
		}
		if(left<=start && end<=right){
			return treeMin[node];
		}
		int mid = (start+end)/2;
		
		return Math.min(min_num(treeMin, node*2,start,mid,left,right), min_num(treeMin, node*2+1,mid+1,end,left,right));
	}
    static int init_max(int[] arr, int[] treeMax, int node, int start, int end){
		if(start == end){
			return treeMax[node]=arr[start];
		}
		
		int mid = (start+end)/2;
		
		return treeMax[node]= Math.max(init_max(arr, treeMax, node*2, start, mid) , init_max(arr, treeMax, node*2+1, mid+1, end));
	}
    static int max_num(int[] treeMax, int node, int start, int end, int left, int right){
		if(start>right || end<left){
			return Integer.MIN_VALUE;
		}
		if(left<=start && end<=right){
			return treeMax[node];
		}
		int mid = (start+end)/2;
		
		return Math.max(max_num(treeMax, node*2,start,mid,left,right), max_num(treeMax, node*2+1,mid+1,end,left,right));
	}
}