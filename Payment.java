import java.util.*;

class Payment implements colourcode{

    static Scanner sc = new Scanner(System.in);

    static String mbNo;

    static void proceedToPay() {
        while (true) {
            System.out.print(BLUE+"> Enter Mobile Number: "+RESET);
            mbNo = sc.next();
            if(mbNo.matches("[789]\\d{9}")) {
                break;
            } else {
				System.out.println(RED+"\n* * * Invalid Input please enter a 10-digit mobile number starting with 8,9 or 7 * * *\n"+RESET);
            }
        }
        System.out.print(YELLOW+"\nYour UPI_ID is " + mbNo + "@UPI\n"+RESET);

        while(true) {
            Random random = new Random();
		    int paymentOPT = 1000 + random.nextInt(9000);

            System.out.println(BOLD+PURPLE+"OTP is send to " + mbNo + " - - - (" + paymentOPT + ")\n"+RESET);
    
            System.out.print(BLUE+"> Enter OPT: "+RESET);
            int OTP = sc.nextInt();
    
            if(paymentOPT == OTP) {
                System.out.println(GREEN+"\n$ $ $ PAYMENT DONE $ $ $");
                System.out.println("$ $ $ Tickets Booked Successfully $ $ $\n"+RESET);
                break;
            } else {
                System.out.println(RED+"\n* * * Wront OTP Entered. Please try Again! * * * \n"+RESET);
            }
        }
    }

    // payment.run();
    
    public static void run() {
        while (true) {
            int exit = 0;
            System.out.println(YELLOW+"\n1. Do you want to enter Mobile number for payment"+RESET);
            System.out.println(RED+"2. exit\n"+RESET);
            System.out.print(BLUE+"> Select an option: "+RESET);
            int op = sc.nextInt();
            switch (op) {
                case 1:
                    exit = 1;
                    proceedToPay();
                    break;
                case 2:
                    exit = 1;
                    System.out.println(magent+"- - - - Thankyou. PLease visit again - - - -"+RESET);
                    break;
                default:
                    System.out.println(RED+"\n* * * Invalid option. Please select a valid option * * *\n"+RESET);
                    break;
            }
            if(exit == 1) {
                break;
            }
        }
    }  
}
