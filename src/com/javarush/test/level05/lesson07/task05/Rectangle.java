package com.javarush.test.level05.lesson07.task05;

/* Создать класс прямоугольник (Rectangle)
Создать класс прямоугольник (Rectangle). Его данными будут top, left, width, height (левая координата, верхняя, ширина и высота). Создать для него как можно больше методов initialize(…)
Примеры:
-	заданы 4 параметра: left, top, width, height
-	ширина/высота не задана (оба равны 0)
-	высота не задана (равно ширине) создаём квадрат
-	создаём копию другого прямоугольника (он и передаётся в параметрах)
*/

public class Rectangle
{
    int top;
    int left;
    int width;
    int height;

    public void initialize(int top, int left, int width, int height){
    this.top=top;
    this.left=left;
    this.width=width;
    this.height=height;
    }

    public void initialize(int top, int left, int height)
    {
        this.top = top;
        this.left = left;
        this.height = height;
    }

    public void initialize(int top, int left)
    {
        this.top = top;
        this.left = left;
    }

    public void initialize(int top)
    {
        this.top = top;
    }

    public void initialize(Rectangle anotherRectangle){
        this.top=anotherRectangle.top;
        this.left=anotherRectangle.left;
        this.width=anotherRectangle.width;
        this.height=anotherRectangle.height;
    }

}


