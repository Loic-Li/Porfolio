import java.util.ArrayList;
import ardoise.*;

public class Quadrilatere extends Forme{
	
	/* 
	 * Un quadrilatère à généralement besoin de 4 points mais c'est possible de le déssiner avec seulement 2 points,
	 * 
	 * Donc dans notre cas pointA designera le point haut gauche et pointB le point bas droit 
	 * 
	 * par la suite on aura pointC et pointD qui représentera respectivement les points bas gauche et haut droite
	 * 
	 * */
	
	private PointPlan pointA;
	private PointPlan pointB;
	
	public Quadrilatere() {
		
	}
	
	public Quadrilatere(String nomForme, PointPlan pointA, PointPlan pointB) {
		super(nomForme);
		try {
            if (pointA.getAbscisse() < 0 || pointA.getAbscisse() >= 200 || pointA.getOrdonnee() < 0 || pointA.getOrdonnee() >= 200 ||
                pointB.getAbscisse() < 0 || pointB.getAbscisse() >= 200 || pointB.getOrdonnee() < 0 || pointB.getOrdonnee() >= 200) {
                throw new IllegalArgumentException("Les points doivent être compris dans une ardoise de 200x200.");
            }

            this.pointA = pointA;
            this.pointB = pointB;
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
	}
	public PointPlan getPointA() {
		return pointA;
	}

	public void setPointA(PointPlan pointA) {
		this.pointA = pointA;
	}

	public PointPlan getPointB() {
		return pointB;
	}

	public void setPointB(PointPlan pointB) {
		this.pointB = pointB;
	}

	@Override
	public void deplacer(int arg0, int arg1) {
		this.pointA.deplacer(arg0, arg1);
		this.pointB.deplacer(arg0, arg1);
	}

	@Override
	public ArrayList<Segment> dessiner() {
		ArrayList<Segment> segments = new ArrayList<>();
		
		try {
			
	        if (pointA.getAbscisse() >= pointB.getAbscisse() || pointA.getOrdonnee() >= pointB.getOrdonnee()) {
	            throw new IllegalArgumentException("Les points A et B ne forment pas un rectangle valide.");
	        }
	        //continue si condition non remplie
	        
	        // Création des points C et D
	        PointPlan pointC = new PointPlan(pointA.getAbscisse(), pointB.getOrdonnee());
			PointPlan pointD = new PointPlan(pointB.getAbscisse(),pointA.getOrdonnee());
			
			Segment segment1 = new Segment(this.pointA, pointD);
			Segment segment2 = new Segment(this.pointA, pointC);
			Segment segment3 = new Segment(this.pointB, pointD);
			Segment segment4 = new Segment(this.pointB, pointC);
			
			//Ajoute des segments
			segments.add(segment1);
			segments.add(segment2);
			segments.add(segment3);
			segments.add(segment4);
			
			return segments;
			
	    } catch (IllegalArgumentException e) {
	        System.out.println("Erreur : " + e.getMessage());
	        return segments;  // Retourner une liste vide en cas d'exception
	    }
	}

	@Override
	public String typeForme() {
		return "Q";
	}
	

	public String toString() {
		return "Quadrilatère :" + this.getNomForme() + " pointA :" + this.getPointA() + " pointB :" + this.getPointB();
	}

}
