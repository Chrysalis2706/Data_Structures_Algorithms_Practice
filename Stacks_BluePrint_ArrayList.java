package Stacks;

import java.util.ArrayList;

public class Stacks_BluePrint_ArrayList {

    static ArrayList<Integer> list = new ArrayList<>();

    // isEmpty
    public static boolean isEmpty(){
        return list.size() == 0;
    }

    // Push element
    public static void push(int data){
        list.add(data);
    }

    // Pop element
    public static int pop(){
        int top = list.get(list.size()-1);
        list.remove(list.size()-1);
        return top;
    }

    // Peek element on top
    public static int peek() {
        return list.get(list.size() - 1);

    }


}
