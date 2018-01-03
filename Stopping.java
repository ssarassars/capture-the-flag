//Xiaopei Huang Assignemnt 5 Stopping
//Making a player that stops at the edge of field

public class Stopping extends Player{
  //constuctor
  public Stopping(Field f, int side, String name, int number, String team,char symbol, double x, double y){
    super(f, side, name, number, team, symbol, x, y);
    this.speedX = Math.random()*MAX_SPEED-(MAX_SPEED/2);
    this.speedY = Math.random()*MAX_SPEED-(MAX_SPEED/2);
  }
  
  public void play(Field field){
    if(this.getX()+speedX < (field.minX)|| this.getX()+speedX > (field.maxX-16)||this.getY()+speedY< (field.minY)|| this.getY()+speedY > (field.maxY-16)){
      
 
      if(this.getX() +speedX< field.minX){
        this.x = field.minX;
      }
      if (this.getX() +speedX> field.maxX-16){
        this.x = field.maxX-16;
      }
      if (this.getY() +speedY< field.minY){
        this.y = field.minY;
      }
      if(this.getY() +speedY> field.maxY-16){
        this.y = field.maxY-16;
      }
      this.speedX = 0;
      this.speedY = 0;
      
    }
    
    
  }
  public void update(Field field){}
}