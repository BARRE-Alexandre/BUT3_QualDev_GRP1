import enumerations.EDirection;
import exceptions.DeplacementException;
import modele.Tondeuse;
import org.junit.Assert;
import org.junit.Test;
import static enumerations.EDeplacement.*;

public class TestTondeuse {

    private Tondeuse tondeuse;

    @Test
    public void testDeplacementGauchePuisEnAvant() throws DeplacementException {
        tondeuse = new Tondeuse(5,5,1,2, EDirection.NORTH);
        tondeuse.deplacement(G);
        tondeuse.deplacement(A);
        Assert.assertEquals(0, tondeuse.getCaseFinale().getX());
        Assert.assertEquals(2, tondeuse.getCaseFinale().getY());
        Assert.assertSame(EDirection.WEST, tondeuse.getSens());
    }

    @Test
    public void testDeplacementDroitePuisEnAvant() throws DeplacementException {
        tondeuse = new Tondeuse(5,5,1,2, EDirection.NORTH);
        tondeuse.deplacement(D);
        tondeuse.deplacement(A);
        Assert.assertEquals(2, tondeuse.getCaseFinale().getX());
        Assert.assertEquals(2, tondeuse.getCaseFinale().getY());
        Assert.assertSame(EDirection.EAST, tondeuse.getSens());
    }

    @Test
    public void testDeplacementAvant() throws DeplacementException {
        tondeuse = new Tondeuse(5,5,1,2, EDirection.NORTH);
        tondeuse.deplacement(A);
        Assert.assertEquals(1, tondeuse.getCaseFinale().getX());
        Assert.assertEquals(1, tondeuse.getCaseFinale().getY());
        Assert.assertSame(EDirection.NORTH, tondeuse.getSens());
    }

    @Test
    public void testDeplacementArriere() throws DeplacementException {
        tondeuse = new Tondeuse(5,5,1,2, EDirection.NORTH);
        tondeuse.deplacement(G);
        tondeuse.deplacement(G);
        tondeuse.deplacement(A);
        Assert.assertEquals(1, tondeuse.getCaseFinale().getX());
        Assert.assertEquals(3, tondeuse.getCaseFinale().getY());
        Assert.assertSame(EDirection.SOUTH, tondeuse.getSens());
    }

    @Test
    public void testDeplacementHorsGrilleNeChangePasLaPosition() {
        tondeuse = new Tondeuse(5, 5, 0, 0, EDirection.NORTH);
        try {
            tondeuse.deplacement(A);
            Assert.fail("Un déplacement hors de la grille doit échouer.");
        } catch (DeplacementException expected) {
            Assert.assertEquals(0, tondeuse.getCaseFinale().getX());
            Assert.assertEquals(0, tondeuse.getCaseFinale().getY());
        }
    }

    @Test
    public void TestDeplacementGeneral() throws DeplacementException {
        tondeuse = new Tondeuse(5,5,1,2,EDirection.NORTH);
        tondeuse.deplacement(G);
        tondeuse.deplacement(A);
        tondeuse.deplacement(G);
        tondeuse.deplacement(A);
        tondeuse.deplacement(G);
        tondeuse.deplacement(A);
        tondeuse.deplacement(G);
        tondeuse.deplacement(A);
        tondeuse.deplacement(A);
        Assert.assertEquals(1, tondeuse.getCaseFinale().getX());
        Assert.assertEquals(1, tondeuse.getCaseFinale().getY());
        Assert.assertSame(EDirection.NORTH, tondeuse.getSens());
    }

    @Test
    public void TestDeplacementGeneralAutre() throws DeplacementException {
        tondeuse = new Tondeuse(5,5,3,3,EDirection.EAST);
        tondeuse.deplacement(A);
        tondeuse.deplacement(A);
        tondeuse.deplacement(D);
        tondeuse.deplacement(A);
        tondeuse.deplacement(A);
        tondeuse.deplacement(D);
        tondeuse.deplacement(A);
        tondeuse.deplacement(D);
        tondeuse.deplacement(D);
        tondeuse.deplacement(A);
        Assert.assertEquals(5, tondeuse.getCaseFinale().getX());
        Assert.assertEquals(5, tondeuse.getCaseFinale().getY());
        Assert.assertSame(EDirection.EAST, tondeuse.getSens());
    }

}
