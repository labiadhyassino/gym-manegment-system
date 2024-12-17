package Model.GestionSalle;

/**
 * Exception personnalisée pour la classe SalleFiliale.
 */
public class SalleNonDisponibleException extends Exception {

    /**
     * Constructeur de l'exception avec un message personnalisé.
     *
     * @param message Le message d'erreur à afficher.
     */
    public SalleNonDisponibleException(String message) {
        super(message);
    }
}
