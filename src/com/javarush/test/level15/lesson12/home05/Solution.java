package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {

    public Solution(String public1) {}
    public Solution(Integer public2) {}
    public Solution(Double public3) {}

    Solution() {}
    Solution(boolean default2) {}
    Solution(int default3) {}

    private Solution(char private1) {}
    private Solution(double private2) {}
    private Solution(Boolean private3) {}

    protected Solution(Long protected1) {}
    protected Solution(byte protected2) {}
    protected Solution(long protected1) {}

}

