public class SearchBall extends Behaviour {

    @Override
    public boolean activatable() {
        return true;
    }

    @Override
    public double[] calcSpeed() {
        return new double[]{1000.0, 100.0};
    }

}
