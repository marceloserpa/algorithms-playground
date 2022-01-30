import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PercolationTest {

    @Test
    public void shouldSiteBeClosedByDefault() {
        Percolation percolation = new Percolation(3);

        Assertions.assertFalse(percolation.isOpen(1, 1));
    }

    @Test
    public void shouldSiteBeEmptyIfClosed() {
        Percolation percolation = new Percolation(3);

        Assertions.assertFalse(percolation.isOpen(1, 1));
        Assertions.assertFalse(percolation.isFull(1, 1));
    }

    @Test
    public void shouldPercolate() {
        Percolation percolation = new Percolation(5);
        percolation.open(1, 4);
        percolation.open(2, 4);
        percolation.open(2, 3);
        percolation.open(3, 3);
        percolation.open(4, 3);
        percolation.open(4, 4);
        percolation.open(5, 4);

        Assertions.assertTrue(percolation.percolates());
    }

    @Test
    public void shouldPercolate4() {
        Percolation percolation = new Percolation(4);
        percolation.open(1, 4);
        percolation.open(2, 4);
        percolation.open(2, 3);
        percolation.open(3, 3);
        percolation.open(4, 3);

        Assertions.assertTrue(percolation.percolates());
    }

    @Test
    public void shouldNotPercolate() {
        Percolation percolation = new Percolation(5);
        percolation.open(1, 4);
        percolation.open(2, 4);
        percolation.open(4, 4);
        percolation.open(5, 4);

        Assertions.assertFalse(percolation.percolates());
    }

    @Test
    public void shouldWorksWithSize1() {
        Percolation percolation = new Percolation(1);
    }

    @Test
    public void shouldWorksWithSize2() {
        Percolation percolation = new Percolation(2);
    }

    // Negative

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenTryOpenRowsNegative() {
        Percolation percolation = new Percolation(10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            percolation.open(-1, 5);
        });
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenTryOpenColNegative() {
        Percolation percolation = new Percolation(10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            percolation.open(2, -1);
        });
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenTryIsFullRowsNegative() {
        Percolation percolation = new Percolation(10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            percolation.isFull(-1, 5);
        });
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenTryIsFullColNegative() {
        Percolation percolation = new Percolation(10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            percolation.isFull(2, -1);
        });
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenTryIsOpenRowsNegative() {
        Percolation percolation = new Percolation(10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            percolation.isOpen(-1, 5);
        });
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenTryIsOpenColNegative() {
        Percolation percolation = new Percolation(10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            percolation.isOpen(2, -1);
        });
    }

    // Greater Numbers
    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenTryOpenGreaterRow() {
        Percolation percolation = new Percolation(10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            percolation.open(11, 5);
        });
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenTryOpenGreaterCol() {
        Percolation percolation = new Percolation(10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            percolation.open(2, 11);
        });
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenTryIsFullGreaterRow() {
        Percolation percolation = new Percolation(10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            percolation.isFull(11, 5);
        });
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenTryIsFullGreaterCol() {
        Percolation percolation = new Percolation(10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            percolation.isFull(2, 11);
        });
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenTryIsOpenGreaterRow() {
        Percolation percolation = new Percolation(10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            percolation.isOpen(11, 5);
        });
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenTryIsOpenGreaterCol() {
        Percolation percolation = new Percolation(10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            percolation.isOpen(2, 11);
        });
    }

    // Zero
    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenTryOpenZeroRow() {
        Percolation percolation = new Percolation(10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            percolation.open(0, 5);
        });
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenTryOpenZEROCol() {
        Percolation percolation = new Percolation(10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            percolation.open(2, 0);
        });
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenTryIsFullzERORow() {
        Percolation percolation = new Percolation(10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            percolation.isFull(0, 5);
        });
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenTryIsFullZeroCol() {
        Percolation percolation = new Percolation(10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            percolation.isFull(2, 0);
        });
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenTryIsOpenZeroRow() {
        Percolation percolation = new Percolation(10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            percolation.isOpen(0, 5);
        });
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionWhenTryIsOpenZeroCol() {
        Percolation percolation = new Percolation(10);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            percolation.isOpen(2, 0);
        });
    }

    @Test
    public void shouldNotPercolate2() {
        Percolation percolation = new Percolation(6);
        percolation.open(1, 6);
        percolation.open(2, 6);
        percolation.open(3, 6);
        percolation.open(4, 6);
        percolation.open(5, 6);

        /**
         *  -  -  -  -  -  x
         *  -  -  -  -  -  x
         *  -  -  -  -  -  x
         *  -  -  -  -  -  x
         *  -  -  -  -  -  x
         *  -  -  -  -  -  -
         */
        Assertions.assertFalse(percolation.percolates());

    }

    @Test
    public void shouldPercolate2() {
        Percolation percolation = new Percolation(6);
        percolation.open(1, 6);
        percolation.open(2, 6);
        percolation.open(3, 6);
        percolation.open(4, 6);
        percolation.open(5, 6);
        percolation.open(5, 5);
        percolation.open(4, 4);
        percolation.open(3, 4);
        percolation.open(2, 4);
        percolation.open(2, 3);
        percolation.open(2, 2);
        percolation.open(2, 1);
        percolation.open(3, 1);
        percolation.open(4, 1);
        percolation.open(5, 1);
        percolation.open(5, 2);
        percolation.open(6, 2);
        percolation.open(5, 4);

        /**
         *  -  -  -  -  -  x
         *  x  x  x  x  -  x
         *  x  -  -  x  -  x
         *  x  -  -  x  -  x
         *  x  x  -  x  x  x
         *  -  x  -  -  -  -
         */
        Assertions.assertTrue(percolation.percolates());

    }
}


