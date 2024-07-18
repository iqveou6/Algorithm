n = int(input())
answer = n
for _ in range(n):
    string = input()
    arr = [string[0]]

    for i in range(len(string)-1):
        if string[i] != string[i+1]:
            if string[i+1] in arr:
                answer -= 1
                break
            arr.append(string[i+1])

print(answer)