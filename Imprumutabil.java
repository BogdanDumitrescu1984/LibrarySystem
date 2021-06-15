package biblioteca;

import java.time.LocalDate;

public interface Imprumutabil {
	void imprumuta (LocalDate dataImprumut);
	void returneaza (LocalDate dataRetur);
	double calculPenalizare(LocalDate dataRetur);
}
