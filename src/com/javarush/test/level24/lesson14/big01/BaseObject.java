package com.javarush.test.level24.lesson14.big01;

/**
 * Базовый класс для всех объектов игры.
 */
public abstract class BaseObject
{
    //координаты
    protected double x;
    protected double y;
    //радиус объекта
    protected double radius;

    protected BaseObject(double x, double y, double radius)
    {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public double getX()
    {
        return x;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public double getY()
    {
        return y;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public double getRadius()
    {
        return radius;
    }

    public void setRadius(double radius)
    {
        this.radius = radius;
    }

    /**
     * Метод рисует свой объект на "канвасе".
     */
    public abstract void draw(Canvas canvas);

    /**
     * Двигаем себя на один ход.
     */
    public abstract void move();

    /**
     * Проверяем - не выходит ли (x,y) за границы.
     */
    public void checkBorders(double minX, double maxX, double minY, double maxY)
    {
        if (x < minX) x = minX;
        if (x > maxX) x = maxX;
        if (y < minY) y = minY;
        if (y > maxY) y = maxY ;
    }

    /**
     * Проверяем - пересекаются ли переданный(o) и наш(this) объекты.
     */
    public boolean isIntersec(BaseObject o)
    {
        double dx = x - o.x;
        double dy = y - o.y;
        double destination = Math.sqrt(dx * dx + dy * dy);
        double destination2 = Math.max(radius, o.radius);
        return destination <= destination2;
    }
}
