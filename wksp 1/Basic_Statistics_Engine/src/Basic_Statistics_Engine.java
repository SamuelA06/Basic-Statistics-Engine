import java.util.ArrayList;
import java.util.Scanner;

public class Basic_Statistics_Engine {
	
	//input
	static Scanner input = new Scanner(System.in);
	
	//command integration
	static commands cmd = new commands();
	
	//list
	static ArrayList<Double> list_1 = new ArrayList<Double>();
	static ArrayList<Double> list_2 = new ArrayList<Double>();
	static ArrayList<Double> list_3 = new ArrayList<Double>();
	static ArrayList<Double> list_4 = new ArrayList<Double>();
	static ArrayList<Double> list_5 = new ArrayList<Double>();
			
	static int FullLists = 0;
	
	static ArrayList[]list_bank = {list_1,list_2,list_3,list_4,list_5};
	
	static String command;
	
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		System.out.println("Welcome to the Basic Statistics Engine (BSE)!");
		
		ArrayList<String> InputCommands = new ArrayList<String>();
			
		InputCommands.add("/New");
		InputCommands.add("/Edit");
		InputCommands.add("/Clear");
		
		ArrayList<String> Commands = new ArrayList<String>();
		
		Commands.add("/Input");
		Commands.add("/Sort");
		Commands.add("/MaxMin");
		Commands.add("/MMM");
		Commands.add("/Spread");
		Commands.add("/Quartiles");
		Commands.add("/Display");
		Commands.add("/Help");
		
		String CommandEntered;
		
		while (true){
			
			FullLists = 0;
			
			for(ArrayList<?> list: list_bank){
				
				if(list.size() != 0) {
					
					FullLists += 1;
				}
				
			}
			
			
			do{
				
				CommandEntered = null;
				
				System.out.println("\nHOME - Enter a command (enter /Help for help)");
									
				CommandEntered = input.next(); 
				
				if(!Commands.contains(CommandEntered)){
					
					System.out.println("\nInvalid Entry");
					
				}
			
			}while(!Commands.contains(CommandEntered));
			
			switch (CommandEntered){
			
				case "/Help":
					
					System.out.println(commands.Help());
				
					break;
			
				case "/Input":
					
					System.out.println("\nYou can:"
							+"\n"	
							+"\n add a new list (/New)"
							+"\n"	
							+"\n edit a list (/Edit)"
							+"\n"	
							+"\n clear a list (/Clear)"	
							+"\n"
							+"\nWhat would you like to do?"
							);
					
					String Command = input.next();				
					
					if(InputCommands.contains(Command)){commands.Input(Command);}else{System.out.println("\nInvalid Entry");}
									
					break;
					
				case "/Sort":
					
					commands.Sort();
					
					break;
					
				case "/MaxMin":
					
					commands.MaxMin();
					
					break;
					
				case "/MMM":
					
					commands.MMM();
					
					break;
					
				case "/Spread":
					
					commands.Spread();
					
					break;
			
				case "/Quartiles":
					
					commands.Quartiles();
					
					break;
					
				case "/Display":
					
					System.out.println("\nList 1: " + list_1
					+"\n"	
					+"\nList 2: " + list_2
					+"\n"	
					+"\nList 3: " + list_3
					+"\n"	
					+"\nList 4: " + list_4
					+"\n"	
					+"\nList 5: " + list_5
					);
					
					break;
			
			}
			
			System.out.println("\nOperation Terminated");
			
			input.nextLine();
			
		}
		
	}
	
}