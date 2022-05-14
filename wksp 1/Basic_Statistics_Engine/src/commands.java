import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.ArrayList;

public class commands {
	
	static int ListNumber = 0;
	
	static Basic_Statistics_Engine BSE = new Basic_Statistics_Engine();
	
	static String Help() {return("\nBSE is a command based system that can store and run calculations on up to five lists"
			+ "\n"
			+ "Enter commands in BSE with \"/\" followed by the command name as listed"
			+ "\n"
			+ "\nThere are seven total commands in BSE:"
			+ "\n"
			+ "\nInput: contains the subcommands: "
			+ "\n New (allows for the entry of numbers into new list)"
			+ "\n Clear(clear a specified list)"
			+ "\n Edit (edits a specified values of a list)"
			+ "\n"
			+ "\nSort: Sorts a specified list"
			+ "\n"
			+ "\nMMM: identifies the Mean, Median, and modes of a specified list"
			+ "\n"
			+ "\nMaxMin: identifies the maximum and minimum of a specified list"
			+ "\n"
			+ "\nSpread: identifies the range, variance, and standard deviation of a specified list"
			+ "\n"
			+ "\nQuartiles: identifies the first quartile, second quartile, third quartile, and the interquartile range of a specified list"
			+"\n"
			+"\nDisplay: displays all lists"
			+ "\n"
			+ "\nUSER NOTES:"
			+ "\n All invalid entries into the program will terminate the process it is undergoing."
			+ "\n DECIMALS MAY BE ENTERED INTO THE SYSTEM."
			+ "\n All operations print \"Operation Terminated\" when they are completed or stopped."
			
			
	);}
	
	static void Input(String mode) {
		
		switch (mode) {
		
			case "/New":
				
				if(BSE.FullLists == 5) {
					
					System.out.println("\nInsufficient storage space. Delete a list first.");
					
					return;
					
				}
				
				int ValueCount = 0;
				
				//input						
				System.out.println("\nHow many values would you like to add to List " + (BSE.FullLists + 1));
				
				try {
					
					ValueCount = BSE.input.nextInt();
					
				}catch (Exception e){
						
					System.out.println("\nInvalid Entry");
					
					return;
									
				}
							
				//System.out.println(BSE.FullLists);
				
				if(BSE.FullLists < 5) {
				
					for(int i = 1; ValueCount >= i; i++){
						
						System.out.println("Enter value #" + i);
						
						try {
						
						BSE.list_bank[BSE.FullLists].add(BSE.input.nextDouble());
						
						}catch (Exception e){
							
							System.out.println("\nInvalid Entry");
							
							BSE.list_bank[BSE.FullLists].clear();
							
							return;
							
						}
						
					}
					
				}
				
				System.out.println("\nList " + (BSE.FullLists + 1) + " created");
				
				break;
			
			case "/Edit":
				
				if(BSE.FullLists == 0) {System.out.println("\nCreate a list first"); return;}
				
				System.out.println("\nList 1: " + BSE.list_1
						+"\n"	
						+"\nList 2: " + BSE.list_2
						+"\n"	
						+"\nList 3: " + BSE.list_3
						+"\n"	
						+"\nList 4: " + BSE.list_4
						+"\n"	
						+"\nList 5: " + BSE.list_5
				);
				
				//initializing necessary vars

				int TempIndex;
				
				double PrevValue;
				
				//no nonexistent lists		
							
				System.out.println("\nWhich list would you like to edit?");
				
				try {
										
					ListNumber = BSE.input.nextInt() - 1;
				
					if(BSE.FullLists < ListNumber + 1 || ListNumber + 1 <= 0) {
						
						System.out.println("\nList not found"); 
						
						return;
						
					}
					
					System.out.println("\nWhich index of list " + (ListNumber + 1) + " would you like to edit?");
					
					TempIndex = (BSE.input.nextInt() - 1);
					
					PrevValue = (double) BSE.list_bank[ListNumber].get(TempIndex);
					
					System.out.println("\nWhat value would you like to set Index " + (TempIndex + 1) + " (currently: "+ PrevValue + ")" + " to?");
					
					BSE.list_bank[ListNumber].set(TempIndex,BSE.input.nextDouble());
			
					System.out.println("\nValue " + (TempIndex + 1) + " of list 1 (originally: " + PrevValue + ") is now " + (double)BSE.list_bank[ListNumber].get(TempIndex));
					
					
				}catch(Exception e){
					
					System.out.println("\nInvalid Entry");
					
					return;
					
				}
				
				break;
				
			case "/Clear":

				if(BSE.FullLists == 0) {System.out.println("\nCreate a list first"); return;}
				
				System.out.println("\nList 1: " + BSE.list_1
						+"\n"	
						+"\nList 2: " + BSE.list_2
						+"\n"	
						+"\nList 3: " + BSE.list_3
						+"\n"	
						+"\nList 4: " + BSE.list_4
						+"\n"	
						+"\nList 5: " + BSE.list_5
				);
			
				System.out.println("\nWhich list would you like to clear?");
				
				try {ListNumber = BSE.input.nextInt() - 1;
				
				}catch(Exception e){
					
					System.out.println("\nInvalid Entry");
					
				}
				
				if(BSE.list_bank[ListNumber].size() > 0){
							
					BSE.list_bank[ListNumber].clear();
					
					System.out.println("\nList " + (ListNumber + 1) + " cleared");
					
				}else {
					
					System.out.println("\nList is empty");
					
				}
			
				break;
				
		}
		
	}
	
