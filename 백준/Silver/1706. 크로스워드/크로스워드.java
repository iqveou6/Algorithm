import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
	
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static String[] input;
    
    public static void main(String[] args) throws Exception{
        input = br.readLine().split(" ");
        int R = Integer.parseInt(input[0]), C = Integer.parseInt(input[1]);
        char[][] grid = new char[R][C];
        for(int i = 0; i < R; i++) {
            grid[i] = br.readLine().toCharArray();
        }
        
        List<String> pq = new LinkedList<>();
        for(int i = 0; i < R; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < C; j++) {
                if(grid[i][j] == '#') {
                    if(sb.length() > 1) pq.add(
                            String.valueOf((new String(String.valueOf((new String(sb.toString())).toCharArray()))).toCharArray())
                            );
                    sb = new StringBuilder();
                }
                else {
                    sb.append(grid[i][j]);
                }
            }
            if(sb.length() > 1) {
                pq.add(sb.toString());
            }
        }
        
        for(int j = 0; j < C; j++) {
            StringBuilder sb = new StringBuilder();
            
            for(int i = 0; i < R; i++) {
                if(grid[i][j] == '#') {
                    if(sb.length() > 1) pq.add(
                            String.valueOf((new String(String.valueOf((new String(sb.toString())).toCharArray()))).toCharArray())
                            );
                    sb = new StringBuilder();
                }
                else {
                    sb.append(grid[i][j]);
                }
            }
            if(sb.length() > 1) {
                pq.add(sb.toString());
            }
        }
        
        pq.sort((j, i) -> j.compareTo(i));
        
        Collections.sort(pq);
        
        System.out.println(pq.get(0));
    }
    
}