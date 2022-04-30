import numpy as np

def check(a, n):
    if n==1:
        print("Полученный массив не является матрицей")
        if a[0][0]==0 and a[0][1]!=0:
            print("Уравнение не имеет решений")
        elif a[0][0]==0 and a[0][1]==0:
            print("Решение данного уравнения: Х = 0")
        else:
            print("Решение данного уравнения: Х =", a[0][1]/a[0][0])
        exit(0)
    else:
        for i in range(n):
            chg = False
            chv = False
            for j in range(n):
                if a[i][j] != 0:
                    chg = True
                if a[j][i] != 0:
                    chv = True
            if chg==False and a[i][n]!=0:
                print("Содержится нулевая строка с ненулевым значением столбца В\nСистема решений не имеет!")
                exit(0)
            if chv==False:
                print("Сожержится нулевой столбец, метод Гаусса не может быть применён к данной матрице")
                exit(0)

def pr(a, n):
    for i in range(len(a)):
        for j in range(len(a[i])):
            if j==n:
                print(' |', end='')
            print("%12f" % a[i][j], end='')
        print('')

def count_line():
    with open('in.txt', 'r') as f:
        i=0
        for line in f:
            i+=1
    return i

def is_number(str):
    try:
        float(str)
        return True
    except ValueError:
        return False

def rhand(n, a):
    m = False
    while m==False:
        a.clear()
        print("Введите матрицу:")
        for i in range(n):
            row = input().split()
            if len(row) == n+1:
                for i in range(len(row)):
                    if is_number(row[i]):
                        row[i] = float(row[i])
                        m = True
                    else:
                        print("Ошибка! Матрица должна содержать только числа (дробные числа с разделителем .), попробуйте ещё раз")
                        m = False
                        break
            else:
                print("Ошибка длины строки. Количество элементов строки должно быть", n+1)
                m = False
                break
            if m==True:
                a.append(row)
            else:
                break

def rauto(n, a):
    for i in range(n):
        a.append([round(np.random.uniform(-100, 100), 6) for k in range(n+1)])
    

def rfile(a):
    with open('in.txt', 'r') as file:
        k = count_line()+1
        try:
            for line in file:
                row = line.split()
                if len(row)==k:
                    a.append([float(x) for x in line.split()])
                else:
                    raise ValueError
        except ValueError:
            print("Ошибка формата данных в файле :(\nУбедитесь, что файл сожержит только числа, разделённые пробелами и попробуйте снова")
            exit(0)
    return k-1


def start(a):
    
    m = False
    while m==False:
        k = int(input("Способ создания матрицы:\n1 - вручную\n2 - из файла\n3 - сгенерировать\n\n"))
        if k==1 or k==2 or k==3:
            m=True
        else:
            print("\nВведите цифру выбранного варианта")

    if k==1 or k==3:
        m = False
        while m==False:
            count = int(input("\nРазмер матрицы (max - 20): "))
            if count>0 and count<=20:
                m=True
            else:
                print("Размер должен быть в диапазоне от 1 до 20")
    else:
        return rfile(a)

    if k==1:
        rhand(count, a)
    elif k==3:
        rauto(count, a)

    return count

