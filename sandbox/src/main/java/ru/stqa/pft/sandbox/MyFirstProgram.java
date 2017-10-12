package ru.stqa.pft.sandbox;

// Текущее состояние - завершение 1-го урока
// Пока sandbox - это по-прежнему 1 модуль (а не несколько разных модулей)

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Eugene");

    Square s = new Square(5);
    System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " + r.area());

    Point p1 = new Point(1,0);
    Point p2 = new Point(1,0);
    System.out.println("Расстояние между точками (" + p1.x + "," + p1.y + ") и (" + p2.x + "," + p2.y + ") = " + distance(p1, p2));
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double distance(Point p1, Point p2) {
    return Math.sqrt(((p2.x-p1.x)*(p2.x-p1.x)) + ((p2.y-p1.y)*(p2.y-p1.y)));
  }

}
