
/* Name - Eshana Agarwal
 * netID - eaa8220
 * Homework #3
 * Changes made: I changed the base design of the functionality because I was getting a 'final' error on JFrame when I was using two different functions(display and startquiz) * 
 */


package hw3;

import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class ExamQ 
{
   String[] questions;
   boolean[] answers;
   int correct;
   int total_answered;

   ExamQ(String[] Questions, boolean[] Answers) 
   {
      this.questions = Questions;
      this.answers = Answers;
      this.correct = 0;
      this.total_answered = 0;
   }

   public void startQuiz() 
   {
	   // defining the frame
      final JFrame jf;
      
      if (this.total_answered < 3) 
      {
         jf = new JFrame("Quiz Question " + (this.total_answered + 1));
         jf.setDefaultCloseOperation(3);
         jf.setSize(500, 500);
         JPanel jp = new JPanel();
         jf.add(jp);
         jp.setLayout(new GridLayout(2, 3));
         jp.add(new JLabel());
         
         int index = new Random().nextInt(this.questions.length);
         jp.add(new JLabel(this.questions[index]));
         
         jp.add(new JLabel());

         // to add the timer component
         class Timer extends Thread {
            boolean selected;
            
            Timer()
            {
            	selected = false;
            }
            
            public void run() {
               try 
               {
                  sleep(5000L);
               } 
               catch (InterruptedException e)
               {
                  return;
               }

               if (!this.selected) {
                  jf.setVisible(false);
                  ++ExamQ.this.total_answered;
                  ExamQ.this.startQuiz();
               }

            }
         }

         final Timer t = new Timer();
         t.start();
         
         JButton jbTrue = new JButton("True");
         jbTrue.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if (ExamQ.this.answers[index]) {
                  ++ExamQ.this.correct;
               }

               ++ExamQ.this.total_answered;
               t.selected = true;
               jf.setVisible(false);
               ExamQ.this.startQuiz();
            }
         });
         jp.add(jbTrue);
         jp.add(new JLabel());
         
         JButton jbFalse = new JButton("False");
         jbFalse.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               if (!ExamQ.this.answers[index]) {
                  ++ExamQ.this.correct;
               }

               ++ExamQ.this.total_answered;
               t.selected = true;
               jf.setVisible(false);
               ExamQ.this.startQuiz();
            }
         });
         jp.add(jbFalse);
         jf.setVisible(true);
         
      } 
      
      else 
      {
         jf = new JFrame("Quiz complete");
         jf.setSize(600,600);
         jf.add(new JLabel("You got " + this.correct + " out of 3!"));
         jf.setVisible(true);
      }

   }
}
