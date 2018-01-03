public abstract class Player extends Entity{
 
 
  /** this player's team name */
  protected String team;
  
  /** this player's name */
  protected String name;
  
  /** this player's number */
  protected int number;
  
  protected int status;//0 for normal, 1 on the way to jail, 2 in jail, 3 holding flag;
  
   
  /** gets this player's team name
    * 
    * @return the team name that this player is on
    */
  public final String getTeam(){ return this.team; }
  
  
  /** gets this player's name
    * 
    * @return the name of this player
    */
  public final String getName(){ return this.name; }

  /** gets this player's number
    * 
    * @return the number of this player
    */
  public final int getNumber(){ return this.number; }

  
  /** creates a player with specified symbol at specified position 
    * 
    * @param f is the field the player will be playing on
    * @param side is the side of the field the player will play on
    * @param name is this name of the player
    * @param number is this player's number 
    * @param team is this player's team name
    * @param symbol is a character (char) representation of this player
    * @param x is the x-coordinate of this player
    * @param y is the y-coordinate of this player
    */
  public Player(Field f, int side, String name, int number, String team, char symbol, double x, double y){
    super(symbol, x, y);
    this.name = name;
    this.number = number;
    this.team = team;
    this.status = 0;
    this.side = side;
    f.registerPlayer(this, this.id, side);  // register the player on the field
  }
  
  /** attempt to catch an opponent player
    * 
    * @param opponent a player on the opponent's team that you are trying to catch
    * @param field is the field the game is being played on
    * @return true if this player successfully catches the opponent player, false otherwise
    */
  public final boolean catchOpponent(Player opponent, Field field){
    return field.catchOpponent(this, opponent);
  }
  


  /** Informs this player that they have been caught by another player. 
    * <p>
    * This method should only be called from within the Field class.  
    * 
    * @param opponent is the player that caught this player  
    * @param id should be the id of the this player
    */
  public void beenCaught(Player opponent, int id){
    /* check if the caller knows this entity's id */
    if( this.id != id ){
      throw new SecurityException("Unauthorized attempt to call beenCaught ");
    }
    
  }
    
  /** attempt to free a teammate from jail
    * 
    * @param teammate is another player on this player's team
    * @param field is the field the game is being played on
    * @return true if the <code>teammate</code> is successfully freed from jail, false otherwise 
    */
  public final boolean freeTeammate(Player teammate, Field field){
    return field.freeTeammate(this, teammate);
  }
    
  /** Informs this player that they have been freed by a teammate 
    * <p>
    * This method should only be called from within the Field class.  
    * 
    * @param teammate is the player that caught this player  
    * @param id should be the id of the this player
    */
  public void hasBeenFreed(Player teammate, int id){
    /* check if the caller knows this entity's id */
    if( this.id != id){
      throw new SecurityException("Unauthorized attempt to call hasBeenFreed ");
    }
    
  }
  
  
  
  /** attempt to pick up the opponent's flag
    * 
    * @param field is the field the game is being played on
    * @return true if this player successfully picked up the opponent's flag, false otherwise 
    */
  public final boolean pickUpFlag(Field field){
    return field.pickUpFlag(this);
  }
  
  
  /** Informs this player that they have picked up the flag
    * <p>
    * This method should only be called from with the Field class.  
    * 
    * @param id should be the id of the this player
    */
  public void hasPickedUpFlag(int id){
    /* check if the caller knows this entity's id */
    if( this.id != id ){
      throw new SecurityException("Unauthorized attempt to call hasPickedUpFlag ");
    }
    
  }
  
  /** Informs this player that they have dropped the flag
    * <p>
    * This method should only be called from within the Field class.  
    * 
    * @param id should be the id of the this player
    */
  public void hasDroppedFlag(int id){
    /* check if the caller knows this entity's id */
    if( this.id != id ){
      throw new SecurityException("Unauthorized attempt to call hasDroppedFlag ");
    }
    
  }
  
  
  /** attempt to win the game
    * 
    * @param field is the field the game is being played on
    * @return true if this player successfully brings the opponent's flag back to this player's base, false otherwise 
    */
  public final boolean winGame(Field field){
    return field.winGame(this);
  } 
  
  public void status(Field f){
    if (this.side == 1){
      if(this.status == 0|| this.status == 3){
        for (Player e : f.getTeam2()){
          if (f.catchOpponent(e, this)==true){
            f.view.message(this.name + " from blue team is going to jail!");
            this.status = 1;
            f.team2JailedPlayers.add(this);
          }
        }
        if(this.status == 0){
          if(f.pickUpFlag(this)==true){
            this.status = 3;
            f.view.message(this.name + " from blue team has picked up the flag!");
          }
        }
      }
      if(this.status==1){
        if(Math.hypot(this.getX() - f.getJail2Position()[0], this.getY() - f.getJail2Position()[1]) <= f.ARMS_LENGTH){
       
          this.status = 2;
         
        }
      }
      if (this.status == 2){
        for (Player e : f.getTeam1()){
          if(f.freeTeammate(e, this)== true){
            this.status = 0;
            f.team2JailedPlayers.clear();
            f.view.message(this.name + " from blue team has been freed from jail");
          }
        }
      }
    }
    else{
      if(this.status == 0|| this.status == 3){
        for (Player e : f.getTeam1()){
          if (f.catchOpponent(e, this)==true){
            this.status = 1;
             f.team1JailedPlayers.add(this);
            f.view.message(this.name + " from red team is going to jail!");
          }
        }
        if(this.status == 0){
          if(f.pickUpFlag(this)==true){
            this.status = 3;
            f.view.message(this.name + " from red team has picked up the flag!");
          }
        }
      }
      if(this.status==1){
        if(Math.hypot(this.getX() - f.getJail1Position()[0], this.getY() - f.getJail1Position()[1]) <= f.ARMS_LENGTH){
       
          this.status = 2;
         
        }
        
      }
      if (this.status == 2){
        for (Player e : f.getTeam2()){
          if(f.freeTeammate(e, this)== true){
            this.status = 0;
            f.team1JailedPlayers.clear();
            f.view.message(this.name + " from red team has been freed from jail");
          }
        }
      }
      
      
    }
    if (this.status == 3){
        if(f.winGame(this)==true){
          f.GAME_IS_WON = true;
          f.view.message("Side " + this.side + "has won!" );
        }
        if(f.pickUpFlag(this)==false){
          this.status = 0;
        }
       
      
  }

    
  }
   
  
  
}