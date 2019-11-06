/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Last_
 */
public class BankingTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here firstName, lastName, phoneNumber, balance, monthlyFees, OverDraftLimit, OverDraftActive, OverDraftFees
        ChequingAccount cheq1 = new ChequingAccount("Terry", "Gu", "1234567890", 1000000, 3000, 500, true, 0);
        System.out.println(cheq1.toString());
        
        cheq1.withdrawal(1000500);
        System.out.println(cheq1.toString());
        
        cheq1.deposit(1000);
        System.out.println(cheq1.toString());
    }
    
}
