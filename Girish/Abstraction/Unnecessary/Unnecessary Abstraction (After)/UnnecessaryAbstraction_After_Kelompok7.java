import javax.swing.JButton;
import java.awt.Color;

public class CustomButton extends JButton {
    public CustomButton(String text, Color color) {
        super(text);
        this.setBackground(color);
    }
}


import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;

public class ButtonTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(300, 200);

        JButton blueButton = new JButton("submit");
        blueButton.setBackground(Color.BLUE);
        frame.add(blueButton);

        JButton redButton = new JButton("submit");
        redButton.setBackground(Color.RED);
        frame.add(redButton);
    }
}
