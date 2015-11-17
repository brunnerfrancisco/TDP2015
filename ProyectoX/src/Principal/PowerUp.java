package Principal;

public abstract class PowerUp extends ElementoEnCelda
{

	public abstract void avanzar(Bomberman b);
	
	public void avanzar (Enemigo e)
	{
//		Celda celdaAnterior = e.getCelda();// PUEDE SER QUE TENGAMOS Q MANEJAR LOS POSX POS Y COMO EN CELDA
//		e.setX(super.miCelda.getPosX());
//		e.setY(super.miCelda.getPosY());
//		e.setCelda(super.miCelda);
//		miCelda.agregarElementoACelda(e);
//		celdaAnterior.eliminarElementoEnCelda();
//		e.setCeldaAnterior(e);
	}
	
	public int destruirse()
	{
		return 0;
	}
}