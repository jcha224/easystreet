/**
 * TCSS 305 - SPRING 2016
 * Assignment 3 - Easy Street
 */
package model;

import java.util.Map;

/**
 * Represents an all-terrain vehicle.
 * 
 * @author John Chang
 * @version 23 April 2016
 */
public class Atv extends AbstractVehicle {

    /** Constant represent death time for this vehicle. */
    private static final int DEATHTIME = 20;
    
    /**
     * Instantiates the instance fields.
     * 
     * @param theX the X coordinate
     * @param theY the Y coordinate
     * @param theDir the Direction
     */
    public Atv(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, DEATHTIME);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean result = true;
        if (theTerrain == Terrain.WALL) {
            result = false;
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        Direction result = super.chooseDirection(theNeighbors);
        while (result == super.getDirection().reverse() 
                        || theNeighbors.get(result) == Terrain.WALL) {
            result = Direction.random();
        }
        return result;
    }
    

}
