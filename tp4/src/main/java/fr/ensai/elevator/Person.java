package fr.ensai.elevator;

import java.util.Random;

/**
 * Represents a person in the hotel elevator simulation.
 */
public class Person {

    private String nickname;
    private int startFloor;
    private int targetFloor;
    private Direction direction;

    private static final String CHARS = "abcdefghijklmnopqrstuvwxyz";
    private static int NEXT_CHAR_INDEX = 0;

    private static Random random = new Random();

    /**
     * Constructs a new Person starting at the specified floor,
     * with the direction of where he is headed, based on the position of
     * his starting and arriving floor.
     * 
     * @param startFloor the floor number where the person starts
     */
    public Person(int startFloor) {
        this.nickname = Person.generateNickname();
        this.startFloor = startFloor;
        this.targetFloor = this.generateTargetFloor();
        this.direction = this.getDirection();
    }

    /**
     * Generates a sequential nickname from the predefined character set.
     * Loops back to the beginning when the end of the set is reached.
     * 
     * @return a unique nickname character
     */
    private static String generateNickname() {
        NEXT_CHAR_INDEX = (NEXT_CHAR_INDEX == 25) ? 0 : NEXT_CHAR_INDEX;
        return String.valueOf(CHARS.charAt(NEXT_CHAR_INDEX++));
    }

    /**
     * Generates a random target floor based on the real number of floors in the hotel
     * And the person has to go to a different floor than the starting one
     * 
     * @return the target floor number
     */
    private int generateTargetFloor() {
        int nbFloors = Config.getInt("hotel.floors.number");
        int nbGeneratedFloor = random.nextInt(nbFloors);
        while (nbGeneratedFloor == this.startFloor){
            nbGeneratedFloor = random.nextInt(nbFloors);
        }
        return nbGeneratedFloor;
    }

    public String getNickname() {
        return this.nickname;
    }

    public int getStartFloor() {
        return this.startFloor;
    }

    public int getTargetFloor() {
        return this.targetFloor;
    }

    @Override
    public String toString() {
        return this.nickname + this.targetFloor;
    }
    /**
     * Calcule la direction de la personne, où les directions sont
     * stockées dans la classe ENUM
     *  */ 
    public Direction getDirection() {
    if (this.targetFloor > this.startFloor) {
        return Direction.UP;
    } 
    if (this.targetFloor < this.startFloor) {
        return Direction.DOWN;
    }
    else {
        return Direction.IDLE;
    }
}
}