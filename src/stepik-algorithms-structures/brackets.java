/*
Формат входа. 
Строка s[1..n], состоящая из заглавных и прописных букв латинского алфавита, 
цифр, знаков препинания и скобок из множества []{}(). 

Формат выхода. 
Если скобки в s расставлены правильно, выведите строку "Success". В противном случае выведите индекс (используя индексацию 
с единицы) первой закрывающей скобки, для которой нет соответствующей открывающей. Если такой нет, выведите индекс первой 
открывающей скобки, для которой нет соответствующей закрывающей. 

Sample Input 1:
([](){([])})

Sample Output 1:
Success


Sample Input 2:
()[]}

Sample Output 2:
5


Sample Input 3:
{{[()]]

Sample Output 3:
7
*/
