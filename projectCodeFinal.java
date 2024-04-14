

import java.util.*;



interface colourcode 
{
	static String bgred="\u001B[41m";
 	static String bgblue="\u001B[44m";
    static String bgmegenta="\u001B[45";
    static String bggreen="\u001B[42m";
  	static String bgyellow="\u001B[43m";
    static String SET_BOLD_TEXT = "\033[0;1m";
	static String REDBRI= "\033[1;91m";
	static String increaseFontSize = "\u001B[50pxm";
	static String resetFormatting = "\033[0m";
	static String BOLD="\u001B[1m";
	static String BLINK ="\u001B[5m";
	static String whitebg="\u001B[47m";
	static String black ="\u001B[30m";
	String skblue = "\u001B[36m";
	static String magent = "\u001B[95m";
	static final String ital = "\u001B[3m";
	static String ul = "\u001B[4m";
	static String RESET = "\u001B[0m";
    static String RED = "\u001B[31m";
    static String GREEN = "\u001B[32m";
    static String YELLOW = "\u001B[33m";
	static String BLUE="\u001B[34m";
	static String PURPLE="\u001B[35m";
	static String WHITE="\u001B[37m";
	static String CYAN="\u001B[36m";
}


class MobileOTPVarification {
	static Scanner sc = new Scanner(System.in);

	static boolean isValidMobileNumber(String MobileNum) {
		return MobileNum.matches("[789]\\d{9}");
	}

	static int sendOTP(String MobileNum) {
		Random random = new Random();
		int otp = 1000 + random.nextInt(9000);
		// 1 + random.nextInt(9); 1-9
		System.out.println("OTP sent to " + MobileNum + " - - - (" + otp + ")");
		return otp;
	}
} 


interface Travel extends Kerala, Goa, TamilNadu, HimachalPradesh, colourcode {

	static void StatePickList() {
		System.out.println(magent+"1.InterState");
		System.out.println("2.IntraState\n"+RESET);

		System.out.print(CYAN+"> Select The StateType: ");
		char n = MobileOTPVarification.sc.next().charAt(0);

		if (n == '1' || n == '2') {
			if (n == '2') {
				TransportationWithinState(n);
			} else {
				TransportationOutSideState(n);
			}
		} else {
			System.out.println(RED+"\n* * * Invalid Input, Please Enter Valid Input * * *\n"+RESET);

			StatePickList();
		}

	}

	static void TransportationWithinState(char stateType) {
		System.out.println(YELLOW+"\n1.trains");
		System.out.println("2.Bus");
		System.out.println("3.Cab"+RESET);

		System.out.print(CYAN+"> Select The TransportationType: "+RESET);
		char n = MobileOTPVarification.sc.next().charAt(0);
		if (n >= '1' && n <= '3') {
			switch (n) {
				case '1':
					IntraStateTravel(n, stateType);
					break;
				case '2':
					IntraStateTravel(n, stateType);
					break;
				case '3':
					IntraStateTravel(n, stateType);
					break;
			}
		} else {
			System.out.println(RED + "\n* * * Invalid Input, Please Enter Valid Input * * *\n" + RESET);

			TransportationWithinState(stateType);
		}
	}

	static void TransportationOutSideState(char stateType) {
		System.out.println(YELLOW+"\n1.Flight");
		System.out.println("2.trains");
		System.out.println("3.Bus");
		System.out.println("4.Cab");
		System.out.println("5.Back"+RESET);

		System.out.print(CYAN+"> Select The TransportationType: "+RESET);
		char n = MobileOTPVarification.sc.next().charAt(0);

		if (n >= '1' && n <= '5') {
			switch (n) {
				case '1':
				case '2':
				case '3':
				case '4':
					InterStateTravel(n, stateType);
					break;
				case '5':
					Travel.StatePickList();
					break;
			}
		} else {
			System.out.print(RED+"\n* * * Invalid Input, Please Enter Valid Input * * *\n"+RESET);

			TransportationOutSideState(stateType);
		}

	}

	static void IntraStateTravel(char transport, char stateType) {
		
		System.out.println(PURPLE+"\n1.Telangana");
		System.out.println("2.Kerala");
		System.out.println("3.Goa");
		System.out.println("4.TamilNadu");
		System.out.println("5.Himachalpradesh");
		System.out.println("6.Back"+RESET);

		System.out.print(CYAN+"> Select The State You Want To Start: ");

		char n = MobileOTPVarification.sc.next().charAt(0);

		if (n >= '1' && n <= '6') {
			switch (n) {
				case '1':
					TelanganaStartingPoints(transport, stateType, n);
					break;
				case '2':
					Kerala.KeralaStartingPoints(transport, stateType, n);
					break;
				case '3':
					Goa.GoaStartingPoints(transport, stateType, n);
					break;
				case '4':
					TamilNadu.TamilNaduStartingPoints(transport, stateType, n);
					break;
				case '5':
					HimachalPradesh.HimachalPradeshStartingPoints(transport, stateType, n);
					break;
				case '6':
					TransportationWithinState(stateType);
					break;
			}
		} else {
			System.out.println(RED+"\n* * * Invalid Input, Please Enter Valid Input * * *\n"+RESET);

			IntraStateTravel(transport, stateType);
		}

	}

