package Principal;

import java.util.Random;

import javax.swing.ImageIcon;
/**
 * 
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public class Altair extends Enemigo{
	protected int posEnAltair;
	public Altair(Terreno t, int p)
	{
		terreno = t;
		imagen = new ImageIcon(getClass().getResource("/images/Altair.jpg"));
		modoDios = true;
		posEnAltair = p;
		estaVivo = true;
	}
	
	
	

	@Override
	/** Si direccion es 0, intenta avanzar hacia Arriba.
	 * Si direccion es 1, intenta avanzar hacia Abajo.
	 * Si direccion es 2, intenta avanzar hacia Izquierda.
	 * Si direccion es 3, intenta avanzar hacia Derecha.
	 */
	public void avanzar() {
		 Random  rnd = new Random();
		 int direccion = rnd.nextInt(4);
		 Celda celdaAAvanzar = terreno.getCelda(posX,posY);
		 if (direccion == 0)
			 celdaAAvanzar = terreno.getCelda(posX, posY-1);
		 if (direccion == 1)
			 celdaAAvanzar = terreno.getCelda(posX, posY+1);
		 if (direccion == 2)
			 celdaAAvanzar = terreno.getCelda(posX-1,posY);
		 if (direccion == 3)
			 celdaAAvanzar = terreno.getCelda(posX+1, posY);
		 celdaAAvanzar.avanzar(this);
	}

	/**
	 * Quita el elemento de la celda, lo setea en muerto para que luego 
	 * juego lo quite, y devuelve la cantidad de puntos.
	 */
	public int destruirse() {
		super.miCelda.eliminarElementoEnCelda();
		estaVivo = false;
		return 20;
		
	}



	/**
	 * Devuelve la posicion en el arreglo de altair, para luego eliminarlo
	 * @return posEnAltair
	 */
	public int getPosEnAltair() {
		return posEnAltair;
	}

}
