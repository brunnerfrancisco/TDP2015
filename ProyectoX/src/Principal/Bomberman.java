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
	protected Juego juego;
	/**
	 * Contructor de la clase, crea una nueva instancia de la misma.
	 */
	public Bomberman(Juego j)
	{
		posX=1;
		posY=1;
		estaVivo=true;
		modoDios=false;
		puntaje=0;
		cantBombasSimultaneas=1;
		cantBombasActuales=1;
		terreno=j.getTerreno();
		juego = j;
		miBomba=new Bomba(terreno);
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
	
	/**
	 * Obtiene la celda a avanzar, y intenta avanzar utilizando el avanzar definido en celda.
	 * 
	 * @param x, coordenada x de la celda a avanzar
	 * @param y, coordenada y de la celda a avanzar
	 */
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
	 * Aumenta la cantidad de bombas
	 */
	public void agregarBomba()
	{
		cantBombasActuales++;
	}
	
	/**
	 * Retorna la bomba del bomberman
	 * @return miBomba
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
		miBomba.addAlcance();
	}
	
	/**
	 * Método que duplica la cantidad de bombas que puede poner el jugador simultaneamente.
	 */
	public void aumentarCantBombas()
	{
		cantBombasSimultaneas++;
		cantBombasActuales++;
	}

	/**
	 * Obtiene la cantidad de bombas simultaneas
	 * @return cantBombasSimultaneas
	 */
	public int getSimultaneas()
	{
		return cantBombasSimultaneas;
	}

	
	public void avanzar(Bomberman b) {}

	/**
	 * Si un enemigo avanza a la celda de bomberman, lo mata
	 */
	public void avanzar(Enemigo e) {
		this.destruirse();
		
	}

	/**
	 * Termina la ejecucion del juego al "morir" bomberman
	 */
	public int destruirse() {
		if (estaVivo()){
			estaVivo = false;
			juego.terminar();
		}
		return 0;
		
	}
	/**
	 * Retorna la cantidad de bombas que puede poner el bomberman simultaneamente
	 * @return Cantidad de bombas que puede poner el bomberman simultaneamente
	 */
	public int obtenerCantBombas() {
		return cantBombasActuales;
	}
	
	/**
	 * Setea una nueva velocidad a bomberman
	 * @param velocidadNueva
	 */
	public void setVelocidad(int velocidadNueva) {
		velocidad = velocidadNueva;
	}

	/**
	 * Obtiene la velocidad de bomberman
	 * @return velocidad
	 */
	public int getVelocidad() {
		return velocidad;
	}

	/**
	 * Obtiene la celda de bomberman
	 * @return miCelda
	 */
	public Celda getCelda() {
		return miCelda;
	}

	/**
	 * Obtiene si bomberman esta en modo Dios o no
	 * @return modoDios
	 */
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

	/**
	 * Obtiene la celda anterior en la que estuvo bomberman
	 * @return celdaAnterior
	 */
	public Celda getCeldaAnterior() {
		return celdaAnterior;
	}

	/**
	 * Setea la celda anterior despues de un movimiento
	 * @param c
	 */
	public void setCeldaAnterior(Celda c) {
		celdaAnterior = c;
		
	}

	/**
	 * Setea la cantidad de bombas simultaneas que puede poner
	 * @param i
	 */
	public void setSimultaneas(int i) {
		cantBombasSimultaneas = i;
		
	}

	/**
	 * Setea en true o false el modo dios.
	 * @param b
	 */
	public void setDios(boolean b) {
		modoDios=b;
	}

	/**
	 * Setea la cantidad de bombas
	 * 
	 */
	public void setCantBombas(int i) {
		cantBombasActuales = i;
	}

	/**
	 * 
	 * @return estaVivo
	 */
	public boolean estaVivo() {
		return estaVivo;
	}	
}