	static void InterStateTravel(char transport, char stateType) {
		System.out.println(PURPLE+"\n1.Telangana");
		System.out.println("2.Kerala");
		System.out.println("3.Goa");
		System.out.println("4.Back"+RESET);

		System.out.print(CYAN+"> Select The State You Want To Start: "+RESET);
		char n = MobileOTPVarification.sc.next().charAt(0); 

		if (n >= '1' && n <= '4') {

			switch (n) {
				case '1':
					TelanganaStartingPoints(transport, stateType, n);
					break;
				case '2':
					Kerala.KeralaStartingPoints(transport, stateType, n);
					break;
				case '3':
					Goa.GoaStartingPoints(transport, stateType, n);
					break;
				case '4':
					Travel.TransportationOutSideState(stateType);
					break;
			}
		} else {
			System.out.println(RED+"\n* * * Invalid Input, Please Enter Valid Input * * *\n"+RESET);
			InterStateTravel(transport, stateType);
		}

	}

	static void TelanganaStartingPoints(char transport, char stateType, char stateNum) {
		System.out.println(BLUE+"\n1.Hyderabad");
		System.out.println("2.Warangal");
		System.out.println("3.Yadadri Buvanagiri"+RESET);

		System.out.print(CYAN+"> Select The City You Want To Start The Journey: "+RESET);

		char cityNum1 = MobileOTPVarification.sc.next().charAt(0);

		if (cityNum1 >= '1' && cityNum1 <= '3') {

			if (stateType == '2') {
				TelanganaDestinationPoints(cityNum1, transport);
			} else if (stateType == '1') {
				Interstate object = new Interstate();
				object.InterStateTravel(transport, stateType, stateNum, cityNum1);

			}
		} else {
			System.out.println(RED+"\n* * * Invalid Input, Please Enter Valid Input * * *\n"+RESET);
			TelanganaStartingPoints(transport, stateType, stateNum);
		}

	}

	static void TelanganaDestinationPoints(char cityNum1, char transport) {
		System.out.println(BLUE+"\n1.Hyderabad");
		System.out.println("2.Warangal");
		System.out.println("3.Yadadri Buvanagiri"+RESET);

		System.out.print(CYAN+"> Select The Destination Point: "+RESET);

		char cityNum2 = MobileOTPVarification.sc.next().charAt(0);

		if (cityNum2 >= '1' && cityNum2 <= '3') {

			if (cityNum1 == cityNum2) {
				System.out.println(
						RED+"* * * Strarting point and Destination point Should not be same, please select different City * * *"+RESET);

				TelanganaDestinationPoints(cityNum1, transport);
			} else {
				if (transport == '1') {
					TicketPriceTrain(cityNum1, cityNum2);
				} else if (transport == '2') {
					TicketPriceBus(cityNum1, cityNum2);
				} else if (transport == '3') {
					TicketPriceCab(cityNum1, cityNum2);
				}

			}
		} else {
			System.out.println(RED+"\n* * * Invalid Input, Please Enter Valid Input * * *\n"+RESET);

			TelanganaDestinationPoints(cityNum1, transport);
		}

	}

	static void TicketPriceTrain(char cityNum1, char cityNum2) {

		int TicketPrice = 0;


		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1' || cityNum1 == '2') && (cityNum2 == '1' || cityNum2 == '2')) {
			TicketPrice = 95;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2' || cityNum1 == '3') && (cityNum2 == '2' || cityNum2 == '3')) {
			TicketPrice = 70;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1' || cityNum1 == '3') && (cityNum2 == '1' || cityNum2 == '3')) {
			TicketPrice = 30;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();
	}

	static void TicketPriceBus(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1' || cityNum1 == '2') && (cityNum2 == '1' || cityNum2 == '2')) {
			TicketPrice = 300;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2' || cityNum1 == '3') && (cityNum2 == '2' || cityNum2 == '3')) {
			TicketPrice = 150;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1' || cityNum1 == '3') && (cityNum2 == '1' || cityNum2 == '3')) {
			TicketPrice = 60;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();
	}

	static void TicketPriceCab(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1' || cityNum1 == '2') && (cityNum2 == '1' || cityNum2 == '2')) {
			TicketPrice = 2000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2' || cityNum1 == '3') && (cityNum2 == '2' || cityNum2 == '3')) {
			TicketPrice = 1500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1' || cityNum1 == '3') && (cityNum2 == '1' || cityNum2 == '3')) {
			TicketPrice = 900;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}
		Payment.run();
	}

}

interface HimachalPradesh extends colourcode {
	static void HimachalPradeshStartingPoints(char transport, char stateType, char stateNum) {
		System.out.println(BLUE+"\n1.Shimla");
		System.out.println("2.Manali");
		System.out.println("3.Dharamshala"+RESET);

		System.out.print(CYAN+"\n> Select The City You Want To Start The Journey: "+RESET);

		char cityNum1 = MobileOTPVarification.sc.next().charAt(0);

		if (cityNum1 >= '1' && cityNum1 <= '3') {
			if (stateType == '2') {
				HimachalPradeshDestinationPoints(cityNum1, transport);
			}
		} else {
			System.out.println(RED+"\n* * * Invalid Input, Please Enter Valid Input * * *\n"+RESET);
			HimachalPradeshStartingPoints(transport, stateType, stateNum);
		}

	}

