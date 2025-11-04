package fr.insee.exemple.services;

import fr.insee.exemple.model.Carburant;
import fr.insee.exemple.model.ModeleVoiture;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.*;

public class VehiculePrixServicesTest {

    private final VehiculePrixServices service = new VehiculePrixServices();

    @Nested
    @DisplayName("Tests du calcul du bonus/malus")
    public class BonusMalusTests {

        @Test
        void should_return_5000_bonus_for_electric_vehicle() {
            ModeleVoiture voiture = new ModeleVoiture("Tesla", "Model 3", Carburant.ELECTRIQUE,
                    LocalDate.of(2022, 1, 1));
            double result = service.calculerBonusMalus(voiture);
            assertThat(result).isEqualTo(5000.0);
        }

        @Test
        void should_return_2000_bonus_for_hybrid_vehicle() {
            ModeleVoiture voiture = new ModeleVoiture("Toyota", "Prius", Carburant.HYBRIDE, LocalDate.of(2020, 1, 1));
            double result = service.calculerBonusMalus(voiture);
            assertThat(result).isEqualTo(2000.0);
        }

        @Test
        void should_return_1000_malus_for_essence_before_1997() {
            ModeleVoiture voiture = new ModeleVoiture("Peugeot", "205", Carburant.ESSENCE, LocalDate.of(1995, 1, 1));
            double result = service.calculerBonusMalus(voiture);
            assertThat(result).isEqualTo(-1000.0);
        }

        @Test
        void should_not_return_malus_for_essence_after_1997() {
            ModeleVoiture voiture = new ModeleVoiture("Peugeot", "206", Carburant.ESSENCE, LocalDate.of(1998, 1, 1));
            double result = service.calculerBonusMalus(voiture);
            assertThat(result).isEqualTo(0.0);
        }

        @Test
        void should_return_2000_malus_for_diesel_before_2012() {
            ModeleVoiture voiture = new ModeleVoiture("Renault", "Laguna", Carburant.DIESEL, LocalDate.of(2010, 1, 1));
            double result = service.calculerBonusMalus(voiture);
            assertThat(result).isEqualTo(-2000.0);
        }

        @Test
        void should_not_return_malus_for_diesel_after_2012() {
            ModeleVoiture voiture = new ModeleVoiture("Renault", "Talisman", Carburant.DIESEL,
                    LocalDate.of(2015, 1, 1));
            double result = service.calculerBonusMalus(voiture);
            assertThat(result).isEqualTo(0.0);
        }

        @Test
        void should_return_0_for_gpl() {
            ModeleVoiture voiture = new ModeleVoiture("Dacia", "Sandero", Carburant.GPL, LocalDate.of(2022, 1, 1));
            double result = service.calculerBonusMalus(voiture);
            assertThat(result).isEqualTo(0.0);
        }

        @Test
        void should_throw_exception_when_modele_is_null_in_bonusMalus() {
            assertThatThrownBy(() -> service.calculerBonusMalus(null))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Le modèle ne peut pas être null");
        }
    }

    @Nested
    @DisplayName("Tests du calcul du prix total")
    public class PrixTotalTests {

        @Test
        @DisplayName("Le prix total doit inclure le bonus")
        void should_add_bonus_to_base_price() {
            ModeleVoiture voiture = new ModeleVoiture("Tesla", "Model 3", Carburant.ELECTRIQUE,
                    LocalDate.of(2022, 1, 1));
            double result = service.calculerPrixTotal(voiture, 35000.0);
            assertThat(result).isEqualTo(40000.0); // 35000 + 5000 bonus
        }

        @Test
        void should_subtract_malus_from_base_price() {
            ModeleVoiture voiture = new ModeleVoiture("Peugeot", "205", Carburant.ESSENCE, LocalDate.of(1995, 1, 1));
            double result = service.calculerPrixTotal(voiture, 3000.0);
            assertThat(result).isEqualTo(2000.0); // 3000 - 1000 malus
        }

        @Test
        void should_not_return_negative_price_even_with_big_malus() {
            ModeleVoiture voiture = new ModeleVoiture("Renault", "Laguna", Carburant.DIESEL, LocalDate.of(2010, 1, 1));
            double result = service.calculerPrixTotal(voiture, 1500.0);
            assertThat(result).isEqualTo(0.0); // 1500 - 2000 = -500 → 0
        }

        @Test
        void should_return_same_price_when_no_bonus_malus() {
            ModeleVoiture voiture = new ModeleVoiture("Dacia", "Sandero", Carburant.GPL, LocalDate.of(2020, 1, 1));
            double result = service.calculerPrixTotal(voiture, 10000.0);
            assertThat(result).isEqualTo(10000.0);
        }

        @Test
        void should_throw_exception_when_modele_is_null_in_prixTotal() {
            assertThatThrownBy(() -> service.calculerPrixTotal(null, 10000.0))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Le modèle ne peut pas être null");
        }

        @Test
        void should_throw_exception_when_price_is_negative() {
            ModeleVoiture voiture = new ModeleVoiture("Tesla", "Model 3", Carburant.ELECTRIQUE,
                    LocalDate.of(2022, 1, 1));
            assertThatThrownBy(() -> service.calculerPrixTotal(voiture, -5000.0))
                    .isInstanceOf(IllegalArgumentException.class)
                    .hasMessage("Le prix ne peut pas être négatif");
        }
    }

}
