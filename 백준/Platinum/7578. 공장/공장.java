import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       int size = Integer.parseInt(br.readLine());
       Seg_Tree sTree = new Seg_Tree(size);
       HashMap<Integer,Integer> map = new HashMap();
       StringTokenizer st = new StringTokenizer(br.readLine());
       for(int i = 0; i<size; i++) {
    	   map.put(Integer.parseInt(st.nextToken()),i);
       }
       long sum = 0;
       st = new StringTokenizer(br.readLine());
       for(int i = 0; i<size; i++) {
    	   int num = Integer.parseInt(st.nextToken());
    	   int index = map.get(num);
    	   sTree.update(1,0,size-1,index+1,size-1);
    	   sum += (index+sTree.query(1,0,size-1,index));
       }
       System.out.println(sum);
    }
    //left,right - 노드가 담당하는 범위 start,end - 현재 내가 검색하려는 범위
    static class Seg_Tree {
    	int tree[];
    	public Seg_Tree(int size) {
    		tree = new int[size*4];
    	}
    	public void propagation(int node,int left,int right) {
    		if(tree[node]!=0&&left!=right) {
    			tree[node*2] += tree[node];
				tree[node*2+1] += tree[node];
				tree[node] = 0;
    		}
    	}
    	public void update(int node,int left,int right,int start,int end) {
    		propagation(node,left,right);
    		if(start<=left&&end>=right) {
    			tree[node] -= 1;
    			return;
    		}else if(end<left||right<start){
    			return;
    		}
    		int mid = (left+right)/2;
			update(node*2,left,mid,start,end);
			update(node*2+1,mid+1,right,start,end);
    	}
    	public int query(int node,int left,int right,int index) {
    		if(left==right&&left==index) {
    			return tree[node];
    		}
    		propagation(node,left,right);
    		int mid = (left+right)/2;
    		if(mid>=index) {
    			return query(node*2,left,mid,index);
    		}else {
    			return query(node*2+1,mid+1,right,index);
    		}
    	}
    }
}