	static void HimachalPradeshDestinationPoints(char cityNum1, char transport) {
		System.out.println(BLUE+"\n 1.Shimla");
		System.out.println("2.Manali");
		System.out.println("3.Dharamshala"+RESET);

		System.out.print(CYAN+"> Select The Destination Point: "+RESET);

		char cityNum2 = MobileOTPVarification.sc.next().charAt(0);
		if (cityNum2 >= '1' && cityNum2 <= '3') {
			if (cityNum1 == cityNum2) {
				System.out.println(
						"\n* * * Strarting point and Destination point Should not be same, please select different City * * *\n");

				HimachalPradeshDestinationPoints(cityNum1, transport);
			} else {
				if (transport == '1') {
					TicketPriceTrain(cityNum1, cityNum2);
				} else if (transport == '2') {
					TicketPriceBus(cityNum1, cityNum2);
				} else if (transport == '3') {
					TicketPriceCab(cityNum1, cityNum2);
				}
			}
		} else {
			System.out.println(RED+"\n* * * Invalid Input, Please Enter Valid Input * * *\n"+RESET);

			HimachalPradeshDestinationPoints(cityNum1, transport);
		}

	}

	static void TicketPriceTrain(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1' || cityNum1 == '2') && (cityNum2 == '1' || cityNum2 == '2')) {
			TicketPrice = 35;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2' || cityNum1 == '3') && (cityNum2 == '2' || cityNum2 == '3')) {
			TicketPrice = 45;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1' || cityNum1 == '3') && (cityNum2 == '1' || cityNum2 == '3')) {
			TicketPrice = 50;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();

	}

	static void TicketPriceBus(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1' || cityNum1 == '2') && (cityNum2 == '1' || cityNum2 == 2)) {
			TicketPrice = 80;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2' || cityNum1 == '3') && (cityNum2 == '2' || cityNum2 == '3')) {
			TicketPrice = 50;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1' || cityNum1 == '3') && (cityNum2 == '1' || cityNum2 == '3')) {
			TicketPrice = 90;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}



		Payment.run();

	}

	static void TicketPriceCab(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1' || cityNum1 == '2') && (cityNum2 == '1' || cityNum2 == '2')) {
			TicketPrice = 2500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2' || cityNum1 == '3') && (cityNum2 == '2' || cityNum2 == '3')) {
			TicketPrice = 3500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1' || cityNum1 == '3') && (cityNum2 == '1' || cityNum2 == '3')) {
			TicketPrice = 1500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}



		Payment.run();

	}
}

interface Kerala extends colourcode {
	static void KeralaStartingPoints(char transport, char stateType, char stateNum) {
		System.out.println(BLUE+"\n 1.Thiruvananthapuram");
		System.out.println("2.Alleppey");
		System.out.println("3.wayanad"+RESET);

		System.out.print(CYAN+"\n> Select The City You Want To Start The Journey: "+RESET);

		char cityNum1 = MobileOTPVarification.sc.next().charAt(0);

		if (cityNum1 >= '1' && cityNum1 <= '3') {
			if (stateType == '2') {
				KeralaDestinationPoints(cityNum1, transport);
			} else {
				Interstate object = new Interstate();
				object.InterStateTravel(transport, stateType, stateNum, cityNum1);
			}
		} else {
			System.out.println(RED+"\n* * * Invalid Input, Please Enter Valid Input * * *\n"+RESET);

			KeralaStartingPoints(transport, stateType, stateNum);
		}

	}

	static void KeralaDestinationPoints(char cityNum1, char transport) {
		System.out.println(BLUE+"\n1.Thiruvananthapuram");
		System.out.println("2.Alleppey");
		System.out.println("3.wayanad"+RESET);

		System.out.print(CYAN+"> Select The Destination Point: "+RESET);

		char cityNum2 = MobileOTPVarification.sc.next().charAt(0);

		if (cityNum2 >= '1' && cityNum2 <= '3') {
			if (cityNum1 == cityNum2) {

				System.out.println(
						"\n* * * Starting point and Destination point Should not be same, please select different City * * *\n");

				KeralaDestinationPoints(cityNum1, transport);
			} else {
				if (transport == '1') {
					TicketPriceTrain(cityNum1, cityNum2);
				} else if (transport == '2') {
					TicketPriceBus(cityNum1, cityNum2);
				} else if (transport == '3') {
					TicketPriceCab(cityNum1, cityNum2);
				}
			}
		} else {

			System.out.println(RED+"\n* * * Invalid Input, Please Enter Valid Input * * *\n"+RESET);

			KeralaDestinationPoints(cityNum1, transport);
		}

	}

	static void TicketPriceTrain(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1' || cityNum1 == '2') && (cityNum2 == '1' || cityNum2 == '2')) {
			TicketPrice = 520;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2' || cityNum1 == '3') && (cityNum2 == '2' || cityNum2 == '3')) {
			TicketPrice = 660;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1' || cityNum1 == '3') && (cityNum2 == '1' || cityNum2 == '3')) {
			TicketPrice = 470;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}



