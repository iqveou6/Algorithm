s = input()
t = input()

if len(s) < len(t):
    s, t = t, s
ans = 0
for i in range(len(s)-1, -1, -1):
    if s == t:
        ans = 1
        break
    if s[i] == 'A':
        s = s[0:i]
    else:
        s = s[0:i]
        s = s[::-1]

print(ans)