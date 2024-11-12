n, m = map(int, input().split())
arr = list(map(int, input().split()))

neg, pos = [], []
last = 0
for x in arr:
    last = max(abs(x), last)
    if x < 0:
        neg.append(x)
    else:
        pos.append(x)
neg.sort()
pos.sort(reverse=True)

answer = 0


for i in range(0, len(pos), m):
    answer += pos[i]*2
for j in range(0, len(neg), m):
    answer += abs(neg[j])*2
print(answer-last)