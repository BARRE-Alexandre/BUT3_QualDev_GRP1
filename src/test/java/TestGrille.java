import modele.Grille;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestGrille {
    private Grille grille;

    @Before
    public void setUp() {
        this.grille = new Grille(5,5);
    }

    @Test
    public void testGetTaille(){
        int expectedSize = 36;
        int actualSize = grille.getTaille();
        Assert.assertEquals(expectedSize, actualSize);
    }

    @Test
    public void testGetCaseUtiliseLesCoordonnees() {
        Assert.assertEquals(2, grille.getCase(2, 4).getX());
        Assert.assertEquals(4, grille.getCase(2, 4).getY());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testGetCaseRefuseUneCoordonneeHorsGrille() {
        grille.getCase(6, 0);
    }

}
