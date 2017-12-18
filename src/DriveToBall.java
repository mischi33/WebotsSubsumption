public class DriveToBall extends Behaviour {
    @Override
    public boolean activatable() {
        return controller.calcRed() < 28000;
    }

    @Override
    public double[] calcSpeed() {
       return new double[] {800.0, 800.0};
    }



}
