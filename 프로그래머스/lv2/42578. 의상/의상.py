def solution(clothes):
    answer = 1
    items = {}

    for item, category in clothes:
        if category not in items:
            items[category] = []
        items[category].append(item)
    #전체경우의수계산
    for k in items.keys():
        answer *= len(items[k])+1

    return answer-1 #아무것도입지않은경우제외