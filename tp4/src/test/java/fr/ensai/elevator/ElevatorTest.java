package fr.ensai.elevator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ElevatorTest {

    /**
     * Il est compliqué de tester la méthode isFull() car on ne peut pas facilement
     * mettre des passagers dans l'ascenseur sans passer par un Mock où il faudrait
     * définir tous les passagers. La méthode addPassengersElevator() règle ce problème
     * en permettant d'ajouter directement un nombre définides passagers pour les tests.
     */

    /**
     * Teste que isFull() retourne true quand l'ascenseur est à pleine capacité.
     */
    @Test
    void isFullSuccessTest() {
        Elevator elevator = new Elevator(1, 0, 3);
        elevator.addPassengersElevator(3);
        assertTrue(elevator.isFull());
    }

    /**
     * Teste que isFull() retourne false quand l'ascenseur n'est pas plein.
     */
    @Test
    void isFullFailureTest() {
        Elevator elevator = new Elevator(1, 0, 3);
        elevator.addPassengersElevator(1);
        assertFalse(elevator.isFull());
    }

    /**
     * Teste que addDestination() ajoute correctement un nouvel étage à la file.
     */
    @Test
    void addDestinationNewFloorTest() {
        Elevator elevator = new Elevator(1, 0, 3);
        elevator.addDestination(5);
        assertTrue(elevator.containDestination(5));
        assertEquals(1, elevator.getDestinationQueueSize());
    }

    /**
     * Teste que addDestination() n'ajoute pas un étage déjà présent dans la file.
     */
    @Test
    void addDestinationDuplicateTest() {
        Elevator elevator = new Elevator(1, 0, 3);
        elevator.addDestination(5);
        elevator.addDestination(5);
        assertEquals(1, elevator.getDestinationQueueSize());
    }

    /**
     * Teste que addDestination() ajoute correctement plusieurs étages différents à la file.
     */
    @Test
    void addDestinationMultipleTest() {
        Elevator elevator = new Elevator(1, 0, 3);
        elevator.addDestination(2);
        elevator.addDestination(4);
        elevator.addDestination(6);
        assertEquals(3, elevator.getDestinationQueueSize());
    }
}