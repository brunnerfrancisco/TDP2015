package Threaders;

import Principal.*;

public class EnemigoThread extends Thread{

	protected Enemigo enemigo;
	protected Juego juego;
	protected Rugulus [] misRugulus;
	protected Altair [] misAltair;
	protected Sirius miSirius;
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
			misRugulus[i] = new Rugulus(juego.getTerreno(), i); // i es la pos en el arreglo para eliminarlo mas rapido
			misAltair[i] = new Altair(juego.getTerreno(), i);
		}
		for (int i = 0; i < 3; i++)
		{
			juego.agregarEnemigo(misRugulus[i]);
			juego.agregarEnemigo(misAltair[i]);
		}
		miSirius = new Sirius(juego.getTerreno(), juego.getBomberman());
		juego.agregarEnemigo(miSirius,29,11);
		cantEnemigos = 7;
		this.juego = juego;
	}
	public Rugulus[] getMisRugulus(){
		return 	misRugulus;
	}
	public Altair[] getMisAltair(){
		return misAltair;
	}
	
	public void run()
	{
		while(cantEnemigos > 0){
			try {

				sleep(700);
				if (miSirius !=null){
					miSirius.avanzar();
					if (miSirius.getCelda() != miSirius.getCeldaAnterior())
						juego.actualizarGUI(miSirius.getCelda(), miSirius.getCeldaAnterior());
						//juego.actualizarGUI();
				}
				for (Altair a: misAltair)
				{
					if (a != null){
						a.avanzar();
						if (a.getCelda() != a.getCeldaAnterior()){
						//	juego.actualizarGUI(a.getCelda(), a.getCeldaAnterior());
							juego.actualizarGUI();
						}
					}
				}
				for (Rugulus r: misRugulus)
				{
					if (r!=null){
						r.avanzar();	
						if (r.getCelda() != r.getCeldaAnterior()){
							juego.actualizarGUI(r.getCelda(),r.getCeldaAnterior());
							//juego.actualizarGUI();
						}
					}
				}
			
				
			}
			catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		juego.terminar();
		
	}
	public void restarEnemigo() {
		cantEnemigos--;
	}
	public Sirius getMiSirius() {
		return miSirius;
	}
	public void matarSirius() {
		miSirius = null;
		
	}

	
}
