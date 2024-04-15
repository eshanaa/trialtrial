package lecture_code;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class nested {

    static Base b;
    public static void main(String[] args) {
        JFrame jf = new JFrame("SMall window");
        jf.setSize(600,600);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel jp = new JPanel();
        jf.add(jp);
        jp.setLayout(new GridLayout(2,2,4,4));
        for (int i=0; i<4; i++){
            JButton temp = new JButton(""+i);
            temp.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    JButton button = (JButton) e.getSource();
                    button.setBackground(Color.RED);
                }
            }
            );
            jp.add(temp);
        }
        // TODO code application logic here
   /*     A.testMe();
        B.testMe();
        A.secondTest();
        B.secondTest();
        
        System.out.println("************************");
        A thing = new B();
        thing.testMe();
 
/*        Outside o = new Outside();
        o.outsideFunc();
        Outside.Inside in = o.getIn();
        Outside.StaticInside.func();
*/
        b = new Base(){
            { // anonymous constructor
                val =100;
            }
            int val=0; //instance initializer
            
            @Override
            public void callMe(){
                System.out.println("Hello from.... ARGH, I have no name!");
                System.out.println(val);
            } 
        };
        
        b.callMe();
        
        
        new Base(){
            @Override
            public void callMe(){
                System.out.println("Hello from.... Another one with no name!");
            }
        }.callMe();
        
        b.callMe();

    }
}
class Base{
    public void callMe(){
        System.out.println("Hello from Base!");
    }
}

class Demo{
    void func(){
        class LocalDemo{
            void localDemoFunc(){
                System.out.println("Hello, small, world!");
            }
        }
        LocalDemo ld = new LocalDemo();
        ld.localDemoFunc();
    }
    void otherFunc(){
        class MyException extends Exception{}
        try {
            throw new MyException();
        } catch (MyException ex) {
        }
    }
}


class Outside{
    private int outerInt;
    private static int outerStaticInt;

    static class StaticInside{
        public static void func(){
            outerStaticInt = 100;
        }
    }
    
    class Inside{
        public void func(){
            outerInt=100;
        }
        public void func2(){
            System.out.println(outerInt);
        }
    }
    void outsideFunc(){
        Inside in = new Inside();
        in.func();
    }
    Inside getIn(){
        return new Inside();
    }
}

class A{
    public static void testMe(){
        System.out.println("Test A");
    }
    public void instanceTest(){
        System.out.println("InstanceTest A");
    }
    public static void secondTest(){
        System.out.println("Second Test A");
    }
}

class B extends A{
    public static void testMe(){
        System.out.println("Test B");
    }
    @Override
    public void instanceTest(){
        System.out.println("InstanceTest B");
    }
}

