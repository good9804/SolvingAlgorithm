def solution(n):
    #n을 str형으로 바꿔 한 자리마다 탐색후 더해준다
    return sum([int(i) for i in str(n)])