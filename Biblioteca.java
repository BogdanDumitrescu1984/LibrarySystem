package biblioteca;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
		private List<Publicatie> publicatii = new ArrayList<Publicatie>();
		private List<Media> media = new ArrayList<Media>();

		public void adaugaPublicatie(Publicatie publicatie) {
			publicatii.add(publicatie);
			publicatie.setId(publicatii.size()+media.size()); // setare id unic egal cu suma lungimilor celor doua liste. Daca se adauga un nou in lista publicatii
															  // dupa elementele deja introduse in lista media va primi un id unic, dupa ultimul id din lista media. 
		}
		
		
		public void adaugaMedia(Media medii) {
			media.add(medii);
			medii.setId(publicatii.size() + media.size());
		}
		
		
		public void testPublicatie() {
			for (int i=0; i< publicatii.size(); i++) {
				System.out.println(publicatii.get(i).getId());
			}
		}
		
		
		public void catalogPublicatii() {
			System.out.println("Catalog publicatii: ");
			for (int i =0; i < publicatii.size(); i++) {
				System.out.println(publicatii.get(i).getId() + ". " + publicatii.get(i).toString());
			}
		}
		
		
		public void catalogMedia() {
			System.out.println("Catalog media: ");
			for (int i =0; i < media.size(); i++) {
				System.out.println(media.get(i).getId() + ". " + media.get(i).toString());
			}
		}
		
		
		public void publicatiiDisponibile() {
			System.out.println("Publicatii disponibile: ");
			for (int i=0; i< publicatii.size(); i++) {
				if (publicatii.get(i).isDisponibil() == true) {
					System.out.println(publicatii.get(i).getId() + ". " + publicatii.get(i).toString());
				}
			}
		}

		
		public void publicatiiImprumutate() {
			System.out.println("Publicatii imprumutate: ");
			for (int i=0; i< publicatii.size(); i++) {
				if (publicatii.get(i).isDisponibil() != true) {
					System.out.println(publicatii.get(i).getId() + ". " + publicatii.get(i).toString());
				}
			}
		}
		
		
		public void consultarePublicatieDupaCategorie(String categorie) {
			System.out.println("Publicatii din categoria \"" + categorie + "\":");
			for (int i=0; i< publicatii.size(); i++) {
				if(publicatii.get(i).categorie == categorie) {
					System.out.println(publicatii.get(i).getId() + ". " + publicatii.get(i).toString());
				}
			}
		}
		
		
		public void consultarePublicatieDupaAutor(String autor) {
			System.out.println("Publicatii scrise de " + autor + ":");
			for (int i=0; i< publicatii.size(); i++) {
				if(publicatii.get(i).autor == autor) {
					System.out.println(publicatii.get(i).getId() + ". " + publicatii.get(i).toString());
				}
			}
		}
		
		
		public void imprumutaPublicatie(int id, LocalDate dataImprumut) {
			for (int i=0; i< publicatii.size(); i++) {
				if(publicatii.get(i).getId() == id) {
					publicatii.get(i).imprumuta(dataImprumut);
					}
				} 
			if (id > publicatii.size()) {
				System.out.println("Publicatia " + id + " nu a fost gasita!");
			}
		}
		
		
		public void returneazaPublicatie(int id, LocalDate dataRetur) {
			for (int i=0; i< publicatii.size(); i++) {
				if(publicatii.get(i).getId() == id) {
					publicatii.get(i).returneaza(dataRetur);
				}
			}if (id > publicatii.size()) {
				System.out.println("Publicatia " + id + " nu a fost gasita!");
			}
		}
		
		
		public void consultaMedia(int id) {
			for (int i=0; i< media.size(); i++) {
				if(media.get(i).getId() == id) {
					media.get(i).consulta();
				}
			}
			if (id > (publicatii.size() + media.size())){
				System.out.println("Media " + id + " nu a fost gasita!");
			}
		}
		
		
		public void elibereazaMedia(int id) {
			for (int i=0; i < media.size(); i++) {
				if (media.get(i).getId() == id) {
					media.get(i).elibereaza();
				}
			}
			if (id > (publicatii.size() + media.size())){
				System.out.println("Media " + id + " nu a fost gasita!");
			}
			
		}
		
}