		Payment.run();

	}

	static void TicketPriceBus(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1' || cityNum1 == '2') && (cityNum2 == '1' || cityNum2 == '2')) {
			TicketPrice = 45;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2' || cityNum1 == '3') && (cityNum2 == '2' || cityNum2 == '3')) {
			TicketPrice = 50;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1' || cityNum1 == '3') && (cityNum2 == '1' || cityNum2 == '3')) {
			TicketPrice = 60;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}



		Payment.run();

	}

	static void TicketPriceCab(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1' || cityNum1 == '2') && (cityNum2 == '1' || cityNum2 == '2')) {
			TicketPrice = 1500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2' || cityNum1 == '3') && (cityNum2 == '2' || cityNum2 == '3')) {
			TicketPrice = 1800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1' || cityNum1 == '3') && (cityNum2 == '1' || cityNum2 == '3')) {
			TicketPrice = 1700;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();

	}

}

interface TamilNadu extends colourcode{
	static void TamilNaduStartingPoints(char transport, char stateType, char stateNum) {
		System.out.println(BLUE+"\n1.Chennai");
		System.out.println("2.kanyakumari");
		System.out.println("3.Madurai");
		System.out.println("4.Rameshwaram");
		System.out.println("5.Coiambatore"+RESET);

		System.out.print(CYAN+"> Select The City You Want To Start The Journey: "+RESET);


		char cityNum1 = MobileOTPVarification.sc.next().charAt(0);

		if (cityNum1 >= '1' && cityNum1 <= '5') {
			if (stateType == '2')
				TamilNaduDestinationPoints(cityNum1, transport);
		} else {
			System.out.println(RED+"\n* * * Invalid Input, Please Enter Valid Input * * *\n"+RESET);

			TamilNaduStartingPoints(transport, stateType, stateNum);

		}

	}

	static void TamilNaduDestinationPoints(char cityNum1, char transport) {

		System.out.println(BLUE+"\n1.Chennai");
		System.out.println("2.kanyakumari");
		System.out.println("3.Madurai");
		System.out.println("4.Rameshwaram");
		System.out.println("5.Coiambatore"+RESET);

		System.out.print(CYAN+"> Select The Destination Point: "+RESET);

		char cityNum2 = MobileOTPVarification.sc.next().charAt(0);

		if (cityNum2 >= '1' && cityNum2 <= '5') {

			if (cityNum1 == cityNum2) {
				System.out.println(
						RED+"\n* * * Strarting point and Destination point Should not be same, please select different City * * *\n"+RESET);

				TamilNaduDestinationPoints(cityNum1, transport);
			} else {
				if (transport == '1') {
					TicketPriceTrain(cityNum1, cityNum2);
				} else if (transport == '2') {
					TicketPriceBus(cityNum1, cityNum2);
				} else if (transport == '3') {
					Travel.TicketPriceCab(cityNum1, cityNum2);
				}
			}
		} else {
			System.out.println(RED+"\n* * * Invalid Input, Please Enter Valid Input * * *\n"+RESET);

			TamilNaduDestinationPoints(cityNum1, transport);
		}

	}

	static void TicketPriceTrain(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1' || cityNum1 == '2') && (cityNum2 == '1' || cityNum2 == '2')) {
			TicketPrice = 45;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2' || cityNum1 == '3') && (cityNum2 == '2' || cityNum2 == '3')) {
			TicketPrice = 25;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3' || cityNum1 == '4') && (cityNum2 == '3' || cityNum2 == '4')) {
			TicketPrice = 75;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '4' || cityNum1 == '5') && (cityNum2 == '4' || cityNum2 == '5')) {
			TicketPrice = 30;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '5' || cityNum1 == '1') && (cityNum2 == '5' || cityNum2 == '1')) {
			TicketPrice = 275;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '5' || cityNum1 == '3') && (cityNum2 == '3' || cityNum2 == '5')) {
			TicketPrice = 225;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1' || cityNum1 == '3') && (cityNum2 == '1' || cityNum2 == '3')) {
			TicketPrice = 225;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1' || cityNum1 == '4') && (cityNum2 == '1' || cityNum2 == '4')) {
			TicketPrice = 225;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2' || cityNum1 == '4') && (cityNum2 == '2' || cityNum2 == '4')) {
			TicketPrice = 225;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2' || cityNum1 == '5') && (cityNum2 == '2' || cityNum2 == '5')) {
			TicketPrice = 225;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();

	}

	static void TicketPriceBus(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1' || cityNum1 == '2') && (cityNum2 == '1' || cityNum2 == '2')) {
			TicketPrice = 35;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2' || cityNum1 == '3') && (cityNum2 == '2' || cityNum2 == '3')) {
			TicketPrice = 55;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3' || cityNum1 == '4') && (cityNum2 == '3' || cityNum2 == '4')) {
			TicketPrice = 75;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '4' || cityNum1 == '5') && (cityNum2 == '4' || cityNum2 == '5')) {
			TicketPrice = 40;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '5' || cityNum1 == '1') && (cityNum2 == '5' || cityNum2 == '1')) {
			TicketPrice = 75;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '5' || cityNum1 == '3') && (cityNum2 == '3' || cityNum2 == '5')) {
			TicketPrice = 25;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1' || cityNum1 == '3') && (cityNum2 == '3' || cityNum2 == '1')) {
			TicketPrice = 45;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1' || cityNum1 == '4') && (cityNum2 == '4' || cityNum2 == '1')) {
			TicketPrice = 75;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2' || cityNum1 == '4') && (cityNum2 == '2' || cityNum2 == '4')) {
			TicketPrice = 25;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2' || cityNum1 == '5') && (cityNum2 == '2' || cityNum2 == '5')) {
			TicketPrice = 30;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '5' || cityNum1 == '4') && (cityNum2 == '4' || cityNum2 == '5')) {
			TicketPrice = 25;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}
		Payment.run();

	}

	static void TicketPriceCab(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1' || cityNum1 == '2') && (cityNum2 == '1' || cityNum2 == '2')) {
			TicketPrice = 14500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2' || cityNum1 == '3') && (cityNum2 == '2' || cityNum2 == '3')) {
			TicketPrice = 12500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3' || cityNum1 == '4') && (cityNum2 == '3' || cityNum2 == '4')) {
			TicketPrice = 17500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '4' || cityNum1 == '5') && (cityNum2 == '4' || cityNum2 == '5')) {
			TicketPrice = 30000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '5' || cityNum1 == '1') && (cityNum2 == '5' || cityNum2 == '1')) {
			TicketPrice = 27500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '5' || cityNum1 == '3') && (cityNum2 == '3' || cityNum2 == '5')) {
			TicketPrice = 225;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1' || cityNum1 == '3') && (cityNum2 == '1' || cityNum2 == '3')) {
			TicketPrice = 225;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2' || cityNum1 == '4') && (cityNum2 == '2' || cityNum2 == '4')) {
			TicketPrice = 225;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2' || cityNum1 == '5') && (cityNum2 == '2' || cityNum2 == '5')) {
			TicketPrice = 225;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} 
		Payment.run();
	}
}

