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
	public void destruirse()
	{
		
	}
	
	/**
	 * Metodo responsable de avanzar a un bomberman en caso de que el bomerman este en modo Dios
	 * @param b
	 */
	public void avanzar(Bomberman b) {
		if (b.modoDios)
		{
			b.setX(this.getCelda().getPosX());
			b.setY(this.getCelda().getPosY());
			//	muevo en la grafica 1*32 para arriba
		}
	}
	@Override
	public void avanzar(Enemigo e) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * Retorna la imagen de la pared
	 * @return
	 */
	public ImageIcon getImagen() {
		// TODO Auto-generated method stub
		return null;
	}
}
