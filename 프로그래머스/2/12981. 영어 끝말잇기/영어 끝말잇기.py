def solution(n, words):
    answer = [0, 0]
    word = []
    start = ''
    for x in words:
        if x in word:
            answer = [len(word)%n+1, len(word)//n+1]
            break
        if start!='':
            if start==x[0]:
                word.append(x)
            else:
                answer = [len(word)%n+1, len(word)//n+1]
                break
            
        if start=='':
            word.append(x)
        start = x[-1]
    return answer