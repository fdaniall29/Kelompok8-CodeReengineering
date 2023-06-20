import java.awt.Color;

import javax.swing.JButton;

public class BlueButton extends JButton {
	public BlueButton(String text) {
		super(text);
		this.setBackground(Color.BLUE);
	}
}

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.junit.jupiter.api.Test;

class ButtonTest {

	@Test
	void test() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(300, 200);
		
		JButton button = new BlueButton("submit");
		
		frame.add(button);
		
		try{Thread.sleep(3000);}catch(InterruptedException e){}
	}

}

import java.awt.Color;

import javax.swing.JButton;

public class RedButton extends JButton {
	public RedButton(String text) {
		super(text);
		this.setBackground(Color.RED);
	}
}