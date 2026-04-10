package fr.ensai.elevator;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

class ElevatorTest {

    /**
     * Il est compliqué de tester la méthode isFull() puisqu'elle
     * fait appel au nombre d'individus dans l'ascenceur. Mais on devrait alors 
     * générer un MOCK pour la liste des passagers, ce qui complexifié beaucoup
     * le test pour une fonction qui est censé être simple. En effet, on ne possède pas 
     * de méthode pour générer des ascenceurs avec des individus déjà dedans.
     */
    @Test
    void isFullSucessTest(){}

}
