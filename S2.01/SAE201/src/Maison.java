import java.util.ArrayList;

import ardoise.*;
public class Maison extends Forme{

	private Forme corps;
	private Forme porte;
	private Forme toit;
	
	public Maison() {
		
	}
	
	public Maison(String nomForme, Forme corps, Forme porte, Forme toit) {
		super(nomForme);
		try {
			if (corps == null || porte == null || toit == null) {
				throw new IllegalArgumentException("Les formes de la maison doivent être définies.");
			}
			this.corps = corps;
			this.porte = porte;
			this.toit = toit;
		} catch (IllegalArgumentException e) {
			System.out.println("Erreur : " + e.getMessage());
		}	
	}
	
	public Forme getCorps() {
		return corps;
	}
	public void setCorps(Forme corps) {
		this.corps = corps;
	}
	public Forme getPorte() {
		return porte;
	}
	public void setPorte(Forme porte) {
		this.porte = porte;
	}
	public Forme getToit() {
		return toit;
	}
	public void setToit(Forme toit) {
		this.toit = toit;
	}
	@Override
	public void deplacer(int arg0, int arg1) {
		try {
			if (corps == null || porte == null || toit == null) {
				throw new NullPointerException("Les formes de la maison n'ont pas été initialisées.");
			}
			this.corps.deplacer(arg0, arg1);
			this.porte.deplacer(arg0, arg1);
			this.toit.deplacer(arg0, arg1);
		} catch (NullPointerException e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
	@Override
	public ArrayList<Segment> dessiner() {
		ArrayList<Segment> segments = new ArrayList<>();
		try {
			if (corps == null || porte == null || toit == null) {
				throw new NullPointerException("Les formes de la maison n'ont pas été initialisées.");
			}
			segments.addAll(this.corps.dessiner());
			segments.addAll(this.toit.dessiner());
			segments.addAll(this.porte.dessiner());
		} catch (NullPointerException e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return segments;
	}
	@Override
	public String typeForme() {
		return "GF";
	}
	
	public String toString() {
		String result = "Maison : ";
	    result += " Toit : " + toit.toString() + ", ";
	    result += " Corps : " + corps.toString() + ", ";
	    result += " Porte : " + porte.toString();
	    return result;
	}
	
}
