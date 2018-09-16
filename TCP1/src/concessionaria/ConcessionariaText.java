package concessionaria;

public class ConcessionariaText extends Concessionaria {

	private String getMenu() {
		//Mostrar menu
		return null;
	}
	
	@Override
	public void showUI() {
		System.out.println(getMenu());
		this.concessionariaInterface.criarMostrarInterface();
	}

}
