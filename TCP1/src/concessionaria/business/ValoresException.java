package concessionaria.business;

public class ValoresException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4632202336589225719L;
	public static final int VALOR_INVALIDO = 0;
	public static final int VALOR_EXCEDIDO = 1;
	
	public ValoresException(int codigo) {
		switch (codigo) {
		case VALOR_INVALIDO:
			 System.out.println("Valor informado inválido!");
			break;
		case VALOR_EXCEDIDO:
			System.out.println("Saldo insuficiente!");
		default:
			break;
		}
	}
}
