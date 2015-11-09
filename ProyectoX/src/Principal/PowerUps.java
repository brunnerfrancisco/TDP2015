package Principal;

public abstract class PowerUps extends ElementoEnCelda
{

	public abstract void avanzar(Bomberman b);
	
	public void avanzar (Enemigo e)
	{
		
	}
	
	public int destruirse()
	{
		return 0;
	}
}