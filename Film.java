package biblioteca;

public class Film extends Media {
	protected String titlu;
	protected int an;
	protected String gen;
	protected String regizor;
	
	
	public Film(String suport, String titlu, int an, String gen, String regizor) {
		super(suport);
		this.titlu = titlu;
		this.an = an;
		this.gen = gen;
		this.regizor = regizor;
	}
	
	
	public String toString() {
		return this.regizor + " " + this.titlu + " " + this.an + " " + this.gen;
	}

}
