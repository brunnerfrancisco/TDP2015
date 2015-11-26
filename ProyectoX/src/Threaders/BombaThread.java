package Threaders;
import javax.swing.ImageIcon;

import Principal.*;
/**
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
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
			int puntos = explotar(miBomba.getX(),miBomba.getY(), miBomba);
			juego.actualizarGUI();
			sleep(400);
			quitarExplosiones(miBomba.getX(),miBomba.getY(), miBomba);
			bomberman.addPuntos(puntos);
			bomberman.agregarBomba();
			juego.actualizarPuntaje();
			juego.quitarEnemigo();
			juego.actualizarGUI();
			
		} catch (InterruptedException e) {	e.printStackTrace();}
	}
	
	/**
	 * Crea una explosion, y afecta a las celdas cercanas, devuelve los puntos obtenidos en la explosion.
	 * @param x
	 * @param y
	 * @param miBomba
	 * @return puntos
	 * @throws InterruptedException
	 */
	public int explotar(int x, int y,Bomba miBomba) throws InterruptedException{
		int alcance = miBomba.getAlcance();
		t.getCelda(x, y).obtenerElem().destruirse();
	    t.getCelda(x, y).eliminarElementoEnCelda();
		
		int puntos = 0;
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
					destrui = true;
					
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

	/**
	 * Nos dice si el elemento en la celda, es una pared no destruible.
	 * @param x
	 * @param y
	 * @return toR
	 */
	private boolean EsParedNoDestruible(int x, int y) {
		boolean toR = false;
		if (x == 0 || y == 0 || x == 11 || y == 30)
			toR = true;
		return toR;
	}

	/**
	 * Quita las explosiones graficas, en las celdas cercanas
	 * @param x
	 * @param y
	 * @param miBomba
	 */
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
	}
}
