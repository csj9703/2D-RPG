public class Battles{

private double playerHealth
private double enemyHealth


public Battles(double healthPlayerBefore, double healthEnemyBefore)
{
	playerHealth=healthPlayerBefore
	enemyHealth=healthEnemyBefore
}

public double playerAttack(double attackDamage)
{
	enemyHealth = enemyHealth - attackDamage
}
public double enemyAttack(double attackDamage)
{
	playerHealth = playerHealth - attackDamage
}
	