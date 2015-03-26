/*  
	# ClassName: CryptCesar (Class for String Crypter and DeCrypter)
	# Author: Diego Alejandro Asencio Cuellar
	# Version: 1.0
	# E-Mail: diego.asencio.cuellar@unillanos.edu.co
	# Description: Clase escrita en java para cifrar cadenas de texto
	               en base al algoritmo de Cesar. esta clase le permite
		       introducir una cadena de texto (String), un numero
		       de posiciones y obtener una nueva cadena cifrada en
		       base a estas mismas posiciones. De la misma Manera
		       permite al usuario ingresar una cadena de texto cifrada
		       respecto a un numero de posiciones y esta devuelve
		       el String Original.

*/
import java.util.Scanner;
public class CryptCesar {
	private String alfabeto,Text,TextCrypt;
	private int posiciones;
	private static Scanner teclado;
	public static CryptCesar i;

		public static void main(String[]args) {
			if(args.length == 2) {
				if( (Integer.parseInt(args[0]) >= 0)&&(Integer.parseInt(args[0]) <= 27) ) {
					teclado = new Scanner(System.in);
					System.out.println("***ALGORITMO DE CIFRADO CESAR*** \n Seleccione una Opcion: \n\t1) Cifrar Texto \n\t2) Decifrar Texto \n\t0) Salir \n\t");
					int opc = teclado.nextInt();
					switch(opc) {
						case 0:
							System.exit(0);
						break;
						case 1: 
							i = new CryptCesar(args,1);
                                  		        i.cifrarTexto();
                                        		System.out.println("Texto Cifrado" + i.getTextoCifrado());
						break;
						case 2:
							i = new CryptCesar(args,2);
                                                        i.decifrarTexto();
                                                        System.out.println(i.getTextoDecifrado());
						break;
						default: System.out.println("Opcion Invalida :/ ");
					}
				}
				else {
					System.out.println("Posiciones No Validas :/ ");
				}
			}else {
				System.out.println("Modo de Uso: java CryptCesar <numero_de_posiciones> <cadena>");
			}
		}

		public CryptCesar(String[]opc, int op) {
			alfabeto = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
			setPosicion(Integer.parseInt(opc[0]));
			if(op == 1) {
				this.Text = opc[1].toUpperCase();
				this.TextCrypt="";
			}else {
				this.TextCrypt = opc[1].toUpperCase();
				this.Text = "";
			}
		}

		public void setPosicion(int pos) {
			this.posiciones = pos;
		}
		public String getTextoCifrado() {
			return TextCrypt;
		}
		public String getTextoDecifrado() {
			return Text;
		}

		private void cifrarTexto() {
			String alpha = generarAlfabeto();
			for(int i=0;i<Text.length();i++) {
				TextCrypt += alpha.charAt( posicion_de_una_letra(Text.charAt(i), alfabeto) );
			}
		}
		private void decifrarTexto() {
			String alpha = generarAlfabeto();
			for(int i=0;i<TextCrypt.length();i++) {
                                Text += alfabeto.charAt( posicion_de_una_letra(TextCrypt.charAt(i), alpha) );
                        }
		}

		private int posicion_de_una_letra(char letra, String aux) {
			for(int i=0;i<aux.length();i++) {
				if(aux.charAt(i) == (letra)) return i;
			}
			return -1;
		}

		private String generarAlfabeto() {
			String newalphabet="";
				for(int i=0;i<alfabeto.length();i++) {
					if(i<(alfabeto.length() - posiciones)) {
						newalphabet += alfabeto.charAt(i+posiciones);
					}else {
						int aux=posiciones- (alfabeto.length() - i );
						newalphabet += alfabeto.charAt(aux);
					}
				}
			return newalphabet;
		}

}
