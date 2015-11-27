package Principal;

public class BombermanController extends Thread{
	
	private Juego juego;
	public boolean izq,der,up,down;
	private int tiempo;
	
	public BombermanController(Juego j){
		juego=j;
		izq = der = up = down = false;
		tiempo = 150;
		
		
	}
	public void run()
	{
		while (true)
		{
			try {
				sleep(tiempo);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			if (izq)
				juego.moverBombermanLEFT();
			else if (der)
					juego.moverBombermanRIGHT();
			else if (up)
					juego.moverBombermanUP();
			else if (down)
					juego.moverBombermanDOWN();
		}
	}
	
	public void restarTiempo()
	{
		tiempo = tiempo -30;
	}

}
