import java.util.*;

class Payment{

    static Scanner sc = new Scanner(System.in);

    static String mbNo;

    static void proceedToPay() {
        while (true) {
            System.out.print("> Enter Mobile Number: ");
            mbNo = sc.next();
            if(mbNo.matches("[789]\\d{9}")) {
                break;
            } else {
				System.out.println("* * * Invalid Input please enter a 10-digit mobile number starting with 8,9 or 7 * * * ");
            }
        }
        System.out.println("Your UPI_ID is " + mbNo + "@UPI\n");

        while(true) {
            Random random = new Random();
		    int paymentOPT = 1000 + random.nextInt(9000);

            System.out.println("OTP is send to " + mbNo + " - - - (" + paymentOPT + ")\n");
    
            System.out.print("> Enter OPT: ");
            int OTP = sc.nextInt();
    
            if(paymentOPT == OTP) {
                System.out.println("\n$ $ $ PAYMENT DONE $ $ $");
                System.out.println("$ $ $ Tickets Booked Successfully $ $ $\n");
                break;
            } else {
                System.out.println("\n* * * Wront OTP Entered. Please try Again! * * * \n");
            }
        }
    }

    // payment.run();
    
    public static void run() {
        while (true) {
            int exit = 0;
            System.out.println("1. Do you want to enter Mobile number for payment");
            System.out.println("2. exit");
            System.out.print("> Select an option: ");
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    exit = 1;
                    proceedToPay();
                    break;
                case 2:
                    exit = 1;
                    System.out.println("- - - - Thankyou. PLease visit again - - - -");
                    break;
                default:
                    System.out.println("Invalid option. Please select a valid option");
                    break;
            }
            if(exit == 1) {
                break;
            }
        }
    }  
}
