package source;

public class Validador {

	public String formatarNome(String nome) { //formata nome
		return nome.substring(0, 1).toUpperCase() + nome.substring(1);
	}
	
	public boolean nomeValido(String nome) { //valida nome
		nome = nome.trim();
		boolean temWS = false;
		
		for(int i = 0; i < nome.length(); ++i) {
			//System.out.printf("\"%c\"\n", nome.charAt(i));
			switch(nome.charAt(i)) {
				case ' ': //simple white space
					temWS = true;
					break;
				case '\n': //break line
					temWS = true;
					break;
				case '\r': //tab space
					temWS = true;
					break;
				case '\u0009': //HORIZONTAL TABULATION.
					temWS = true;
					break;
				case '\u000B': // VERTICAL TABULATION.
					temWS = true;
					break;
				case '\u000C': // FORM FEED.
					temWS = true;
					break;
				case '\u001C': // FILE SEPARATOR
					temWS = true;
					break;
				case '\u001D': // GROUP SEPARATOR.
					temWS = true;
					break;
				case '\u001E': // RECORD SEPARATOR.
					temWS = true;
					break;
			}
			
			if(temWS) {//se tiver WHITESPACE 
				break; //finaliza o loop
			}
		}
		
		return !temWS; //return false if there is whitespace
	
	}
	
	
	
	
}
