import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
	static int max = 0;
	static boolean[][] resulted = new boolean[1000001][11];
    public static void main(String[] args) throws NumberFormatException, IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       String su = st.nextToken();
       int K = Integer.parseInt(st.nextToken());
       char[] arr = su.toCharArray();
       DFS(arr,K,0);
       if(max==0) {
    	   System.out.println(-1);
       }else {
    	   System.out.println(max);
       }
    }
    static void DFS(char[] arr,int depth,int count) {
    	if(arr[0]=='0') {
    		return;
    	}
    	if(count==depth) {
    		max = Math.max(max, Integer.parseInt(new String(arr)));
    		return;
    	}
    	//첫번째로 바뀌는 인덱스
    	for(int i = 0; i<arr.length-1; i++) {
    		//두번째로 지정되는 인덱스
    		for(int j = i+1; j<arr.length; j++) {
    			swap(arr,i,j);
    			if(!resulted[Integer.parseInt(new String(arr))][count+1]) {
    				resulted[Integer.parseInt(new String(arr))][count+1] = true;
        			DFS(arr,depth,count+1);
    			}
    			swap(arr,j,i);
    		}
    	}
    }
    static void swap(char[] arr,int i1,int i2) {
    	char tmp = arr[i1];
    	arr[i1] = arr[i2];
    	arr[i2] = tmp;
    }
}
