
public class PartFromBall extends Behaviour {
    @Override
    public boolean activatable() {
        if (controller.getZAccel() > 10 && controller.getZAccel() < 12) {
            return true;
        }
        return false;
    }

    @Override
    public double[] calcSpeed() {
        return new double[]{-1000, -1000};
    }
}