	static void Sort() {
		
		if(BSE.FullLists == 0) {System.out.println("\nCreate a list first"); return;}
		
		System.out.println("\nList 1: " + BSE.list_1
				+"\n"	
				+"\nList 2: " + BSE.list_2
				+"\n"	
				+"\nList 3: " + BSE.list_3
				+"\n"	
				+"\nList 4: " + BSE.list_4
				+"\n"	
				+"\nList 5: " + BSE.list_5
		);
					
		System.out.println("\nWhich list would you like to sort?");
			
		try{
			
			ListNumber = BSE.input.nextInt() - 1;
			
		}catch(Exception e) {
			
			System.out.println("\nInvalid Entry");
			
			return;
			
		}
			
		if(BSE.FullLists < ListNumber + 1 || ListNumber + 1 <= 0) {

			System.out.println("\nList not found"); 
			
			return;
			
		}
		
		System.out.println("\nList " + (ListNumber + 1) + "(In order from lowest to highest):");
		
		System.out.println("");

		ArrayList<Double> Output = new ArrayList<Double>();
		
		int ComparisonIndex = 0; //the index of the number that is being compared with the number below 
		
		int FocusIndex = 0; //the index of number being added to Output
		
		while (FocusIndex != BSE.list_bank[ListNumber].size()){ //while all the numbers have not been compared
			
			while (ComparisonIndex != Output.size()){ //stop when you try to get a number outside the list is outside list

				if((double)BSE.list_bank[ListNumber].get(FocusIndex) >= Output.get(ComparisonIndex)){ // if the number being added is greater than the number being compared, move up one
					
					ComparisonIndex++;
					
					continue;	
					
				}else{
					
					break;
					
				}
				
			}
		
			Output.add(ComparisonIndex, (double)BSE.list_bank[ListNumber].get(FocusIndex));
		
			FocusIndex++;
			
			ComparisonIndex = 0;
			
		}	
		
		System.out.println(Output);
		
		BSE.list_bank[ListNumber] = Output;
			
	}
	
	static void MaxMin(){
		
		if(BSE.FullLists == 0) {System.out.println("\nCreate a list first"); return;}
		
		System.out.println("\nList 1: " + BSE.list_1
				+"\n"	
				+"\nList 2: " + BSE.list_2
				+"\n"	
				+"\nList 3: " + BSE.list_3
				+"\n"	
				+"\nList 4: " + BSE.list_4
				+"\n"	
				+"\nList 5: " + BSE.list_5
		);
		
		System.out.println("\nWhich list would you like to find the Max and Min values for?");
		
		try {
			
			ListNumber = BSE.input.nextInt() - 1;
			
		}catch(Exception e){
			
			System.out.println("\nInvalid Entry");
			
			return;
		
		}
		

		if(BSE.FullLists < ListNumber + 1 || ListNumber + 1 <= 0) {
			
			System.out.println("\nList not found"); 
			
			return;
			
		}
		
		
		double Mi = (double) BSE.list_bank[ListNumber].get(0);
		
		for(double min : (ArrayList<Double>)BSE.list_bank[ListNumber]){if(min < Mi){Mi = min;}}
			
		double Ma = (double) BSE.list_bank[ListNumber].get(0);
		
		for (double max : (ArrayList<Double>)BSE.list_bank[ListNumber]) {if(max > Ma){Ma = max;}}
		
		System.out.println("\nMaximum: " + Ma);
		
		System.out.println("Minimum: " + Mi);
		
	}
	
