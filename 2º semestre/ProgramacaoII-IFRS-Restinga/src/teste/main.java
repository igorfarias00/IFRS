package teste;
import java.util.ArrayList; // Importa a classe ArrayList

public class main {
	public static void main(String[] args) {
		

		ArrayList<String> carros = new ArrayList<String>(); // Cria um ArrayList


		carros.add("corvette");			//0
		carros.add("camaro");			//1
		carros.add("Wuling Hongguang");	//2
		carros.add("Lingbox Uni Mini");	//3

		carros.remove(1);
		
		System.out.println(carros);

	}
}
