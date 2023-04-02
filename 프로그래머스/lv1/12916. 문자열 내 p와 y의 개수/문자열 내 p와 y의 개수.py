def solution(s):
    #모두 소문자로 변환후 p와 y의 개수 비교
    return s.lower().count('p')==s.lower().count('y')