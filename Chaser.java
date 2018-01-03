
public class Chaser extends Player{
  //constuctor
  public Chaser(Field f, int side, String name, int number, String team,char symbol, double x, double y){
    super(f, side, name, number, team, symbol, x, y);
    this.speedX = Math.random()*MAX_SPEED-(MAX_SPEED/2);
    this.speedY = Math.random()*MAX_SPEED-(MAX_SPEED/2);
  }
  
  public void play(Field field){
    
    Entity target;

    if ( field.team1.contains(this)){
      if ( field.team2.size()==0){
        target = null;
      }
      else{
        target = field.team2.get(0);//makes shallow copy of the target
      }
    }
    else{
      if ( field.team1.size()==0){
        target = null;
      }
      else{
        target = field.team1.get(0);//makes shallow copy of the target
      }
    }
    if (target == null){
      this.speedX = 0;
      this.speedY = 0;
    }
    else{
    
      // direction needed to reach target
      double xVector = target.getX()- this.getX();
      
      double yVector = target.getY()-this.getY();
      
      if (xVector == 0){// dont need to move on x axix
        this.speedX = 0;// set speed X to 0
        if (yVector >= 0 ){// check Y vector is positve or negative
          this.speedY = MAX_SPEED;//positiver max speed
        }
        else{
          this.speedY = -MAX_SPEED;// negative max speed
        }
        if(this.getX()+speedX < (field.minX)|| this.getX()+speedX > (field.maxX-16)||this.getY()+speedY< (field.minY)|| this.getY()+speedY > (field.maxY-16)){
            this.speedX = 0;
            this.speedY = 0;
        }
      }
      else{
        if (Math.abs(xVector) < Math.abs(yVector)){// check which direction has bigger magnitute
          if (yVector >= 0 ){// check Y vector is positve or negative
            this.speedY = MAX_SPEED;//positiver max speed
          }
          else{
            this.speedY = -MAX_SPEED;// negative max speed
          }
          this.speedX = this.speedY / (yVector/ xVector);
          if(this.getX()+speedX < (field.minX)|| this.getX()+speedX > (field.maxX-16)||this.getY()+speedY< (field.minY)|| this.getY()+speedY > (field.maxY-16)){
            this.speedX = 0;
            this.speedY = 0;
          }
        }
        else if (Math.abs(xVector) > Math.abs(yVector)){
          if (xVector > 0 ){
            this.speedX = MAX_SPEED;
          }
          else{
            this.speedX = -MAX_SPEED;
          }
          this.speedY = this.speedX * (yVector/ xVector);
          if(this.getX()+speedX < (field.minX)|| this.getX()+speedX > (field.maxX-16)||this.getY()+speedY< (field.minY)|| this.getY()+speedY > (field.maxY-16)){
            this.speedX = 0;
            this.speedY = 0;
          }
        }
        else{// target
          if(this.getX()+speedX < (field.minX)|| this.getX()+speedX > (field.maxX-16)||this.getY()+speedY< (field.minY)|| this.getY()+speedY > (field.maxY-16)){
          this.speedX = 0;
          this.speedY = 0;
          }
          else{
          
          this.speedX = target.getSpeedX();
          this.speedY = target.getSpeedY();
          }
        }
       
      }
    }

      
 
  }
      
  public void update(Field field){}
 
}

