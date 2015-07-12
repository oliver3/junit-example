import java.util.ArrayList;
import java.util.List;

public class Mandje {
    public static final int BEZORGKOSTEN_GRENS = 20;
    public static final int BEZORGKOSTEN_PRIJS = 4;

    private List<Product> producten = new ArrayList<Product>();

    public void addProduct(Product product) {
        producten.add(product);
    }

    public int getTotaalPrijs() {
        int totaal = 0;
        for (Product product : producten) {
            totaal += (product.getAantal() * product.getPrijs());
        }
        if (totaal < BEZORGKOSTEN_GRENS) {
            totaal += BEZORGKOSTEN_PRIJS;
        }
        return totaal;
    }
}
