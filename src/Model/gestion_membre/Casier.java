package Model.gestion_membre;

import java.util.function.*;

public final class Casier {
    private int idCasier = 0;
    private int idMembre;
    private int num = 0;
    private boolean occupation;
    private int codeAcces;

    // Constructeur
    public Casier(int id, int idMembre, int num, boolean occupation, int codeAcces) {
        this.idCasier = id;
        this.idMembre = idMembre;
        this.num = num;
        this.occupation = occupation;
        this.codeAcces = codeAcces;
    }

    // Lambda pour réserver un casier
    public final BiFunction<Integer, Integer, Boolean> reserverCasier = (idMembre, codeAcces) -> {
        if (!occupation) {
            this.idMembre = idMembre;
            this.occupation = true;
            return true;
        }
        return false;
    };

    // Lambda pour libérer un casier
    public final Runnable libererCasier = () -> {
        this.idMembre = 0;
        this.occupation = false;
    };

    // Lambda pour vérifier si le casier est occupé
    public final Supplier<Boolean> estOccupe = () -> occupation;

    // Getters (lambdas pour accéder aux attributs finals)
    public final Supplier<Integer> getIdCasier = () -> idCasier;
    public final Supplier<Integer> getIdMembre = () -> idMembre;
    public final Supplier<Integer> getNum = () -> num;
    public final Supplier<Integer> getCodeAcces = () -> codeAcces;

    // Setter pour codeAcces (avec Consumer)
    public final Consumer<Integer> setCodeAcces = newCode -> this.codeAcces = newCode;
}
