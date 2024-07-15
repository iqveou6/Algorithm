import sys
n, m = map(int, sys.stdin.readline().split())
height = list(map(int, sys.stdin.readline().split()))
start = 0
end = max(height)
ans = 0
while start<=end:
    result = 0
    mid = (start+end)//2
    for i in height:
        if mid<i:
            result+=i-mid
    if result==m:
        ans = mid
        break
    elif result>m:
        start = mid+1
        ans = mid
    else:
        end = mid-1
print(ans)