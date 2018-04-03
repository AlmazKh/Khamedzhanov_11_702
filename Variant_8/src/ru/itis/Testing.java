package ru.itis;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.FileInputStream;
import java.util.Scanner;

public class Testing {
    private GraphicPic testedGraphicPic;

    @Before
    public void setTestedGraphicPic() {
        testedGraphicPic = new GraphicPic();
        testedGraphicPic.newGraphicPic("ListOfFigures.txt");
    }

    @Test
    public void testHasSquareBiggerThanZero() {
        GraphicPic result = testedGraphicPic.hasSquareBiggerThanS(0);
        Assert.assertTrue(result.size() == 2);
    }

    /*@Test  //TODO: такой же тест, нужно усложнить
    public void testHasSquareBiggerThanHugeS() {
        GraphicPic result = testedGraphicPic.hasSquareBiggerThanS(10000);
        Assert.assertTrue(result.size() == 1);
    }*/

    @Test
    public void testHasSquareBiggerThanS() {
        GraphicPic result = testedGraphicPic.hasSquareBiggerThanS(10);
        for(int i = 0; i < result.size(); i++) {
            if(result.get(i).getType().equals("3")) {
                double sOfCircle = Math.PI * Double.parseDouble(result.get(i).getRightX())*Double.parseDouble(result.get(i).getRightX());
                if(sOfCircle > 10) {
                    continue;
                } else {
                    Assert.assertTrue(false);
                    return;
                }
            }
            if(result.get(i).getType().equals("1")) {
                double sOfRectangle = (Double.parseDouble(result.get(i).getLeftY()) - Double.parseDouble(result.get(i).getRightY())) *
                        (Double.parseDouble(result.get(i).getRightX()) - Double.parseDouble(result.get(i).getLeftX()));
                if(sOfRectangle > 10) {
                    continue;
                } else {
                    Assert.assertTrue(false);
                    return;
                }
            }
        }
        Assert.assertTrue(true);
    }

    @Test
    public void testNewGraphicPicNotNull() {
        Assert.assertTrue(testedGraphicPic.size() > 1);
    }

    @Test
    public void testNewGraphicPicHasAllFigures() {
        /*GraphicPic result = new GraphicPic();
        result.newGraphicPic("ListOfFigures.txt");*/
        int count = 0;
        try {
            FileInputStream listOfFigures = new FileInputStream("ListOfFigures.txt");
            Scanner scanner = new Scanner(listOfFigures);
            while (scanner.hasNext()) {
                scanner.nextLine();
                count++;
            }
        } catch (Exception e) {

        }
        Assert.assertTrue(testedGraphicPic.size() == count);
    }

    @Test
    public void testDeleteAllSameTypeFigure() {
        testedGraphicPic.delete(2);
        for (int i = 0; i < testedGraphicPic.size(); i++) {
            if(testedGraphicPic.get(i).getType().equals("2")) {
                Assert.assertFalse(true);
                return;
            }
        }
        Assert.assertTrue(true);

    }

    @Test
    public void testInsert() {
        //TODO: сделать тест по размеру(!), типу, и значению цвета
        Figure  figure = new Figure("3", "3", "3", "5", "0", "243");
        int sizeBefore = testedGraphicPic.size();
        testedGraphicPic.insert(figure);
        int sizeAfter = testedGraphicPic.size();
        Assert.assertTrue(sizeAfter == sizeBefore);

    }

}