interface Goa extends colourcode{

	static void GoaStartingPoints(char transport, char stateType, char stateNum) {
		System.out.println(BLUE+"\n1.Bardez");
		System.out.println("2.Pernem");
		System.out.println("3.Mormugoa");
		System.out.println("4.Sanguem"+RESET);

		System.out.print(CYAN+"> Select The City You Want To Start The Journey: "+RESET);

		char cityNum1 = MobileOTPVarification.sc.next().charAt(0);
		if (cityNum1 >= '1' && cityNum1 <= '4') {
			if (stateType == 2) {
				GoaDestinationPoints(cityNum1, transport);
			} else {
				Interstate object = new Interstate();
				object.InterStateTravel(transport, stateType, stateNum, cityNum1);
			}
		} else {
			System.out.println(RED+"\n* * * Invalid Input, Please Enter Valid Input * * *\n"+RESET);

			GoaStartingPoints(transport, stateType, stateNum);
		}
	}

	static void GoaDestinationPoints(char cityNum1, char transport) {
		System.out.println(BLUE+"\n1.Bardez");
		System.out.println("2.Pernem");
		System.out.println("3.Mormugoa");
		System.out.println("4.Sanguem"+RESET);

		System.out.print(CYAN+"> Select The Destination Point: "+RESET);
		char cityNum2 = MobileOTPVarification.sc.next().charAt(0);

		if (cityNum2 >= '1' && cityNum2 <= '4') {

			if (cityNum1 == cityNum2) {
				System.out.println(
						"Strarting point and Destination point Should not be same, please select different City");

				GoaDestinationPoints(cityNum1, transport);
			} else {
				if (transport == '1') {
					TicketPriceTrain(cityNum1, cityNum2);
				} else if (transport == '2') {
					TicketPriceBus(cityNum1, cityNum2);
				} else if (transport == '3') {
					TicketPriceCab(cityNum1, cityNum2);
				}
			}
		} else {
			System.out.println(RED+"\n* * * Invalid Input, Please Enter Valid Input * * *\n"+RESET);

			GoaDestinationPoints(cityNum1, transport);
		}
	}

