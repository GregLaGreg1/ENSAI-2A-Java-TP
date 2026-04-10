package fr.ensai.elevator;

import java.util.Random;

public class CrazyElevator extends Elevator{

    private static Random random = new Random();

    public CrazyElevator(int id, int startFloor, int capacity){
        super(id, startFloor, capacity);
        
    }

    /**
     * On pioche avec équiproba égale à 1/3 une des situations au choix:
     * L'ascenceur ne bouge pas; il évite le prochain arrêt et va directement au 
     * suivant; il se comporte normalement et va au prochain arrêt.
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
     * Determine le nombre de passagers qui descendent dans cas différents
     * tirés avec équiproba de 1/2 : Soit l'ascenceur s'arrête et se vide effectivement, 
     * soit il ne s'arrête pas
     * 
     * @param floor L'étage où s'arrête les passagers
     * @return Le nombre de passagers qui descendent
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
     * Determine si l'ascenceur envoie les passagers dans l'espace s'il est plein 
     * et qu'il y en a trop, soit il les fait monter simplement
     * 
     * @param floor L'étage où les personnes veulemnt rentrer dans l'ascenceur
     */
    @Override
    public void loadPassengers(Floor floor) {
    if (this.isFull()) {
        this.getpassengers().clear();
    } else {
        super.loadPassengers(floor);
    }
}
}