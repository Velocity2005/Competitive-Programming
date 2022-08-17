c = int(input())

for n in range(c):
    winner = True
    l, w = map(int,input().split(" "))
    if l % 2 == 1:
        winner = not winner

    if w % 2 == 1:
        winner = not winner

    print("Tonya" if winner else "Burenka")