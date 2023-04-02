def solution(n):
    sum=0
    #1부터 n까지 탐색
    for i in range(1,n+1):
        if n%i==0:
            sum+=i
            
    return sum