package things;

import characters.Person;
import conditions.Feeling;

public class Lace extends Thing{
    public Lace() {
        super("Шнурок");
    }

    @Override
    public void impress(Person person) {
        person.setFeeling(Feeling.DEJAVU);
    }
}
