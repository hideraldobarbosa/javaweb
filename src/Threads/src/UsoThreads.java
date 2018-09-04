import java.awt.geom.*;

import javax.swing.*;

import java.util.*;
import java.util.concurrent.RunnableFuture;
import java.awt.*;
import java.awt.event.*;

public class UsoThreads {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		JFrame marco=new MarcoRebote();
		
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}

class PelotaThreads implements Runnable{
	public PelotaThreads (Pelota pelotaUm, Component componenteUm){
		pelota= pelotaUm;
		componente = componenteUm;
	}
	
	public void run(){
		
		
		System.out.println("Estado da Thread :"+Thread.currentThread().isInterrupted());
		//for (int i=1; i<=3000; i++){
		//while(!Thread.interrupted()){
		  while(!Thread.currentThread().isInterrupted()){
			  
			pelota.mueve_pelota(componente.getBounds());
			
			componente.paint(componente.getGraphics());
			
			/*
			try{
				Thread.sleep(4);
			}catch(InterruptedException e){
				//e.printStackTrace();
				//System.out.println("Impossivel parar a execução");
				//System.exit(0);
			}*/
		}
		 System.out.println("Estado da Thread esta parado :"+Thread.currentThread().isInterrupted());

		
	}
	private Pelota pelota;
	private Component componente;
	
	
}



//Movimiento de la pelota-----------------------------------------------------------------------------------------

class Pelota{
	
	// Mueve la pelota invirtiendo posición si choca con límites
	
	public void mueve_pelota(Rectangle2D limites){
		
		x+=dx;
		
		y+=dy;
		
		if(x<limites.getMinX()){
			
			x=limites.getMinX();
			
			dx=-dx;
		}
		
		if(x + TAMX>=limites.getMaxX()){
			
			x=limites.getMaxX() - TAMX;
			
			dx=-dx;
		}
		
		if(y<limites.getMinY()){
			
			y=limites.getMinY();
			
			dy=-dy;
		}
		
		if(y + TAMY>=limites.getMaxY()){
			
			y=limites.getMaxY()-TAMY;
			
			dy=-dy;
			
		}
		
	}
	
	//Forma de la pelota en su posición inicial
	
	public Ellipse2D getShape(){
		
		return new Ellipse2D.Double(x,y,TAMX,TAMY);
		
	}	
	
	private static final int TAMX=15;
	
	private static final int TAMY=15;
	
	private double x=0;
	
	private double y=0;
	
	private double dx=1;
	
	private double dy=1;
	
	
}

// Lámina que dibuja las pelotas----------------------------------------------------------------------


class LaminaPelota extends JPanel{
	
	//Añadimos pelota a la lámina
	
	public void add(Pelota b){
		
		pelotas.add(b);
	}
	
	public void paintComponent(Graphics g){
		
		super.paintComponent(g);
		
		Graphics2D g2=(Graphics2D)g;
		
		for(Pelota b: pelotas){
			
			g2.fill(b.getShape());
		}
		
	}
	
	private ArrayList<Pelota> pelotas=new ArrayList<Pelota>();
}


//Marco con lámina y botones------------------------------------------------------------------------------

class MarcoRebote extends JFrame{
	
	public MarcoRebote(){
		
		setBounds(600,300,600,350);
		
		setTitle ("Marcador");
		
		lamina=new LaminaPelota();
		
		add(lamina, BorderLayout.CENTER);
		
		JPanel laminaBotones=new JPanel();
	
		button1=new JButton("Thread-1");
		
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evento) {
				// TODO Auto-generated method stub
				comece_o_jogo(evento);
				
			}
		});
		
		button1=new JButton("Thread-1");
		
		button1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evento) {
				// TODO Auto-generated method stub
				comece_o_jogo(evento);				
			}
		});
		laminaBotones.add(button1);
		
		button2=new JButton("Thread-2");
		
		button2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evento) {
				// TODO Auto-generated method stub
				comece_o_jogo(evento);				
			}
		});
		laminaBotones.add(button2);

		button3=new JButton("Thread-3");
		
		button3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evento) {
				// TODO Auto-generated method stub
				comece_o_jogo(evento);				
			}
		});
		
		laminaBotones.add(button3);

		parar1 =new JButton("Parar 1");
		
		parar1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evento) {
				// TODO Auto-generated method stub
				parar(evento);				
			}
		});
		
		laminaBotones.add(parar1);

		parar2 =new JButton("Parar 2");
		
		parar2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evento) {
				// TODO Auto-generated method stub
				parar(evento);				
			}
		});

		laminaBotones.add(parar2);
		
		parar3 =new JButton("Parar 3");
		
		parar3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent evento) {
				// TODO Auto-generated method stub
				parar(evento);				
			}
		});
		laminaBotones.add(parar3);
		
		add(laminaBotones, BorderLayout.SOUTH);
	}

		

	//Añade pelota y la bota 1000 veces
	
	public void comece_o_jogo (ActionEvent evento) {
		
					
			Pelota pelota=new Pelota();
			
			lamina.add(pelota);
			
			Runnable r= new PelotaThreads(pelota, lamina);
			
			//Thread t = new Thread(r);
			
			if(evento.getSource().equals(button1)){
				
				t1 = new Thread(r);
				
				t1.start();
				
			}else if(evento.getSource().equals(button2)){
				
				t2 = new Thread(r);
			
				t2.start();
				
			}else if(evento.getSource().equals(button3)){
				
				t3= new Thread(r);
			
				t3.start();
			}
		
	}
	
	@SuppressWarnings("deprecation")
	private void parar(ActionEvent evento) {
		// TODO Auto-generated method stub
		//t.stop(); absoleto metodo
		if(evento.getSource().equals(parar1)){
			t1.interrupt();
		}else if(evento.getSource().equals(parar2)){
			t2.interrupt();
			
		}else if(evento.getSource().equals(parar3)){
			t3.interrupt();
		}
	}
	
	Thread t1, t2, t3;
	
	JButton button1, button2, button3, parar1, parar2, parar3;
	private LaminaPelota lamina;
	
}
