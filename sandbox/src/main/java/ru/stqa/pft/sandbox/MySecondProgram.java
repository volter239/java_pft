package ru.stqa.pft.sandbox;

public class MySecondProgram {

  public static void main(String[] args) {
    Point2 p = new Point2(0.5, 0.7, 1.5, 1.7);
    System.out.println("Использование метода: расстояние между точками  (" + p.x1 + "," + p.y1 + ") и (" + p.x2 + "," + p.y2 + ") = " + p.distance());
  }
}
