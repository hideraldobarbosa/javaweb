package ThreadSincronizada;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSincronizada {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Banco b = new Banco();
		
		for (int i=0;i<100;i++){
			
			ExecucaoTransferencia r = new ExecucaoTransferencia(b, i, 2000);
			
			Thread t=new Thread(r);
			
			t.start();
		}

	}

}

class Banco{
	
	public Banco(){
	
		contas = new double[100];
		
		for (int i=0;i<contas.length;i++){
			contas[i]= 2000;
		}
		// saldoSuficiente = lockBanco.newCondition();
		
	}

	public synchronized void transferencia(int contaOrigem, int contaDestino, double valor ) throws InterruptedException {
		
		// lockBanco.lock();
		
		//try{
			
			while (contas[contaOrigem]<valor) {   // verifica se saldo � maior que valor saida

			//	saldoSuficiente.await();
				wait();
			
			}
			System.out.println(Thread.currentThread());
			
			contas[contaOrigem]-=valor; // dinheiro que saiu da conta origem
			
			System.out.printf("%10.2f de %d para %d", valor, contaOrigem, contaDestino);
			
			contas[contaDestino]+=valor; // dinheiro que entra na conta destino
			
			System.out.printf("Saldo Total: %10.2f%n -> ", getSaldoTotal());
			
			//saldoSuficiente.signalAll();
			
			notifyAll();
			
		 //    }
		//finally{
	//		saldoSuficiente.signalAll();
		//	lockBanco.unlock();
     //}
				
	}
	
	public double getSaldoTotal(){
		
		double somatotal = 0;
		
		for(double a:contas){
			somatotal+=a;
		}
		
		return somatotal;
		
	}
	
	private final double[] contas;
	private Lock lockBanco = new ReentrantLock();
	private Condition saldoSuficiente;
	
}

class ExecucaoTransferencia implements Runnable{

	public ExecucaoTransferencia(Banco b, int de, double max){
		
		banco=b;
		daConta = de;
		qtdeMax = max;
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

		try{

			while(true){
				
				int paraConta = (int)(100*Math.random());
				double valor=qtdeMax*Math.random();
				
				banco.transferencia(daConta, paraConta, valor);
				
				Thread.sleep((int)(Math.random()*10));
				}
	     	}catch(InterruptedException erro){
				
			}
	}
	
	private Banco banco;
	private int daConta;
	private double qtdeMax;
	
	
}




