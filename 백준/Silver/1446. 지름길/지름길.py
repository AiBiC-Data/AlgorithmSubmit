import sys

n, d = map(int, sys.stdin.readline().split())
graph = [list(map(int, input().split())) for _ in range(n)]
dis = [i for i in range(d+1)]

for i in range(d+1):
    dis[i] = min(dis[i], dis[i-1]+1)
    for s, e, shortcut in graph:
        if i == s and e <= d and dis[i]+shortcut < dis[e]:
            dis[e] = dis[i]+shortcut

print(dis[d])