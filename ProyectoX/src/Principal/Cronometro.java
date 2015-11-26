package Principal;
/**
 * @author Brunner Francisco, Vercelli Franco, Volpe Leandro.
 *
 */
public class Cronometro extends javax.swing.JFrame {  
	 
	protected int min =1, seg =0; 
	protected Juego miJuego;

	/** Creates new form NewJFrame */ 
	 public Cronometro(Juego j)
	 { 
		 miJuego=j;
	 } 

	 Thread crono = new Thread()
	 { 

		 public void run() 
		 { 
			 try
			 {
				 min--;
				 seg=60;
				 while(min>=0)
				 {
					 seg--;					 
					 miJuego.getGUI().getTiempoLabelContenido().setText(min + ": " + seg);
				 
					 Thread.sleep(1000); 
					 if(seg==0)
					 {
						 min--;
						 seg=60;
						 if(min<0)
						 {		
							 miJuego.getBomberman().destruirse();
						 }
					 }					
				 }
			 }
			 catch (java.lang.InterruptedException ie) { System.out.println(ie.getMessage()); } 
		 }
	 };
}
	 
