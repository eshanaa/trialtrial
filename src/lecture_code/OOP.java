package lecture_code;


import java.util.logging.Level;
import java.util.logging.Logger;

public class OOP {
    static int thing;
    int instanceThing;
    
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
        OOP newVar = new OOP();
        newVar.instanceThing = 100;
        
    }
    
}

//public class: globally accessive
//non-public class: globally accessive, package creation
//Member class: a nested class ccreation from within the outer class
//Static class: A nested class similar to member class, but exists in static context
//inner class: created inside a function across the context (static/instance) of the function
//Anonymous class: An inner class with no name

//member class exists in the instance. can't create a member object within a static context
//static class only has access to the static items in the outer class. is a nested class
//dont have access to everything in the outer class.

//instance items = member class.
//no need of instance, = choose between static or member class

//global class - nested class
/* Class A {
	class Member{
	}
	static class SClass{
	}
}
*/
class GettinAnA extends Exception{}

class Test1{
    int x;
    double y;
    Test1(){
        //x=0; //"this" invocation must be the first line.
        this(0);
        x+=1;
        OOP.thing=10;
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
        } 
        catch (GettinAnA ex) {
            Logger.getLogger(Test1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    void testThrow2() throws GettinAnA{
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