	static void TicketPriceTrain(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1' || cityNum1 == '2') && (cityNum2 == '1' || cityNum2 == '2')) {
			TicketPrice = 50;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2' || cityNum1 == '3') && (cityNum2 == '2' || cityNum2 == '3')) {
			TicketPrice = 70;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3' || cityNum1 == '4') && (cityNum2 == '3' || cityNum2 == '4')) {
			TicketPrice = 30;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1' || cityNum1 == '4') && (cityNum2 == '1' || cityNum2 == '4')) {
			TicketPrice = 40;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '4' || cityNum1 == '2') && (cityNum2 == '2' || cityNum2 == '4')) {
			TicketPrice = 25;
			System.out.println("\nTicketPrice: " + TicketPrice);
		} else if ((cityNum1 == '1' || cityNum1 == '3') && (cityNum2 == '1' || cityNum2 == '3')) {
			TicketPrice = 35;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}
		Payment.run();

	}

	static void TicketPriceBus(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);
		if ((cityNum1 == '1' || cityNum1 == '2') && (cityNum2 == '1' || cityNum2 == '2')) {
			TicketPrice = 80;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2' || cityNum1 == '3') && (cityNum2 == '2' || cityNum2 == '3')) {
			TicketPrice = 60;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3' || cityNum1 == '4') && (cityNum2 == '3' || cityNum2 == '4')) {
			TicketPrice = 90;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1' || cityNum1 == '4') && (cityNum2 == '1' || cityNum2 == '4')) {
			TicketPrice = 60;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '4' || cityNum1 == '2') && (cityNum2 == '2' || cityNum2 == '4')) {
			TicketPrice = 55;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1' || cityNum1 == '3') && (cityNum2 == '1' || cityNum2 == '3')) {
			TicketPrice = 45;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}
		Payment.run();
	}

	static void TicketPriceCab(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);
		if ((cityNum1 == '1' || cityNum1 == '2') && (cityNum2 == '1' || cityNum2 == '2')) {
			TicketPrice = 15500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2' || cityNum1 == '3') && (cityNum2 == '2' || cityNum2 == '3')) {
			TicketPrice = 17500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3' || cityNum1 == '4') && (cityNum2 == '3' || cityNum2 == '4')) {
			TicketPrice = 15300;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1' || cityNum1 == '4') && (cityNum2 == '1' || cityNum2 == '4')) {
			TicketPrice = 14400;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '4' || cityNum1 == '2') && (cityNum2 == '2' || cityNum2 == '4')) {
			TicketPrice = 1250;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1' || cityNum1 == '3') && (cityNum2 == '1' || cityNum2 == '3')) {
			TicketPrice = 25;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}
		Payment.run();
	}
}

class Interstate implements Travel{

	static void InterStateTravel(char transport, char stateType, char stateNum, char cityNum1) {
		System.out.println(PURPLE+"\n1.Telangana");
		System.out.println("2.Kerala");	
		System.out.println("3.Goa");
		System.out.println("4. Back"+RESET);

		System.out.print(CYAN+"> Select The State You Want To Reach: "+RESET);

		char n = MobileOTPVarification.sc.next().charAt(0);

		if (n >= '1' && n <= '4') {
			if (n == stateNum) {
				System.out.println(RED+"* * * Please Choose Other State * * *"+RESET);
				InterStateTravel(transport, stateType, stateNum, cityNum1);
			} else {
				switch (n) {
					case '1':
						TelanganaDestinationPoints(transport, stateType, stateNum, cityNum1, n);
						break;
					case '2':
						KeralaDestinationPoints(transport, stateType, stateNum, cityNum1, n);
						break;
					case '3':
						GoaDestinationPoints(transport, stateType, stateNum, cityNum1, n);
						break;
					case '4':
						Travel.TransportationOutSideState(stateType);
						break;
				}
			}
		} else {
			System.out.println(RED+"\n* * * Invalid Input, Please Enter Valid Input * * *\n"+RESET);

			InterStateTravel(transport, stateType, stateNum, cityNum1);
		}

	}

	static void KeralaDestinationPoints(char transport, char stateType, char stateNum, char cityNum1, char stateNum2) {
		System.out.println(BLUE+"\n1.Thiruvananthapuram");
		System.out.println("2.Alleppey");
		System.out.println("3.wayanad"+RESET);

		System.out.print(CYAN+"> Select The Destination Point: "+RESET);

		char cityNum2 = MobileOTPVarification.sc.next().charAt(0);

		if (cityNum2 >= '1' && cityNum2 <= '3') {
			if (stateNum == '1' && stateNum2 == '2') {
				TelanganaToKerala(transport, cityNum1, cityNum2);
			} else if (stateNum == '3' && stateNum2 == '2') {
				GoaToKerala(transport, cityNum1, cityNum2);
			}
		} else {
			System.out.println(RED+"\n* * * Invalid Input, Please Enter Valid Input * * *\n"+RESET);

			KeralaDestinationPoints(transport, stateType, stateNum, cityNum1, stateNum2);
		}

	}

	static void GoaDestinationPoints(char transport, char stateType, char stateNum, char cityNum1, char stateNum2) {
		System.out.println(BLUE+"\n1.Bardez");
		System.out.println("2.Pernem");
		System.out.println("3.Sanguem"+RESET);

		System.out.print(CYAN+"> Select The Destination Point: "+RESET);


		char cityNum2 = MobileOTPVarification.sc.next().charAt(0);

		if (cityNum2 >= '1' && cityNum2 <= '3') {
			if (stateNum == '1' && stateNum2 == '3') {
				TelenganaToGoa(transport, cityNum1, cityNum2);
			} else if (stateNum == '2' && stateNum2 == '3') {
				KeralaToGoa(transport, cityNum1, cityNum2);
			}
		} else {
			System.out.println(RED+"\n* * * Invalid Input, Please Enter Valid Input * * *\n"+RESET);

			GoaDestinationPoints(transport, stateType, stateNum, cityNum1, stateNum2);
		}

	}

