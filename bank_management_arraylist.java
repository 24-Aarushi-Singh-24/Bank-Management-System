package lab5;

import java.util.Scanner;
import java.util.ArrayList;

class Account {
  private int accountNumber;
  private String accountType;
  private String serviceBranchIFSC;
  private float minimumBalance;
  private float availableBalance;
  private int coustomerID;
  private String coustmerName;
  private static int totalAccountCreated;

  Account() {
    accountNumber = 0;
    accountType = "";
    serviceBranchIFSC = "";
    minimumBalance = 0;
    availableBalance = 0;
    coustomerID = 0;
    coustmerName = "";
    totalAccountCreated++;
  }

  public void setDetails( int accnumber, String acctype, String IFSC, float minBalance, float avaBalance,int coustID, String coustName) {
    accountNumber = accnumber;
    accountType = acctype;
    serviceBranchIFSC = IFSC;
    minimumBalance = minBalance;
    availableBalance = avaBalance;
    coustomerID = coustID;
    coustmerName = coustName;
  }

  public String getDetails(int BankId) {
    return ("\nAccount number: " +accountNumber +"\nAccount type: " +accountType +"\nIFSC code: " +serviceBranchIFSC +"\nMin Balance: " +minimumBalance +"\nAvailable Balance: " +availableBalance +"\nCoustmer Id: " +coustomerID +"\nCoustmer name: " +coustmerName +"\n"
    );
  }

  public float getBalance(int accoutNumber) {
    return (availableBalance);
  }

  public void deposit(int accountNumber, float amount) {
    availableBalance = availableBalance + amount;
    System.out.println("Rs " +amount +" has credited in account.Balance of account is: " +availableBalance
    );
  }

  public void withdraw(int accountNumber, float amount) {
    if (amount <= availableBalance) {
      availableBalance = availableBalance - amount;
      System.out.println("Rs " +amount +" has withdrawn from account.Balance of account is:" +availableBalance
      );
    } else {
      System.out.println(
        "You have not enough amount in your account to withdraw."
      );
    }
  }

  static int totalAccount() {
    return totalAccountCreated;
  }

  public int getid() {
    return coustomerID;
  }

  public int getacno() {
    return accountNumber;
  }

  public void updateminbalance(int accountNumber, int amount) {
    minimumBalance = amount;
  }

  public void updatecname(int accountNumber, String name) {
    coustmerName = name;
  }

  public void updatecid(int accountNumber, int id) {
    coustomerID = id;
  }

  public void compare(Account first, Account second) {
    if (first.availableBalance > second.availableBalance) {
      System.out.print(
        "\nFirst account has more balance than second.\nDetalis of first account are:"
      );
      String f = first.getDetails(first.getacno());
      System.out.println(f);
    }
    if (first.availableBalance < second.availableBalance) {
      System.out.print(
        "\nSecond account has more balance than first.\nDetails of second account are:"
      );
      String s = second.getDetails(second.getacno());
      System.out.println(s);
    }
    if (first.availableBalance == second.availableBalance) {
      System.out.println("\nBoth account have same balance.");
      System.out.print("Details of first account are: ");
      String i = first.getDetails(first.getacno());
      System.out.println(i);
      System.out.print("\nDetails of second account are: ");
      String ii = second.getDetails(second.getacno());
      System.out.println(ii);
    }
  }
}

public class bank_management_arraylist {

