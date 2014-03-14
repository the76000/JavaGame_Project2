import java.util.Scanner;


public class JavaGame {
//Global variables
	public static int currentLocale = 0;
	public static int dir = -1;
	public static int totalScore = 0;
	public static int score[] = new int[8];  
	public static Item inventory[];
    public static int[][] nav;
    public static Locale[] locations;
	public static String command; 
	public static boolean stillPlaying = true;
	public static int moveCounter = 0;
	Item item0;
	Item item1;
	Item item2;
	Item item3;
	Item item4;
	Item item5;
	

	public static void main(String args[]){
	//locations
		for(int i=1; i<8; i++){
			score[i]=5;
		}
		Item item0 = new Item(0);
        item0.setName("Map");
        item0.setDesc("This is a map.");
        
        Item item1 = new Item(1);
        item1.setName("Message in a Bottle");
        item1.setDesc("It reads: 'Save me! I'm trapped in the castle!");
        
        Item item2 = new Item(2);
        item2.setName("Water Bottle");
        item2.setDesc("It's a bottle full of water");
        
        Item item3 = new Item(3);
        item3.setName("Princess' Kiss");
        item3.setDesc("It's so sweet.");
        
        Item item4 = new Item(4);
        item4.setName("Magic Sword");
        item4.setDesc("It can slay dragons.");
        
        Item item5 = new Item(5);
        item5.setName("Magic Shield");
        item5.setDesc("It can block fire.");
        
        inventory = new Item[6];
		inventory[0] = item0; 
	    inventory[1] = item1;
		inventory[2] = item2;
		inventory[3] = item3;
		inventory[4] = item4;
		inventory[5] = item5;
		
		Locale loc0 = new Locale(0);
        loc0.setName("Town");
        loc0.setDesc("This is your home town.");
       
        Locale loc1 = new Locale(1);
        loc1.setName("Magick Shoppe");
        loc1.setDesc("There is a Magic Sword and Shield.");
        
        Locale loc2 = new Locale(2);
        loc2.setName("Ocean");
        loc2.setDesc("There is a message in a bottle.");
        
        Locale loc3 = new Locale(3);
        loc3.setName("Field");
        loc3.setDesc("The grass here is nice and soft.");
        
        EarthsCore loc4 = new EarthsCore(4);
        loc4.setName("Desert");
        loc4.setDesc("It is hot. What did you expect?");
        loc4.setDistance(3);
        
        Locale loc5 = new Locale(5);
        loc5.setName("Plains");
        loc5.setDesc("This is a lot of grass.");
        
        EarthsCore loc6 = new EarthsCore(6);
        loc6.setName("Glacier");
        loc6.setDesc("It is cold. What did you expect?");
        loc6.setDistance(-3);
        
        Locale loc7 = new Locale(7);
        loc7.setName("Castle");
        loc7.setDesc("There is nothing to do here yet.");
        
        		
				locations = new Locale[8];
				locations[0] = loc0; 
				locations[1] = loc1;
				locations[2] = loc2;
				locations[3] = loc3;
				locations[4] = loc4;
				locations[5] = loc5;
				locations[6] = loc6;
				locations[7] = loc7;
			
			//2d navigation array
				nav = new int[][] {
							  // n  s  e  w
			/*Town 0*/	     	{1,-1,-1,-1}, 
			/*market 1*/		{-1,0, 3, 2},
			/*ocean 2*/		    {-1,-1,1,-1},
			/*field 3*/			{4,-1,-1, 1},
			/*desert 4*/		{6, 3,-1, 5},
			/*plains 5*/		{7,-1, 4,-1},
			/*glacier 6*/		{-1,4,-1, 7},
			/*castle 7*/		{-1,5, 6,-1},
				};
				
	
		updateDisplay();
		
		while(stillPlaying){
		getCommand();
		updateDisplay();
		}
		
		
	
		
	}
	
