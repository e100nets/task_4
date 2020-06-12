Реализовать метод пузырьковой сортировки в варианте, когда в метод передается два массива: первый массив – массив с объектами, которые необходимо отсортировать, а второй массив – массив целых чисел, согласно которым необходимо отсортировать первый массив.	Сигнатура метода должна быть:
public static <T> void sort(T[] data, int[] orderValues)	
Сортировка должна работать следующим образом:	
{ "green", "blue", "red" }, { 5, 8, 1 }  –> { "red", "green", "blue" }, { 1, 5, 8 }	
Очевидно, что все сравнения надо выполнять над числами из второго массива, а любые обмены делать одновременно в двух массивах.
