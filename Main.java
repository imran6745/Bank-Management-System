


import java.util.ArrayList;
import java.util.Scanner;
// 2k26csm35 imran
  // 2k26csm16 Ali Gul

class Person {
    String name;
    int age;

    Person(String n, int a) {
        name = n;
        age = a;
    }
}


class BankAccount extends Person {
    int accountNumber;
    double balance;

    BankAccount(String n, int a, int acc, double b) {
        super(n, a);
        accountNumber = acc;
        balance = b;
    }

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Amount Deposited Successfully!");
        } else {
            System.out.println("Invalid Amount!");
        }
    }

    void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid Amount!");
        } else if (amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal Successful!");
        } else {
            System.out.println("Insufficient Balance!");
        }
    }

    void display() {
        System.out.println("\n--- ACCOUNT DETAILS ---");
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: Rs. " + balance);
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<BankAccount> accounts = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n=== BANK MANAGEMENT SYSTEM ===");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. View All Accounts");
            System.out.println("0. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();

                    System.out.print("Enter Account Number: ");
                    int acc = sc.nextInt();

                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();

                    if (age < 18 || balance < 0) {
                        System.out.println("Invalid Age or Balance!");
                        break;
                    }

                    boolean exists = false;

                    for (BankAccount b : accounts) {
                        if (b.accountNumber == acc) {
                            exists = true;
                            break;
                        }
                    }

                    if (exists) {
                        System.out.println("Account Already Exists!");
                    } else {
                        accounts.add(
                            new BankAccount(name, age, acc, balance)
                        );
                        System.out.println("Account Created Successfully!");
                    }
                    break;

                case 2:
                    System.out.print("Enter Account Number: ");
                    int depositAcc = sc.nextInt();

                    System.out.print("Enter Amount: ");
                    double depositAmount = sc.nextDouble();

                    boolean foundDeposit = false;

                    for (BankAccount b : accounts) {
                        if (b.accountNumber == depositAcc) {
                            b.deposit(depositAmount);
                            foundDeposit = true;
                            break;
                        }
                    }

                    if (!foundDeposit)
                        System.out.println("Account Not Found!");
                    break;

                case 3:
                    System.out.print("Enter Account Number: ");
                    int withdrawAcc = sc.nextInt();

                    System.out.print("Enter Amount: ");
                    double withdrawAmount = sc.nextDouble();

                    boolean foundWithdraw = false;

                    for (BankAccount b : accounts) {
                        if (b.accountNumber == withdrawAcc) {
                            b.withdraw(withdrawAmount);
                            foundWithdraw = true;
                            break;
                        }
                    }

                    if (!foundWithdraw)
                        System.out.println("Account Not Found!");
                    break;

                case 4:
                    System.out.print("Enter Account Number: ");
                    int checkAcc = sc.nextInt();

                    boolean foundCheck = false;

                    for (BankAccount b : accounts) {
                        if (b.accountNumber == checkAcc) {
                            b.display();
                            foundCheck = true;
                            break;
                        }
                    }

                    if (!foundCheck)
                        System.out.println("Account Not Found!");
                    break;

                case 5:
                    if (accounts.isEmpty()) {
                        System.out.println("No Accounts Found!");
                    } else {
                        for (BankAccount b : accounts) {
                            b.display();
                            System.out.println("-------------------");
                        }
                    }
                    break;

                case 0:
                    System.out.println("Thank You for Using Our Bank!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 0);

        sc.close();
    }
}
