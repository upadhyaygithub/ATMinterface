import java.util.Scanner;

class BankAccount {
    int balance;
    int prevTransaction;
    String customerName;
    String customerId;
    int flag = 0;

    BankAccount(String var1, String var2) {
        this.customerName = var1;
        this.customerId = var2;
    }

    public final void clrscr() {
        try {
            try {
                String var1 = System.getProperty("os.name");
                if (var1.contains("Windows")) {
                    Runtime.getRuntime().exec("cls");
                } else {
                    Runtime.getRuntime().exec("clear");
                }
            } catch (Exception var2) {
                (new ProcessBuilder(new String[]{"cmd", "/c", "cls"})).inheritIO().start().waitFor();
            }
        } catch (Exception var3) {
        }

    }

    void checkId() {
        this.clrscr();
        System.out.println("Welcome " + this.customerName);
        System.out.println();
        System.out.print("Please enter the Customer ID or PIN: ");
        Scanner var1 = new Scanner(System.in);
        String var2 = var1.nextLine();
        if (var2.equals(this.customerId)) {
            this.clrscr();
            this.showMenu();
        } else {
            System.out.println("=================================");
            System.out.println("Wrong Login!!");
            System.out.println("=================================");
            if (this.flag < 3) {
                ++this.flag;
                this.checkId();
            }
        }

    }

    void deposit(int var1) {
        if (var1 != 0) {
            this.balance += var1;
            this.prevTransaction = var1;
        }

    }

    void withdraw(int var1) {
        if (this.balance > var1) {
            this.balance -= var1;
            this.prevTransaction = -var1;
        } else {
            this.clrscr();
            System.out.println("=================================");
            System.out.println("Sufficient Balance not available for the withdrawl!");
            System.out.println("=================================");
        }

    }

    void getPrevTransaction() {
        if (this.prevTransaction > 0) {
            System.out.println("Deposited: " + this.prevTransaction);
        } else if (this.prevTransaction < 0) {
            System.out.println("Withdraw: " + Math.abs(this.prevTransaction));
        } else {
            System.out.println("No Transaction Occured ");
        }

    }

    public void transfer(double var1, BankAccount var3) {
        if ((double)this.balance < var1) {
            this.clrscr();
            System.out.println("=================================");
            System.out.println("Transfer Fails due to insufficient balance!");
            System.out.println("=================================");
        } else {
            this.balance = (int)((double)this.balance - var1);
            var3.balance = (int)((double)var3.balance + var1);
            System.out.println("Account of " + this.customerName + " becomes $" + this.balance);
            System.out.println("Account of " + var3.customerName + " becomes $" + var3.balance);
            System.out.println("\n");
        }

    }

    private void showMenu() {
        Scanner var2 = new Scanner(System.in);
        System.out.println("Welcome " + this.customerName);
        System.out.println("Your ID is  " + this.customerId);

        char var1;
        do {
            System.out.println("\n");
            System.out.println("\n");
            System.out.println("A. Check Balance");
            System.out.println("B. Deposit");
            System.out.println("C. Withdraw");
            System.out.println("D. Previous Transaction");
            System.out.println("E. Transfer");
            System.out.println("F. Exit");
            System.out.println("=================================");
            System.out.println("Enter the option");
            System.out.println("=================================");
            var1 = var2.next().charAt(0);
            var1 = Character.toUpperCase(var1);
            System.out.println("\n");
            switch (var1) {
                case 'A':
                    this.clrscr();
                    System.out.println("================");
                    System.out.println("Balance " + this.balance);
                    System.out.println("================");
                    System.out.println("\n");
                    break;
                case 'B':
                    this.clrscr();
                    System.out.println("================");
                    System.out.println("Enter the amount to deposit");
                    System.out.println("================");
                    int var3 = var2.nextInt();
                    this.deposit(var3);
                    System.out.println("\n");
                    break;
                case 'C':
                    this.clrscr();
                    System.out.println("================");
                    System.out.println("Enter the amount to withdraw");
                    System.out.println("================");
                    int var4 = var2.nextInt();
                    this.withdraw(var4);
                    System.out.println("\n");
                    break;
                case 'D':
                    this.clrscr();
                    System.out.println("================");
                    this.getPrevTransaction();
                    System.out.println("================");
                    System.out.println("\n");
                    break;
                case 'E':
                    this.clrscr();
                    System.out.println("***************");
                    System.out.println("To whom");
                    BankAccount var5 = new BankAccount("Aryan", "1022");
                    System.out.println(var5.customerName);
                    System.out.println("***************");
                    System.out.println("Amount to Transfer");
                    double var6 = var2.nextDouble();
                    System.out.println("***************");
                    this.transfer(var6, var5);
                    break;
                case 'F':
                    this.clrscr();
                    System.out.println("***************");
                    break;
                default:
                    this.clrscr();
                    System.out.println("Invalid Option!!! Please Enter Again");
            }
        } while(var1 != 'F');

        System.out.println("ThankYou For using our services");
    }
}
