import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TestClass {
    @Test
    public void checkListsOfIncludeAndExclude() {
        String[] arrOfPaths = new String[]{
                "\\epbyminsd0235\\Video Materials",
                "\\EPUALVISA0002.kyiv.com\\Workflow\\ORG\\Employees\\Special",
                "\\EPUALVISA0002.kyiv.com\\Workflow\\ORG\\Employees\\Lviv",
                "C:\\Windows",
                "C:\\file\\innerfile",
                "-",
                "\\epbyminsd0235\\Video Materials\\someInnerFile",
                "\\EPUALVISA0002.kyiv.com\\Workflow\\ORG\\Employees\\Special\\innerFolder",
                "\\EPUALVISA0002.kyiv.com\\Workflow\\ORG\\Employees\\Lviv\\123",
                "C:\\Windows\\file"
        };
        ServiceSplitter serviceSplitter = new ServiceSplitter(arrOfPaths);
        assertEquals(serviceSplitter.setIncludePaths.size(), 5);
        assertEquals(ServiceSplitter.setExcludePaths.size(), 4);
    }

    @Test
    public void checkOrderOfEntities() {
        List<Entity> list = new ArrayList<>();
        Entity first = new Entity("Alex", 124l, new Date());
        Entity second = new Entity("Boris", 777l, new Date());
        Entity third = new Entity("Denis", 234l, new Date());
        list.add(second);
        list.add(third);
        list.add(first);
        Collections.sort(list);
        assertEquals(list.indexOf(first), 0);
        assertEquals(list.indexOf(second), 1);
        assertEquals(list.indexOf(third), 2);
    }

    @Test
    public void checkUniqueness() {
        String[] arr = {"C:\\file",
                "C:\\file2",
                "C:\\file3",
                "C:\\file4",
                "C:\\file3",
                "C:\\file2"
        };
        ServiceSplitter serviceSplitter = new ServiceSplitter(arr);
        assertEquals(serviceSplitter.setIncludePaths.size(), 4);
    }
}
