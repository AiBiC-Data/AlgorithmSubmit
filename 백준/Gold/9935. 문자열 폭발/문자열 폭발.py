import sys
input = sys.stdin.readline

s = input().rstrip()
b = list(input().rstrip())
q = []

for i in s:
    q.append(i)
    if len(q) >= (len(b)):
        if q[-len(b):] == b:
            for _ in range(len(b)):
                q.pop()
print(*q if q else "FRULA",sep="")