public class BalanceBall extends Behaviour {


    @Override
    public boolean activatable() {
        return controller.getDistanceSensor("ps0").getValue() > 180 || controller.getDistanceSensor("ps7").getValue() > 180;
    }

    @Override
    public double[] calcSpeed() {
        if ((controller.getDistanceSensor("ps7").getValue() > 150 && controller.getDistanceSensor("ps7").getValue() < 300) && (controller.getDistanceSensor("ps0").getValue() > 150 && controller.getDistanceSensor("ps0").getValue() < 300)) {
            controller.saveMove(new double[] {-200.0, -200.0});
            return new double[]{200, 200};
        }
        else if (controller.getDistanceSensor("ps7").getValue() > 150 && controller.getDistanceSensor("ps0").getValue() > 150) {
            controller.saveMove(new double[] {-1000.0, -1000.0});
            return new double[]{1000, 1000};
        } else if (controller.getDistanceSensor("ps1").getValue() > 150 || controller.getDistanceSensor("ps0").getValue() > 300) {
            controller.saveMove(new double[] {-1000, 0});
            return new double[]{1000, 0};
        } else if (controller.getDistanceSensor("ps6").getValue() > 150 || controller.getDistanceSensor("ps7").getValue() > 300) {
            controller.saveMove(new double[] {0, -1000.0});
            return new double[]{0, 1000};
        } else {
            controller.saveMove(new double[] {-1000.0, -1000.0});
            return new double[]{1000, 1000};
        }

    }

}
