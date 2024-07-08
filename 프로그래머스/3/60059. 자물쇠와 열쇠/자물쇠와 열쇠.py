def rotation(arr):
    row = len(arr)
    col = len(arr[0])

    rot_arr = [[0]*row for _ in range(col)]
    
    for i in range(row):
        for j in range(col):
            rot_arr[j][row-i-1] = arr[i][j]
    return rot_arr

def check(new_lock):
    lock_length = len(new_lock)//3
    for i in range(lock_length, lock_length*2):
        for j in range(lock_length, lock_length*2):
            if new_lock[i][j] != 1:
                return False
    return True
def solution(key, lock):
    answer = True
    key_len = len(key)
    lock_len = len(lock)
    
    new_lock = [[0]*lock_len*3 for _ in range(lock_len*3)]
    
    for i in range(lock_len):
        for j in range(lock_len):
            new_lock[i+lock_len][j+lock_len] = lock[i][j]
            
    for _ in range(4):
        for i in range(len(new_lock)-key_len+1):
            for j in range(len(new_lock)-key_len+1):
                for x in range(key_len):
                    for y in range(key_len):
                        new_lock[i+x][j+y] += key[x][y]
                if check(new_lock):
                    return True
                for x in range(key_len):
                    for y in range(key_len):
                        new_lock[i+x][j+y] -= key[x][y]
        key = rotation(key)
    return False