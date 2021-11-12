import java.util.EventObject;

public class SheepCounterEvent extends EventObject {
    private final SheepCounterModel.Status status;
    private final int total;
    private final int current;

    public SheepCounterEvent(SheepCounterModel sheepCounterModel) {
        super(sheepCounterModel);
        this.total = sheepCounterModel.getTotalSheep();
        this.current = sheepCounterModel.getCurrentSheep();
        this.status = sheepCounterModel.getStatus();
    }

    public int getTotal() {
        return total;
    }

    public int getCurrent() {
        return current;
    }

    public SheepCounterModel.Status getStatus() {
        return status;
    }
}
