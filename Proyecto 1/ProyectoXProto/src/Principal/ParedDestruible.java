package Principal;

public class ParedDestruible extends Pared {
	public ParedDestruible()
	{
		
	}
	public void destruirse()
	{
		
	}
	@Override
	public void avanzar(Bomberman b) {
		if (b.modoDios)
		{
			b.setX(this.getCelda().getPosX());
			b.setY(this.getCelda().getPosY());
			muevo en la grafica 1*32 para arriba
		}
	}
	@Override
	public void avanzar(Enemigo e) {
		// TODO Auto-generated method stub
		
	}
}
