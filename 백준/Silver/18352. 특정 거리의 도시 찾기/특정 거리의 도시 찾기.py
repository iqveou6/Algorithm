n, m, k, x = map(int, input().split())                           
graph = [[] for _ in range(n+1)]                                 
                                                                 
for _ in range(m):                                               
    a, b = map(int, input().split())                             
    graph[a].append(b)                                           
                                                                 
from collections import deque                                    
answer = [m]*(n+1)                                               
                                                                 
def dfs(graph, visited, v, cnt):                                 
    global answer                                                
    q = deque()                                                  
    visited[v] = True                                            
    answer[v] = cnt                                              
    q.append(v)                                                  
    while q:                                                     
        v = q.popleft()                                          
        for i in graph[v]:                                       
            if not visited[i]:                                   
                visited[i] = True                                
                q.append(i)                                      
                answer[i] = min(answer[i], answer[v]+1)          
visited = [False]*(n+1)                                          
dfs(graph, visited, x, 0)                                        
sol = []                                                         
for i in range(1, n+1):                                          
    if answer[i] == k:                                           
        sol.append(i)                                            
                                                                 
if not sol:                                                      
    print(-1)                                                    
else:                                                            
    for x in sol:                                                
        print(x)                                                 
                                                                 
                                                                 