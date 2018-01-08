public class DriveToBall extends Behaviour {
    @Override
    public boolean activatable() {
        return controller.calcRed() < 3700;
    }

    @Override
    public double[] calcSpeed() {
        controller.saveMove(new double[] {-800.0, -800.0});
        return new double[] {800.0, 800.0};
    }



}
