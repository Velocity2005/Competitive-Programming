cases = int(input())
for i in range(cases):
    length, prefix = map(int,input().split(" "))
    nums = list(map(int,input().split(" ")))
    inPrefix = set()
    for j in range(prefix):
        inPrefix.add(nums[j])

    list.sort(nums)
    count = 0
    for j in range(prefix):
        if nums[j] not in inPrefix:
            count += 1



    print(count)
