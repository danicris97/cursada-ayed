package testing;

//import java.util.Random;

public class test {

	public static void main(String[] args) {
		CPU cpu = new CPU(5, 10);
		cpu.cargar();
		cpu.atender();
		
		System.out.println("\n\n CPU con lista enlazada... \n\n");
		CpuLinkedList cpu2 = new CpuLinkedList(5);

		cpu2.cargar(10);
		//cpu2.cargar();
		cpu2.atender();
	}

}
