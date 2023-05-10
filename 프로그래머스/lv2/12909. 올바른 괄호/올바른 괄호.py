def solution(s):
    stack = []
    for i in s:
        if i == '(':
            stack.append(i)
        else:
            if stack == []: # )이  나왔는데 스택이 비어있는경우
                return False
            else:
                stack.pop()
    if stack != []: # 다 끝났는데 스택이 비어있지않다면
        return False
    return True
