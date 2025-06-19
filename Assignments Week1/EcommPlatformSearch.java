import java.util.*;

class Product {
    private final int productId;
    private final String productName;
    private final String category;

    public Product(int productId, String productName, String category) {
        this.productId   = productId;
        this.productName = productName;
        this.category    = category;
    }

    public int getProductId()       { return productId;   }
    public String getProductName()  { return productName; }
    public String getCategory()     { return category;    }

    @Override
    public String toString() {
        return String.format("Product{id=%d,name=%s,cat=%s}",
                              productId, productName, category);
    }
}


public class EcommPlatformSearch {
    // Linear search: returns index or -1
    public static int linearSearch(Product[] arr, String targetName) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].getProductName().equalsIgnoreCase(targetName)) {
                return i;
            }
        }
        return -1;
    }

    // Binary search on sorted-by-name array: returns index or -1
    public static int binarySearch(Product[] arr, String targetName) {
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = arr[mid].getProductName()
                         .compareToIgnoreCase(targetName);
            if (cmp == 0) {
                return mid;
            } else if (cmp < 0) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Product[] products = {
            new Product(1, "Laptop",   "Electronics"),
            new Product(2, "Coffee",   "Grocery"),
            new Product(3, "Smartphone","Electronics"),
            new Product(4, "Desk",     "Furniture")
        };

        // Linear search
        int idx1 = linearSearch(products, "Desk");
        System.out.println("Linear found at index: " + idx1);

        // Prepare sorted array (by name)
        Product[] sorted = Arrays.copyOf(products, products.length);
        Arrays.sort(sorted, (a,b) ->
            a.getProductName().compareToIgnoreCase(b.getProductName())
        );

        // Binary search
        int idx2 = binarySearch(sorted, "Desk");
        System.out.println("Binary found at index: " + idx2);
    }
}
