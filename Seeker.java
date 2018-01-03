
public class Seeker extends Player {

 public Seeker(Field f, int side, String name, int number, String team, char symbol, double x, double y) {
  super(f, side, name, number, team, symbol, x, y);
  // TODO Auto-generated constructor stub
  this.speedX = Math.random() * 4 - 2;
  this.speedY = Math.random() * 4 - 2;
 }

 @Override
 public void play(Field field) {
   if (this.side == 1){
     
      if (this.status == 0){
        this.move(field, field.getFlag2Position()[0],field.getFlag2Position()[1], 1);

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
        
        this.move(field,field.getFlag1Position()[0],field.getFlag1Position()[1], 1);
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
        if(field.winGame(this) == true){
          field.GAME_IS_WON = true;
      }
    }
  }
 }
  
 

 @Override
 public void update(Field field) {
  // TODO Auto-generated method stub

 }
 }


