import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SheepCounterController implements ActionListener {
    private final SheepCounterModel sheepCounterModel;

    public SheepCounterController(SheepCounterModel model) {
        this.sheepCounterModel = model;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if (action.equals("increment")) {
            sheepCounterModel.increment();
        } else if (action.equals("decrement")) {
            sheepCounterModel.decrement();
        } else {
            JTextField text = (JTextField) e.getSource();
            sheepCounterModel.setTotalSheep(Integer.parseInt(text.getText()));
        }
    }
}
