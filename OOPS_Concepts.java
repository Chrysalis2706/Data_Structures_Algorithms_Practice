class Pen{
    public int tip;
    public String color;
    private String password;

    void setTip(int newTipSize){
        this.tip = newTipSize;  // this.tip refers the tip at the 1st line of the class
    }

    String getColor(){
        return this.color;
    }

    void setPassword(String newPass){
        this.password = newPass;
    }

    String getPassword(){
        return this.password;
    }

}

class Student {
    int roll;
    String name;
    int[] marks;

    Student (){
        int[] marks = new int[3];
        System.out.println("Constructor is called...");
    }

    Student (int s_roll){
        int[] marks = new int[3];
        this.roll  = s_roll;
    }

    Student (String s_name){
        int[] marks = new int[3];
        this.name = s_name;
    }

//    //Shallow copy
//    Student (Student s1){
//        int[] marks = new int[3];
//        this.marks = s1.marks;
//
//        // Also see deep copy
//    }

}

class Animals {
    String type;
    void eat(){
        System.out.println("Eats.. > called from class Animals");
    }
}

class Mammals extends Animals {
    void give_birth(){
        System.out.println("Reproduce... > called from class Mammals");
    }
}

class Dogs extends Mammals {
    String breed;
    void bark(){
        System.out.println("Bhow! Bhow!");
    }
}

class Humans extends Animals {
    void breath(){
        System.out.println("Let's Breath!");
    }
}

// Interfaces

interface chessPlayer{
    public void moves();
}

class Queen implements chessPlayer{

    public void moves() {
        System.out.println("Moves of queen");
    }
}

// Multiple inheritance

interface Herbivores{
    public void eats_plant();

}

interface Carnivores{
    public void eats_meat();
}

class Bear implements Herbivores, Carnivores{
    public void eats_plant(){
        System.out.println("Bear eat plants");
    }
    public void eats_meat(){
        System.out.println("Bear eats meat");
    }
}


public class OOPS_Concepts {

    public static void main(String[] args) {
        Pen p1 = new Pen(); // Default Constructors
        p1.setTip(5);
        System.out.println(p1.tip); // because the variable is public
//        System.out.println(p1.password); // error because password is private
        p1.setPassword("Hello");
        System.out.println(p1.getPassword());  // get method can be used to access the private variable

        // Non parametric constructors
        Student s1 = new Student();

        // Parameteric Constructors & Constructor overloading
        Student s2 = new Student(210);
        Student s3 = new Student("Parth");

//        s1.marks[0] = 90;
//        s1.marks[1] = 80;
//        s1.marks[2] = 100;

//        // Shallow copy
//        Student shallow_student = new Student(s1);
//        for (int i=0; i<3; i++){
//            System.out.print(shallow_student.marks[i]);
//        }

//        Inheritance

        Dogs shadow = new Dogs();
        shadow.breed = "German Shepherd";
        shadow.bark();
        shadow.give_birth();
        shadow.eat();


        Bear b1 = new Bear();

        b1.eats_meat();
        b1.eats_plant();


    }

}


