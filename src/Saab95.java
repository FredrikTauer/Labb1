import java.awt.*;

public class Saab95 extends Bil{


    private boolean turboOn;

    /**
     * Constructor for Saab95
     * @param nrDoors the number of doors to set
     * @param enginePower the engine power to set
     * @param color the color to set
     * @param modelName the model name to set
     */
    public Saab95(int nrDoors, double enginePower, Color color, String modelName){
        super(nrDoors, enginePower, color, modelName);
	    turboOn = false;
	    this.setSpeedFactor(speedFactor());
        stopEngine();
    }

    /**
     * Sets the state of turboOn to true.
     */
    public void setTurboOn(){
	    turboOn = true;
    }

    /**
     * Sets the state of turboOn to false.
     */
    public void setTurboOff(){
	    turboOn = false;
    }

    /**
     * Get the speed factor of the car
     * @return the speedfactor
     */
    public double speedFactor() {
        double turbo = 1;
        if(turboOn) turbo = 1.3;
        return getEnginePower() * 0.01 * turbo;
    }
}
