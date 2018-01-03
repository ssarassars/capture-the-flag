import java.util.ArrayList;

public class BaseDefender extends Player {
  
  public BaseDefender(Field f, int side, String name, int number, String team, char symbol, double x, double y) {
  super(f, side, name, number, team, symbol, x, y);
 
  this.speedX = Math.random() * 4 - 2;
  this.speedY = Math.random() * 4 - 2;
 }
  
  @Override
 public void play(Field field) {
    
   ArrayList<Player> b;

    int[] basePositionOwn;    
    int[] flagPositionOwn; 
    
      if( field.getTeam1().contains(this)){
        b = field.getTeam2();
       basePositionOwn = field.getBase1Position();
       flagPositionOwn = field.getFlag1Position();
      } else {
        b = field.getTeam1();
       basePositionOwn = field.getBase2Position();
       flagPositionOwn = field.getFlag2Position(); 
      }
      int xBasePositionOwn = basePositionOwn[0];
      int yBasePositionOwn = basePositionOwn[1];
      int xFlagPositionOwn = flagPositionOwn[0];
      int yFlagPositionOwn = flagPositionOwn[1];
      

        if (this.side == 1){
     
      if (this.status == 0){
        for (int i = 0; i < b.size(); i++){
          Player currentPlayer = (Player) b.get(i);
          if((Math.hypot( currentPlayer.getX() - xFlagPositionOwn, currentPlayer.getY() - yFlagPositionOwn ) <= 30)){
            this.move(field, currentPlayer.getX(), currentPlayer.getY(), 1);
        }else {
         this.move(field, xFlagPositionOwn + 16, yFlagPositionOwn + 30, 0.5);
        }
        }
  } 
        
  
      if(this.status == 1){
        this.move(field,field.getJail2Position()[0],field.getJail2Position()[1], 1);
      }
      if(this.status == 2){
        this.speedX = 0;
        this.speedY = 0;
      }
      if (this.status == 3){
        this.move(field,field.getBase1Position()[0],field.getBase1Position()[1], 1);
      }
    }
    else{
      if (this.status == 0){
        for (int i = 0; i < b.size(); i++){
          Player currentPlayer = (Player) b.get(i);
          if((Math.hypot( currentPlayer.getX() - xFlagPositionOwn, currentPlayer.getY() - yFlagPositionOwn ) <= 30)){
            this.move(field, currentPlayer.getX(), currentPlayer.getY(), 1);
        }else {
         this.move(field, xFlagPositionOwn + 16, yFlagPositionOwn + 30, 0.5);
        }
        }
  } 
      
      if(this.status == 1){
        this.move(field,field.getJail1Position()[0],field.getJail1Position()[1], 1);
      }
      if(this.status == 2){
        this.speedX = 0;
        this.speedY = 0;
      }
      if (this.status == 3){
        this.move(field,field.getBase2Position()[0],field.getBase2Position()[1], 1);
      }
    }
     }
  
  
  
   @Override
 public void update(Field field) {

}
}