	static void MMM() {
		
		if(BSE.FullLists == 0) {System.out.println("\nCreate a list first"); return;}
		
		System.out.println("\nList 1: " + BSE.list_1
				+"\n"	
				+"\nList 2: " + BSE.list_2
				+"\n"	
				+"\nList 3: " + BSE.list_3
				+"\n"	
				+"\nList 4: " + BSE.list_4
				+"\n"	
				+"\nList 5: " + BSE.list_5
		);
		
		//mean
		
		System.out.println("\nWhich list would you like to run calculations on?");
		
		try {
			
			ListNumber = BSE.input.nextInt() - 1;
			
		}catch(Exception e){
			
			System.out.println("\nInvalid Entry");
			
			return;
		
		}
		
		if(BSE.FullLists < ListNumber + 1 || ListNumber + 1 <= 0) {
			
			System.out.println("\nList not found"); 
			
			return;
			
		}
		
		double sum = 0;
		
		for(double item : (ArrayList<Double>)BSE.list_bank[ListNumber]){
			
			sum += item;
			
		}
		
		double Mean = sum/(BSE.list_bank[ListNumber].size());
		
		//median
		
		System.out.println("\nMean: " + Mean);
		
		ArrayList<Double> Output = new ArrayList<Double>();
		
		int ComparisonIndex = 0; 
		
		int FocusIndex = 0;
		
		while (FocusIndex != BSE.list_bank[ListNumber].size()){
			
			while (ComparisonIndex != Output.size()){ 

				if((double)BSE.list_bank[ListNumber].get(FocusIndex) >= Output.get(ComparisonIndex)){ 
					
					ComparisonIndex++;
					
					continue;	
					
				}else{
					
					break;
					
				}
				
			}
		
			Output.add(ComparisonIndex, (double)BSE.list_bank[ListNumber].get(FocusIndex));
		
			FocusIndex++;
			
			ComparisonIndex = 0;
			
		}
			
		double Median;
		
		if ((Output.size() % 2) == 0) {
			
			Median = ((Output.get(Output.size()/2) + Output.get((Output.size()/2) - 1))/2);
			
		}else {
			
			Median = Output.get((int)((Output.size()/2) + .5));
			
		}
		
		System.out.println("Median: " + Median);
		
		//mode
		
		int ModeCount = 1;
		
		int ValueCount = 0;
		
		ArrayList<Double> Mode = new ArrayList<Double>();
		
		for (double value: (ArrayList<Double>)BSE.list_bank[ListNumber]){
			
			for(double otherValues : (ArrayList<Double>)BSE.list_bank[ListNumber]) {
				
				if (value == otherValues) {
					
					ValueCount += 1;
				
				}
				
			}
			
			if (ValueCount > ModeCount) {
				
				Mode.clear();
				
				ModeCount = ValueCount;
				
			}
			
			if (ValueCount >= ModeCount) {
				
				if (!Mode.contains(value)) {
					
					Mode.add(value);
					
				}
						
			}
			
			ValueCount = 0;
			
		}
		
		System.out.println("Mode(s): " + Mode);
				
	}
	
	static void Spread() {
		
		if(BSE.FullLists == 0) {
			
			System.out.println("\nCreate a list first"); 
			
			return;
			
		}
		
		System.out.println("\nList 1: " + BSE.list_1
				+"\n"	
				+"\nList 2: " + BSE.list_2
				+"\n"	
				+"\nList 3: " + BSE.list_3
				+"\n"	
				+"\nList 4: " + BSE.list_4
				+"\n"	
				+"\nList 5: " + BSE.list_5
		);
		
		System.out.println("\nWhich list would you like to run calculations on?");
		
		try {
			
			ListNumber = BSE.input.nextInt() - 1;
			
		}catch(Exception e){
			
			System.out.println("\nInvalid Entry");
			
			return;
		
		}
		
		if(BSE.FullLists < ListNumber + 1 || ListNumber + 1 <= 0) {

			System.out.println("\nList not found"); 
			
			return;
			
		}

		
		//range
		
		double Mi = (double) BSE.list_bank[ListNumber].get(0);
		
		for(double min : (ArrayList<Double>)BSE.list_bank[ListNumber]){if(min < Mi){Mi = min;}}
			
		double Ma = (double) BSE.list_bank[ListNumber].get(0);
		
		for (double max : (ArrayList<Double>)BSE.list_bank[ListNumber]) {if(max > Ma){Ma = max;}}
		
		System.out.println("\nRange: " + (Ma - Mi));
		
		//standard deviation (and variance)
		double sum = 0;
		
		for(double item : (ArrayList<Double>)BSE.list_bank[ListNumber]){
			
			sum += item;
			
		}
		
		double Mean = sum/(BSE.list_bank[ListNumber].size());
		
		double Vari = 0;
		
		for(double value: (ArrayList<Double>)BSE.list_bank[ListNumber]){
			
			double TempSquare = value - Mean;
			
			Vari += Math.pow((TempSquare),2);
			
		}
		
		Vari /= BSE.list_bank[ListNumber].size();
		
		System.out.println("Standard Deviation: " + Math.sqrt(Vari));
		
		System.out.println("Variance: " + Vari);
			
	}
	
