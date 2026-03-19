import java.util.*;
class test1{
	public static void main(String ags[]){
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome To The Ahmedabad BRTS Portal");
		REGISTRATION R = new REGISTRATION();// here we write object at line 6 before sout beacause we write obj first that if in brts class any static bolck or constructor are there than they run first
		LOCATIONS L = new LOCATIONS();
		boolean flag = false; 
		while(true){
			System.out.println("1. Login  \n2. Register  \n3. show routes");
			System.out.print("Enter your choice:");
			int ch = sc.nextInt();
			switch(ch){
				case 1: 
					if(flag){
						R.Login();
					}
					else{
						System.out.println("You need to register first");
					}
					break ;
				case 2: 
					if(flag){
						System.out.println("You are already registered");
					}
					else{
						R.Register();
						flag = true;
					}						
					break ;
				case 3: 
					L.Routes();
					return;
				default: 
					System.out.println("invalid choice");
			}
		}
	}
}


class REGISTRATION{
	Scanner sc = new Scanner(System.in);
	String name;
	String email;
	String pass;
	String confpass;
	int age;
	String mob;
	
	void Login(){
		System.out.print("enter email:");
		String email1 = sc.nextLine();
		System.out.print("enter pass:");
		String pass1 = sc.nextLine();
		if(email1.equals(email)&&pass.equals(pass1)){
			System.out.println("login succsesfull" + " " + "welcome" + " " + name);
		}
		else{
			System.out.println("invalid email or password");
			Login();
		}
	}
	
	void Register(){
		System.out.print("enter name:");
		name = sc.nextLine();
		boolean m = true;
		while(m){
			System.out.print("enter mobile number:");
			mob = sc.nextLine();
			if(mob.length()==10){
				m=false;
			}
			else{
				System.out.println("Enter Valid Mobile Number");
			}
		}
		boolean a = true;
		while(a){
			System.out.print("enter age:");
			age = sc.nextInt();
			if(age>=0&&age<=110){
				a = false;
			}
			else{
				System.out.println("enter valid age");
			}
		}
		sc.nextLine();
		System.out.print("enter email:");
		email = sc.nextLine();
		boolean p = true;
		while(p){
			System.out.print("enter password:");
			pass = sc.nextLine();
			if(pass.length()<=7){
				System.out.println("Password length must be atleast 8 character");
			}
			else{
				p = false;
			}
		}
		while(true){  // here we write direct true because after while loop no any statment in this method 
			System.out.print("enter conform passsword:");
			confpass = sc.nextLine();
			if(pass.equals(confpass)){
				System.out.println("Registration succesfully");
				return;
			}
			else{
				System.out.println("enter valid conform password");
			}
		}
	}
}
class LOCATIONS extends REGISTRATION{
	Scanner sc = new Scanner(System.in);
	static int From;
	static int To;
	static int distance;
	
