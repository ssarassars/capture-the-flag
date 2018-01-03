public class RandomWalker extends Player{
  //constuctor
  public RandomWalker(Field f, int side, String name, int number, String team,char symbol, double x, double y){
    super(f, side, name, number, team, symbol, x, y);
    this.speedX =Math.random()*MAX_SPEED-(MAX_SPEED/2);
    this.speedY =Math.random()*MAX_SPEED-(MAX_SPEED/2);
  }
  
  public void play(Field field){
   if(this.getX() +speedX< field.minX){
      this.x = field.minX;
      this.speedX = -this.speedX;
    }
    if (this.getX() +speedX> field.maxX-16){
      this.x = field.maxX-16;
      this.speedX = -this.speedX;
    }
    if (this.getY() +speedY< field.minY){
      this.y = field.minY;
      this.speedY = -this.speedY;
    }
    if(this.getY() +speedY> field.maxY-16){
      this.y = field.maxY-16;
      this.speedY = -this.speedY;
    }
  }
  public void update(Field field){}
}