public class BalanceBall extends Behaviour {
    @Override
    public boolean activatable() {
        return controller.getDistanceSensor("ps0").getValue() > 180 || controller.getDistanceSensor("ps7").getValue() > 180;
    }

    @Override
    public double[] calcSpeed() {
    double right = controller.getDistanceSensor("ps6").getValue()
            + controller.getDistanceSensor("ps7").getValue();
    double left = controller.getDistanceSensor("ps0").getValue()
            + controller.getDistanceSensor("ps1").getValue();

        return new double[]{left, right};
    }
}
