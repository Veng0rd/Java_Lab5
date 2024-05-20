import javax.swing.*;
import java.awt.*;


public class BouncingBallApp extends JFrame {
    private BallPanel _ballPanel;
    private JSpinner _redSpinner;
    private JSpinner _greenSpinner;
    private JSpinner _blueSpinner;

    public BouncingBallApp() {
        setTitle("Bouncing Ball");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        _ballPanel = new BallPanel();
        add(_ballPanel);

        JPanel _colorPanel = new JPanel();

        _redSpinner = createColorSpinner();
        _greenSpinner = createColorSpinner();
        _blueSpinner = createColorSpinner();

        _colorPanel.add(new JLabel("Red:"));
        _colorPanel.add(_redSpinner);
        _colorPanel.add(new JLabel("Green:"));
        _colorPanel.add(_greenSpinner);
        _colorPanel.add(new JLabel("Blue:"));
        _colorPanel.add(_blueSpinner);

        add(_colorPanel, BorderLayout.SOUTH);

        Timer timer = new Timer(2, e -> _ballPanel.updateBall());
        timer.start();
    }

    private JSpinner createColorSpinner() {
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(0, 0, 255, 1));
        spinner.addChangeListener(e -> {
            int red = (Integer) _redSpinner.getValue();
            int green = (Integer) _greenSpinner.getValue();
            int blue = (Integer) _blueSpinner.getValue();
            _ballPanel.setBallColor(new Color(red, green, blue));
        });
        return spinner;
    }
}