package info1.ships;


/**
 * une implementation de l'interface ICoord manipulant des coordonnées alphanumériques comme "A1", "B6", "J3", etc.
 */

public class Coord implements ICoord {

    // TODO
    private String x;
    private String y;

    /**
     * NB : LA SIGNATURE DU CONSTRUCTEUR DOIT ETRE RESPECTEE
     *
     * constructeur d'un objet Coord
     * @param xy la coordonnée aphanumérique sous la forme d'une chaine de caractères
     * @throws BadCoordException si la chaine de caractère ne permet pas de définir une coordonnée alphanumérique
     */
    public Coord(String xy) throws BadCoordException {
        // TODO
        
        if ((xy.charAt(0)-64) < 1 || (xy.charAt(0)-64) > 10){
            throw new BadCoordException();
        }

        String y = xy.substring(1);

        if (Integer.parseInt(y) > 10 || Integer.parseInt(y) < 1){
            throw new BadCoordException();
        }

        this.x = xy.substring(0,1);
        this.y = xy.substring(1);
    }

    @Override
    public char getAlphaX() {
        // TODO
	return this.x.charAt(0);
    }

    @Override
    public int getX() {
        // TODO
        return this.x.charAt(0) - 64;
    }

    @Override
    public int getY() {
        // TODO
        return Integer.parseInt(this.y);
    }

    @Override
    public String toString() {
        // TODO
        return this.x + "" + this.y ;
    }

    @Override
    public boolean equals(Object o) {
        // TODO
        if ((o!=null) && (o.getClass()==getClass())){
            Coord coord = (Coord) o;

            if (coord.x.equals(this.x) && coord.y.equals(this.y)){
                return true;
            }

        }

        return false;
    }

    @Override
    public int hashCode() {
        // TODO
        
        int hash =1;
        hash = hash * 17 + Integer.parseInt(this.y);
        hash = hash * 31 + (this.x.charAt(0) - 64);
        return hash;
    }
}
