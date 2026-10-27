import java.util.*;

class Node {
    int value;
    int x; 
    int y;
    Node left;
    Node right;
    
    public Node(int x, int y, int value) {
        this.value = value;
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    public List<Integer> pre = new ArrayList<>();
    public List<Integer> post = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfo) {
        int[][] answer = new int[2][nodeinfo.length];
        List<int[]> nodes = new ArrayList<>();
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes.add(new int[] {nodeinfo[i][0], nodeinfo[i][1], i+1});
        }
        nodes.sort((a, b) -> b[1] - a[1]);
        int[] root = nodes.get(0);
        Node rootNode = new Node(root[0], root[1], root[2]);
            
        for (int i = 1; i < nodes.size(); i++) {
            Node current = rootNode;
            while(true) {
                int[] cur= nodes.get(i); 
                Node nextNode = new Node(cur[0], cur[1], cur[2]);
                if (current.x > nextNode.x) {
                    if (current.left == null) {
                        current.left = nextNode;
                        break;
                    }
                    current = current.left;
                } else {
                    if (current.right == null) {
                        current.right = nextNode;
                        break;
                    }
                    current = current.right;
                }
            }
            
        }
        preorder(rootNode);
        postorder(rootNode);
        
        for(int i = 0; i < answer[0].length; i++) {
            answer[0][i] = pre.get(i);
        }
        for(int i = 0; i < answer[0].length; i++) {
            answer[1][i] = post.get(i);
        }
        return answer;
    }
    
    public void preorder(Node node) {
        if (node == null) return;
        pre.add(node.value);
        preorder(node.left);
        preorder(node.right);
    }
    
    public void postorder(Node node) {
        if (node == null) return;
        postorder(node.left);
        postorder(node.right);
        post.add(node.value);
    }
}