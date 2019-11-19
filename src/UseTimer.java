import java.util.Timer;
import java.util.TimerTask;
class Matier{

}
public class UseTimer {
    private static class Mytimer extends TimerTask {
        @Override
        public void run() {
            System.out.println("10秒到了");
        }
    }
    public static void main(String[] args) {
        Timer timer=new Timer();
        timer.schedule(new Mytimer(),10*1000);
        timer.scheduleAtFixedRate(new Mytimer(),1000,3000);
    }
}
