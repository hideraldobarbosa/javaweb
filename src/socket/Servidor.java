package socket;

import javax.swing.*;
import java.awt.*;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public static void main(String[] args) {

		FormServidor formServidor = new FormServidor();
	
		formServidor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	}
}

class FormServidor extends JFrame implements Runnable {
	
	public FormServidor(){
		
		setBounds(1200,300,280,350);
		JPanel minhaFolha = new JPanel();
		
		minhaFolha.setLayout(new BorderLayout());
		
		areaTexto  = new JTextArea();
		
		minhaFolha.add(areaTexto, BorderLayout.CENTER);
		
		add(minhaFolha);
		
		setVisible(true);
		
		Thread minhaThread = new Thread(this);

		minhaThread.start();
	}
	
	private JTextArea areaTexto;

	@Override
	public void run() {
		// TODO Auto-generated method stub
		//System.out.println("estou na escuta");
		try {
			ServerSocket servidor = new ServerSocket(9999);
			
			while(true){
			
				Socket meuSocket = servidor.accept();
				
				DataInputStream fluxoentrada = new DataInputStream(meuSocket.getInputStream());
				
				String mensagemTexto = fluxoentrada.readUTF();
				
				areaTexto.append("      \n"+mensagemTexto);
				
				meuSocket.close();
		 }
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	
	} 
	
	}
