public class SearchBall extends Behaviour {
    private boolean ballFound = false;

    @Override
    public boolean activatable() {
        return true;
    }

    @Override
    public double[] calcSpeed() {
        double left = controller.calcRed() - 24100;
        return new double[]{left, 0.0};
    }

}
