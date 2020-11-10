import java.awt.*;
import java.awt.geom.Point2D;

public class Bil implements Movable {

    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private double speedFactor;
    private Point2D position;
    private int direction; // 0 = norr, 1 = öst, 2 = syd, 3 = väst

    /**
     * Constructor for Bil
     * @param nrDoors number of doors to set
     * @param enginePower the engine power to set
     * @param color the color to set
     * @param modelName the model name to set
     */
    public Bil(int nrDoors, double enginePower, Color color, String modelName) {
        setNrDoors(nrDoors);
        setEnginePower(enginePower);
        setColor(color);
        setModelName(modelName);
        this.position = new Point2D.Double( 0.0, 0.0);
    }

    /**
     * Set the number of doors on car
     * @param nr the number of doors to set
     */
    private void setNrDoors(int nr) {
        this.nrDoors = nr;
    }

    /**
     * Set the engine power
     * @param pw the power to set
     */
    private void setEnginePower(double pw) {
        this.enginePower = pw;
    }

    /**
     * The the color
     * @param color the color to set
     */
    private void setColor(Color color) {
        this.color = color;
    }

    /**
     * The model name
     * @param modelName the model name
     */
    private void setModelName(String modelName) {
        this.modelName = modelName;
    }

    /**
     * Sets the speedfactor
     * @param speedFactor the speedfactor to set
     */
    public void setSpeedFactor(double speedFactor) {
        this.speedFactor = speedFactor;
    }

    /**
     * Get the number of doors on the car
     * @return the number of doors on the car
     */
    public int getNrDoors(){
        return nrDoors;
    }

    /**
     * Get the engine power
     * @return the engine power
     */
    public double getEnginePower(){
        return enginePower;
    }

    /**
     * Get the current speed of the car
     * @return the current speed
     */
    public double getCurrentSpeed(){
        return currentSpeed;
    }

    /**
     * Get the color of the car
     * @return the color of the car
     */
    public Color getColor(){
        return color;
    }

    /**
     * Get the model name
     * @return the model name
     */
    public String getModelName() {
        return modelName;
    }

    /**
     * Get the position
     * @return the position
     */
    public Point2D getPosition() {
        return position;
    }

    /**
     * Get the direction
     * @return the direction
     */
    public int getDirection() {
        return direction;
    }

    /**
     * Sets the current speed to 0.1
     */
    public void startEngine(){
        currentSpeed = 0.1;
    }

    /**
     * Sets the current speed to 0
     */
    public void stopEngine(){
        currentSpeed = 0;
    }

    /**
     * Increases the speed (up to a maximum of enginePower)
     * @param amount the amount of gas applied
     */
    private void incrementSpeed(double amount){
        double newSpeed = getCurrentSpeed() + speedFactor * amount;
        if (newSpeed >= currentSpeed) {
            currentSpeed = Math.min(newSpeed, enginePower);
        }
    }

    /**
     * Decreases the speed (to a minimum to 0)
     * @param amount the amount of brake applied
     */
    private void decrementSpeed(double amount){
        double newSpeed = getCurrentSpeed() - speedFactor * amount;
        if (newSpeed <= currentSpeed) {
            currentSpeed = Math.max(newSpeed, 0);
        }
    }

    /**
     * The amount of gas causing acceleration
     * @param amount of gas
     */
    // TODO fix this method according to lab pm
    public void gas(double amount){
        if (amount < 0 || amount > 1)
            throw new IllegalArgumentException("Not between 0 and 1");
        incrementSpeed(amount);
    }

    /**
     * The amount of braking causing retardation
     * @param amount of brake applied
     */
    // TODO fix this method according to lab pm
    public void brake(double amount){
        if (amount < 0 || amount > 1)
            throw new IllegalArgumentException("Not between 0 and 1");
        decrementSpeed(amount);
    }

    /**
     * Changes the car's position according to speed and direction
     */
    @Override
    public void move() {
        if (direction == 0) {
            this.position.setLocation(position.getX(), position.getY() + getCurrentSpeed());
        } else if (direction == 1) {
            this.position.setLocation(position.getX() + getCurrentSpeed(), position.getY());
        } else if (direction == 2) {
            this.position.setLocation(position.getX(), position.getY() - getCurrentSpeed());
        } else {
            this.position.setLocation(position.getX() - getCurrentSpeed(), position.getY());
        }
    }

    /**
     * Changes the cars rotation 90 to the left
     */
    @Override
    public void turnLeft() {
        if (direction > 0) {
            direction -= 1;
        } else {
            direction = 3;
        }
    }

    /**
     * Changes the cars rotation 90 to the right
     */
    @Override
    public void turnRight() {
        if (direction < 3) {
            direction += 1;
        } else {
            direction = 0;
        }
    }
}












