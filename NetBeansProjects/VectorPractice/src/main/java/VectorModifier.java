
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
public class VectorModifier {
    Vector<Integer> inputVector = new Vector<Integer>();
    
    VectorModifier(Vector<Integer> vector) {
        inputVector = vector;
    }
    
    public Vector<Integer> orderize(){
        Vector<Integer> orderedVector = new Vector<Integer>();
        for (int i = 0; i < inputVector.size(); i++) {
            if (i == 0) {
                orderedVector.add(inputVector.get(i));
            } else {
                outer:
                for (int j = 0; j < orderedVector.size(); j++) {
                    if (inputVector.get(i) <= orderedVector.get(j)) {
                        orderedVector.add(j, inputVector.get(i));
                        break outer;
                    } else if (j == orderedVector.size() - 1 && inputVector.get(i) > orderedVector.get(j)) {
                        orderedVector.add(inputVector.get(i));
                        break outer;
                    }
                }
            }
        }
        return orderedVector;
    }
    
    public Vector<Integer> distinctize(){
        Vector<Integer> orderedVector = new Vector<Integer>();
        for (int i = 0; i < inputVector.size(); i++) {
            if (i == 0) {
                orderedVector.add(inputVector.get(i));
            } else {
                outer:
                for (int j = 0; j < orderedVector.size(); j++) {
                    if (inputVector.get(i) == orderedVector.get(j)) {
                        break outer;
                    } else if (inputVector.get(i) < orderedVector.get(j)) {
                        orderedVector.add(j, inputVector.get(i));
                        break outer;
                    } else if (j == orderedVector.size() - 1 && inputVector.get(i) > orderedVector.get(j)) {
                        orderedVector.add(inputVector.get(i));
                        break outer;
                    }
                }
            }
        }
        return orderedVector;
    }
}
