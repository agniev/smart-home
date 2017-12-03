import org.junit.jupiter.api.Test;
import ru.sbt.mipt.oop.entities.SmartHome;
import ru.sbt.mipt.oop.entities.Door;
import ru.sbt.mipt.oop.entities.Light;
import ru.sbt.mipt.oop.entities.Room;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Roman on 01.12.2017.
 */
public class TestComposite {
    @Test
    public void testActionableComposite(){
        List<Light> lights1 = Arrays.asList(new Light("1", false), new Light("2", false));
        List<Door> doors1 =Arrays.asList(new Door(false, "1"));
        Room kitchen = new Room(lights1, doors1, "kitchen");
        List<Light> lights2 = Arrays.asList(new Light("3", true));
        List<Door> doors2 =Arrays.asList(new Door(false, "2"));
        Room bathroom = new Room(lights2, doors2, "bathroom");
        SmartHome smartHome = new SmartHome(Arrays.asList(kitchen,bathroom));
        Set<Object> unvisitedObjects = new HashSet<>();
        unvisitedObjects.add(smartHome);
        unvisitedObjects.add(kitchen);
        unvisitedObjects.add(bathroom);
        unvisitedObjects.addAll(lights1);
        unvisitedObjects.addAll(lights2);
        smartHome.executeAction(obj -> {
            unvisitedObjects.remove(obj);
        });
        assertEquals(0, unvisitedObjects.size());
    }

}
