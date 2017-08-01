/**
 * TCSS 305 - SPRING 2016
 * Assignment 3 - Easy Street
 */
package model;

import java.util.Map;

/**
 * Represents a Taxi.
 * 
 * @author John Chang
 * @version 23 April 2016
 */
public class Taxi extends AbstractVehicle {

    /** Constant represent death time for this vehicle. */
    private static final int DEATHTIME = 10;
    
    /**
     * Instantiates the instance fields.
     * 
     * @param theX the X coordinate
     * @param theY the Y coordinate
     * @param theDir the Direction
     */
    public Taxi(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, DEATHTIME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean result = false;
        if (theTerrain == Terrain.STREET 
                        || theTerrain == Terrain.CROSSWALK
                        || theTerrain == Terrain.LIGHT) {
            result = true;
        } 
        if (theTerrain == Terrain.LIGHT
                        && theLight == Light.RED) {
            result = false;
        }
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Direction chooseDirection(final Map<Direction, Terrain> theNeighbors) {
        Direction current = super.getDirection();
        if (theNeighbors.get(current) == Terrain.WALL 
                        || theNeighbors.get(current) == Terrain.GRASS
                        || theNeighbors.get(current) == Terrain.TRAIL) {
            current = current.left();
        } 
        if (theNeighbors.get(current) == Terrain.WALL 
                        || theNeighbors.get(current) == Terrain.GRASS
                        || theNeighbors.get(current) == Terrain.TRAIL) {
            current = current.reverse();            
        }
        if (theNeighbors.get(current) == Terrain.WALL
                        || theNeighbors.get(current) == Terrain.GRASS
                        || theNeighbors.get(current) == Terrain.TRAIL) {
            current = current.right();            
        }
        return current;
    }
    
}
