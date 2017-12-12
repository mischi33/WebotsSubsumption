import com.cyberbotics.webots.controller.DifferentialWheels;

public class RobotController extends DifferentialWheels {


    public static void main(String [] args) {
        RobotController controller = new RobotController();
        controller.run();

    }

    public void run(){
        while (step(15) != -1) {
            Behaviour searchBall = new SearchBall();
            Behaviour driveToBall = new DriveToBall();
            Behaviour balanceBall = new BalanceBall();
            Behaviour partFromBall = new PartFromBall();

            if (partFromBall.activatable()) {

            } else if (balanceBall.activatable()) {

            } else if (driveToBall.activatable()) {

            } else if (searchBall.activatable()) {

            }
        }
    }
}
