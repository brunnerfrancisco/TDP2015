package Principal;

import javax.swing.ImageIcon;

/**
 * Clase Bomberman que maneja toda la lógica del jugador.
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public class Bomberman extends ElementoEnCelda
{
	protected int velocidad;
	protected int cantBombasSimultaneas;
	protected int cantBombasActuales;
	protected boolean modoDios;
	protected int puntaje;
	protected int posX;
	protected int posY;
	protected boolean estaVivo;
	protected Bomba miBomba; // Prototipo de bomba
	protected Terreno terreno;
	protected Celda celdaAnterior;
	
	/**
	 * Contructor de la clase, crea una nueva instancia de la misma.
	 */
	public Bomberman(Terreno t)
	{
		posX=1;
		posY=1;
		estaVivo=true;
		modoDios=false;
		puntaje=0;
		cantBombasSimultaneas=1;
		cantBombasActuales=1;
		terreno=t;
		miBomba=new Bomba(t);
		miCelda = terreno.getCelda(1, 1);
		celdaAnterior = terreno.getCelda(1, 1);
		imagen = new ImageIcon(getClass().getResource("/images/bomberman.jpg"));
		
	}
	
	/**
	 * Método que setea una nueva posición en X pasada por parámetro.
	 * @param x, de tipo entero.
	 */
	public void setX(int x)
	{
		posX=x;
	}
	
	/**
	 * Método que setea una nueva posición en Y pasada por parámetro.
	 * @param y, de tipo entero.
	 */
	public void setY(int y)
	{
		posY=y;
	}
	
	/**
	 * Método que devuelve la posición en X del jugador.
	 * @return posX
	 */
	public int getX()
	{
		return posX;
	}
	
	/**
	 * Método que devuelve la posición en Y del jugador.
	 * @return posY
	 */
	public int getY()
	{
		return posY;
	}
	
	/**
	 * Método que cambia el estado del modo dios del jugador.
	 * @param d, de tipo boolean
	 */
	public void modoDios(boolean d)
	{
		modoDios=d;
	}
	
	
	
	/**
	 * Método que devuelve el puntaje del jugador en ese momento.
	 * @return puntaje, de tipo entero.
	 */
	public int getPuntos()
	{
		return puntaje;
	}
	
	
	public void avanzar(int x, int y)
	{
		terreno.getCelda(x,y).avanzar(this);	
	}
	
	/**
	 *Método que le permite al jugador poner una, o más, bombas. 
	 */
	public Bomba ponerBomba()
	{
		if(cantBombasActuales>0)
		{
			Bomba miBomba = new Bomba(terreno);
			miBomba.setPosX(posX);
			miBomba.setPosY(posY);
			terreno.getCelda(posX, posY).ponerBombaEnCelda(miBomba);
			cantBombasActuales--;
			return miBomba;
		}
		return null;
	}
	
	/**
	 * 
	 */
	public void agregarBomba()
	{
		cantBombasActuales++;
	}
	
	/**
	 * Retorna la bomba del bomberman
	 * @return
	 */
	public Bomba getBomba()
	{
		return miBomba;
	}
	
	
	/**
	 * Método que duplica el alcance de la bomba que pone el jugador.
	 */
	public void duplicarAlcance()
	{
		int alcanceNuevo = miBomba.getAlcance() *2;
		miBomba.setAlcance(alcanceNuevo);
	}
	
	/**
	 * Método que duplica la cantidad de bombas que puede poner el jugador simultaneamente.
	 */
	public void aumentarCantBombas()
	{
		cantBombasSimultaneas++;
		cantBombasActuales++;
	}

	public int getSimultaneas()
	{
		return cantBombasSimultaneas;
	}
	@Override
	public void avanzar(Bomberman b) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void avanzar(Enemigo e) {
		this.destruirse();
		
	}

	@Override
	public int destruirse() {
		estaVivo = false;
		return 0;
		
	}
	/**
	 * Retorna la cantidad de bombas que puede poner el bomberman simultaneamente
	 * @return Cantidad de bombas que puede poner el bomberman simultaneamente
	 */
	public int obtenerCantBombas() {
		return cantBombasActuales;
	}

	public void setVelocidad(int velocidadNueva) {
		velocidad = velocidadNueva;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public Celda getCelda() {
		return miCelda;
	}

	public boolean modoDios() {
		return modoDios;
	}

	
	/**
	 * Método que aumenta el puntaje del jugador de acuerdo a la cantidad que indica el parámetro. 
	 * @param p, de tipo entero.
	 */
	public void addPuntos(int p) {
			puntaje+=p;
	}

	public Celda getCeldaAnterior() {
		return celdaAnterior;
	}

	public void setCeldaAnterior(Celda c) {
		celdaAnterior = c;
		
	}

	public void setSimultaneas(int i) {
		cantBombasSimultaneas = i;
		
	}

	public void setDios(boolean b) {
		modoDios=b;
	}

	public void setCantBombas(int i) {
		cantBombasActuales = i;
	}

	

	
}