  public static void main(String[] args) {
    ArrayList <Account> arr=new ArrayList<Account>();
    arr.add(new Account());
    arr.add(new Account());
    arr.add(new Account());
    arr.add(new Account());
    arr.add(new Account());
    arr.get(0).setDetails(2101001, "Savings", "IIITG1234", 0, 25000, 101, "ABC");
    arr.get(1).setDetails(2101002, "Savings", "IIITG1234", 0, 10000, 102, "MNO");
    arr.get(2).setDetails(2101003, "Savings", "IIITG1234", 0, 100000, 103, "JKL");
    arr.get(3).setDetails(2101004, "Savings", "IIITG1234", 0, 53000, 104, "PQR");
    arr.get(4).setDetails(2101005, "Savings", "IIITG1234", 0, 18000, 105, "XYZ");

    Scanner sc = new Scanner(System.in);

//    System.out.println(
//      "\nEnter 1 for Update Details\nEnter 2 for Get Details\nEnter 3 for Deposit\nEnter 4 for Withdraw\nEnter 5 for compare two accounts\nEnter 6 to display total no. of account created\nEnter 7 for add an account\nEnter 8 to delete an account\nEnter 9 for exit."
//    );
    int n = 1;
    int flag = 0;
    int p = 5;
    while (n != 9) {
    
      flag = 0;
      System.out.println(
    	      "\nEnter 1 for Update Details\nEnter 2 for Get Details\nEnter 3 for Deposit\nEnter 4 for Withdraw\nEnter 5 for compare two accounts\nEnter 6 to display total no. of account created\nEnter 7 for add an account\nEnter 8 to delete an account\nEnter 9 for exit."
    	    );
      System.out.print("\nEnter your choice:");
      n = sc.nextInt();

      switch (n) {
        
        case 7:
        System.out.println("Enter the details of account:");
        System.out.print("Enter the account number: ");
        int acc=sc.nextInt();
        System.out.print("Enter the type of account: ");
        String type=sc.next();
        System.out.print("Enter the IFSC: ");
        String ifsc=sc.next();
        System.out.print("Enter the min balance: ");
        int min_Bal=sc.nextInt(); 
        System.out.print("Enter the available balance: ");
        int ava_bal=sc.nextInt();
        String emp3=sc.nextLine();
        System.out.print("Enter the coustmer id: ");
        int coustmer_id=sc.nextInt();
        String emp2=sc.nextLine();
        System.out.print("Enter the coustmer name: ");
        String name=sc.nextLine();
        arr.add(new Account());
        arr.get(p).setDetails(acc,type, ifsc, min_Bal, ava_bal, coustmer_id,name);
        System.out.println("Account created successfully.");         
        p++;
        break; 
         
        

        case 8:
        flag = 0;
        System.out.print("Enter the account no which you want to delete:");
        int id9 = sc.nextInt();
       
        for (int j = 0; j < arr.size(); j++) {
          if (arr.get(j).getacno() == id9) {
            arr.remove(arr.get(j));
            p--;
            flag = 1;
            System.out.println("Account deleted successfully.");
            break;
          }
        }
        if (flag == 0) {
          System.out.print("You entered a wrong  account no.Try again.");
        }
        break;



        case 1:
          System.out.print(
            "Enter the account no. whose details you want to update:"
          );
          int b_id = sc.nextInt();
          for (int j = 0; j <arr.size(); j++) {
            if ( arr.get(j).getacno() == b_id) {
              System.out.print(
                "\nEnter 1 for Update minimum balance\n2 for Get update coustmer id\n3 for update coustmer name\n\nEnter a number according to the type of change you want:"
              );
              int u = sc.nextInt();
              String e = sc.nextLine();
              if (u == 1) {
                System.out.print("Enter the new minimum balance:");
                int min_bal = sc.nextInt();
                arr.get(j).updateminbalance(b_id, min_bal);
                System.out.print("Minimum balance updated.");
                flag = 1;
            
              }

              if (u == 2) {
                System.out.print("Enter the new coustmer id:");
                int id = sc.nextInt();
                arr.get(j).updatecid(b_id, id);
                System.out.print("Coustmer id updated.");
                flag = 1;
              }

              if (u == 3) {
                System.out.print("Enter the name:");
                String Name = sc.nextLine();
                arr.get(j).updatecname(b_id, Name);
                System.out.print("Name updated.");
                flag = 1;
              }
              if (u != 1 && u != 2 && u != 3) {
                System.out.print("You entered a wrong option.Try again");
                flag = 1;
              }
            }
          }
          if (flag == 0) {
            System.out.print("You entered a wrong  account no.Try again.");
          }
          break;
        case 2:
          flag = 0;
          System.out.print("Enter the account no. whose details you want:");
          int bid = sc.nextInt();
          for (int j = 0; j < arr.size(); j++) {
            if (arr.get(j).getacno() == bid) {
              String b =arr.get(j).getDetails(bid);
              System.out.print(b);
              flag=1;
            }
          }

          if (flag == 0) {
            System.out.println("You entered a wrong  account no.Try again.");
          }

          break;

        case 3:
          flag = 0;
          System.out.print("Enter the account no:");
          int id1 = sc.nextInt();
         
          for (int j = 0; j <arr.size(); j++) {
            if (arr.get(j).getacno() == id1) {
              System.out.print("Enter the amount:");
              int d = sc.nextInt();
              arr.get(j).deposit(id1, d);
              flag = 1;
              break;
            }
          }
          if (flag == 0) {
            System.out.print("You entered a wrong  account no.Try again.");
          }
          break;
        case 4:
          flag = 0;
          System.out.print("Enter the account no:");
          int id2 = sc.nextInt();
         
          for (int j = 0; j <arr.size(); j++) {
            if (arr.get(j).getacno() == id2) {
              System.out.print("Enter the amount:");
              int w = sc.nextInt();
              arr.get(j).withdraw(id2, w);
              flag = 1;
              break;
            }
          }
          if (flag == 0) {
            System.out.print("You entered a wrong  account no.Try again.");
          }
          break;
        case 5:
          flag = 1;
          System.out.print("Enter the first account no.:");
          int id3 = sc.nextInt();
          String a = sc.nextLine();
          System.out.print("Enter the second account no.:");
          int id4 = sc.nextInt();
          for (int i = 0; i <arr.size(); i++) {
            for (int j = 0; j < arr.size(); j++) {
              if (arr.get(i).getacno() == id3 && arr.get(j).getacno() == id4) {
                arr.get(i).compare(arr.get(i), arr.get(j));
                flag = 1;
                break;
              }
            }
          }
          if (flag == 0) {
            System.out.print("You entered a wrong  account no.Try again.");
          }
          break;
        case 9:
          System.out.println("Thank you for visiting us.");
          break;
        case 6:
          System.out.println(
            "Total no of account created is: " + arr.size()
          );
          break;
   
        default:
          System.out.println(
            "The entered number does not belong to the given choices.Try again."
          );
          break;
      }
    }
    sc.close();
  }
}