def solution(participant, completion):
    participant.sort()
    completion.sort()
    ##이름순으로 정렬
    for partci,comple in zip(participant, completion):
        if partci != comple:
            return partci##같지않으면 완주못한사람
    return participant.pop()##동명이인