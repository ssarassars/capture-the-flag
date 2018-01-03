


public class Flag extends Entity{
  public int status;
  
  /* flag does not have any logic yet */
  public void status(Field f){
    this.status = 0;
    if (this.side == 1){
      for(Player e : f.getTeam2()){
        if(e.status == 3){
          this.status = 3;
        }
      }
    }
    else{
      for(Player e : f.getTeam1()){
        if(e.status == 3){
          this.status = 3;
          
        }
      }
    }
  }
  @Override
  public void play(Field f){
    if (this.status == 0){
      this.speedX = this.speedY = 0;
    }
    if (this.status ==3){
      if (this.side == 1){
        this.move(f, f.getBase2Position()[0], f.getBase2Position()[1],1);
      }
      else{
        this.move(f, f.getBase1Position()[0], f.getBase1Position()[1],1);
      }
    }
  }
  
  /* flag does not move yet */
  @Override
  public void update(Field f){
    if (this.status == 0){
      if(this.side == 1){
        if(this.getX() > (f.maxX-f.minX)/2){
          this.x = 34+f.minX;
          this.y = 191+f.minY;
        }
      }
      else{
        if(this.getX() < (f.maxX -f.minX)/2){
          this.x = 754+f.minX;
          this.y = 391+f.minY;
        }
      }
    }
  }
  



  @Override
  public boolean equals(Object o){
    if(this == o){return true;}

    if(o == null){ 
      System.err.println("null equals");
      return false;  
    }

    /* flags are the same if they have the same symbol */
    if(o instanceof Flag && this.getSymbol() == ((Flag)o).getSymbol()){
      return true;
    }
    
    return false;
  }


  public Flag(char symbol,  int x, int y){
    super(symbol, x, y);
    this.speedX = this.speedY = 0;
    this.status =0;
  }

  public Flag(Field f, int side, char symbol, int x, int y, String ref){
    super(f, side, symbol, x, y, ref);
    this.speedX = this.speedY = 0;
    this.status = 0;
  }
  
}