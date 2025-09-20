public class PlaceTiles {

    public static int placeTile(int n, int m) {

        // base case
        if (n == m) return 2; // tiles can be placed both vertically and horizontally
        if (n < m) return 1;  // tiles can only be placed horizontally (one way)

        // vertically → reduce n by m (since vertical tile occupies full m height)
        int vertPlacements = placeTile(n - m, m);

        // horizontally → reduce n by 1 (since one row is occupied horizontally)
        int horiPlacements = placeTile(n - 1, m);

        return vertPlacements + horiPlacements;
    }

    public static void main(String args[]) {
        int n = 4, m = 2;
        System.out.println(placeTile(n, m)); // Expected Output: 5
    }
}