	public static void updateDisplay() {
		   System.out.println(locations[currentLocale].getName() + ": " + locations[currentLocale].getDesc()); //location name and description
		   System.out.println("Number of moves: " + moveCounter + ", " + "Score: " + totalScore);  //number of moves and score
		   if (currentLocale == 4){
			   System.out.println(((EarthsCore) locations[currentLocale]).getDistance() + " feet from the Earth's Core. No wonder it's so hot.");
		   } else if (currentLocale == 6){
			   System.out.println(((EarthsCore) locations[currentLocale]).getDistance() + " feet from the Earth's Core. No wonder it's so cold.");
		   }
		   if (totalScore != 0 && moveCounter != 0){
		   System.out.println("Acheivement Ratio " + moveCounter/totalScore);     //Achievement ratio
		   }
		   //which directions you can go
		   if (currentLocale == 0){
			   System.out.println("You can go north");
		   }
		   if (currentLocale == 1){
			   System.out.println("You can go west, east, south");
		   }
		   if (currentLocale == 2){
			   System.out.println("You can go east");
		   }
		   if (currentLocale == 3){
			   System.out.println("You can go west, north");
		   }
		   if (currentLocale == 4){
			   System.out.println("You can go west, north, south");
		   }
		   if (currentLocale == 5){
			   System.out.println("You can go north, east");
		   }
		   if (currentLocale == 6){
			   System.out.println("You can go west, south");
		   }
		   if (currentLocale == 7){
			   System.out.println("You can go south, east ");
		   }
	 }
	
	public static void getCommand() {
	     @SuppressWarnings("resource")
		Scanner inputReader = new Scanner(System.in);
	      command = inputReader.nextLine();  // command is global.
	      setDir();
	   }
	
