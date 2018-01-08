public class BalanceBall extends Behaviour {


    @Override
    public boolean activatable() {
        return controller.getDistanceSensor("ps0").getValue() > 180 || controller.getDistanceSensor("ps7").getValue() > 180;
    }

    @Override
    public double[] calcSpeed() {
//    double right = controller.getDistanceSensor("ps6").getValue()
//            + controller.getDistanceSensor("ps7").getValue() -100;
//    double left = controller.getDistanceSensor("ps0").getValue()
//            + controller.getDistanceSensor("ps1").getValue()-100;
//
//        return new double[]{left, right};

        if ((controller.getDistanceSensor("ps7").getValue() > 150 && controller.getDistanceSensor("ps7").getValue() < 300) && (controller.getDistanceSensor("ps0").getValue() > 150 && controller.getDistanceSensor("ps0").getValue() < 300)) {
            controller.saveMove(new double[] {-200.0, -200.0});
            return new double[]{200, 200};
        }
        else if (controller.getDistanceSensor("ps7").getValue() > 150 && controller.getDistanceSensor("ps0").getValue() > 150) {
            controller.saveMove(new double[] {-800.0, -800.0});
            return new double[]{800, 800};
        } else if (controller.getDistanceSensor("ps1").getValue() > 150 || controller.getDistanceSensor("ps0").getValue() > 300) {
            controller.saveMove(new double[] {-1000, 0});
            return new double[]{1000, 0};
        } else if (controller.getDistanceSensor("ps6").getValue() > 150 || controller.getDistanceSensor("ps7").getValue() > 300) {
            controller.saveMove(new double[] {0, -1000.0});
            return new double[]{0, 1000};
        } else {
            controller.saveMove(new double[] {-800.0, -800.0});
            return new double[]{800, 800};
        }

    }

}
