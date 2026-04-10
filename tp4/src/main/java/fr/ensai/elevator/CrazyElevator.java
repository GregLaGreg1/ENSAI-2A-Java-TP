package fr.ensai.elevator;

import static fr.ensai.elevator.Elevator.logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CrazyElevator extends Elevator{

    private static Random random = new Random();

    public CrazyElevator(int id, int startFloor, int capacity){
        super(id, startFloor, capacity);
        
    }

    /**
     * At each step, a crazy elevator can, with equal probability:
     * remain stationary
     * skip its next destination and go directly to the next one
     * go to the next floor as a normal elevator
     */
    @Override
    public void move() {
        int nbCas = random.nextInt(3);
        switch (nbCas) {
            case 0 -> {return;}
            case 1 -> {if (this.getDestinationQueueSize() >= 2){
                           this.getdestinationQueue().remove(0);
                           super.move();}}
            case 2 -> {super.move();}
        }
    }

    /**
     * Half of the time, the elevator unloads passengers whose target floor matches the current floor.
     * The other half it doesn't.
     * Updates the lastUnloaded list.
     * 
     * @param floor the Floor where passengers will exit
     * @return the number of passengers unloaded
     */
    @Override
    public int unloadPassengers(Floor floor) {
        int nbCas = random.nextInt(2);
        switch (nbCas) {
            case 0 -> {return 0;}
            case 1 -> {return super.unloadPassengers(floor);}
            default -> { return 0; }
        }
    }
    
    /**
     * Loads passengers waiting on the specified floor to the space if
     * the elevator is full, otherwise will act as usual
     * 
     * @param floor the Floor where passengers board the elevator
     */
    @Override
    public void loadPassengers(Floor floor) {
    if (this.isFull()){
        this.getpassengers().clear();
        }
    else {
        super.loadPassengers(floor);}
    }
}