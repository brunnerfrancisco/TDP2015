package Threaders;
import javax.swing.ImageIcon;

import Principal.*;

public class BombaThread extends Thread
{
	private Bomberman bomberman;
	private Juego juego;
	private Terreno t;
	private int xPos, xNeg, yNeg, yPos;
	/**
	 * Constructor de la clase, crea una nueva instancia de la misma.
	 * @param juego
	 * @param b
	 */
	public BombaThread(Juego juego, Bomberman b)
	{
		bomberman = b;
		this.juego = juego;
		t = juego.getTerreno();
		xPos = 0;xNeg = 0;yNeg = 0; yPos = 0;
	}
	
	
	public void run()
	{
		try {
			Bomba miBomba = bomberman.ponerBomba();
			miBomba.setAlcance(bomberman.getBomba().getAlcance());
			juego.actualizarGUI();
			
			sleep(3000);
//			Bomba miBomba = bomberman.getBomba();
			int puntos = explotar(miBomba.getX(),miBomba.getY(), miBomba);
			juego.actualizarGUI();
			sleep(400);
			quitarExplosiones(miBomba.getX(),miBomba.getY(), miBomba);
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
	
	public int explotar(int x, int y,Bomba miBomba) throws InterruptedException{
//		int x = miBomba.getX();
//		int y = miBomba.getY();
		int alcance = miBomba.getAlcance();

	    t.getCelda(x, y).eliminarElementoEnCelda();
		
		int puntos = 0;
		ImageIcon imagenAnterior;
		Celda celda;
		ElementoEnCelda elementoCelda;
		ExplosionGrafica exp; 
		int i=x+1;
		boolean destrui=false;
		while (i<=(x+alcance)&&(!destrui))
		{	xPos++;
			celda = t.getCelda(i, y);
			elementoCelda =celda.obtenerElem();
			if(elementoCelda!=null)
			{
				puntos = puntos + elementoCelda.destruirse();
				destrui = true; // Ya rompi una pared destruible o algo hay q sacar los powerup
				
			}
			exp = new ExplosionGrafica();
			celda.agregarElementoACelda(exp);
			i++;
		}
		i=x-1;
		destrui=false;
		while (i>=(x-alcance)&&(!destrui))
		{
			xNeg++;
			celda = t.getCelda(i, y);
			elementoCelda =celda.obtenerElem();
			if(elementoCelda!=null)
			{
				puntos = puntos + elementoCelda.destruirse();
				destrui=true;
			}
			exp = new ExplosionGrafica();
			celda.agregarElementoACelda(exp);
			i--;
		}
		int j=y+1;
		destrui=false;
		while (j<=(y+alcance)&&(!destrui))
		{
			yPos++;
			celda = t.getCelda(x, j);
				elementoCelda= celda.obtenerElem();
			if(	elementoCelda!=null)
			{
				puntos = puntos + elementoCelda.destruirse();
				destrui=true;
			}

			exp = new ExplosionGrafica(1);
			celda.agregarElementoACelda(exp);
			j++;
		}
		j=y-1;
		destrui=false;
		while (j>=(y-alcance)&&(!destrui))
		{
			yNeg++;
			celda = t.getCelda(x, j);
			elementoCelda= celda.obtenerElem();
			if(	elementoCelda!=null)
			{
				puntos = puntos + elementoCelda.destruirse();
				destrui=true;
			}

			exp = new ExplosionGrafica(1);
			celda.agregarElementoACelda(exp);
			j--;
		}
		return puntos;
		
	}


	private void quitarExplosiones(int x, int y, Bomba miBomba) {
		Celda celda;
		ElementoEnCelda elementoCelda;
		ExplosionGrafica exp; 

		int alcance = miBomba.getAlcance();
		for(int i = x+1; i <= x+xPos; i++)
		{	
			celda = t.getCelda(i, y);
			elementoCelda =celda.obtenerElem();
			celda.eliminarElementoEnCelda();
		}
		for(int i = x-xNeg; i <= x-1; i++)
		{
			celda = t.getCelda(i, y);
			elementoCelda =celda.obtenerElem();
			celda.eliminarElementoEnCelda();
		}
		for(int j = y+1; j <= y+yPos; j++)
		{
			celda=t.getCelda(x, j);
			elementoCelda=celda.obtenerElem();
			celda.eliminarElementoEnCelda();
		}
		for(int j = y-yNeg; j <= y-1; j++)
		{
			celda=t.getCelda(x, j);
			elementoCelda=celda.obtenerElem();
			celda.eliminarElementoEnCelda();
		}
		
//		for(int i = y+1; i < x+xNeg; i++)
//		{
//				celda = t.getCelda(x, j);
//				elementoCelda= celda.obtenerElem();
//			if(	elementoCelda!=null)
//			{
//				puntos = puntos + elementoCelda.destruirse();
//				destrui=true;
//			}
//
//			exp = new ExplosionGrafica(1);
//			celda.agregarElementoACelda(exp);
//			j++;
//		}
//		j=y-1;
//		destrui=false;
//		while (j>=(y-alcance)&&(destrui))
//		{
//			celda = t.getCelda(x, j);
//			elementoCelda= celda.obtenerElem();
//			if(	elementoCelda!=null)
//			{
//				puntos = puntos + elementoCelda.destruirse();
//				destrui=true;
//			}
//
//			exp = new ExplosionGrafica(1);
//			celda.agregarElementoACelda(exp);
//			j--;
//		}
//		
	}
}
