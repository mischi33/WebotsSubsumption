public class DriveToBall extends Behaviour {
    @Override
    public boolean activatable() {
        return false;
    }

    @Override
    public double[] calcSpeed() {
        return new double[0];
    }
}
