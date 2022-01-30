import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PercolationTest {

    @Test
    public void shouldSiteBeClosedByDefault(){
        Percolation percolation = new Percolation(3);

        Assertions.assertFalse(percolation.isOpen(1,1));
    }

    @Test
    public void shouldSiteBeEmptyIfClosed(){
        Percolation percolation = new Percolation(3);

        Assertions.assertFalse(percolation.isOpen(1,1));
        Assertions.assertFalse(percolation.isFull(1,1));
    }

    @Test
    public void shouldPercolate(){
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
    public void shouldPercolate4(){
        Percolation percolation = new Percolation(4);
        percolation.open(1, 4);
        percolation.open(2, 4);
        percolation.open(2, 3);
        percolation.open(3, 3);
        percolation.open(4, 3);

        Assertions.assertTrue(percolation.percolates());
    }

    @Test
    public void shouldNotPercolate(){
        Percolation percolation = new Percolation(5);
        percolation.open(1, 4);
        percolation.open(2, 4);
        percolation.open(4, 4);
        percolation.open(5, 4);

        Assertions.assertFalse(percolation.percolates());
    }

    @Test
    public void shouldWorksWithSize1(){
        Percolation percolation = new Percolation(1);
    }

    @Test
    public void shouldWorksWithSize2(){
        Percolation percolation = new Percolation(2);
    }

}


