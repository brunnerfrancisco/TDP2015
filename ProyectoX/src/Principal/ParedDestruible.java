package Principal;

import javax.swing.ImageIcon;

public class ParedDestruible extends Pared 
{
	/**
	 * Constructor de la clase, crea una nueva instancia de la misma.
	 * @param c
	 */
	public ParedDestruible(Celda c)
	{
		this.miCelda = c;
	}
	
	/**
	 * 
	 */
	public int destruirse()
	{
		super.miCelda.eliminarElementoEnCelda();
		return 10;
	}
	
	/**
	 * Metodo responsable de avanzar a un bomberman en caso de que el bomerman este en modo Dios
	 * @param b
	 */
	public void avanzar(Bomberman b) {
		if (b.modoDios())
		{
			Celda celdaAnterior = b.getCelda(); // PUEDE SER QUE TENGAMOS Q MANEJAR LOS POSX POS Y COMO EN CELDA
			b.setX(super.miCelda.getPosX());
			b.setY(super.miCelda.getPosY());
			b.setCelda(super.miCelda);
			miCelda.agregarElementoACelda(b);
			celdaAnterior.eliminarElementoEnCelda();
			//	Falta actualizar la grafica
		}
	}
	@Override
	public void avanzar(Enemigo e) {
		if (e.modoDios())
		{	Celda celdaAnterior = e.getCelda();// PUEDE SER QUE TENGAMOS Q MANEJAR LOS POSX POS Y COMO EN CELDA
		
			e.setX(super.miCelda.getPosX());
			e.setY(super.miCelda.getPosY());
			e.setCelda(super.miCelda);
			miCelda.agregarElementoACelda(e);
			celdaAnterior.eliminarElementoEnCelda();
			//	Falta actualizar la grafica
		}
	}
	
}
