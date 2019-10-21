
import java.util.Random;
import java.util.Vector;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Last_
 */
public class VectorModifierTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Vector<Integer> intVector = new Vector<Integer>();
        for (int i = 0; i < 20; i++) {
            intVector.add(new Random().nextInt(100));
        }
        System.out.println("Values of Original Vector: ");
        for (Integer x: intVector) {
            System.out.print(x + " ");
        }
        System.out.println("\nValues of Ordered Vector: ");
        VectorModifier vecModifier = new VectorModifier(intVector);
        for (Integer x: vecModifier.orderize()){
            System.out.print(x + " ");
        }
        System.out.println("\nValues of Distincted Vector: ");
        for (Integer x: vecModifier.distinctize()){
            System.out.print(x + " ");
        }
    }
    
}
