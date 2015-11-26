package Principal;

import javax.swing.ImageIcon;
/**
 * 
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public class ParedDestruible extends Pared 
{
	/**
	 * Constructor de la clase, crea una nueva instancia de la misma.
	 * @param c
	 */
	public ParedDestruible(Celda c)
	{
		this.miCelda = c;
		imagen = new ImageIcon(getClass().getResource("/images/paredDestruible.jpg"));
	}
	
	/**
	 * Quita la pared de la celda.
	 * return 10
	 */
	public int destruirse()
	{
		super.miCelda.eliminarElementoEnCelda();
		return 10;
	}
	
	/**
	 * avanza a un bomberman en caso de que el bomerman este en modo Dios
	 * @param b
	 */
	public void avanzar(Bomberman b) {
		if (b.modoDios())
		{
			Celda celdaAnterior = b.getCelda(); // PUEDE SER QUE TENGAMOS Q MANEJAR LOS POSX POS Y COMO EN CELDA
			b.setX(super.miCelda.getPosX());
			b.setY(super.miCelda.getPosY());
			b.setCelda(super.miCelda);
			b.setCeldaAnterior(celdaAnterior);
			miCelda.agregarElementoACelda(b);
			celdaAnterior.eliminarElementoEnCelda();
		}
	}

	/**
	 * avanza a un enemigo en caso de que sea Sirius
	 * @param e
	 */
	public void avanzar(Enemigo e) {
		if (e.modoDios())
		{	Celda celdaAnterior = e.getCelda();// PUEDE SER QUE TENGAMOS Q MANEJAR LOS POSX POS Y COMO EN CELDA
		
			e.setX(super.miCelda.getPosX());
			e.setY(super.miCelda.getPosY());
			e.setCelda(super.miCelda);
			e.setCeldaAnterior(celdaAnterior);
			miCelda.agregarElementoACelda(e);
			celdaAnterior.eliminarElementoEnCelda();
		}
	}
	
	
	
}
