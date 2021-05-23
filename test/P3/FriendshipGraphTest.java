package P3;

import static org.junit.Assert.*;
import org.junit.Test;

public class FriendshipGraphTest {

    @ Test
    public void GTest1() {
        FriendshipGraph graph = new FriendshipGraph();

        Person rachel = new Person("Rachel");
        Person ross = new Person("Ross");
        Person ben = new Person("Ben");
        Person kramer = new Person("Kramer");

        graph.addVertex(rachel);
        graph.addVertex(ross);
        graph.addVertex(ben);
        graph.addVertex(kramer);

        graph.addEdge(rachel, ross);
        graph.addEdge(ross, rachel);
        graph.addEdge(ross, ben);
        graph.addEdge(ben, ross);
        /*
         * System.out.println(graph.getDistance(rachel, ross));// 1
         * System.out.println(graph.getDistance(rachel, ben));// 2
         * System.out.println(graph.getDistance(rachel, rachel));// 0
         * System.out.println(graph.getDistance(rachel, kramer));// -1
         */
        assertEquals(1, graph.getDistance(rachel, ross));
        assertEquals(2, graph.getDistance(rachel, ben));
        assertEquals(0, graph.getDistance(rachel, rachel));
        assertEquals(-1, graph.getDistance(rachel, kramer));
    }

    @Test
    public void GTest2() {
        FriendshipGraph graph = new FriendshipGraph();

        Person per1 = new Person("per1");
        graph.addVertex(per1);

        Person per2 = new Person("per2");
        graph.addVertex(per2);
        //同名时出现异常
        //Person per3 = new Person("per1");
        // graph.addVertex(per3);
    }

    @Test
    public void GTest3() {
        FriendshipGraph graph = new FriendshipGraph();

        Person pa = new Person("A");
        Person pb = new Person("B");
        Person pc = new Person("C");
        Person pd = new Person("D");
        Person pe = new Person("E");
        Person pf = new Person("F");
       

        graph.addVertex(pa);
        graph.addVertex(pb);
        graph.addVertex(pc);
        graph.addVertex(pd);
        graph.addVertex(pe);
        graph.addVertex(pf);
      

        graph.addEdge(pa, pb);
        graph.addEdge(pa, pd);
        graph.addEdge(pb, pd);
        graph.addEdge(pc, pd);
        graph.addEdge(pd, pe);
        graph.addEdge(pc, pf);
       

        assertEquals(2, graph.getDistance(pa, pe));
        assertEquals(1, graph.getDistance(pa, pd));
        assertEquals(3, graph.getDistance(pb, pf));
        assertEquals(2, graph.getDistance(pd, pf));
    }


}