	static void TelanganaDestinationPoints(char transport, char stateType, char stateNum, char cityNum1,
			char stateNum2) {
		System.out.println(BLUE+"\n1.Hyderabad");
		System.out.println("2.Warangal");
		System.out.println("3.Yadadri Buvanagiri"+RESET);

		System.out.print(CYAN+"> Select The Destination Point: "+RESET);

		char cityNum2 = MobileOTPVarification.sc.next().charAt(0);

		if (cityNum2 >= '1' && cityNum2 <= '3') {

			if (stateNum == '2' && stateNum2 == '1') {
				KeralaToTelangana(transport, cityNum1, cityNum2);
			} else if (stateNum == '3' && stateNum2 == '1') {
				GoaToTelangana(transport, cityNum1, cityNum2);
			}

		} else {
			System.out.println(RED+"\n* * * Invalid Input, Please Enter Valid Input * * *\n"+RESET);

			TelanganaDestinationPoints(transport, stateType, stateNum, cityNum1, stateNum2);
		}

	}

	static void KeralaToTelangana(char transport, char cityNum1, char cityNum2) {
		switch (transport) {

			case '1':
				KeralaToTelanganaTicketPriceTrain(cityNum1, cityNum2);
				break;
			case '2':
				KeralaToTelanganaTicketPriceBus(cityNum1, cityNum2);
				break;
			case '3':
				KeralaToTelanganaTicketPriceCab(cityNum1, cityNum2);
				break;
			case '4':
				KeralaToTelanganaTicketPriceFlight(cityNum1, cityNum2);
				break;

		}
	}

