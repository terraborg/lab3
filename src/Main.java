import characters.Owl;
import characters.Person;
import characters.Pooh;
import places.House;
import places.OutDoor;
import places.Place;

public class Main {
    public static void main(String[] args) {
        Place house = new House();
        Place outdoor = new OutDoor();
        house.setNearPlaces(outdoor);
        Person[] people = new Person[]{new Owl(house), new Pooh(house)};
        while(true)
        {
            boolean isEnded = true;
            System.out.println("----------------------------------------------------------------");
            System.out.println();
            for(var person : people)
            {
                if(person.act())
                {
                    isEnded = false;
                    person.checkCondition();
                }

            }
            if(isEnded) {
                System.out.println("История завершилась");
                return;
            }
            System.out.println();
        }
    }
}