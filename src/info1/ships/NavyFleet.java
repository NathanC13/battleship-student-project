package info1.ships;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Classe définissant une flotte de navires
 */

public class NavyFleet implements INavyFleet {

    // TODO
    private List<IShip> fleet;
    private int size;

    /**
     * NB : LA SIGNATURE DU CONSTRUCTEUR DOIT ETRE RESPECTEE
     *
     * Construit une nouvelle flotte
     */
    public NavyFleet() {
        // TODO
        this.fleet = new ArrayList<>(20);
        this.size = 0;
    }

    @Override
    public int remainingSize() {
        // TODO

        if (this.size<20){
            return 20-this.size;
        }else if (this.size==20){
            return 0;
        }

        return 0;

    }

    @Override
    public boolean isComplete() {
        // TODO

        if (remainingSize()<=0){
            return true;
        }

        return false;

    }


    @Override
    public int add(IShip IShip) {
        // TODO

        if (this.fleet.contains(IShip)){
            return -1;
        }

        if (this.size + IShip.getSize() > 20){
            return -2;
        }

        for (IShip ship: this.fleet) {
            List<ICoord> coordfleet = ship.getCoords();
            List<ICoord> coordship = IShip.getCoords();

            for (ICoord coord: coordship){
                if (coordfleet.contains(coord)){
                    return -3;
                }
            }

        }

        fleet.add(IShip);
        this.size += IShip.getSize();
        return 0;

    }

    @Override
    public List<IShip> getShips() {
        // TODO

        this.fleet.sort(null);

        return this.fleet;

    }

    @Override
    public Set<IShip> getShips(ShipCategory shipCategory) {
        // TODO

        Set set = new LinkedHashSet();

        for (IShip ship: this.fleet){
            if (ship.getCategory()==shipCategory){
                set.add(ship);
            }
        }


        return set;

    }

    @Override
    public boolean isBelgianConfiguration() {
        // TODO

        Set aircraft = getShips(ShipCategory.AIRCRAFT_CARRIER); //porte avion
        Set battleship = getShips(ShipCategory.BATTLESHIP); //cuirasse
        Set cruiser = getShips(ShipCategory.CRUISER); //croiseur
        Set destroyer = getShips(ShipCategory.DESTROYER); //torpilleur
        Set submarine = getShips(ShipCategory.SUBMARINE); //sous marin


        if (aircraft.size()==0){
            if (battleship.size()==1){
                if (cruiser.size()==2){
                    if (destroyer.size()==3){
                        if (submarine.size()==4){
                            return true;
                        }
                    }
                }
            }
        }


        return false;

    }

    @Override
    public boolean isFrenchConfiguration() {
        // TODO

        Set aircraft = getShips(ShipCategory.AIRCRAFT_CARRIER); //porte avion
        Set battleship = getShips(ShipCategory.BATTLESHIP); //cuirasse
        Set cruiser = getShips(ShipCategory.CRUISER); //croiseur
        Set destroyer = getShips(ShipCategory.DESTROYER); //torpilleur
        Set submarine = getShips(ShipCategory.SUBMARINE); //sous marin

        if (aircraft.size()==1){
            if (battleship.size()==1){
                if (cruiser.size()==2){
                    if (destroyer.size()==2){
                        if (submarine.size()==1){
                            return true;
                        }
                    }
                }
            }
        }


        return false;

    }


    @Override
    public String toString() {
        // TODO
        return this.fleet + " " + this.size;
    }
}
