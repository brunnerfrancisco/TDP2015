package Threaders;

import Principal.Bomberman;

public class MasacThread extends Thread{

	protected Bomberman bomb;
	protected int cantBombasS;
	protected int cantBombas;
	public MasacThread(Bomberman b) {
		bomb = b;
//		cantBombasS = b.getSimultaneas();
//		cantBombas = b.obtenerCantBombas();
	}

	public void run()
	{

		cantBombasS = bomb.getSimultaneas();
		cantBombas = bomb.obtenerCantBombas();
		bomb.setSimultaneas(100);
		bomb.setCantBombas(100);
		bomb.setDios(true);
		try {
			sleep(5000);
			bomb.setSimultaneas(cantBombasS);
			bomb.setDios(false);
			bomb.setCantBombas(cantBombas);
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
