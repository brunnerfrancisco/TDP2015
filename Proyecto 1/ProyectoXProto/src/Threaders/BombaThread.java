package Threaders;
import Principal.*;

public class BombaThread extends Thread
{
	private Bomberman bomberman;
	private Juego juego;
	public BombaThread(Juego juego, Bomberman b)
	{
		bomberman = b;
		this.juego = juego;
	}
	public void run()
	{
		try {
			bomberman.ponerBomba();
			juego.actualizarGUI();
			
			sleep(3000);
			Bomba miBomba = bomberman.getBomba();
			miBomba.explotar(miBomba.getX(),miBomba.getY());
			bomberman.agregarBomba();
			juego.actualizarGUI();
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
