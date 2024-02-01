import model.Carro;
import model.Proprietario;

public class App {
	public static void main(String[] args) throws Exception {
		Carro carro = new Carro();
		Proprietario proprietario = new Proprietario();
		
		carro.setAno(2025);
		carro.setMarca("Toyota");
		carro.setModelo("Corolla");
		
		proprietario.setNome("Programador Java");
		proprietario.setCarro(carro);
		
		System.out.println(Reflection.formatterXML(proprietario));
	}
}
