import org.junit.Before;
import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



public class MyTest {

    private Saab95 testSaab;
    private Volvo240 testVolvo;

    @Before
    public void init() {
        testSaab = new Saab95(2, 125, Color.red, "Saab95");
        testSaab.startEngine();
        testVolvo = new Volvo240(4, 125, Color.blue, "Vavlo");
    }


    @Test
    public void testStartEngine() {
        assertTrue(testSaab.getCurrentSpeed() == 0.1);
    }

    @Test
    public void testSpeedfactorGreaterWithTurboOn() {
        testSaab.setTurboOff();
        double speedfactor = testSaab.speedFactor();
        testSaab.setTurboOn();
        assertTrue(testSaab.speedFactor() > speedfactor);
    }

    @Test
    public void testTurnRight() {
        int startDir = testSaab.getDirection();
        testSaab.turnRight();
        assertTrue(startDir != testSaab.getDirection());
        while(testSaab.getDirection() != 3) {
            testSaab.turnRight();
        }
        testSaab.turnRight();
        assertTrue(testSaab.getDirection() == 0);
    }

    @Test
    public void testTurnLeft() {
        int startDir = testSaab.getDirection();
        testSaab.turnLeft();
        assertTrue(startDir != testSaab.getDirection());
        while(testSaab.getDirection() != 0) {
            testSaab.turnLeft();
        }
        testSaab.turnLeft();
        assertTrue(testSaab.getDirection() == 3);
    }

    @Test
    public void testMovement() {
        for (int i = 0; i < 4; i++) {
            double startY = testSaab.getPosition().getY();
            double startX = testSaab.getPosition().getX();
            testSaab.turnRight();
            testSaab.move();
            if (testSaab.getDirection() == 0) {
                assertTrue(testSaab.getPosition().getY() > startY);
            } else if (testSaab.getDirection() == 1) {
                assertTrue(testSaab.getPosition().getX() > startX);
            } else if (testSaab.getDirection() == 2) {
                assertTrue(testSaab.getPosition().getY() < startY);
            } else {
                assertTrue(testSaab.getPosition().getX() < startX);
            }
        }
    }

    @Test
    public void testSpeedIncreaseOnGas() {
        double initalSpeed = testSaab.getCurrentSpeed();
        testSaab.gas(0.9);
        assertTrue(testSaab.getCurrentSpeed() > initalSpeed);
    }

    @Test
    public void testExceptionThrowOnGas() {
        boolean thrown = false;
        try {
            testSaab.gas(1.1);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testExceptionThrownOnBrake() {
        boolean thrown = false;
        try {
            testSaab.brake(1.1);
        } catch (IllegalArgumentException e) {
            thrown = true;
        }
        assertTrue(thrown);
    }

    @Test
    public void testSpeedDecreaseOnBrake() {
        double initalSpeed = testSaab.getCurrentSpeed();
        testSaab.brake(0.9);
        assertTrue(testSaab.getCurrentSpeed() < initalSpeed);
    }

    @Test
    public void testSpeedNeverNegative() {
        testSaab.stopEngine(); // Changes speed to 0
        testSaab.brake(0.9);
        assertTrue(testSaab.getCurrentSpeed() == 0);
    }

    @Test
    public void testSpeedNeverSurpassesEnginePower() {

        for(int i = 1; i< 1000; i++) // TODO Change use of arbitrary number
            testSaab.gas(1);

        assertTrue(testSaab.getCurrentSpeed() == testSaab.getEnginePower());
    }

    @Test
    public void testGetColor() {
        Color trueColor = Color.red;
        assertTrue(testSaab.getColor() == trueColor);
    }

    @Test
    public void testGetNrOfDoors() {
        int trueNrOfDoors = 2;
        assertTrue(testSaab.getNrDoors() == 2);
    }

    @Test
    public void testGetModelName() {
        String trueModelName = "Saab95";
        assertTrue(testSaab.getModelName() == trueModelName);
    }

}