	public static void setDir() {
		
	
        
        
	 if (command.equalsIgnoreCase("north") || command.equalsIgnoreCase("n") ) {
         dir = 0;
         moveCounter = moveCounter + 1;
         move();
     
	
	 } else if ( command.equalsIgnoreCase("south") || command.equalsIgnoreCase("s") ) {
         dir = 1;
         moveCounter = moveCounter + 1;
         move();
     
	 
	 } else if ( command.equalsIgnoreCase("east")  || command.equalsIgnoreCase("e") ) {
         dir = 2;
         moveCounter = moveCounter + 1;
         move();
     
	 
	 } else if ( command.equalsIgnoreCase("west")  || command.equalsIgnoreCase("w") ) {
         dir = 3;
         moveCounter = moveCounter + 1;
         move(); 
	
	 
	 } else if ( command.equalsIgnoreCase("quit")  || command.equalsIgnoreCase("q") ) {
         System.out.println("You quit loser.");
         stillPlaying = false;
     
	
	 } else if ( command.equalsIgnoreCase("help") || command.equalsIgnoreCase("h")){
    	  System.out.println("You can type north, south, east, west, quit, inventory, map, take, laser, kick, uninstall, fight.");
     
	
	 } else if ( command.equalsIgnoreCase("map")  || command.equalsIgnoreCase("m")) {
    	  if (inventory[0].gethasItem() == true){
		  System.out.println("           ------      ------");
    	  System.out.println("           |    |      |    |");
    	  System.out.println("           |7   |------|6   |");
    	  System.out.println("           |    |      |    |");
    	  System.out.println("           ------      ------");
    	  System.out.println("             |           |   ");
    	  System.out.println("             |           |   ");
    	  System.out.println("           ------      ------");
    	  System.out.println("           |    |      |    |");
    	  System.out.println("           |5   |------|4   |");
    	  System.out.println("           |    |      |    |");
    	  System.out.println("           ------      ------");
    	  System.out.println("                         |   ");
    	  System.out.println("                         |   ");
    	  System.out.println("------     ------      ------");
    	  System.out.println("|    |     |    |      |    |");
    	  System.out.println("|2   |-----|1   |------|3   |");
    	  System.out.println("|    |     |    |      |    |");
    	  System.out.println("------     ------      ------");
    	  System.out.println("             |               ");
    	  System.out.println("             |               ");
    	  System.out.println("           ------            ");
    	  System.out.println("           |    |            ");
    	  System.out.println("           |0   |            ");
    	  System.out.println("           |    |            ");
    	  System.out.println("           ------");
    	  System.out.println("You are at " + currentLocale);
    	  }
	 
	 
	 } else if ( command.equalsIgnoreCase("kick") || command.equalsIgnoreCase("k")){
    	 System.out.println("You're trying to throw kicks again? It's the same result; you hurt youself genius.");
     
	 
	 } else if ( command.equalsIgnoreCase("uninstall") || command.equalsIgnoreCase("u")){
		 System.out.println("That's not in this game, I've done enough sucking up.");
		 
	 
	 } else if ( command.equalsIgnoreCase("take") || command.equalsIgnoreCase("t")){
		 if (currentLocale == 0 && inventory[0].gethasItem() == false){
			inventory[0].sethasItem(true);
		 }
		 if (currentLocale == 1 && inventory[4].gethasItem() == false && inventory[5].gethasItem() == false){
				inventory[4].sethasItem(true);
				inventory[5].sethasItem(true);
				locations[1].setDesc("You bought everything already.");
		 }
		 if (currentLocale == 2 && inventory[2].gethasItem() == false){
				inventory[2].sethasItem(true);
		 }
	 
	
	 } else if ( command.equalsIgnoreCase("inventory") || command.equalsIgnoreCase("i")){
		 if (inventory[0].gethasItem() == true){
			 System.out.println(inventory[0].getName() + ": " + inventory[0].getDesc());
		 }
		 if (inventory[1].gethasItem() == true){
			 System.out.println(inventory[1].getName() + ": " + inventory[1].getDesc());
		 }
		 if (inventory[2].gethasItem() == true){
			 System.out.println(inventory[2].getName() + ": " + inventory[2].getDesc());
		 }
		 if (inventory[3].gethasItem() == true){
			 System.out.println(inventory[3].getName() + ": " + inventory[3].getDesc());
		 }
		 if (inventory[4].gethasItem() == true){
			 System.out.println(inventory[4].getName() + ": " + inventory[4].getDesc());
		 }
		 if (inventory[5].gethasItem() == true){
			 System.out.println(inventory[5].getName() + ": " + inventory[5].getDesc());
		 }
	 
	 
	 } else if ( command.equalsIgnoreCase("fight") || command.equalsIgnoreCase("f")){
		 	if ( currentLocale == 7 && inventory[4].gethasItem() == false){
		 		System.out.println("You lose!! Why would you do that?");
		 		stillPlaying = false;
		 	} else if (currentLocale == 7 && inventory[4].gethasItem() == true){
		 		System.out.println("You win!! You saved the princess!");
		 		stillPlaying = false;
		 		inventory[3].sethasItem(true);
		 	} else if (inventory[4].gethasItem() == true && currentLocale != 7){
		 		System.out.println("There's nothing to fight.");
		 	} else if (inventory[4].gethasItem() == false){
		 		System.out.println("You have nothing to fight with.");
		 	}
		 
	 
	 } else if ( command.equalsIgnoreCase("laser") || command.equalsIgnoreCase("l")){
		 	if (currentLocale == 7){
		 		System.out.println("The dragon is impervious to lasers!");
		 	} else {
		 		System.out.println("You fired lasers out of your eyes.");	
		 	} 
	 }
		  
	 
	}
    public static void move(){  
      if (nav[currentLocale][dir] >= 0 && nav[currentLocale][dir] <= 7){
    	  currentLocale = nav[currentLocale][dir];
    	  totalScore+=score[currentLocale];
    	  score[currentLocale]=0;
      } else if (nav[currentLocale][dir] == -1) {
    	  System.out.println("You cannot go that way");
      }
	}
	
}