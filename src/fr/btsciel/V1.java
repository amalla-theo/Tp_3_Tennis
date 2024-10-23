package fr.btsciel;

import clavier.In;

public class V1 {
    public static void main(String[] args) {

        int iClassementJoueur = 0, iClassementAdversaire = 0, iDifferenceClassement = 0;
        int iCapitalDepart = 0;
        int iVictoires = 0, iVictoiresPEC = 0, iBonus = 0;
        int iDefaites = 0, iDefaitesEgal = 0, iDefaitesMoinsUn = 0, iDefaitesMoinsDeux = 0;
        int iPoints = 0, iPointsTotal = 0;
        int iSeuilMontee = 0, iSeuilDescente = 0;
        String sClassement = "0";

        System.out.println("(1)NC (2)40 (3)30_5 (4)30_4 (5)30_3 (6)30_2 (7)30_1 (8)30 (9)15_5 (10)15_4");
        System.out.println("\nVeuillez saisir votre classement: ");
        iClassementJoueur = In.readInteger();


        final int NC = 1, _40 = 2, _30_5 = 3, _30_4 = 4, _30_3 = 5, _30_2 = 6, _30_1 = 7, _30 = 8, _15_5 = 9, _15_4 = 10;

        switch (iClassementJoueur) {
            case 1:
                sClassement = "NC";
                iCapitalDepart = 0;
                iSeuilMontee = 50;
                break;
            case 2:
                sClassement = "40";
                iCapitalDepart = 2;
                iSeuilMontee = 80;
                iSeuilDescente = 30;
                break;
            case 3:
                sClassement = "30_5";
                iCapitalDepart = 5;
                iSeuilMontee = 150;
                iSeuilDescente = 50;
                break;
            case 4:
                sClassement = "30_4";
                iCapitalDepart = 10;
                iSeuilMontee = 260;
                iSeuilDescente = 90;
                break;
            case 5:
                sClassement = "30_3";
                iCapitalDepart = 20;
                iSeuilMontee = 340;
                iSeuilDescente = 145;
                break;
            case 6:
                sClassement = "30_2";
                iCapitalDepart = 30;
                iSeuilMontee = 410;
                iSeuilDescente = 205;
                break;
            case 7:
                sClassement = "30_1";
                iCapitalDepart = 50;
                iSeuilMontee = 480;
                iSeuilDescente = 245;
                break;
            case 8:
                sClassement = "30";
                iCapitalDepart = 80;
                iSeuilMontee = 510;
                iSeuilDescente = 290;
                break;
            case 9:
                sClassement = "15_5";
                iCapitalDepart = 120;
                iSeuilMontee = 580;
                iSeuilDescente = 325;
                break;
            case 10:
                sClassement = "15_4";
                iCapitalDepart = 160;
                iSeuilMontee = 660;
                iSeuilDescente = 395;
                break;
        }

        System.out.println("Votre capital de départ est de: " + iCapitalDepart);

        if (sClassement.equals("NC") || sClassement.equals("40") || sClassement.equals("30_5") || sClassement.equals("30_4")) {
            iVictoiresPEC = 5;
        } else if (sClassement.equals("30_3") || sClassement.equals("30_2") || sClassement.equals("30_1") || sClassement.equals("30_1") || sClassement.equals("15_5") || sClassement.equals("15_4")) {
            iVictoiresPEC = 6;
        }

        System.out.println("\nVeuillez saisir votre nombre de victoires");
        iVictoires = In.readInteger();

        System.out.println("\nVeuillez saisir votre nombre de défaites");
        iDefaites = In.readInteger();



        for (int i = 1; i <= iDefaites; i++) {
            System.out.println("(1)NC (2)40 (3)30_5 (4)30_4 (5)30_3 (6)30_2 (7)30_1 (8)30 (9)15_5 (10)15_4");
            System.out.println("Veuillez saisir le classement de votre adversaire n° " + i);
            iClassementAdversaire = In.readInteger();

            iDifferenceClassement = iClassementAdversaire - iClassementJoueur;

            switch (iDifferenceClassement) {
                case 0:
                    iDefaitesEgal++;
                    break;
                case -1:
                    iDefaitesMoinsUn++;
                    break;
                default:
                    if (iDifferenceClassement <= -2){
                        iDefaitesMoinsDeux++;
                    }
                    break;
            }
        } //Sortie de la boucle for

        iBonus = iVictoires - iDefaitesEgal - 2*iDefaitesMoinsUn - 5*iDefaitesMoinsDeux; // formule Bonus

        if (iBonus >= 0 && iBonus <= 4) {
            iBonus = 1;
        } else if (iBonus >= 5 && iBonus <= 9) {
            iBonus = 2;
        }else if (iBonus >= 10 && iBonus <= 14) {
            iBonus = 3;
        }else if (iBonus >= 15 && iBonus <= 19) {
            iBonus = 4;
        }else if (iBonus >= 20 && iBonus <= 24) {
            iBonus = 5;
        }else if (iBonus >= 25) {
            iBonus = 6;
        }else{
            iBonus = 0;
        }


        System.out.println("Nombre de victoire pris en compte: " +iVictoiresPEC);
        System.out.println("Bonus: " + iBonus);

        iVictoiresPEC = iVictoiresPEC + iBonus;

        if (iVictoires < iVictoiresPEC) {
            iVictoiresPEC = iVictoires;
        }

        System.out.println("Nombre de victoire pris en compte après bonus: " + iVictoiresPEC + "\n");

        for (int i = 1; i <= iVictoiresPEC; i++) {
            System.out.println("(1)NC (2)40 (3)30_5 (4)30_4 (5)30_3 (6)30_2 (7)30_1 (8)30 (9)15_5 (10)15_4");
            System.out.println("Veuillez saisir le classement de votre adversaire n° " + i);
            iClassementAdversaire = In.readInteger();

            iDifferenceClassement = iClassementAdversaire - iClassementJoueur;

            switch (iDifferenceClassement) { //Le mélange switch/if semble être la meilleure option
                case 1:
                    iPoints = 100;
                    break;
                case 0:
                    iPoints = 50;
                    break;
                case -1:
                    iPoints = 30;
                    break;
                case -2:
                    iPoints = 20;
                    break;
                case -3:
                    iPoints = 15;
                    break;
                default:
                    if (iDifferenceClassement >= 2) {
                        iPoints = 150;
                    }if (iDifferenceClassement <= -4) {
                    iPoints = 0;
                }
                    break;
            }

            iPointsTotal = iPointsTotal + iPoints;
            System.out.println("Nombre de points: " + iPoints + "\n");
        } //Sortie de la boucle for
        iPointsTotal = iPointsTotal + iCapitalDepart;
        System.out.println("Nombre de points total: " + iPointsTotal);

        if (iPointsTotal >= iSeuilMontee) {
            System.out.println("Vous montez dans le classement");
        }else{ if (iPointsTotal <= iSeuilDescente) {
            System.out.println("Vous descendez dans le classement");
        }else System.out.printf("Vous restez dans votre catégorie");}

    } // FIN public static void main(String[] args)

}
