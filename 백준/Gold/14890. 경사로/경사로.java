import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int X = Integer.parseInt(st.nextToken());
			int[][] arr = new int[N][N];
			for(int i = 0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j<N; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			int sum = 0;
			int count = 0;
			int height = 0;
			boolean canMake = false;
			sum += cal(true,arr,N,X);
			sum += cal(false,arr,N,X);
			System.out.println(sum);
	}
	public static int cal(boolean rc,int[][] arr,int N,int X) {
		int sum = 0;
		int count = 0;
		int height = 0;
		boolean canMake = false;
		Outer : for(int row = 0; row<N; row++) {
			height = rc ? arr[row][0] : arr[0][row];
			count = 1;
			canMake = false;
			for(int col = 1; col<N; col++) {
				if(height==(rc ? arr[row][col] : arr[col][row])) {
					count+=1;
					if(canMake&&count==X) {
						canMake = false;
						count = 0;
					}
				}else if((rc ? arr[row][col] : arr[col][row])==height+1) {
					if(canMake) continue Outer;
					if(count<X) {
						continue Outer;
					}else {
						count = 1;
						height = height+1;
					}
				}else if((rc ? arr[row][col] : arr[col][row])==height-1) {
					if(canMake) continue Outer;
					if(X!=1) {
						canMake = true;
						count = 1;
					}else {
						count = 0;
					}
					height = height-1;
				}else {
					continue Outer;
				}
			}
			if(!canMake) sum+=1;
		}
		return sum;
	}

}
