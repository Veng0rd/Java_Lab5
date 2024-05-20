import javax.swing.*;
import java.awt.*;

class BallPanel extends JPanel {
    private int x = 0;
    private int y = 0;
    private int diameter = 50;
    private int xVelocity = 1;
    private int yVelocity = 1;
    private Color _ballColor = Color.BLACK;

    public BallPanel() {
        setBackground(Color.GRAY);
    }

    public void setBallColor(Color color) {
        _ballColor = color;
    }

    public void updateBall() {
        x += xVelocity;
        y += yVelocity;

        if (x < 0 || x + diameter > getWidth()) {
            xVelocity = -xVelocity;
        }

        if (y < 0 || y + diameter > getHeight()) {
            yVelocity = -yVelocity;
        }

        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(_ballColor);
        g.fillOval(x, y, diameter, diameter);
    }
}
