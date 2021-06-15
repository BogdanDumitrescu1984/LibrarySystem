package biblioteca;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class Carte extends Publicatie {
	public static int TERMEN_IMPRUMUT = 4;
	public static double PENALIZARE = 0.5;
	protected int anPublicatie;

	public Carte(String autor, String titlu, int anPublicatie, String categorie) {
		super(autor, titlu);
		this.anPublicatie = anPublicatie;
		this.categorie = categorie;
	}
	
	public String toString() {
		return this.autor + " " + this.titlu + " " + this.anPublicatie + " " + this.categorie;
	}
	
	@Override
	public void returneaza(LocalDate dataRetur) {
		if (this.disponibil == false) {
			this.disponibil = true;
		}
		else{
			System.out.println("Publicatie " + this.getId() + " nu poate fi returnata (nu a fost imprumutata)!");
		}
		if(this.dataImprumut != null) {
			if (Period.between(this.dataImprumut.plusDays(TERMEN_IMPRUMUT*7), dataRetur).getDays()>0) {
				System.out.println("Termen depasit pentru publicatia " + this.getId() + "!");
				System.out.println("Penalizare " + calculPenalizare(dataRetur) + " lei.");
			} else {
				System.out.println("Publicatia " + this.getId() + " a fost returnata.");
			}
		}
	}
	
	@Override
	public double calculPenalizare(LocalDate dataRetur) {
		LocalDate dateBefore = this.dataImprumut.plusWeeks(TERMEN_IMPRUMUT);
		double diferenta = ChronoUnit.DAYS.between(dateBefore, dataRetur);
		return diferenta*PENALIZARE;	
		}

}
