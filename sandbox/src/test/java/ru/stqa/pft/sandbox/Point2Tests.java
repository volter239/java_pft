package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Point2Tests {

    @Test
    public void testArea() {
        Point2 p = new Point2(0.5, 0.7, 1.5, 1.7);
        Assert.assertTrue((p.distance()-1.4142<0.001));
    }

}
