public class DriveBack extends Behaviour {
    private boolean reachedWall = false;
    private int driveBackValue=400;

    @Override
    public boolean activatable() {

        if (controller.getZAccel() > 10 && controller.getZAccel() < 10.9 && !reachedWall) {
            System.out.println(controller.getZAccel());
            reachedWall = true;
        }

        if (driveBackValue > 0 && reachedWall) {
            driveBackValue--;
            return true;
        }
        if (driveBackValue <= 0 ) {
            driveBackValue=400;
            reachedWall = false;
        }
        return false;
    }

    @Override
    public double[] calcSpeed() {
        return new double[]{-970, -1000};
    }
}
