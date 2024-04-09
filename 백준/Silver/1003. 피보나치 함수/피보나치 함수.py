li = [0, 1]
n = int(input())
for j in range(n):
    nn = int(input())
    if nn == 0:
        print('1 0')
    elif nn == 1:
        print('0 1')
    else:
        for i in range(1, nn):
            put_n = li[i-1] + li[i]
            li.append(put_n)
        print(li[nn-1], li[nn])
    li = [0, 1]