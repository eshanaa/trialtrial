/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cs3913spring2023gui;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 *
 * @author dkatz
 */
public class CS3913Spring2023GUI {

    /**
     * @param args the command line arguments
     */
    static JButton theButton;
    public static void main(String[] args) {
        JFrame jf = new JFrame("My First window!");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jp = new JPanel();
        jp.setBackground(Color.red);
        jp.setLayout(new GridLayout(2,3,4,4));
        JPanel[] arr = new JPanel[4];
        for (int i = 0; i<4; i++){
            arr[i] = new JPanel();
            arr[i].add(new JLabel("Panel number: "+(i+1)));
        }
        arr[0].setBackground(Color.BLUE);
        arr[1].setBackground(Color.MAGENTA);
        arr[2].setBackground(Color.PINK);
        arr[3].setBackground(Color.WHITE);
        for (JPanel temp:arr)
            jp.add(temp);
        //jp.setOpaque(true);
        JButton secondButton = new JButton("DON'T PRESS ME!");
        secondButton.addActionListener(new WrongButtonPressed());
        jp.add(secondButton);
        theButton = new JButton("CLICK ME");
        theButton.addActionListener(new ButtonPressed());
        jp.add(theButton);
        jf.setBackground(Color.yellow);
        jf.add(jp);
        
        jf.setSize(1000,400);
        jf.setVisible(true);
        System.out.println("The end of main!");
    }
    
}
class WrongButtonPressed implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
        CS3913Spring2023GUI.theButton.setText("<HTML>NO, NOT THAT!!!<BR>OH THE HORROR!");
    }
    
}

class ButtonPressed implements ActionListener{
    int i;
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton source = (JButton) e.getSource();
        source.setText("THANK YOU!");
    }
    
}