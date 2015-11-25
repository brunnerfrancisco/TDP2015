package Principal;

public class Cronometro extends javax.swing.JFrame {  
	 
	int min =5, seg =0; 
	Juego miJuego;

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
							 miJuego.terminar();
						 }
					 }					
				 }
			 }
			 catch (java.lang.InterruptedException ie) { System.out.println(ie.getMessage()); } 
		 }
	 };
}
	 
