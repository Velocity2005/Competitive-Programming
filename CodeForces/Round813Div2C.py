import sys

cases = int(sys.stdin.readline())

for l in range(cases):
    length = int(sys.stdin.readline())
    nums = list(map(int, sys.stdin.readline().split(" ")))
    seen = set()
    moves = 0
    seen.add(nums[0])
    inc =1
    for i in range(1, length):
        if nums[i] in seen:
            inc = 0
        else:
            seen.add(nums[i])
            if nums[i] >= nums[i - 1]:
                inc+=1
            else:
                inc = 1
    print(len(seen)-inc)
