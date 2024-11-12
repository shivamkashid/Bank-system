import java.util.*;
public class Bank {
    static String username;
    static long mobile;
    static String pan;
    static long adhar;
    static int pin;
    static String address;
    static double bal;
    final static long accountnumber = 123123123L;
    final static String ifsc = "bank123"; 
    static ArrayList<String> statement = new ArrayList<>();


    public static void main(String[] args) {
        welcome();
    }

    public static void welcome() {
        for( ; ; ) {
            Scanner sc = new Scanner(System.in);
            System.out.println();
            System.out.println("    * * * * * WELCOME TO RBI * * * * * ");
            System.out.println();
            System.out.println("1. Create Bank Account");
            System.out.println("2. Existing User");

            System.out.print("Enter an option : ");
            int option = sc.nextInt();

            switch (option) {
                case 1:
                    createAccount(sc);
                    break;
            
                case 2:
                    login(sc);
                    break;

                default:
                    System.out.println("Enter a valid option...");
            }
        }
    }

    public static void createAccount(Scanner sc) {
        System.out.println();
        System.out.println("    * * * * * ACCOUNT CREATION MODULE * * * * *");
        System.out.println();

        System.out.print("Enter Username : ");
        sc.nextLine();
        username = sc.nextLine();
        System.out.print("Enter Mobile Number : ");
        mobile = sc.nextLong();
        System.out.print("Enter Aadhar Number : ");
        adhar = sc.nextLong();
        System.out.print("Enter Pancard Number : ");
        pan = sc.next();
        System.out.print("Enter Address : ");
        sc.nextLine();
        address = sc.nextLine();
        System.out.print("Enter Pin : ");
        pin = sc.nextInt();
        System.out.print("Enter Amount to deposit : ");
        bal = sc.nextDouble();

        System.out.println();
        System.out.println("Account Created Successfully...!");
        System.out.println();

    }



    public static void login(Scanner sc) {        
        if(username != null) {
            System.out.println("    * * * * * LOGIN MODULE * * * * * ");
            System.out.println();
            for(int i=1; i<=3; i++) {
                System.out.print("Enter mobile number : ");
                long mobile1 = sc.nextLong();
                System.out.print("Enter pin : ");
                int pin1 = sc.nextInt();

                if((mobile1 == mobile) && (pin1 == pin)) {
                    homePage(sc);
                }
                else {
                    System.out.println();
                    System.out.println("Invalid Credential");
                    System.out.println();
                }
            }
            System.exit(0);
        }
        else {
            System.out.println();
            System.out.println("Create Your Account First...\nThank You...!");
            System.out.println();
        }
    }


    public static void homePage(Scanner sc) {
        for( ; ; ) {
            System.out.println();
            System.out.println("    * * * * * HOME PAGE MODULE * * * * *");
            System.out.println();

            System.out.println("1. Deposit Amount");
            System.out.println("2. Withdraw Amount");
            System.out.println("3. Check Balance");
            System.out.println("4. Statements");
            System.out.println("5. Edit Profile");
            System.out.println("6. Logout");
            System.out.println();

            System.out.print("Enter an option : ");
            int option = sc.nextInt();

            switch(option) {
                case 1:
                    depositAmount(sc);
                    break;

                case 2:
                    withdrawAmount(sc);
                    break;
                
                case 3:
                    checkBalance(sc);
                    break;

                case 4:
                    statement(sc);
                    break;

                case 5:
                    editProfile(sc);
                    break;

                case 6:
                    System.out.println("THANK YOU...!\nPLEASE NEVER VISIT AGAIN...");
                    System.exit(0);

                default:
                    System.out.println("Enter a valid option");
            }
        }
    }



    public static void depositAmount(Scanner sc) {
        System.out.println("    * * * * * DEPOSIT AMOUNT MODULE * * * * *");
        System.out.println();
        
        System.out.print("Enter amount to deposit : ");
        long amt = sc.nextLong();

        bal += amt;
        statement.add("Deposit Amount : " + amt);
        System.out.println("Amount Creadit Successfully");
        return;
    }


    public static void withdrawAmount(Scanner sc) {
        System.out.println("    * * * * * WITHDRAW AMOUNT MODULE * * * * *");
        for(int i=1; i<=3; i++) {
            System.out.print("Enter amount to withdraw : ");
            long amountWithdraw = sc.nextLong();
            System.out.print("Enter pin : ");
            int pin1 = sc.nextInt();

            if(pin1==pin) {
                if(amountWithdraw <= bal) {
                    bal -= amountWithdraw;
                    statement.add("Withdraw Amount : " + amountWithdraw);
                    System.out.println("Amount Debited Successfully...");
                }
                else {
                    System.out.println("Insufficient Fund...");
                }
                return;
            }
            else {
                System.out.println();
                System.out.println("Enter a valid pin");
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Your account has been deactivated for 24 hours");
        System.exit(0);
    }


    public static void checkBalance(Scanner sc) {
        System.out.println("    * * * * * CHECK BALANCE MODULE * * * * *");
        for(int i=1; i<=3; i++) {
            System.out.print("Enter pin : ");
            int pin1 = sc.nextInt();
            
            if(pin1 == pin) {
                System.out.println("Account balance is : " + bal + "rs");
            }
            else {
                System.out.println("Enter a valid pin");
            }
            return;
        }
        System.out.println();
        System.out.println("Try after sometime");
        System.exit(0);
    }


    public static void statement(Scanner sc) {
        System.out.println("    * * * * * STATEMENT MODULE * * * * *");
        for(String str : statement) {
            System.out.println(str);
        }
    }


    public static void editProfile(Scanner sc) {
        System.out.print("Enter new username : ");
        sc.nextLine();
        username = sc.nextLine();
        System.out.print("Enter new pin : ");
        pin = sc.nextInt();
        System.out.print("Enter new mobile number : ");
        mobile = sc.nextLong();

        
        login(sc);
    }
    
}
