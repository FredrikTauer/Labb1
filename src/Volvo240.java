import java.awt.*;

public class Volvo240 extends Bil{

    private final static double trimFactor = 1.25;

    /**
     * Constructor for Volvo240
     * @param nrDoors the number of doors to set
     * @param enginePower the engine power to set
     * @param color the color to set
     * @param modelName the model name to set
     */
    public Volvo240(int nrDoors, double enginePower, Color color, String modelName){
        super(nrDoors, enginePower, color, modelName);
        this.setSpeedFactor(speedFactor());
        stopEngine();
    }

    /**
     * Get the speedfactor of the car
     * @return the speedfactor
     */
    private double speedFactor(){
        return getEnginePower() * 0.01 * trimFactor;
    }

}
