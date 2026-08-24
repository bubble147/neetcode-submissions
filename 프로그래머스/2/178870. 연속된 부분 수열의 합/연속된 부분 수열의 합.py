def solution(sequence, k):
    answer = [0, 0]
    best = float('inf')
    total = 0
    left = 0

    for right in range(len(sequence)):
        total += sequence[right]
        while total > k:
            total -= sequence[left]
            left += 1
        if total == k and right - left < best:
            best = right - left
            answer[0] = left
            answer[1] = right
            
    return answer