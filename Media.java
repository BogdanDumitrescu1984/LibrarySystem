package biblioteca;

public class Media extends Item implements Consultabil {
	protected String suport;
	
	
	public Media(String suport) {
		this.suport = suport;
	}

	@Override
	public void consulta() {
		if (this.disponibil == true) {
			this.disponibil = false;
		System.out.println("Media " + this.getId() + " este in consultare.");
		}
	}

	
	@Override
	public void elibereaza() {
		if(this.disponibil == false){
			this.disponibil = true;
		}
		System.out.println("Media " + this.getId() + " este libera.");
	}
}
