package Principal;

import java.util.Random;

import javax.swing.ImageIcon;

public class Altair extends Enemigo{
	protected int posEnAltair;
	public Altair(Terreno t, int p)//, int x, int y)
	{
		terreno = t;
//		posX = x;
//		posY = y;
		imagen = new ImageIcon(getClass().getResource("/images/Altair.jpg"));
		modoDios = true;
		posEnAltair = p;
		estaVivo = true;
//		miCelda = terreno.getCelda(posX, posY);
	}
	
	
	

	@Override
	/* Si direccion es 0, intenta avanzar hacia Arriba.
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

	@Override
	public int destruirse() {
		super.miCelda.eliminarElementoEnCelda();
		estaVivo = false;
		return 20;
		
	}




	public int getPosEnAltair() {
		return posEnAltair;
	}

}
