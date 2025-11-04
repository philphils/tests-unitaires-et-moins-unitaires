package fr.insee.exemple.services;

import java.time.LocalDate;
import fr.insee.exemple.model.ModeleVoiture;
import fr.insee.exemple.model.Carburant;

public class VehiculePrixServices {
    private static final double BONUS_ELECTRIQUE = 5000.0;
    private static final double BONUS_HYBRIDE = 2000.0;
    private static final double MALUS_ESSENCE_ANCIEN = 1000.0;
    private static final double MALUS_DIESEL_ANCIEN = 2000.0;

    /**
     * Calcule le bonus/malus écologique pour un modèle de voiture.
     * Les règles sont les suivantes :
     * - Véhicules électriques : bonus de 5000€
     * - Véhicules hybrides : bonus de 2000€
     * - Véhicules essence avant 1997 : malus de 1000€
     * - Véhicules diesel avant 2012 : malus de 2000€
     * - Autres cas : pas de bonus/malus
     *
     * @param modele le modèle de voiture
     * @return le montant du bonus (positif) ou du malus (négatif)
     * @throws IllegalArgumentException si le modèle est null
     */
    public double calculerBonusMalus(ModeleVoiture modele) {
        if (modele == null) {
            throw new IllegalArgumentException("Le modèle ne peut pas être null");
        }

        Carburant carburant = modele.getCarburant();
        LocalDate dateConstruction = modele.getAnneeConstruction();

        if (carburant == Carburant.ELECTRIQUE) {
            return BONUS_ELECTRIQUE;
        }
        
        if (carburant == Carburant.HYBRIDE) {
            return BONUS_HYBRIDE;
        }

        if (carburant == Carburant.ESSENCE && dateConstruction.getYear() <= 1997) {
            return -MALUS_ESSENCE_ANCIEN;
        }

        if (carburant == Carburant.DIESEL && dateConstruction.getYear() <= 2012) {
            return -MALUS_DIESEL_ANCIEN;
        }

        return 0.0;
    }

    /**
     * Calcule le prix total d'un véhicule en tenant compte du bonus/malus écologique.
     *
     * @param modele le modèle de voiture
     * @param prixBase le prix de base du véhicule
     * @return le prix total incluant le bonus/malus
     * @throws IllegalArgumentException si le modèle est null ou si le prix est négatif
     */
    public double calculerPrixTotal(ModeleVoiture modele, double prixBase) {
        if (modele == null) {
            throw new IllegalArgumentException("Le modèle ne peut pas être null");
        }
        if (prixBase < 0) {
            throw new IllegalArgumentException("Le prix ne peut pas être négatif");
        }

        double bonusMalus = calculerBonusMalus(modele);
        return Math.max(0, prixBase + bonusMalus);
    }
}