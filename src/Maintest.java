import clavier.In;

import java.lang.runtime.SwitchBootstraps;

public class Maintest {
    public static void main(String[] args) {

        int iClassementJoueur = 0;
        int iClassementAdversaire = 0;
        int iDifferenceClassement = 0;
        int iVictoiresPEC = 0;
        int iVictoires = 0;
        int iVictoiresMax = 0;
        int iVictoireClassement = 0;
        int iPoints = 0;
        int iPointsTotal = 0;
        String sClassement = "0";

        System.out.println("(1)NC (2)40 (3)30_5 (4)30_4 (5)30_3 (6)30_2 (7)30_1 (8)30 (9)15_5 (10)15_4");
        System.out.println("\nVeuillez saisir votre classement: ");
        iClassementJoueur = In.readInteger();


        final int NC = 1, _40 = 2, _30_5 = 3, _30_4 = 4, _30_3 = 5, _30_2 = 6, _30_1 = 7, _30 = 8, _15_5 = 9, _15_4 = 10;

        switch (iClassementJoueur) {
            case 1:
                sClassement = "NC";
                break;
            case 2:
                sClassement = "40";
                break;
            case 3:
                sClassement = "30_5";
                break;
            case 4:
                sClassement = "30_4";
                break;
            case 5:
                sClassement = "30_3";
                break;
            case 6:
                sClassement = "30_2";
                break;
            case 7:
                sClassement = "30_1";
                break;
            case 8:
                sClassement = "30";
                break;
            case 9:
                sClassement = "15_5";
                break;
            case 10:
                sClassement = "15_4";
                break;
        }


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
            System.out.println("(1)NC (2)40 (3)30_5 (4)30_4 (5)30_3 (6)30_2 (7)30_1 (8)30 (9)15_5 (10)15_4\n");
            System.out.println("Veuillez saisir le classement de votre adversaire n° " + i);
            iClassementAdversaire = In.readInteger();


            switch (iClassementAdversaire) {  //Penser à faire le calcul pour trouver la différence de classement
                case 1:
                    sClassement = "NC";
                    break;
                case 2:
                    sClassement = "40";
                    break;
                case 3:
                    sClassement = "30_5";
                    break;
                case 4:
                    sClassement = "30_4";
                    break;
                case 5:
                    sClassement = "30_3";
                    break;
                case 6:
                    sClassement = "30_2";
                    break;
                case 7:
                    sClassement = "30_1";
                    break;
                case 8:
                    sClassement = "30";
                    break;
                case 9:
                    sClassement = "15_5";
                    break;
                case 10:
                    sClassement = "15_4";
                    break;
            }


            iDifferenceClassement = iClassementAdversaire - iClassementJoueur;

            switch (iDifferenceClassement) { //remplacer par un if
                case 2:
                    iPoints = 150;
                    break;
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
                case -4:
                    iPoints = 0;
                    break;
                default:
                    System.out.println("Veuillez saisir un chiffre valide");
                    break;
            }

            iPointsTotal = iPointsTotal + iPoints;
        }
        System.out.println("Nombre de points total: " + iPointsTotal);
    }
}
