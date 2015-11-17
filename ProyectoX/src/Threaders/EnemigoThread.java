package Threaders;

import Principal.*;

public class EnemigoThread extends Thread{

	protected Enemigo enemigo;
	protected Juego juego;
	protected  Rugulus [] misRugulus;
	protected Altair [] misAltair;
	protected int cantEnemigos;
	/**
	 * Constructor de la clase, crea una nueva instancia de la misma.
	 * @param juego
	 * @param b
	 */
	public EnemigoThread(Juego juego)
	{
		misRugulus = new Rugulus[3];
		misAltair = new Altair[3];
		for (int i = 0; i < 3; i++)
		{
			misRugulus[i] = new Rugulus(juego.getTerreno());
			misAltair[i] = new Altair(juego.getTerreno());
		}
//		for (int i = 0; i < 3; i++)
//		{
//			juego.agregarEnemigo(misRugulus[i]);
//			juego.agregarEnemigo(misAltair[i]);
//		}
//		cantEnemigos = 6;
			juego.agregarEnemigo(misRugulus[0]);
		this.juego = juego;
	}
	
	public void run()
	{
		while(true){
			try {
//			for (Rugulus r: misRugulus)
//			{
			
				sleep(1000);
				misRugulus[0].avanzar();	
				if (misRugulus[0].getCelda() != misRugulus[0].getCeldaAnterior()){
					juego.actualizarGUI(misRugulus[0].getCelda(), misRugulus[0].getCeldaAnterior());
					//juego.actualizarGUI();
				}
//				    juego.actualizarGUI();
					
				System.out.println(misRugulus[0].getX()+" "+ misRugulus[0].getY());
			}
//			}
//			for (Altair a: misAltair)
//			{
//				a.avanzar();
//				juego.actualizarGUI();
//				sleep(1000);
//			}
		catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}
}
