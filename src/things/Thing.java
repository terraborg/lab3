package things;

import characters.Person;
import conditions.Feeling;

import java.util.Objects;

abstract public class Thing implements Sightable {
    private final String name;

    protected Thing(String name) {
        this.name = name;
    }

    @Override
    public void impress(Person person)
    {
        person.setFeeling(Feeling.NONE);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Thing thing)) return false;
        return Objects.equals(name+getClass().getName(), thing.name + thing.getClass().getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
