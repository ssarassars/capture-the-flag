import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Team{
  public Field field;
  public int numPlayer;
  public Player[] player;
  public int side;// which side of the field is the team on, 1 for Left, 2 for Right
  public String teamName;
  
  
  //constructors
    // just a simple constructor with field and numplay create a team with empty array of size numplayer
  public Team(Field field, int side, int numPlayer){
    this.field = field;
    this.numPlayer = numPlayer;
    this.player = new Player[numPlayer];
    this.side = side;
  }
    // slightly more complex constructor
    // enter: field, number of each type of player in order of {!!!!!!!}
  public Team(Field field, int side, int numSeeker, int numCatcherSeeker, int numCatcherTerritory, int numJailBreaker, int numBaseDefender){
    this.field = field;
    this.numPlayer = numSeeker + numCatcherSeeker + numCatcherTerritory + numJailBreaker + numBaseDefender;
    this.player = new Player[numPlayer];
    this.side = side;
    String colour;
    char c;
    if(this.side == 1){
      colour = "blues";
      c = 'b';
    }
    else{
      colour = "reds";
      c = 'r';
    }
    // put the players in the array.
    Integer counter = 0;//counter to keep track of array
    for (int i = 0; i < numSeeker; i++){
      this.player[counter] = new Seeker(this.field, this.side, counter.toString(), counter, colour, c, Math.random()*400+this.field.minX+((this.side+1)% 2 * 300), Math.random()*500+field.minY);//recommend (field, side, name, number, team, x, y)
      counter++;
    }
    for (int i = 0; i < numCatcherSeeker; i++){
      this.player[counter] = new CatcherSeeker(this.field, this.side, counter.toString(), counter, colour, c, Math.random()*400+this.field.minX+((this.side+1)% 2 * 300), Math.random()*500+field.minY);//recommend (field, side, name, number, team, x, y)
      counter++;
    }
    for (int i = 0; i < numCatcherTerritory; i++){
      this.player[counter] = new CatcherTerritory(this.field, this.side, counter.toString(), counter, colour, c, Math.random()*400+this.field.minX+((this.side+1)% 2 * 300), Math.random()*500+field.minY);//recommend (field, side, name, number, team, x, y)
      counter++;
    }
    for (int i = 0; i < numJailBreaker; i++){
      this.player[counter] = new JailBreaker(this.field, this.side, counter.toString(), counter, colour, c, Math.random()*400+this.field.minX+((this.side+1)% 2 * 300), Math.random()*500+field.minY);//recommend (field, side, name, number, team, x, y)
      counter++;
    }
   for (int i = 0; i < numBaseDefender; i++){
      this.player[counter] = new BaseDefender(this.field, this.side, counter.toString(), counter, colour, c, Math.random()*400+this.field.minX+((this.side+1)% 2 * 300), Math.random()*500+field.minY);//recommend (field, side, name, number, team, x, y)
      counter++;
  }
  }
  public Team(Field field, int side, String fileName){
    File infile;
    Scanner in;
    
    this.field = field;
    String colour;
    char c;
    if(this.side == 1){
      colour = "blues";
      c = 'b';
    }
    else{
      colour = "reds";
      c = 'r';
    }
    int counter = 0;
    try{
      infile = new File(fileName);
      in = new Scanner(infile);
      in.nextLine();
      in.nextLine();
      
      this.teamName = in.nextLine().trim();
      this.numPlayer = in.nextInt();
  
      while (in.hasNext()){
        String name = in.next();
        int number = in.nextInt();
        String className = in.next();
        if (className == "Seeker"){
          this.player[counter] = new Seeker(this.field, this.side, name, number, colour, c, Math.random()*400+this.field.minX+((this.side+1)% 2 * 400), Math.random()*500+field.minY);//recommend (field, side, name, number, team, x, y)
          counter++;
        }
        if (className == "CatcherSeeker"){
          this.player[counter] = new CatcherSeeker(this.field, this.side, name, number, colour, c, Math.random()*400+this.field.minX+((this.side+1)% 2 * 400), Math.random()*500+field.minY);//recommend (field, side, name, number, team, x, y)
          counter++;
        }
        if (className == "CatcherTerritory"){
          this.player[counter] = new CatcherTerritory(this.field, this.side, name, number, colour, c, Math.random()*400+this.field.minX+((this.side+1)% 2 * 400), Math.random()*500+field.minY);//recommend (field, side, name, number, team, x, y)
          counter++;
        }
        if (className == "JailBreaker"){
          this.player[counter] = new JailBreaker(this.field, this.side, name, number, colour, c, Math.random()*400+this.field.minX+((this.side+1)% 2 * 400), Math.random()*500+field.minY);//recommend (field, side, name, number, team, x, y)
          counter++;
        }
        if (className == "BaseDefender"){
          this.player[counter] = new BaseDefender(this.field, this.side, name, number, colour, c, Math.random()*400+this.field.minX+((this.side+1)% 2 * 400), Math.random()*500+field.minY);//recommend (field, side, name, number, team, x, y)
          counter++;
        }
        
        //copy paste above for new type of player;
      }
    }catch(FileNotFoundException e){
      System.err.println("File " + fileName + " was not found");
      System.err.println("Exception thrown : " + e);      
    }
 }
  //setters
  public void setTeamName(String teamName){
    this.teamName = teamName;
  }
  //getters
  public int getSide(){
    return this.side;
  }
  public int getSize(){
    return this.numPlayer;
  }
  public Player[] getTeam(){
    return this.player;
  }
}
