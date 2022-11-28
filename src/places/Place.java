package places;

import characters.Person;
import things.Sightable;
import things.Thing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

abstract public class Place {
    public ArrayList<Person> getCharacters() {
        return characters;
    }

    ArrayList<Person> characters = new ArrayList<>();

    public Sightable[] getSightables() {
        return things;
    }

    private Thing[] things;

    public Place[] getNearPlaces() {
        return nearPlaces;
    }

    private Place[] nearPlaces;

    private final String name;

    public Place(String name, Thing... things)
    {
        this.name = name;
        this.things = things;
        nearPlaces = new Place[0];
    }

    public String getName() {
        return name;
    }

    public void setNearPlaces(Place... places)
    {
        nearPlaces = places;
    }

    public void removeCharacter(Person character)
    {
        characters.remove(character);
    }

    public void addCharacter(Person character) {
        characters.add(character);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Place place)) return false;
        return Objects.equals(name+getClass().getName(), place.name + place.getClass().getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return getClass().getName() + "{" +
                ", things=" + Arrays.toString(things) +
                ", name='" + name + '\'' +
                '}';
    }
}
