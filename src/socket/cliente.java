package socket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.*;

public class cliente {

	public static void main(String[] args){
		
		FormCliente meuForm = new FormCliente();
		
		meuForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}

class FormCliente extends JFrame {
	
	public FormCliente(){
		
		setBounds(600,300,280,350);
		
		FolhaEstruturaCliente minhaFolha = new FolhaEstruturaCliente();
		
		add(minhaFolha);
		
		setVisible(true);
	}
}

class FolhaEstruturaCliente extends JPanel{
	public FolhaEstruturaCliente(){
		JLabel texto = new JLabel("Cliente");
		add(texto);
		campo1 = new JTextField(20);
	
		add(campo1);
		
		botao = new JButton("Enviar");
		
		EnviaTexto meuevento = new EnviaTexto();
	
		botao.addActionListener(meuevento);
		
		add(botao);
	
	}
	private JTextField campo1;
	private JButton botao;
	
	private class EnviaTexto implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
		try {
			Socket meuSocket = new Socket("192.168.15.5", 9999);
			
			DataOutputStream fluxosaida = new DataOutputStream(meuSocket.getOutputStream());
			
			fluxosaida.writeUTF(campo1.getText());
			
			fluxosaida.close();
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			
			System.out.println(e.getMessage());
		}
		
	
		}

	}
}


