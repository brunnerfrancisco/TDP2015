package Principal;

import javax.swing.ImageIcon;

/**
 * Clase que modela los distintos enemigos que tiene el juego.
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public abstract class Enemigo extends ElementoEnCelda
{

	protected int velocidad;
	protected boolean modoDios;
	protected int posX;
	protected int posY;
	protected Terreno terreno;
	protected boolean estaVivo;
	protected Celda celdaAnterior;
	
	/**
	 * Constructor de la clase, crea una nueva instancia de la misma.
	 */
	public Enemigo()
	{
		
	}
	
	/**
	 * Método que devuelve la velocidad del enemigo.
	 * @return velocidad
	 */
	public int getVel()
	{
		return velocidad;
	}
	
	/**
	 * Método responsable del avance de los enemigos.
	 */
	public abstract void avanzar();

	public void setX(int x) {
		posX = x;
	}
	
	public void setY(int y) {
		posY = y;
	}

	public int getX() {
		return posX;
	}

	public int getY() {
		return posY;
	}

	public Celda getCelda() {
		return super.miCelda;
	}

	public boolean modoDios() {
		return modoDios;
	}
	
	public void avanzar(Enemigo e) {
	
	}
	
	public void avanzar(Bomberman b) {
		b.destruirse();
	}

	public boolean estaVivo() {
		return estaVivo;
	}
	
	public Celda getCeldaAnterior() {
		return celdaAnterior;
	}

	public void setCeldaAnterior(Celda c) {
		celdaAnterior = c;
		
	}
	
}
