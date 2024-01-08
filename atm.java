import java.util.Scanner;


 class Bankacc {
    private static double bal;
    public Bankacc(double inbal)
    {
        Bankacc.bal = inbal;
    }
    public static double getbal()
    {
        return bal;
    }
    public static void deposit(double amt)
    {
        if(amt > 0)
        {
            bal += amt;
            System.out.println("Deposit done. Current Balance: " + bal);
        }
        else
        {
            System.out.println("Try again");
        }
    }
    public static void withdraw(double amt)
    {
        if(amt>0 && amt<= bal)
        {
            bal -= amt;
            System.out.println("Withdrawal complete.Current Balance: "+ bal);
        }
        else if(amt <=0)
        {
            System.out.println("Enter valid amount");
        }
        else
        {
            System.out.println("Withdrawal failed");
        }
    }
};

public class atm
{  
    private static Bankacc useracc;
    public atm ( Bankacc useracc)
    {
       atm.useracc = useracc;
    }
    public void display(){            
   
        System.out.println("------Welcome------");
        System.out.println("1.Balance");             
        System.out.println("2.Deposit");
        System.out.println("3.Withdraw");
        System.out.println("4.Exit");
    
    }

    public void transaction(int choice)
    {
        Scanner obj = new Scanner(System.in);
        switch(choice)
        {
            case 1:
            System.out.println("Current Balance: " + Bankacc.getbal());
            break;

            case 2:
            System.out.println("Enter amount to be deposited: ");
            double amtd = obj.nextDouble();
            Bankacc.deposit(amtd);
            break;

            case 3:
            System.out.println("Enter amount to be withdrawed: ");
            double amtw = obj.nextDouble();
            useracc.withdraw(amtw);
            break;

            case 4:
            System.out.println("Thanks for using.");
            break;
        }

    };
    
    public static void main(String[] args) {
       atm obj1 = new atm(useracc);
       Bankacc useracc= new Bankacc(1000);
       while (true) {
        
       
        obj1.display();
        System.out.print("Enter your choice: ");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        obj1.transaction(choice);
       }
        
    }

}
