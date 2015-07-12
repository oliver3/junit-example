import org.junit.Test;

import static org.junit.Assert.*;

public class MandjeTest {
    @Test
    public void testGetTotaalPrijs() throws Exception {
        Mandje mandje = new Mandje();

        mandje.addProduct(new Product(2, "Prei", 2));
        mandje.addProduct(new Product(1, "Brood", 3));
        mandje.addProduct(new Product(5, "Melk", 2));
        mandje.addProduct(new Product(1, "Champagne", 30));

        assertEquals("Totaalprijs is de optelsom", 47, mandje.getTotaalPrijs());
    }

    @Test
    public void testGetTotaalPrijsMetBezorgkosten() throws Exception {
        Mandje mandje = new Mandje();

        int prijs = Mandje.BEZORGKOSTEN_GRENS - 1;
        mandje.addProduct(new Product(1, "Onder de grens product", prijs));

        assertEquals("Totaalprijs is met bezorgkosten",
                prijs + Mandje.BEZORGKOSTEN_PRIJS, mandje.getTotaalPrijs());
    }

    @Test
    public void testGetTotaalPrijsZonderBezorgkosten() throws Exception {
        Mandje mandje = new Mandje();

        int prijs = Mandje.BEZORGKOSTEN_GRENS;
        mandje.addProduct(new Product(1, "Op de grens product", prijs));

        assertEquals("Totaalprijs is zonder bezorgkosten",
                prijs, mandje.getTotaalPrijs());
    }

    @Test
    public void testGetTotaalPrijsLeegWinkelwagentje() throws Exception {
        Mandje mandje = new Mandje();

        assertEquals("Totaalprijs van een leeg mandje is 0",
                0, mandje.getTotaalPrijs());
    }
}