import characters.Owl;
import characters.Person;
import characters.Pooh;
import conditions.ConditionChecker;
import places.House;
import places.OutDoor;
import places.Place;

public class Main {
    public static void main(String[] args) {
        Place house = new House();
        Place outdoor = new OutDoor();
        house.setNearPlaces(outdoor);
        Person[] people = new Person[]{new Owl(house), new Pooh(house)};
        ConditionChecker checker = new ConditionChecker();
        while(true)
        {
            boolean isEnded = false;
            System.out.println("----------------------------------------------------------------");
            System.out.println();
            for(var person : people)
            {
                if(!person.act())
                    isEnded = true;
            }
            if(isEnded) {
                System.out.println("История завершилась");
                return;
            }
            for(var person : people)
                checker.checkCondition(person);
        }
    }
}