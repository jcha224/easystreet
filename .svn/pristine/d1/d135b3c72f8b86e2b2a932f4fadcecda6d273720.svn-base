/**
 * TCSS 305 - SPRING 2016
 * Assignment 3 - Easy Street
 */
package model;

import java.util.Map;

/**
 * Represents a bicycle.
 * 
 * @author John Chang
 * @version 23 April 2016
 */
public class Bicycle extends AbstractVehicle {

    /** Constant represent death time for this vehicle. */
    private static final int DEATHTIME = 30;
    
    /**
     * Instantiates the instance fields.
     * 
     * @param theX the X coordinate
     * @param theY the Y coordinate
     * @param theDir the Direction
     */
    public Bicycle(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, DEATHTIME);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean result = false;
        if (theTerrain == Terrain.TRAIL 
                        || theTerrain == Terrain.STREET
                        || theTerrain == Terrain.LIGHT
                        || theTerrain == Terrain.CROSSWALK) {
            result = true;
        } 
        if ((theTerrain == Terrain.CROSSWALK 
                        || theTerrain == Terrain.LIGHT)
                        && (theLight == Light.RED
                        || theLight == Light.YELLOW)) {
            result = false;
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        final Direction result = super.getDirection();
        boolean trailCheck = false;
        for (final Direction dir : theNeighbors.keySet()) {
            if (theNeighbors.get(dir) == Terrain.TRAIL
                            && dir != super.getDirection().reverse()) {
                trailCheck = true;
            }
        }
        return chooseDirection(theNeighbors, result, trailCheck);
    }
    
    /**
     * This is a helper method for the original chooseDirection method.
     * 
     * @param theNeighbors the map of surrounding terrain
     * @param theDir the current direction of vehicle
     * @param theTrail checks if there is a trail nearby
     * @return the final direction
     */
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors, 
                                     final Direction theDir, final boolean theTrail) {
        Direction result = theDir;
        if (theTrail) {
            if (theNeighbors.get(result) != Terrain.TRAIL) {
                result = result.left();
            } 
            if (theNeighbors.get(result) != Terrain.TRAIL) {
                result = result.reverse();
            }
        } else {
            if (theNeighbors.get(result) == Terrain.GRASS 
                            || theNeighbors.get(result) == Terrain.WALL) {
                result = result.left();
            } 
            if (theNeighbors.get(result) == Terrain.GRASS 
                            || theNeighbors.get(result) == Terrain.WALL) {
                result = result.reverse();            
            }
            if (theNeighbors.get(result) == Terrain.GRASS 
                            || theNeighbors.get(result) == Terrain.WALL) {
                result = result.right();            
            }
        }
        return result;
    }
    
}
