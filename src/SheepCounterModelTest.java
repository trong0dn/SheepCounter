import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SheepCounterModelTest {

    private SheepCounterModel model;

    @Before
    public void setUp() throws Exception {
        this.model = new SheepCounterModel();
    }

    @Test
    public void getStatusInconsistent() {
        model.setTotalSheep(50);
        model.setCurrentSheep(51);
        assertEquals(SheepCounterModel.Status.INCONSISTENT, model.getStatus());
    }

    @Test
    public void getStatusComplete() {
        model.setTotalSheep(50);
        model.setCurrentSheep(51);
        assertEquals(SheepCounterModel.Status.INCONSISTENT, model.getStatus());
    }

    @Test
    public void getStatusIncomplete() {
        model.setTotalSheep(50);
        model.setCurrentSheep(51);
        assertEquals(SheepCounterModel.Status.INCONSISTENT, model.getStatus());
    }

    @Test
    public void setTotal() {
        model.setTotalSheep(49);
        assertEquals(49, model.getTotalSheep());
    }

    @Test
    public void increment() {
        model.setCurrentSheep(29);
        model.increment();
        assertEquals(30, model.getCurrentSheep());
    }

    @Test
    public void decrement() {
    }
}