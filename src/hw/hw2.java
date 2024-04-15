/*
Name: Eshana Agarwal
netID: eaa8220
N-number: N17499820
Course: CS 3913
Homework #2
*/

package hw;

import java.util.Random;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class newButton extends JButton {
    boolean pressed;
    buttonThread bThread;

    newButton() 
    {
        pressed = false;
        bThread = new buttonThread(this);
    }
}

class buttonThread extends Thread {
    newButton button;

    buttonThread(newButton _button) {
        button = _button;
    }

    @Override
    public void run() {
        while(true) {
            try {
                sleep(500);
                if(!button.pressed) { // if the button isn't pressed
                    Color new_color = hw2.getRandColor(); // change color randomly
                    button.setBackground(new_color);
                }
                else { // if the button is pressed
                    sleep(500); // sleep (changes color and stays on that color)
                }
            }
            catch(Exception e) {}
        }
    }
}


public class hw2 { // modified from hw1
    static final int GRID_ROWS = 4;
    static final int GRID_COLS = 2;
    static final int num_buttons = GRID_ROWS * GRID_COLS;

    static Color getRandColor() { // returns color itself
        Random rand = new Random();
        int[] rgbVal = new int[3];

        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);

        rgbVal[0] = r;
        rgbVal[1] = g;
        rgbVal[2] = b;

        return new Color(r, g, b);
    }

    public static void main(String[] args) { 
        JFrame jf = new JFrame("Pick any button!");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(500, 500);

        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(GRID_ROWS, GRID_COLS));

        newButton[] buttons = new newButton[num_buttons];

        for (int i = 0; i < num_buttons; i++) {
            Color currColor = getRandColor();

           // create a new button
            newButton currButton = new newButton();
            currButton.setBackground(currColor);
            currButton.setOpaque(true);
            currButton.setBorderPainted(false);

            currButton.addActionListener(new ButtonListener(buttons, currButton));
            // add to the beginning of the thread
            currButton.bThread.start();

            buttons[i] = currButton;
            jp.add(buttons[i]);
        }

        jf.add(jp);
        jf.setVisible(true);
    }
}

class ButtonListener implements ActionListener {
    newButton[] buttons;
    newButton currButton;

    ButtonListener(newButton[] _buttons, newButton _currButton) {
        buttons = _buttons;
        currButton = _currButton;
    }

    @Override
    public void actionPerformed(ActionEvent click) {
    	if (currButton.pressed == true)
    	{
    		currButton.pressed = false;
    	}
    	else
    	{
    		currButton.pressed = true;
    	}
    	

        for (newButton button : buttons) {
            if (button.pressed != true) {
                Color new_color = hw2.getRandColor();
                button.setBackground(new_color);
            }
        }
    }
    
}