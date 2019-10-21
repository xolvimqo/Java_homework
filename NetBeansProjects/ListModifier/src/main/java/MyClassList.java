
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Last_
 */
public class MyClassList {
    public static void main(String[] args) {
        // Declaration of arraylist
        ArrayList<Integer> myList = new ArrayList<Integer>();
        myList.add(15);
        myList.add(85);
        myList.add(66);
        myList.add(100);
        myList.add(88);
        myList.add(25);
        
        // enhanced for loop
        for (Integer x :myList) {
            System.out.println(x);
        }
        System.out.println("Size of myList: " + myList.size());
        myList.remove(2);
        for (Integer x :myList) {
            System.out.println(x);
        }
        System.out.println("Size of myList: " + myList.size());
    }
}
