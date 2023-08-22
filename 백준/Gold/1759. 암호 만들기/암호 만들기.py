import itertools

l, c = map(int, input().split())
alp = list(map(str, input().split()))
alp_mo = []
alp_ja = []
mo = {"a", "e", "i", "o", "u"}
t = []

for a in alp:
    if a in mo:
        alp_mo.append(a)
    else:
        alp_ja.append(a)

while alp_mo:
    m = alp_mo.pop()
    tmp = alp_mo + alp_ja
    comb = itertools.combinations(tmp, l - 1)

    for c in comb:
        tm = set(c)
        tm.add(m)
        if len(tm - set(mo)) < 2:
            continue
        t.append("".join(sorted(tm)))

for k in sorted(t):
    print(k)