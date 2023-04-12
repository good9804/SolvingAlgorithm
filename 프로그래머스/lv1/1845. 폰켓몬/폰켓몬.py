def solution(nums):
    return min(len(nums)/2, len(set(nums)))
    ##중복되지않은것이  N/2보다 작으면 정답,