package buffer;

import java.nio.CharBuffer;

public class DBuffer {
    public static void main(String[] args) {
        try {
            CharBuffer cb = CharBuffer.allocate(10);
            cb.put("H");
            cb.put("E");
            cb.put("L");
            cb.put("L");
            cb.put("O");
            String st = "";
            cb.flip();
            // System.out.println("Current position: " + cb.position());
            // System.out.println(cb.hasRemaining());
            while (cb.hasRemaining()) {
                st += cb.get();
            }
            System.out.println(st);
            System.out.println("Current position: " + cb.position());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
