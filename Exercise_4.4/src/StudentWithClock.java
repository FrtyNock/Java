import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentWithClock implements Learner {
    private Learner learner;

    public StudentWithClock(Learner learner) {
        this.learner = learner;
    }

    @Override
    public void learn() {
        SimpleDateFormat ft = new SimpleDateFormat("HH.mm.ss");
        learner.learn();
        Date date = new Date();
        System.out.println("Текущее время: " + ft.format(date));
    }
}
