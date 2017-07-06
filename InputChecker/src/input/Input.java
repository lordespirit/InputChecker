package input;

import java.util.Scanner;

public class Input {
	
    public interface CheckBadFormat {
		public abstract boolean checkBadFormat(String str);
	}

	public String scanPhone(){
		
		System.out.print("Introduce teléfono de contacto : ");
		return scanLine("Telefono",new CheckBadFormat() {			
			@Override
			public boolean checkBadFormat(String telefono) {
				String pattern = "^[0-9]{9,13}$";
				return !telefono.matches(pattern);
			}
		});

	}
	
	public String scanEmail(){

		System.out.print("Introduce dirección de correo electrónico del contacto : ");
		return scanLine("Email",new CheckBadFormat() {			
			@Override
			public boolean checkBadFormat(String email) {
				String pattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
				return !email.matches(pattern);
			}
		});
			
	}
	
	
	/**
	 * Lee un String y verifica que cumpla con un patron dado por la interfaz CheckBadFormat
	 * @param strPatron
	 * @param checker
	 */
	protected String scanLine(String strPatron, CheckBadFormat checker){
		
		String strComprobacion;
		boolean isBadFormat;
		do{
				strComprobacion = scanLine();
				isBadFormat = checker.checkBadFormat(strComprobacion); 
			if(isBadFormat){
				System.err.println("Error, el " + strPatron + " : " + strComprobacion +
						" es incorrecto. Vuelve a introducir");
			}
		}while(isBadFormat);

		return strComprobacion;
		
	}
	
	
	public static String scanLine(){
		Scanner reader = new Scanner(System.in);
		String var = reader.nextLine();
		//reader.close();
		return var;
	}
	
	
}
