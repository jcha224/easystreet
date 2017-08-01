/**
 * TCSS 305 - SPRING 2016
 * Assignment 3 - Easy Street
 */
package model;

import java.util.Map;

/**
 * Represents a human.
 * 
 * @author John Chang
 * @version 23 April 2016
 */
public class Human extends AbstractVehicle {

    /** Constant represent death time for this vehicle. */
    private static final int DEATHTIME = 50;
    
    /**
     * Instantiates the instance fields.
     * 
     * @param theX the X coordinate
     * @param theY the Y coordinate
     * @param theDir the Direction
     */
    public Human(final int theX, final int theY, final Direction theDir) {
        super(theX, theY, theDir, DEATHTIME);
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean canPass(final Terrain theTerrain, final Light theLight) {
        boolean result = false;
        if (theTerrain == Terrain.GRASS 
                        || theTerrain == Terrain.CROSSWALK) {
            result = true;
        } 
        if (theTerrain == Terrain.CROSSWALK 
                        && theLight == Light.GREEN) {
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
        int terrainCheck = 0;
        for (final Direction dir : theNeighbors.keySet()) {
            if (theNeighbors.get(dir) == Terrain.CROSSWALK) {
                terrainCheck++;
                result = dir;
            }
            if (theNeighbors.get(dir) == Terrain.GRASS) {
                terrainCheck++;
            }
        }
        if (terrainCheck > 1) {
            while (result == super.getDirection().reverse()
                            || (theNeighbors.get(result) == Terrain.STREET
                            || theNeighbors.get(result) == Terrain.LIGHT
                            || theNeighbors.get(result) == Terrain.TRAIL
                            || theNeighbors.get(result) == Terrain.WALL)) {
                result = super.chooseDirection(theNeighbors);
            }
            
        } else {
            result = super.getDirection().reverse();
        }
        
        return result;
    }
    

}