	static void Quartiles(){
		
		if(BSE.FullLists == 0) {
			
			System.out.println("\nCreate a list first"); 
			
			return;
			
		}
		
		System.out.println("\nList 1: " + BSE.list_1
				+"\n"	
				+"\nList 2: " + BSE.list_2
				+"\n"	
				+"\nList 3: " + BSE.list_3
				+"\n"	
				+"\nList 4: " + BSE.list_4
				+"\n"	
				+"\nList 5: " + BSE.list_5
		);
		
		double Q_One = 0;
		
		double Q_Three = 0;
		
		double Median;
		
		int Q_Sub_Odd = 0;
		
		MathContext mc = new MathContext(2, RoundingMode.DOWN);
		
		System.out.println("\nWhich list would you like to run calculations on?");
		
		try {
			
			ListNumber = BSE.input.nextInt() - 1;
			
			if(BSE.list_bank[ListNumber].size() < 4) {
				
				System.out.println("\nInvalid Entry: List must contain 4 or more values");
				
				return;
				
			}
			
		}catch(Exception e){
			
			System.out.println("\nInvalid Entry");
			
			return;
		
		}
		
		if(BSE.FullLists < ListNumber + 1 || ListNumber + 1 <= 0) {

			System.out.println("\nList not found"); 
			
			return;
			
		}


		ArrayList<Double> Output = new ArrayList<Double>();
		
		int ComparisonIndex = 0; //the index of the number that is being compared with the number below 
		
		int FocusIndex = 0; //the index of number being added to Output
		
		while (FocusIndex != BSE.list_bank[ListNumber].size()){ //while all the numbers have not been compared
			
			while (ComparisonIndex != Output.size()){ //stop when you try to get a number outside the list is outside list

				if((double)BSE.list_bank[ListNumber].get(FocusIndex) >= Output.get(ComparisonIndex)){ // if the number being added is greater than the number being compared, move up one
					
					ComparisonIndex++;
					
					continue;	
					
				}else{
					
					break;
					
				}
				
			}
		
			Output.add(ComparisonIndex, (double)BSE.list_bank[ListNumber].get(FocusIndex));
		
			FocusIndex++;
			
			ComparisonIndex = 0;
			
		}	
		
		if ((Output.size() % 2) == 0) {
			
			BigDecimal Q_Sub_Even = new BigDecimal(((Output.size() + 1)/4), mc);
			
			if((Output.size() % 4) == 0){
				
				Median = ((Output.get(Output.size()/2) + Output.get((Output.size()/2) - 1))/2);
				
				Q_One = (Output.get(Q_Sub_Even.intValue() - 1) + Output.get(Q_Sub_Even.intValue()))/2;
				
				Q_Three = ((Output.get((Output.size()) - Q_Sub_Even.intValue()) + (Output.get((Output.size()) - Q_Sub_Even.intValue() - 1)))/2);
				
			}else {
			
				Median = ((Output.get(Output.size()/2) + Output.get((Output.size()/2) - 1))/2);
				
				Q_One = Output.get(Q_Sub_Even.intValue());
				
				Q_Three = Output.get((Output.size()) - Q_Sub_Even.intValue());
			
			}
			
		}else {
			
			Q_Sub_Odd = ((Output.size() + 1)/4);
			
			Median = Output.get((int)((Output.size()/2) + .5));
			
			Q_One = (Output.get(Q_Sub_Odd - 1) + Output.get(Q_Sub_Odd))/2;
			
			Q_Three = ((Output.get((Output.size()) - Q_Sub_Odd) + (Output.get((Output.size()) - Q_Sub_Odd - 1)))/2);
			
		}
			
		System.out.println("\nQ_1: " + Q_One);
		
		System.out.println("Q_2 (Equal to Median): " + Median);
			
		System.out.println("Q_3: " + Q_Three);
			
		System.out.println("Interquartile Range: " + (Q_Three - Q_One));
	
	}
	
}