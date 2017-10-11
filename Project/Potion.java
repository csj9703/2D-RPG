public class Potion
{
  int hpRestore = 2;
  //Player player = new Player();
  public void restoreTwo(Player player)
  {
    int health = player.getHealth();
    health += hpRestore;
    player.setHealth(health);
  }
}
