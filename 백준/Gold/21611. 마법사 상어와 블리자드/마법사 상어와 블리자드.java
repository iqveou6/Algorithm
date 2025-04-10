import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] x = {-1,-1,1,1};
	static int[] y = {1,-1,1,-1};
	//true를 만나면 방향을 전환 v,>,^,<순서대로 남,동,북,서
	static int[] moveX = {0,1,0,-1};
	static int[] moveY = {1,0,-1,0};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] answer = new int[4];
		StringTokenizer st = new StringTokenizer(br.readLine());
		int size = Integer.parseInt(st.nextToken());
		int repeat = Integer.parseInt(st.nextToken());
		int[][] arr = new int[size][size];
		boolean[][] resulted = new boolean[size][size];
		Deque<Node> q = new LinkedList();
		//방향이 바뀔 true 입력
		for(int i = 0; i<4; i++) {
			int s_row = size/2;
			int s_col = size/2;
			for(int j = 0; j<size/2; j++) {
				s_row += y[i];
				s_col += x[i];
				resulted[s_row][s_col] = true;
			}
		}
		//북,남,서,동 1,2,3,4 서쪽 시작이 1
		int[][] cord = new int[5][size/2];
		int plus = 9;
		int[] west = new int[size/2];
		int[] south = new int[size/2];
		int[] east = new int[size/2];
		int[] north = new int[size/2];
		west[0] = 1;
		south[0] = 3;
		east[0] = 5;
		north[0] = 7;
		for(int i = 1; i<size/2; i++) {
			west[i] = west[i-1]+plus;
			plus+=2;
			south[i] = south[i-1]+plus;
			plus+=2;
			east[i] = east[i-1]+plus;
			plus+=2;
			north[i] = north[i-1]+plus;
			plus+=2;
		}
		cord[1] = north;
		cord[2] = south;
		cord[3] = west;
		cord[4] = east;
		for(int i = 0; i<arr.length; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j<arr.length; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		//true를 만나면 방향을 전환 v,>,^,<순서대로 남,동,북,서
		int toward = 0;
		int ri = size/2;
		int ci = size/2-1;
		int cnt = 1;
		while((ri>=0&&ci>=0)&&arr[ri][ci]!=0) {
			q.add(new Node(arr[ri][ci],cnt++));
			ri+=moveY[toward%4];
			ci+=moveX[toward%4];
			if(resulted[ri][ci]) {
				if(toward%4==3) {
					q.add(new Node(arr[ri][ci],cnt++));
					ci -= 1;
				}
				toward++;
			}
		}
		//마법으로 칸깨기,구슬폭발,그룹핑
		Deque<Node> save = new LinkedList();
		for(int i = 0; i<repeat; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken());
			int range = Integer.parseInt(st.nextToken());
			int tmp = 0;
			//구슬 부시기
			while(!q.isEmpty()) {
				Node n = q.poll();
				if(tmp<range&&n.count==cord[to][tmp]) {
					tmp++;
					continue;
				}
				save.add(n);
			}
			regroup(q,save);
			//여기까지 해결
			
			Queue<Node> t = new LinkedList();
			while(true) {
				boolean b = false;
				while(!q.isEmpty()) {
					Node n = q.peek();
					if(t.isEmpty()) {
						t.add(q.poll());
					}else {
						if(t.peek().value==n.value) {
							t.add(q.poll());
						}else {
							if(t.size()>=4) {
								b = true;
								answer[t.peek().value] += t.size();
								t.clear();
							}else {
								regroup(save,t);
							}
						}
					}
				}
				//과정이 다 끝났을 때 t에는 처리되지 못한 구슬이 남아있다
				if(t.size()>=4) {
					b = true;
					answer[t.peek().value] += t.size();
					t.clear();
				}else {
					regroup(save,t);
				}
				//save에 있는 내용을 다시 q로 옮긴다
				regroup(q,save);
				//폭발이 일어난 적 없다면 while문을 종료한다.
				if(!b) {
					break;
				}
			}
			//모든 폭발이 일어난 후 그룹핑을 통해서 다시 넣어준다 이때 사이즈는 (size*size)-1을 넘어가면 안된다
			//종료조건은 save의 사이즈가 기준치를 넘거나 q가 전부 비게 되면 종료된다
			cnt = 1;
			while(save.size()<(size*size)-1&&!q.isEmpty()) {
				Node n = q.peek();
				if(t.isEmpty()) {
					t.add(q.poll());
				}else {
					if(t.peek().value==n.value) {
						t.add(q.poll());
					}else {
						//q에서 꺼낸 값과 t의 값이 서로 다르면 t를 (개수,구슬종류) 두개로 그룹핑해서 save에 넣어준다
						save.add(new Node(t.size(),cnt++));
						save.add(new Node(t.peek().value,cnt++));
						t.clear();
					}
				}
			}
			if(!t.isEmpty()) {
				save.add(new Node(t.size(),cnt++));
				save.add(new Node(t.peek().value,cnt++));
				t.clear();
			}
			q.clear();
			while(save.size()>(size*size)-1) {
				save.pollLast();
			}
			regroup(q,save);
		}
		System.out.println(((long)(answer[1]+(2*answer[2])+(3*answer[3]))));
	}
	static class Node{
		int value;
		int count;
		public Node(int value, int count) {
			this.value = value;
			this.count = count;
		}
		
	}
	static void regroup(Queue<Node> q,Queue<Node> save) {
		while(!save.isEmpty()) {
			q.add(save.poll());
		}
	}
}
