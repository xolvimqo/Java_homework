/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Last_
 */
public class PassArray {
    public void doubleArrayElements(int[] array) {
    for (int counter = 0; counter < array.length; counter++) {
      array[counter] *= 2;
    }
  }

  public void modifyElement(int element) {
    element *= 2;
    System.out.println("Value of element in modify element: " + element);
  }
}
