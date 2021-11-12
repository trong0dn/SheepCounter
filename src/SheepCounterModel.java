import java.util.ArrayList;
import java.util.List;

public class SheepCounterModel {

    public enum Status {INCOMPLETE, COMPLETE, INCONSISTENT}
    public int totalSheep;
    public int currentSheep;
    private Status status;
    private final List<SheepCounterView> views;

    public SheepCounterModel() {
        this.totalSheep = 0;
        this.currentSheep = 0;
        this.status = Status.INCOMPLETE;
        this.views = new ArrayList<>();
    }

    public void addSheepCounterView(SheepCounterView view) {
        views.add(view);
    }

    public void removeSheepCounterView(SheepCounterView view) {
        views.remove(view);
    }

    public Status getStatus() {
        return status;
    }

    public int getTotalSheep() {
        return totalSheep;
    }

    public int getCurrentSheep() {
        return currentSheep;
    }

    public void setTotalSheep(int totalSheep) {
        this.totalSheep = totalSheep;
        updateViews();
    }

    public void increment() {
        this.currentSheep++;
        updateViews();
    }

    public void decrement() {
        if (this.currentSheep > 0) {
            this.currentSheep--;
            updateViews();
        }
    }

    public void updateStatus() {
        if (currentSheep < totalSheep) {
            this.status = Status.INCOMPLETE;
        } else if (currentSheep == totalSheep) {
            this.status = Status.COMPLETE;
        } else {
            this.status = Status.INCONSISTENT;
        }
    }

    public void updateViews() {
        updateStatus();
        for (SheepCounterView view : views) {
            view.handleSheepCounterUpdate(new SheepCounterEvent(this));
        }
    }
}
