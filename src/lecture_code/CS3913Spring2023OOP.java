/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cs3913.spring2023.oop;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author dkatz
 */
public class CS3913Spring2023OOP {
    static int thing;
    int instanceThing;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Test1 var = new Test1(10);
        var.x = 100;
        Object o1 = new Test1(5);
        var = (Test1) o1;
        //var.testThrow2(); //must handle the exception either with Try or rethrow
        System.out.println(var.x);
        System.out.println("5+3="+5+3);
        System.out.println(5+3+"=5+3");
        thing = 10;
        CS3913Spring2023OOP newVar = new CS3913Spring2023OOP();
        newVar.instanceThing = 100;
        
    }
    
}
class GettinAnA extends Exception{}
class Test1{
    int x;
    double y;
    Test1(){
        //x=0; //"this" invocation must be the first line.
        this(0);
        x+=1;
        CS3913Spring2023OOP.thing=10;
    }
    Test1(int newx, double newy){
        //this(20); //Recursive constructor invocation not allowed
        x = newx;
        y = newy;
    }
    Test1(int newval){
        this(newval,5.5);
        //x = newval;
    }
    void testThrow(){
        try {
            throw new GettinAnA();
        } catch (GettinAnA ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void testThrow2()throws GettinAnA{
        throw new GettinAnA();
    }
    
    void test(){
        System.out.println("Inside Test1");
    }
}

class Test2 extends Test1{
    Test2(){
        super(5,10.2);
    }
    @Override
    void test(){
        super.test();
        
    }
}

abstract class Test3{
    abstract void func();
}

class Test4 extends Test3{
    @Override
    void func(){
        
    }
}