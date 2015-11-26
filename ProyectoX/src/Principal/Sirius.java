package Principal;

import java.util.Random;

import javax.swing.ImageIcon;
/**
 * 
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public class Sirius extends Enemigo {
	
	protected Bomberman jugador;
	public Sirius(Terreno t,  Bomberman b)
	{
		terreno = t;
		imagen = new ImageIcon(getClass().getResource("/images/sirius.jpg"));
		modoDios = false;
		estaVivo = true;
		jugador = b;
	}
	
	/**
	 * Decide donde avanza sirius persiguiendo a bomberman.
	 */
	public void avanzar() {
		 Random  rnd = new Random();
		 int direccion = rnd.nextInt(2);
		 if (direccion == 0)
			 avanzarEnX();
		 else
			 avanzarEnY();
		
	}

	private void avanzarEnY() {
		int yBomb = jugador.getY();
		int yEnem = posY;
		Celda celdaAAvanzar = terreno.getCelda(posX,posY);
		if (yEnem == yBomb)
			avanzarEnX();
		else
		{
			if (yBomb > yEnem)
				celdaAAvanzar = terreno.getCelda(posX, yEnem+1);
			else
				celdaAAvanzar = terreno.getCelda(posX, yEnem-1);
			celdaAAvanzar.avanzar(this);
		}
	}
	
	private void avanzarEnX() {
		int xBomb = jugador.getX();
		int xEnem = posX;
		Celda celdaAAvanzar = terreno.getCelda(posX,posY);
		if (xEnem == xBomb)
			avanzarEnY();
		else
		{
			if (xBomb > xEnem)
				celdaAAvanzar = terreno.getCelda(posX+1, posY);
			else
				celdaAAvanzar = terreno.getCelda(posX-1, posY);
			celdaAAvanzar.avanzar(this);
		}
		
	}	
	
	/**
	 * Quita el elemento de la celda, lo setea en muerto para que luego 
	 * juego lo quite, y devuelve la cantidad de puntos.
	 */
	public int destruirse() {
		super.miCelda.eliminarElementoEnCelda();
		estaVivo = false;
		return 50;
	}

}
