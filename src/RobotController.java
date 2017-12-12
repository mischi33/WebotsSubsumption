import com.cyberbotics.webots.controller.DifferentialWheels;

public class RobotController extends DifferentialWheels {


    public static void main(String [] args) {
        Behaviour search = new SearchBall();
        Behaviour drive = new DriveToBall();
        Behaviour balance = new BalanceBall();
        Behaviour part = new PartFromBall();

        if (part.activatable()) {

        } else if (balance.activatable()) {

        } else if (drive.activatable()) {

        } else if (search.activatable()) {

        }
    }
}