	static void KeralaToTelanganaTicketPriceTrain(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 740;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 749;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 770;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 850;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 860;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 920;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 750;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 740;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 790;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}
		Payment.run();
	}

	static void KeralaToTelanganaTicketPriceBus(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 2800;

			System.out.println("\nTicketPrice: " + TicketPrice);
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 2200;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 2500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 2400;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 2300;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 2500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 2500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 2700;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 2750;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();

	}

	static void KeralaToTelanganaTicketPriceCab(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 14900;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 16500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 16500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 16500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 18500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 14500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 15700;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 15500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 15000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();
	}

	static void KeralaToTelanganaTicketPriceFlight(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 3500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 3500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 3400;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 4200;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 3300;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 6500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 6200;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 5800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 6000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();

	}

	static void GoaToTelangana(char transport, char cityNum1, char cityNum2) {
		switch (transport) {

			case '1':
				GoaToTelanganaTicketPriceTrain(cityNum1, cityNum2);
				break;
			case '2':
				GoaToTelanganaTicketPriceBus(cityNum1, cityNum2);
				break;
			case '3':
				GoaToTelanganaTicketPriceCab(cityNum1, cityNum2);
				break;
			case '4':
				GoaToTelanganaTicketPriceFlight(cityNum1, cityNum2);
				break;

		}
	}

	static void GoaToTelanganaTicketPriceTrain(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 700;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 970;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 550;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 870;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 900;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 650;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 750;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 900;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}
		Payment.run();
	}

	static void GoaToTelanganaTicketPriceBus(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 1800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 2300;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 2800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 2500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 2500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 2800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 3500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 2800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 3750;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();
	}

	static void GoaToTelanganaTicketPriceCab(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 13900;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 15500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 16000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 16500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 17500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 16500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 16700;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 17500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 16000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();

	}

	static void GoaToTelanganaTicketPriceFlight(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 2500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 3800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 4200;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 4300;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 3600;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 5500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 6000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 5800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 6600;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}
		Payment.run();

	}

	static void KeralaToGoa(char transport, char cityNum1, char cityNum2) {
		switch (transport) {

			case '1':
				KeralaToGoaTicketPriceFlight(cityNum1, cityNum2);
				break;
			case '2':
				KeralaToGoaTicketPriceTrain(cityNum1, cityNum2);
				break;
			case '3':
				KeralaToGoaTicketPriceBus(cityNum1, cityNum2);
				break;
			case '4':
				KeralaToGoaTicketPriceCab(cityNum1, cityNum2);
				break;

		}
	}

	static void KeralaToGoaTicketPriceTrain(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 900;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 1500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 1050;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 1060;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 1000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 1100;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 1600;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 1250;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 1200;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}
		Payment.run();

	}

	static void KeralaToGoaTicketPriceBus(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 2500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 2000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 2800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 2200;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 2300;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 2800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 2100;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 2300;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 2350;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}
		Payment.run();

	}

	static void KeralaToGoaTicketPriceCab(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 15400;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 13100;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 12800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 18600;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 19900;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 16500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 18700;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 18500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 15600;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();
	}

	static void KeralaToGoaTicketPriceFlight(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 6500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 8700;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 8950;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 9900;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 9700;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 9000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 6900;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 8800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 5600;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();
	}

	static void TelenganaToGoa(char transport, char cityNum1, char cityNum2) {
		switch (transport) {

			case '1':
				TelenganaToGoaTicketPriceFlight(cityNum1, cityNum2);
				break;
			case '2':
				TelenganaToGoaTicketPriceTrain(cityNum1, cityNum2);
				break;
			case '3':
				TelenganaToGoaTicketPriceBus(cityNum1, cityNum2);
				break;
			case '4':
				TelenganaToGoaTicketPriceCab(cityNum1, cityNum2);
				break;

		}
	}

	static void TelenganaToGoaTicketPriceTrain(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);
		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 480;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 550;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 480;
			System.out.println("\nTicketPrice: " + TicketPrice);
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 560;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 600;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 550;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 600;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();
	}

	static void TelenganaToGoaTicketPriceBus(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 1500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 2800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == 1) && (cityNum2 == 3)) {
			TicketPrice = 1800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 2200;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 2000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 3800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 2500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 2800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 2750;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();
	}

	static void TelenganaToGoaTicketPriceCab(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 13000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 15000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 15000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 16700;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 17000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 16500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 17700;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 17500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 15000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();
	}

	static void TelenganaToGoaTicketPriceFlight(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 3500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 3700;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 4000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 4500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 4700;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 5000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 6000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 5800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 6600;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();
	}

	static void TelanganaToKerala(char transport, char cityNum1, char cityNum2) {
		switch (transport) {

			case '1':
				TicketPriceFlight(cityNum1, cityNum2);
				break;
			case '2':
				TicketPriceTrain(cityNum1, cityNum2);
				break;
			case '3':
				TicketPriceBus(cityNum1, cityNum2);
				break;
			case '4':
				TicketPriceCab(cityNum1, cityNum2);
				break;

		}
	}

	static void GoaToKerala(char transport, char cityNum1, char cityNum2) {
		switch (transport) {

			case '1':
				GoaTokeralaTicketPriceFlight(cityNum1, cityNum2);
				break;
			case '2':
				GoaTokeralaTicketPriceTrain(cityNum1, cityNum2);
				break;
			case '3':
				GoaTokeralaTicketPriceBus(cityNum1, cityNum2);
				break;
			case '4':
				GoaTokeralaTicketPriceCab(cityNum1, cityNum2);
				break;
		}
	}

	static void GoaTokeralaTicketPriceTrain(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 900;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 1500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 1050;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 1060;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 1000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 1100;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 1600;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 1250;
			System.out.println("\nTicketPrice: " + TicketPrice);
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 1200;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();
	}

	static void GoaTokeralaTicketPriceBus(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 2500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 2000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 2800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 2200;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 2300;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 2800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 2100;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 2300;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 2350;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();
	}

	static void GoaTokeralaTicketPriceCab(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);
		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 15400;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 13100;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 12800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 18600;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 19900;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 16500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 18700;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 18500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 15600;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();
	}

	static void GoaTokeralaTicketPriceFlight(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);
		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 6500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 8700;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 8950;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 9900;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 9700;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 9000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 6900;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 8800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 5600;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();
	}

	static void TicketPriceTrain(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 4600;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 2500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 2200;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 2500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 1000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 1100;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 1600;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 1900;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 1200;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();
	}

	static void TicketPriceBus(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 4200;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 2000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 1800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 1700;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 620;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 1000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 1300;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 950;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();
	}

	static void TicketPriceCab(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 13400;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 13100;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 12800;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 15600;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 10000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 15200;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 19000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 18100;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 16500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();
	}

	static void TicketPriceFlight(char cityNum1, char cityNum2) {
		int TicketPrice = 0;

		System.out.println(PURPLE+"\nNOTE: If in case you entered 300 I takes only the first number (300 == 3) !!! ^ v ^"+RESET);
		System.out.print(CYAN+"\n> Enter Number Of Tickets You Want To Book: "+RESET);
		char tc = MobileOTPVarification.sc.next().charAt(0);

		if ((cityNum1 == '1') && (cityNum2 == '1')) {
			TicketPrice = 7500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '2')) {
			TicketPrice = 6000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '1') && (cityNum2 == '3')) {
			TicketPrice = 9050;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '1')) {
			TicketPrice = 5900;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '2')) {
			TicketPrice = 7700;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '2') && (cityNum2 == '3')) {
			TicketPrice = 8000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '1')) {
			TicketPrice = 4900;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '2')) {
			TicketPrice = 7000;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		} else if ((cityNum1 == '3') && (cityNum2 == '3')) {
			TicketPrice = 6500;
			System.out.println("\nTicket Price for " + tc + " tickets: " + (TicketPrice * (tc - 48)));
		}

		Payment.run();
	}

}


class User extends MobileOTPVarification implements Travel {

	public final String MobileNum = null;

	public static void main(String[] args) {

		System.out.println(RED+BOLD+"\n\n- - - - Welcome to TicketOdyssey.com - - - -"+RESET);

		User obj = new User();

		while (true) {
			System.out.print(CYAN+"\n> Enter your Mobile Number: "+RESET);
			String MobileNum = sc.next();

			if (isValidMobileNumber(MobileNum)) {
	
				for (int i = 0;; i++) {
					int otp = sendOTP(MobileNum);
					System.out.print(CYAN+"> Enter the OTP sent to your Mobile Number: "+RESET);
	
					int userOTP = sc.nextInt();
					if (userOTP == otp) {
						System.out.println(GREEN+"******* Login Successfull *******\n"+RESET);
						Travel.StatePickList();
						break;
					} else {
						System.out.println(RED+"******** Incorrect OTP Login Faild *******\n"+RESET);
					}
				}
				break;
			} else {
				System.out.println(RED+"* * * Invalid Input please enter a 10-digit mobile number starting with 8,9 or 7 * * * "+RESET);
			}
		}
	}
}