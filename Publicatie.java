package biblioteca;

import java.time.LocalDate;

public abstract class Publicatie extends Item implements Imprumutabil {
	protected String autor;
	protected String titlu;
	protected String categorie;
	protected LocalDate dataImprumut;
	

	public Publicatie(String autor, String titlu) {
		this.autor = autor;
		this.titlu = titlu;		
	}
	
	public boolean isDisponibil() {
		return this.disponibil;
	}

	@Override
	public void imprumuta(LocalDate dataImprumut){
		if (this.disponibil == true) {
			this.disponibil = false;
			this.dataImprumut = dataImprumut;
			System.out.println("Publicatie " + this.getId() + " a fost imprumutata.");
		}
		else {
			System.out.println("Publicatie " + this.getId() + " este indisponibila!");
		}
	
	}

	public void returneaza(LocalDate dataRetur){
	}

	public double calculPenalizare(LocalDate dataRetur) {
		return 0;
	}

}
