package org.example.bank;


import org.example.bank.controller.AccountController;
import org.example.bank.model.Account;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        AccountController service = new AccountController();

        char ch = 'Y';

        do {

            System.out.println("\n==============================");
            System.out.println("       BANK MANAGEMENT");
            System.out.println("==============================");

            System.out.println("1. Create Account");
            System.out.println("2. Find Account");
            System.out.println("3. Update Account");
            System.out.println("4. Delete Account");
            System.out.println("5. Display All Accounts");
            System.out.println("6 . Find by Accountnumber");
            System.out.println("7. Exit");

            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine();


            switch (choice) {



                case 1:

                    System.out.print("Enter Account Number: ");
                    long accountNumber = sc.nextLong();
                    sc.nextLine();
                    System.out.print("Enter Holder Name: ");
                    String holderName = sc.nextLine();

                    System.out.print("Enter Balance: ");
                    double balance = sc.nextDouble();

                    Account account =
                            new Account(
                                    accountNumber,
                                    holderName,
                                    balance
                            );

                    service.createAccount(account);

                    break;



                case 2:

                    System.out.print("Enter Account ID: ");

                    Long id = sc.nextLong();

                 Account foundAccount =
                            service.findById(id);

                    if (foundAccount != null) {

                        System.out.println("\nAccount Found:");
                        System.out.println(foundAccount);

                    } else {

                        System.out.println("Account not found!");
                    }

                    break;



                case 3:

                    System.out.print("Enter Account ID: ");

                    Long updateId = sc.nextLong();
                    sc.nextLine();

                    Account updateAccount =
                            service.findById(updateId);

                    if (updateAccount != null) {

                        System.out.print("Enter New Holder Name: ");
                        String newHolderName = sc.nextLine();

                        System.out.print("Enter New Balance: ");
                        double newBalance = sc.nextDouble();

                        updateAccount.setHolderName(newHolderName);
                        updateAccount.setBalance(newBalance);

                        service.updateAccount(updateAccount);

                    } else {

                        System.out.println("Account not found!");
                    }

                    break;



                case 4:

                    System.out.print("Enter Account ID: ");

                    Long deleteId = sc.nextLong();

                    //  service.deleteAccount(deleteId);

                    break;



                case 5:

                    service.findAll();

                    break;


                case 6:
                    System.out.print("Enter Accountnumber: ");
                    long accno = sc.nextLong();
                    Account acc = service.findByAcc(accno);
                    if(acc!=null)
                        System.out.println(acc);
                    else
                        System.out.println("Account not found");
                    break;
                case 7:

                    ch = 'N';

                    break;


                default:

                    System.out.println("Invalid choice!");

            }



            System.out.println(
                    "Do you want to continue then press Y/N"
            );

            ch = sc.next().charAt(0);




        } while (ch == 'Y' || ch == 'y');

        System.out.println("Thank you for using Bank Management!");

        sc.close();

    }

}