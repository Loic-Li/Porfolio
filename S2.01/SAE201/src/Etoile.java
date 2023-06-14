import java.util.ArrayList;

import ardoise.*;
public class Etoile extends Forme{
	
	private Forme branche1;
	private Forme branche2;
	private Forme branche3;
	private Forme branche4;
	
	public Etoile(){
		
	}
	
	public Etoile(String nomForme, Forme branche1, Forme branche2, Forme branche3, Forme branche4) {
		super(nomForme);
		this.branche1 = branche1;
		this.branche2 = branche2;
		this.branche3 = branche3;
		this.branche4 = branche4;
	}
	
	public Forme getBranche1() {
		return branche1;
	}

	public void setBranche1(Forme branche1) {
		this.branche1 = branche1;
	}

	public Forme getBranche2() {
		return branche2;
	}

	public void setBranche2(Forme branche2) {
		this.branche2 = branche2;
	}

	public Forme getBranche3() {
		return branche3;
	}

	public void setBranche3(Forme branche3) {
		this.branche3 = branche3;
	}

	public Forme getBranche4() {
		return branche4;
	}

	public void setBranche4(Forme branche4) {
		this.branche4 = branche4;
	}
	
	

	@Override
	public void deplacer(int arg0, int arg1) {
		
		try {
			if (branche1 == null || branche2 == null || branche3 == null || branche4 == null) {
				throw new NullPointerException("Les formes de l'étoile n'ont pas été initialisées.");
			}
				this.branche1.deplacer(arg0, arg1);
				this.branche2.deplacer(arg0, arg1);
				this.branche3.deplacer(arg0, arg1);
				this.branche4.deplacer(arg0, arg1);

			}
			catch (NullPointerException e) {
				System.out.println("Erreur : " + e.getMessage());
			}
	}

	@Override
	public ArrayList<Segment> dessiner() {
		ArrayList<Segment> segments = new ArrayList<>();
		
		try {
		if (branche1 == null || branche2 == null || branche3 == null || branche4 == null) {
			throw new NullPointerException("Les formes de l'étoile n'ont pas été initialisées.");
		}
		
			segments.addAll(branche1.dessiner());
			segments.addAll(branche2.dessiner());
			segments.addAll(branche3.dessiner());
			segments.addAll(branche4.dessiner());
			return segments;
		}
		catch (NullPointerException e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		return segments;
	}
	
	@Override
	public String typeForme() {
		return "GF";
	}
	
	@Override
	public String toString() {
		return "Etoile [branche1=" + branche1.toString() + ", branche2=" + branche2.toString() + ", branche3=" + branche3.toString() + ", branche4=" + branche4.toString() + "]";
	}

}
