import java.util.ArrayList;
import ardoise.*;

public class Chapeau extends Forme {
	
	private PointPlan pointA;
	private PointPlan pointB;
	private PointPlan pointC;
	
	public Chapeau() {
		
	}
	
	public Chapeau(String nomForme, PointPlan pointA, PointPlan pointB, PointPlan pointC) {
		super(nomForme);
		
		try {
			if (pointA.getAbscisse() < 0 || pointA.getAbscisse() > 200 || pointA.getOrdonnee() < 0 || pointA.getOrdonnee() > 200) {
				throw new IllegalArgumentException("Le point A est en dehors des limites de l'ardoise.");
			}
			if (pointB.getAbscisse() < 0 || pointB.getAbscisse() > 200 || pointB.getOrdonnee() < 0 || pointB.getOrdonnee() > 200) {
				throw new IllegalArgumentException("Le point B est en dehors des limites de l'ardoise.");
			}
			if (pointC.getAbscisse() < 0 || pointC.getAbscisse() > 200 || pointC.getOrdonnee() < 0 || pointC.getOrdonnee() > 200) {
				throw new IllegalArgumentException("Le point C est en dehors des limites de l'ardoise.");
			}
			
			this.pointA = pointA;
			this.pointB = pointB;
			this.pointC = pointC;
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

	public PointPlan getPointC() {
		return pointC;
	}

	public void setPointC(PointPlan pointC) {
		this.pointC = pointC;
	}

	@Override
	public void deplacer(int arg0, int arg1) {
		this.pointA.deplacer(arg0, arg1);
		this.pointB.deplacer(arg0, arg1);
		this.pointC.deplacer(arg0, arg1);
	}

	@Override
	public ArrayList<Segment> dessiner() {
		ArrayList<Segment> segments = new ArrayList<>();
		
		Segment segment1 = new Segment(this.pointA, this.pointB);
		Segment segment2 = new Segment(this.pointB, this.pointC);
		
		try {
	        if ((pointB.getOrdonnee() - pointA.getOrdonnee()) * (pointC.getAbscisse() - pointA.getAbscisse())
	                == (pointC.getOrdonnee() - pointA.getOrdonnee()) * (pointB.getAbscisse() - pointA.getAbscisse())) {
	            throw new IllegalArgumentException("Les points A, B et C sont alignés. Impossible de dessiner le chapeau.");
	        }
	    } catch (IllegalArgumentException e) {
	        System.out.println("Erreur : " + e.getMessage());
	    }
		
		segments.add(segment1);
		segments.add(segment2);
		
		return segments;
	}

	@Override
	public String typeForme() {
		return "C";
	}
	
	public String toString() {
		return "Chapeau :" + this.getNomForme() + " pointA :" + this.getPointA() + " pointB :" + this.getPointB() + " pointC : " + this.getPointC();
	}
}
