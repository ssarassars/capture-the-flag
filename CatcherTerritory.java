import java.util.ArrayList;

public class CatcherTerritory extends Player {

 public CatcherTerritory(Field f, int side, String name, int number, String team, char symbol, double x, double y) {
  super(f, side, name, number, team, symbol, x, y);
  // TODO Auto-generated constructor stub
  this.speedX = Math.random() * 4 - 2;
  this.speedY = Math.random() * 4 - 2;
 }


 @Override
 public void play(Field field) {
  // TODO Auto-generated method stub
  ArrayList<Player> b;
  int[] jailPosition;
  int[] basePosition;
  ArrayList<Entity> jailedPlayers;
  
  if (field.getTeam1().contains(this)) {
   b = field.getTeam2();
   jailPosition = field.getJail1Position();
   basePosition = field.getBase1Position();
   jailedPlayers = field.getTeam1JailedPlayers();
  } else {
   b = field.getTeam1();
   jailPosition = field.getJail2Position();
   basePosition = field.getBase2Position();
   jailedPlayers = field.getTeam2JailedPlayers();

  }

//
//  if (!this.isEntityInTerritory(field)) {
//   //this.move(basePosition[0], basePosition[1]);
//  } 
//  
//  else if (chased != null) {
//    this.move(chased.getX() ,chased.getY());
//
//  } 

  if (this.side == 1){
     
      if (this.status == 0){
        Player chased = null;

        for (int i = 0; i < b.size(); i++) {
          Player currentPlayer = (Player) b.get(i);
          if (!jailedPlayers.contains(b.get(i))) {
            chased = currentPlayer;
            break;
    //System.out.println("player has been caught");
   }
  }
         if (this.isEntityInTerritory(field)){
           this.speedX *= -1;
           this.speedY *= -1;
         }else if (chased != null) {
             this.move(field, chased.getX() ,chased.getY(), 1);  
           } else {
             this.moveRandomlyWithinTerritory(field);
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
        if (this.status == 0){
        Player chased = null;

        for (int i = 0; i < b.size(); i++) {
          Player currentPlayer = (Player) b.get(i);
          if (!jailedPlayers.contains(b.get(i))) {
            chased = currentPlayer;
            break;
    //System.out.println("player has been caught");
   }
  }
         if (this.isEntityInTerritory(field)){
           this.speedX *= -1;
           this.speedY *= -1;
         }else if (chased != null) {
             this.move(field, chased.getX() ,chased.getY(), 1);  
           } else {
             this.moveRandomlyWithinTerritory(field);
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
  // TODO Auto-generated method stub

 }

}
