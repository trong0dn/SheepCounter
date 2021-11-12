import javax.swing.*;
import java.awt.*;

public class SheepCounterFrame extends JFrame implements SheepCounterView {
    private final SheepCounterModel model;
    private final SheepCounterController controller;
    private final JTextField totalTextField;
    private final JTextField currentTextField;
    private final JLabel statusLabel;

    public SheepCounterFrame() {
        super("Sheep Counter!");
        this.setLayout(new GridLayout(4,2));
        model = new SheepCounterModel();
        model.addSheepCounterView(this);

        controller = new SheepCounterController(model);

        JLabel totalLabel = new JLabel("Total Sheep");
        totalLabel.setHorizontalAlignment(SwingConstants.CENTER);

        totalTextField = new JTextField("0");
        totalTextField.setBackground(Color.WHITE);
        totalTextField.setHorizontalAlignment(SwingConstants.CENTER);
        totalTextField.setActionCommand("total");
        totalTextField.addActionListener(controller);

        JLabel currentLabel = new JLabel("Current Sheep");
        currentLabel.setHorizontalAlignment(SwingConstants.CENTER);

        currentTextField = new JTextField("0");
        currentTextField.setHorizontalAlignment(SwingConstants.CENTER);
        currentTextField.setBackground(Color.WHITE);
        currentTextField.setActionCommand("current");
        currentTextField.addActionListener(controller);
        currentTextField.setEditable(false);

        JButton incrementButton = new JButton("Increment");
        incrementButton.setActionCommand("increment");
        incrementButton.addActionListener(controller);

        JButton decrementButton = new JButton("Decrement");
        decrementButton.setActionCommand("decrement");
        decrementButton.addActionListener(controller);

        statusLabel = new JLabel();
        statusLabel.setHorizontalAlignment(SwingConstants.CENTER);

        this.add(totalLabel);
        this.add(totalTextField);
        this.add(currentLabel);
        this.add(currentTextField);
        this.add(incrementButton);
        this.add(decrementButton);
        this.add(statusLabel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 300);
        this.setVisible(true);
    }

    public void handleSheepCounterUpdate(SheepCounterEvent e) {
        currentTextField.setText(String.valueOf(e.getCurrent()));

        if (e.getStatus() == SheepCounterModel.Status.INCOMPLETE) {
            statusLabel.setText("incomplete!");
            statusLabel.setForeground(Color.RED);
        } else if (e.getStatus() == SheepCounterModel.Status.COMPLETE) {
            statusLabel.setText("complete!");
            statusLabel.setForeground(Color.GREEN);
        } else {
            statusLabel.setText("inconsistent!");
            statusLabel.setForeground(Color.YELLOW);
        }
    }

    public static void main(String[] args) {
        new SheepCounterFrame();
    }
}
