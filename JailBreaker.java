import java.util.ArrayList;

public class JailBreaker extends Player {

 public JailBreaker(Field f, int side, String name, int number, String team, char symbol, double x, double y) {
  super(f, side, name, number, team, symbol, x, y);

  this.speedX = Math.random() * 4 - 2;
  this.speedY = Math.random() * 4 - 2;
 }

 @Override
 public void play(Field field) {
  ArrayList<Entity> b;

  if (field.getTeam1().contains(this)) {
   b = field.getTeam2JailedPlayers();
  } else {
   b = field.getTeam1JailedPlayers();
  }

  
 if (this.side == 1){
     
      if (this.status == 0){
        if (b.size() >0) {
            this.move(field, field.getJail2Position()[0],field.getJail2Position()[1], 1);
          }else if (this.isEntityInTerritory(field)) {
          this.moveRandomlyWithinTerritory(field);
        }else {
          this.move(field, field.getBase1Position()[0], field.getBase1Position()[1], 1);
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
        if (b.size() >0) {
            this.move(field, field.getJail1Position()[0],field.getJail1Position()[1], 1);
          }else if (!this.isEntityInTerritory(field)) {
          this.moveRandomlyWithinTerritory(field);
        }else {
          this.move(field, field.getBase2Position()[0], field.getBase2Position()[1], 1);
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