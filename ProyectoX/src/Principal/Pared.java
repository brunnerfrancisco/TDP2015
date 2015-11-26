package Principal;
/**
 * 
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public abstract class Pared extends ElementoEnCelda {
	protected Celda miCelda;
	
	/**
	 * Obtiene la celda donde esta el elemento
	 * @return miCelda
	 */
	public Celda getCelda()
	{
		return miCelda;
	}
}
