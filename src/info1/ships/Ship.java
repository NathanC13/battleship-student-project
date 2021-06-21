package info1.ships;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * une implémentation "abstraite" d'un bateau quelconque, de taille indéterminée
 */


public abstract class Ship implements IShip {

    // TODO
    private String name;
    private Coord ayFront;
    private Coord ayBack;

    /**
     * NB : LA SIGNATURE DU CONSTRUCTEUR DOIT ETRE RESPECTEE
     *
     * construit un bateau quelconque
     * @param name le nom du bateau
     * @param ayFront la coordonnée de la proue du bateau
     * @param ayBack la coordonnée de la poupe du bateau
     * @throws BadCoordException si l'une des coordonnées données ne définit pas une coordonnée alphanumérique correcte
     * @throws CoordsBadShipException si les coordonnées données ne permettent pas de définir un bateau correct :
     *  une ligne, une colonne, de la bonne taille, etc.
     */
    public Ship(String name, String ayFront, String ayBack)
            throws BadCoordException, CoordsBadShipException {
        // TODO
        this.name = name;
        this.ayFront = new Coord(ayFront);
        this.ayBack = new Coord(ayBack);

        if (getCategory() == ShipCategory.AIRCRAFT_CARRIER){
            if (this.getSize() != 5){
                throw new CoordsBadShipException();
            }
        }

        if (getCategory() == ShipCategory.CRUISER){
            if (this.getSize() != 3){
                throw new CoordsBadShipException();
            }
        }

        if (getCategory() == ShipCategory.BATTLESHIP){
            if (this.getSize() != 4){
                throw new CoordsBadShipException();
            }
        }

        if (getCategory() == ShipCategory.DESTROYER){
            if (this.getSize() != 2){
                if (this.getSize() != 3){
                    throw new CoordsBadShipException();
                }
            }
        }

        if (getCategory() == ShipCategory.SUBMARINE){
            if (this.getSize() != 1){
                throw new CoordsBadShipException();
            }
        }
    }


    @Override
    public List<ICoord> getCoords() {
        // TODO

        List<ICoord> val = new LinkedList<>();

        if (this.ayFront.getX() == this.ayBack.getX()){
            int min = Math.min(this.ayFront.getY(), this.ayBack.getY());
            int max = Math.max(this.ayFront.getY(), this.ayBack.getY());
            for (int i = 0; min <= max; min++){

                try {
                    val.add(new Coord(this.ayFront.getAlphaX()+ "" + min));
                } catch (BadCoordException e) {
                    e.printStackTrace();
                }
            }
        }else if (this.ayFront.getY() == this.ayBack.getY()){

            char min = (char) Math.min(this.ayFront.getAlphaX(), this.ayBack.getAlphaX());
            char max = (char) Math.max(this.ayFront.getAlphaX(), this.ayBack.getAlphaX());
            for (int i = 0; min <= max; min++){

                try {
                    val.add(new Coord(min + "" + this.ayFront.getY()));
                } catch (BadCoordException e) {
                    e.printStackTrace();
                }
            }

        }

        if (this.ayFront.getX() > this.ayBack.getX() || this.ayFront.getY() > this.ayBack.getY()){
            Collections.reverse(val);
        }

        return val;

    }

    @Override
    public ICoord getFront() {
        //TODO
        return this.ayFront;
    }

    @Override
    public ICoord getBack() {
        // TODO
        return this.ayBack;
    }

    @Override
    public String getName() {
        // TODO
        return this.name;
    }

    @Override
    public int getSize() {
        // TODO

        if (this.ayFront.getX() == this.ayBack.getX()){
            return (Math.abs(this.ayFront.getY()-this.ayBack.getY())+1);
        }else if (this.ayFront.getY() == this.ayBack.getY()){
            return (Math.abs(this.ayFront.getX()-this.ayBack.getX())+1);
        }

        return -1;

    }

    @Override
    public String toString() {
        // TODO
        return this.name + " " + this.ayFront + " " + this.ayBack;
    }

    @Override
    public boolean equals(Object o) {
        // TODO

        if ((o!=null) && (o.getClass()==getClass())){
            Ship ship = (Ship) o;
            if (this.name.equals(ship.name)){
                if (this.ayFront.equals(ship.ayFront)){
                    if (this.ayBack.equals(ship.ayBack)){
                        return true;
                    }
                }
            }

        }

        return false;

    }

    @Override
    public int hashCode() {
        // TODO

        int hash = 1;
        hash = hash * 17 + this.name.hashCode();
        hash = hash * 31 + this.ayFront.hashCode();
        hash = hash * 13 + this.ayBack.hashCode();


        return hash;

    }


}
