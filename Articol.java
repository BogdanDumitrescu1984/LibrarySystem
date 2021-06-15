package biblioteca;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
//import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;

public class Articol extends Publicatie {
	public static int TERMEN_IMPRUMUT = 2;
	public static double PENALIZARE = 0.1;
	protected String publicatie;
	protected LocalDate dataPublicatiei;
	
	
	public Articol(String autor, String titlu, String categorie, String publicatie, LocalDate dataPublicatiei) {
		super(autor, titlu);
		this.categorie = categorie;
		this.publicatie = publicatie;
		this.dataPublicatiei = dataPublicatiei;
	}

	
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.uuuu");
		return this.autor + " " + this.titlu + " " + this.publicatie + " " + this.dataPublicatiei.format(formatter); 
	}
	
	
	@Override
	public void returneaza(LocalDate dataRetur) {
		if (this.disponibil == false) {
			this.disponibil = true;
		}
		else{
			System.out.println("Publicatie " + this.getId() + " nu poate fi returnata (nu a fost imprumutat)!");
		}
		if(this.dataImprumut != null) {
			if (Period.between(this.dataImprumut.plusWeeks(TERMEN_IMPRUMUT), dataRetur).getDays()>0) {
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
