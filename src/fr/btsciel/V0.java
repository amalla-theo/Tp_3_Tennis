package fr.btsciel;

import clavier.In;

public class V0 {
    public static void main(String[] args) {

        int iClassementJoueur = 0;
        int iCapitalDepart = 0;
        int iClassementAdversaire = 0;
        int iDifferenceClassement = 0;
        int iVictoiresPEC = 0;
        int iVictoires = 0;
        int iPoints = 0;
        int iPointsTotal = 0;
        int iSeuilMontee = 0;
        int iSeuilDescente = 0;
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
        if (iVictoires < iVictoiresPEC) {
            iVictoiresPEC = iVictoires;
        }

        System.out.println("Le nombre de victoire pris en compte est de: " + iVictoiresPEC + "\n");

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
