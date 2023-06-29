def solution(operations):
    answer = []
    for i in operations:
        if i[0]=='I':
            answer.append(int(i[2:]))
        elif len(answer)>0:
            if 'D 1' in i:
                answer.remove(max(answer))
            elif 'D -1' in i:
                answer.remove(min(answer))
    if len(answer)==0:
        return [0,0]
    mi=min(answer); ma=max(answer)
    return [ma,mi]