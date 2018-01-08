import java.util.ArrayList;

public class DriveBack extends Behaviour {
    private boolean reachedWall = false;
    private int counter = 0;
    private ArrayList<double[]> moves;

    @Override
    public boolean activatable() {
        if (((controller.getZAccel() > 9.82 && controller.getYAccel() < -4) || controller.getYAccel() > 4.5 || controller.getZAccel() > 10) && controller.getZAccel() < 12 && controller.getYAccel() > -7 && controller.getZAccel() > 9.8) {
            System.out.println(controller.getYAccel());
            System.out.println(controller.getZAccel());
            reachedWall = true;
            moves = controller.getMoveList();
            counter = moves.size() - 1;
        }

        if (counter > -10 && reachedWall) {
            counter--;
            return true;
        }
        if (reachedWall && counter == -10) {
            controller.clearMoveList();
            reachedWall = false;
        }
        return false;
    }

    @Override
    public double[] calcSpeed() {

        if (counter >= 0) {
            return moves.get(counter);
        } else {
            return new double[]{1000, 100};
        }
    }
}
