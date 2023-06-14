import java.util.ArrayList;
import ardoise.*;

public class Triangle extends Forme{
	
	private PointPlan pointA;
	private PointPlan pointB;
	private PointPlan pointC;
	
	public Triangle() {}
	
	public Triangle(String nomForme, PointPlan pointA, PointPlan pointB, PointPlan pointC) {
		super(nomForme);
		try {
			if (pointA.getAbscisse() < 0 || pointA.getAbscisse() >= 200 || pointA.getOrdonnee() < 0 || pointA.getOrdonnee() >= 200 ||
			    pointB.getAbscisse() < 0 || pointB.getAbscisse() >= 200 || pointB.getOrdonnee() < 0 || pointB.getOrdonnee() >= 200 ||
			    pointC.getAbscisse() < 0 || pointC.getAbscisse() >= 200 || pointC.getOrdonnee() < 0 || pointC.getOrdonnee() >= 200) {
				throw new IllegalArgumentException("Les points doivent être compris dans une ardoise de 200x200.");
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
		// Déplacer chaque point en fonction des points donnée en parametre
		this.pointA.deplacer(arg0, arg1);
		this.pointB.deplacer(arg0, arg1);
		this.pointC.deplacer(arg0, arg1);
	}

	@Override
	public ArrayList<Segment> dessiner() {
		ArrayList<Segment> segments = new ArrayList<>();
		
		//Créer les différents segment qui permet de faire la droite entre 2 points
		Segment segment1 = new Segment(this.pointA, this.pointB);
		Segment segment2 = new Segment(this.pointB, this.pointC);
		Segment segment3 = new Segment(this.pointA, this.pointC);
		
		try {
            // Vérification de l'alignement des points
            if ((pointB.getOrdonnee() - pointA.getOrdonnee()) * (pointC.getAbscisse() - pointA.getAbscisse())
                == (pointC.getOrdonnee() - pointA.getOrdonnee()) * (pointB.getAbscisse() - pointA.getAbscisse())) {
                throw new IllegalArgumentException("Les points A, B et C sont alignés. Impossible de dessiner le triangle.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
            return segments;  // Retourner une liste vide en cas d'exception
        }
		
		//Ajoute les segments à une liste qu'on va return
		segments.add(segment1);
		segments.add(segment2);
		segments.add(segment3);
		
		return segments;
	}

	@Override
	public String typeForme() {
		return "T";
	}
	
	public String toString() {
		return "Triangle :" + this.getNomForme() + " pointA :" + this.getPointA() + " pointB :" + this.getPointB() + " pointC : " + this.getPointC();
	}
}
