import func as f
from datetime import datetime
import time
import sys
import copy
a = []
n=f.start(a)
f.check(a, n)

x=[0]*n
b=copy.deepcopy(a)

print("\nРасширенная матрица:")
f.pr(a, n)

time=datetime.now()
opr=1


for j in range(n-1):
    k=0
    max = abs(a[j][j])
    for i in range(j+1, n, 1):     # Поиск максимального элемента столбца
        if abs(a[i][j])>max:
            max=abs(a[i][j])
            k=i                    # Номер строки, содержащей 
                                   # этот максимальный элемент   
    if k!=0:
        for m in range(n+1):       # Меняем строки местами,
            buf=a[j][m]            # чтобы максимальный элемент оказался
            a[j][m]=a[k][m]        # на главной диагонали
            a[k][m]=buf

    for i in range(j+1, n, 1):     # Обнуление чисел под гл. диагональю
        if a[j][j]==0:
            print("Матрицу нельзя привести к треугольному виду")
            exit(0)
        u=a[i][j]/a[j][j]
        for m in range(j, n+1, 1):
            a[i][m]=a[i][m]-a[j][m]*u
    
    opr*=a[j][j]                   # Счётчик определителя

opr*=a[j+1][j+1]
print("\nОпределитель матрицы: ", round(opr, 4))
print("\nТреугольная матрица:")
f.pr(a, n)

x[n-1] = a[n-1][n]/a[n-1][n-1]
for i in range(n-2, -1, -1):
    r=0
    for j in range(n-1, i, -1):
        r+=a[i][j]*x[j]
    x[i]=(a[i][n]-r) / a[i][i]

print("\nРезультат:")
for i in range(n):
    print("X(",i+1,") = ", round(x[i], 4), sep='')

print("\nНевязка:")
for i in range(n):
    r=0
    for j in range(n):
        r+=b[i][j]*x[j]
    b[i][n] = abs(abs(b[i][n]) - abs(r))
    print(i+1, ") ", round(b[i][n], 20), sep='')

print("\nВремя выполнения: ",datetime.now()-time)