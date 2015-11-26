package Principal;

/**
 * 
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public abstract class PowerUp extends ElementoEnCelda
{

	public abstract void avanzar(Bomberman b);
	
	/**
	 * Avanza a un enemigo, a la celda donde esta el power up, sin afectarlo
	 */
	public void avanzar (Enemigo e)
	{
		Celda celdaAnterior = e.getCelda();
		e.setX(super.miCelda.getPosX());
		e.setY(super.miCelda.getPosY());
		e.setCelda(super.miCelda);
		miCelda.agregarElementoACelda(e);
		celdaAnterior.eliminarElementoEnCelda();
		e.setCeldaAnterior(celdaAnterior);
	}
	
	public int destruirse()	{	return 0; }
}