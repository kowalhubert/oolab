//package agh.ics.oop;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class AnimalTest {
//
//    @Test
//    void moveTest() {
//        Animal zbigniew_frog = new Animal();
//        assertEquals("Północ, (2,2)", zbigniew_frog.toString());
//        Object[] Moves = new Object[]{MoveDirection.FORWARD,MoveDirection.FORWARD,MoveDirection.RIGHT,MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.FORWARD,MoveDirection.RIGHT,MoveDirection.RIGHT,MoveDirection.FORWARD,MoveDirection.LEFT,MoveDirection.BACKWARD};
//        String[] result={"Północ, (2,3)","Północ, (2,4)","Wschód, (2,4)","Wschód, (3,4)","Północ, (3,4)","Północ, (3,4)", "Wschód, (3,4)", "Południe, (3,4)", "Południe, (3,3)", "Wschód, (3,3)","Wschód, (2,3)"};
//        for (int i=0;i<result.length;i++){
//            zbigniew_frog.move((MoveDirection) Moves[i]);
//            assertEquals(result[i],zbigniew_frog.toString());
//        }
//    }
//}