import ardoise.*;


public class TestArdoise {
	
    public static void main(String[] args) throws InterruptedException{
        Ardoise ardoise = new Ardoise();
        
        
        //Les oiseaux ----------------------------------------------------------------------------------------------------
        PointPlan p1 = new PointPlan(118,13);
        PointPlan p2 = new PointPlan(123,20);
        PointPlan p3 = new PointPlan(128,13);

        Forme oiseau1 = new Chapeau("oiseau 1", p1, p2, p3);
        oiseau1.dessiner();
        ardoise.ajouterForme(oiseau1);
        
        PointPlan p4 = new PointPlan(133,30);
        PointPlan p5 = new PointPlan(136, 32);
        PointPlan p6 = new PointPlan(138,30);
        
        
        Forme oiseau2 = new Chapeau("oiseau 2", p4, p5, p6);
        oiseau2.dessiner();
        ardoise.ajouterForme(oiseau2);
        
        PointPlan p7 = new PointPlan(142,14);
        PointPlan p8 = new PointPlan(144,17);
        PointPlan p9 = new PointPlan(146,14);

        Forme oiseau3 = new Chapeau("oiseau 3", p7, p8, p9);
        oiseau3.dessiner();
        ardoise.ajouterForme(oiseau3);
        
        //La tour ----------------------------------------------------------------------------------------------------
        
        PointPlan t4 = new PointPlan(9,100);
        PointPlan t5 = new PointPlan(20,198);
        
        Forme tour = new Quadrilatere("tour", t4, t5);
        ardoise.ajouterForme(tour);
        tour.dessiner();
        
        //Les montagnes  ----------------------------------------------------------------------------------------------
        
        PointPlan m1 = new PointPlan(3,14);
        PointPlan m2 = new PointPlan(43,3);
        PointPlan m3 = new PointPlan(112,14);
        
        Forme montagne1 = new Triangle("Montage 1", m1, m2, m3);
        ardoise.ajouterForme(montagne1);
        montagne1.dessiner();
      
        
        PointPlan m4 = new PointPlan(152,7);
        PointPlan m5 = new PointPlan(166,3);
        PointPlan m6 = new PointPlan(172,7);
        
        Forme montagne2 = new Triangle("Montage 2", m4, m5, m6);
        ardoise.ajouterForme(montagne2);
        montagne2.dessiner();
        
        
        //L'étoile ------------------------------------------------------------------------------------------------------
        
        PointPlan e1 = new PointPlan(170,52);
        PointPlan e2 = new PointPlan(173,45);
        PointPlan e3 = new PointPlan(177,52);
        Forme etoileb1 = new Chapeau("Etoile branche 1", e1, e2, e3);

        
        
        PointPlan e4 = new PointPlan(177,52);
        PointPlan e5 = new PointPlan(184,57);
        PointPlan e6 = new PointPlan(177,60);
        Forme etoileb2 = new Chapeau("Etoile branche 2", e4, e5, e6);

        
        
        PointPlan e7 = new PointPlan(177,60);
        PointPlan e8 = new PointPlan(174,66);
        PointPlan e9 = new PointPlan(170,60);
        Forme etoileb3 = new Chapeau("Etoile branche 3", e7, e8, e9);

        
        
        PointPlan e10 = new PointPlan(170,60);
        PointPlan e11 = new PointPlan(164,57);
        PointPlan e12 = new PointPlan(170,52);
        Forme etoileb4 = new Chapeau("Etoile branche 4", e10, e11, e12);
        
        
        Forme etoile = new Etoile("Une étoile", etoileb1, etoileb2, etoileb3, etoileb4);
        ardoise.ajouterForme(etoile);
        etoile.dessiner();
        
        //La maison ----------------------------------------------------------------------------------------------------
        
        PointPlan t1 = new PointPlan(80,140);
        PointPlan t2 = new PointPlan(130,100);
        PointPlan t3 = new PointPlan(180,140);
        Forme toit = new Chapeau("Toit Maison", t1, t2, t3);
        
        PointPlan p10 = new PointPlan(120,170);
        PointPlan p11 = new PointPlan(140,198);
        Forme porte = new Quadrilatere("porte", p10, p11);
        
        
        PointPlan c1 = new PointPlan(80,140);
        PointPlan c2 = new PointPlan(180,198);
        Forme corps = new Quadrilatere("corps maison", c1, c2);
        
        
        Forme maison = new Maison("maison 1", corps, porte, toit);
        maison.dessiner();
        ardoise.ajouterForme(maison);
        System.out.println(maison.toString());

        //-------------------------------------------------------------------------------------------------------------

        ardoise.dessinerGraphique();
        
       while(true) {
        	Thread.sleep(1000);
            ardoise.deplacer("", 0, 0);
            oiseau1.deplacer(1, 0);
            oiseau2.deplacer(1, 0);
            oiseau3.deplacer(1, 0);
       	
        }
        
    }
}