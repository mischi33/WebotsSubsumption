public class DriveBack extends Behaviour {
    private boolean reachedWall = false;

    @Override
    public boolean activatable() {

        if (controller.getZAccel() > 10 && controller.getZAccel() < 12) {
            reachedWall = true;
        }
        if (controller.getLeftEncoder() > 0 && controller.getRightEncoder() > 0 && reachedWall) {
            return true;
        }
        if (controller.getLeftEncoder() <= 0 || controller.getRightEncoder() <= 0) {
            reachedWall = false;
        }
        return false;
    }

    @Override
    public double[] calcSpeed() {
        return new double[]{-1000, -1000};
    }
}
