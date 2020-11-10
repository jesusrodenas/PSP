package PSP.UD00.flujos.entrada.caracteres;

public abstract class Codificador {
	private static final int DESPLAZAMIENTO_CESAR = 3;
	
	public static String codifica (String texto) {
        StringBuilder cifrado = new StringBuilder();
        int codigo = DESPLAZAMIENTO_CESAR % 26;
        for (int i = 0; i < texto.length(); i++) {
        	if (texto.charAt(i)!=' ') {
	            if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
	                if ((texto.charAt(i) + codigo) > 'z') {
	                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
	                } else {
	                    cifrado.append((char) (texto.charAt(i) + codigo));
	                }
	            } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
	                if ((texto.charAt(i) + codigo) > 'Z') {
	                    cifrado.append((char) (texto.charAt(i) + codigo - 26));
	                } else {
	                    cifrado.append((char) (texto.charAt(i) + codigo));
	                }
	            }
        	}else {
        		cifrado.append( (char) texto.charAt(i) );
        	}
        }
        return cifrado.toString();
	}
	
	public static String decodifica (String texto) {
		StringBuilder cifrado = new StringBuilder();
        int codigo = DESPLAZAMIENTO_CESAR % 26;
        for (int i = 0; i < texto.length(); i++) {
        	if (texto.charAt(i)!=' ') {
        		if (texto.charAt(i) >= 'a' && texto.charAt(i) <= 'z') {
                    if ((texto.charAt(i) - codigo) < 'a') {
                        cifrado.append((char) (texto.charAt(i) - codigo + 26));
                    } else {
                        cifrado.append((char) (texto.charAt(i) - codigo));
                    }
                } else if (texto.charAt(i) >= 'A' && texto.charAt(i) <= 'Z') {
                    if ((texto.charAt(i) - codigo) < 'A') {
                        cifrado.append((char) (texto.charAt(i) - codigo + 26));
                    } else {
                        cifrado.append((char) (texto.charAt(i) - codigo));
                    }
                }        		
        	}else {
        		cifrado.append( (char) texto.charAt(i) );
        	}
        }
        return cifrado.toString();
	}
}
