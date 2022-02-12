import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PointTest {

    @Test
    public void calculateSlope(){
        Point p = new Point(19442, 16965);
        Point q = new Point(817, 27043);
        Point r = new Point(30924, 18040);

        Assertions.assertEquals(-0.5411006711409396, p.slopeTo(q));
        Assertions.assertEquals(0.09362480404110782, p.slopeTo(r));
    }

    @Test
    public void shouldComparePointsAndReturnsNegative(){
        Point p = new Point(19442, 16965);
        Point q = new Point(817, 27043);
        Point r = new Point(30924, 18040);

        Assertions.assertEquals(-1, p.compareTo(q));
        Assertions.assertEquals(-1, p.compareTo(r));
    }

    @Test
    public void shouldComparePointsAndReturnsPositive(){
        Point p = new Point(470, 439);
        Point q = new Point(495, 197);
        Assertions.assertEquals(1, p.compareTo(q));
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionIfCompareToReceiveNull(){
        Point p = new Point(470, 439);
        Assertions.assertThrows(NullPointerException.class, () -> {
            p.compareTo(null);
        });
    }

    @Test
    public void shouldThrowsIllegalArgumentExceptionIfSlopeToReceiveNull(){
        Point p = new Point(470, 439);
        Assertions.assertThrows(NullPointerException.class, () -> {
            p.slopeTo(null);
        });
    }

    @Test
    public void shouldReturnPositiveInfinity(){
        Point p = new Point(8, 7);
        Point q = new Point(8, 0);

        Assertions.assertEquals(Double.POSITIVE_INFINITY, p.slopeTo(q));
    }


}