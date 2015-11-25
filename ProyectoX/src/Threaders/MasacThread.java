package Threaders;

import Principal.Bomberman;

public class MasacThread extends Thread{

	protected Bomberman bomb;
	protected int cantBombasS;
	protected int cantBombas;
	public MasacThread(Bomberman b) {
		bomb = b;
		cantBombasS = b.getSimultaneas();
		cantBombas = b.obtenerCantBombas();
	}

	public void run()
	{

//		cantBombasS = bomb.getSimultaneas();
//		cantBombas = bomb.obtenerCantBombas();

		System.out.println("Simultaneas Antes " +  bomb.getSimultaneas());

		System.out.println("cantBombas ante " +  bomb.obtenerCantBombas());
		
		bomb.setSimultaneas(100);
		bomb.setCantBombas(100);

		System.out.println("Simultaneas Antes " +  bomb.getSimultaneas());

		System.out.println("cantBombas ante " +  bomb.obtenerCantBombas());
		bomb.setDios(true);
		try {
			sleep(5000);
			bomb.setSimultaneas(cantBombasS);
			bomb.setDios(false);
			bomb.setCantBombas(cantBombas);

			System.out.println("Simultaneas dsp " +  bomb.getSimultaneas());

			System.out.println("cantBombas dsp " +  bomb.obtenerCantBombas());
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