	void Routes(){
		String[][] route = {{"RTO Circle","Maninagar"},{"Chandkheda","Naroda"},
		                    {"Ghuma","Science CIty"},{"Vastral Gam","Vasna"},{"Thaltel","Kalupur Railway Staion"}};
		System.out.println("Available Routes");
		 for (int i = 0; i < route.length; i++) {
            System.out.println((i + 1) + ". " + route[i][0] + " to " + route[i][1]);
        }
		System.out.print("Enter route number :");
		int n = sc.nextInt();
		//String r = route[n-1][0] + "to" + route[n-1][1];  no use now
		station(n);
		
	}
	void station(int n){
		String[] route1 = {"RTO Circle","Income Tax","Kalupur","Kankaria","Maninagar"};
		int[][] distances1 ={{0,4,8,10,9},{4,0,5,6,9},{8,5,0,3,4},{10,7,3,0,2},{9,9,4,2,0}};
		String[] route2 = {"Chandkheda","Visat","Motera","Naroda"};
		int[][] distances2 ={{0,3,3,14},{3,0,1,13},{3,1,0,14},{14,13,14,0}};
		String[] route3 = {"Ghuma","Bopal","ISKON","Sola","Science City"};
		int[][] distances3 ={{0,2,8,13,11},{2,0,6,11,9},{8,6,0,8,8},{13,11,8,0,4},{11,9,8,4,0}};
		String[] route4 = {"Vastral Gam","CTM","Isanpur","Paldi","Vasna"};
		int[][] distances4 ={{0,5,8,16,14},{5,0,4,13,10},{8,4,0,12,10},{16,13,12,0,5},{14,10,10,5,0}};
		String[] route5 = {"Thaltej","Gurukul","Memnagar","Sabarnati","Kalupur Railway Station"};
		int[][] distances5 ={{0,4,6,13,12},{4,0,4,12,10},{6,4,0,12,9},{13,12,12,0,9},{12,10,9,9,0}};
		
		switch(n){
			case 1:
				
				System.out.println("Available Stations :");
				for(int i = 0;i<route1.length;i++){
					System.out.println((i+1) + ". " + route1[i]);
				}
				System.out.print("Select the number for the 'From' station: ");
				From = sc.nextInt();
				System.out.print("Select the number for the 'To' station: ");
				To = sc.nextInt();
				
				if(From-1>=0&&From-1<route1.length&&To-1>=0&&To-1<route1.length){
					distance = distances1[From-1][To-1];
					System.out.println("Journey Details :");
					System.out.println("From: " + route1[From-1]);
					System.out.println("To  : " + route1[To-1]);
					System.out.println("Distance :" + distance + " " + "km");
				}
				else{
					System.out.println("Invalid Selection");
				}
				break;
				
			case 2:
				
				System.out.println("Available Stations :");
				for(int i = 0;i<route2.length;i++){
					System.out.println((i+1) + ". " + route2[i]);
				}
				System.out.print("Select the number for the 'From' station: ");
				From = sc.nextInt();
				System.out.print("Select the number for the 'To' station: ");
				To = sc.nextInt();
				
				if(From-1>=0&&From-1<route2.length&&To-1>=0&&To-1<route2.length){
					distance = distances2[From-1][To-1];
					System.out.println("Journey Details :");
					System.out.println("From: " + route2[From-1]);
					System.out.println("To  : " + route2[To-1]);
					System.out.println("Distance :" + distance + " " + "km");
				}
				else{
					System.out.println("Invalid Selection");
				}
				break;
				
			case 3:
				
				System.out.println("Available Stations :");
				for(int i = 0;i<route3.length;i++){
					System.out.println((i+1) + ". " + route3[i]);
				}
				System.out.print("Select the number for the 'From' station: ");
				From = sc.nextInt();
				System.out.print("Select the number for the 'To' station: ");
				To = sc.nextInt();
				
				if(From-1>=0&&From-1<route3.length&&To-1>=0&&To-1<route3.length){
					distance = distances3[From-1][To-1];
					System.out.println("Journey Details :");
					System.out.println("From: " + route3[From-1]);
					System.out.println("To  : " + route3[To-1]);
					System.out.println("Distance :" + distance + " " + "km");
				}
				else{
					System.out.println("Invalid Selection");
				}
				break;
				
			case 4:
				
				System.out.println("Available Stations :");
				for(int i = 0;i<route4.length;i++){
					System.out.println((i+1) + ". " + route4[i]);
				}
				System.out.print("Select the number for the 'From' station: ");
				From = sc.nextInt();
				System.out.print("Select the number for the 'To' station: ");
				To = sc.nextInt();
				
				if(From-1>=0&&From-1<route4.length&&To-1>=0&&To-1<route4.length){
					distance = distances4[From-1][To-1];
					System.out.println("Journey Details :");
					System.out.println("From: " + route4[From-1]);
					System.out.println("To  : " + route4[To-1]);
					System.out.println("Distance :" + distance + " " + "km");
				}
				else{
					System.out.println("Invalid Selection");
				}
				break;
				
			case 5:
				
				System.out.println("Available Stations :");
				for(int i = 0;i<route5.length;i++){
					System.out.println((i+1) + ". " + route5[i]);
				}
				
				System.out.print("Select the number for the 'From' station: ");
				From = sc.nextInt();
				System.out.print("Select the number for the 'To' station: ");
				To = sc.nextInt();
				
				if(From-1>=0&&From-1<route5.length&&To-1>=0&&To-1<route5.length){
					distance = distances5[From-1][To-1];
					System.out.println("Journey Details :");
					System.out.println("From: " + route5[From-1]);
					System.out.println("To  : " + route5[To-1]);
					System.out.println("Distance :" + distance + " " + "km");
				}
				else{
					System.out.println("Invalid Selection");
				}
				break;
				
				default:
					System.out.println("Invalid Route Choice");
		}
		System.out.println("enter for book ticket");
		booktecket b = new booktecket();
		b.display();
	}
}
class booktecket extends LOCATIONS{
	int ticketNumber = 1;
	double fare;
	double totalFare;
	double discount;
	booktecket(){
		if(distance>=0&&distance<=5){
			fare = 7;
			if(age<=18){
				fare =5;
			}
			else if(age>55){
				fare = 2;
			}
		}
		else if(distance>5&&distance<=10){
			fare = 15;
			if(age<=18){
				fare =10;
			}
			else if(age>55){
				fare = 5;
			}
		}
		else if(distance>10&&distance<=15){
			fare = 25;
			if(age<=18){
				fare =20;
			}
			else if(age>55){
				fare = 10;
			}
		}
		else{
			fare = 35;
			if(age<=18){
				fare =30;
			}
			else if(age>55){
				fare = 15;
			}
		}
		
	}
	void display(){
		System.out.println(" ********************************* ");
		System.out.println(" ************ JANMARG ************ ");
		System.out.println();
		System.out.println(" TicketNumber :" + " " + ticketNumber);
		System.out.println(" From         :" + " " + From);
		System.out.println(" To           :" + " " + To);
		System.out.println(" Distance     :" + " " + distance + " km ");
		System.out.println(" fare         :" + " " + fare + " rs. ");
		//System.out.println(" Discount     :" + " " + (fare-Totalfare) + " rs. ");
		//System.out.println(" Total fare   :" + " " + Totalfare + " rs. ");//THIS TWO LINES IS NOT VALID FOR YOUNG PEOPLE
		System.out.println();
		System.out.println(" Entry Validity Time :" + " " + " 30 Minutes");
		System.out.println(" Exit Validity Time  :" + " " + " 240 Minutes");
		System.out.println(" THANK YOU , HAVE A NICE TRIP  \n THIS TICKET IS NOT REFUNDABLE");
		System.out.println();
		System.out.println(" ************ JANMARG ************ ");
		System.out.println(" ********************************* ");
		ticketNumber++;
	}
}