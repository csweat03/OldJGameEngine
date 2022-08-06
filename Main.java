import me.christian.rs.RunningSim;

public class Main {

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                RunningSim.INSTANCE.init();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
