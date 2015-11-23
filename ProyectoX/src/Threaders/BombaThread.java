package Threaders;
import Principal.*;

public class BombaThread extends Thread
{
	private Bomberman bomberman;
	private Juego juego;
	/**
	 * Constructor de la clase, crea una nueva instancia de la misma.
	 * @param juego
	 * @param b
	 */
	public BombaThread(Juego juego, Bomberman b)
	{
		bomberman = b;
		this.juego = juego;
	}
	public void run()
	{
		try {
			Bomba miBomba = bomberman.ponerBomba();
			juego.actualizarGUI();
			
			sleep(3000);
//			Bomba miBomba = bomberman.getBomba();
			int puntos = miBomba.explotar(miBomba.getX(),miBomba.getY());
			bomberman.addPuntos(puntos);
			bomberman.agregarBomba();
			juego.actualizarPuntaje();
			juego.quitarEnemigo();
			juego.actualizarGUI();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
