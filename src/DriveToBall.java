public class DriveToBall extends Behaviour {
    @Override
    public boolean activatable() {
        int[] colors = controller.calcColors();
        return colors[0] < 3720 || (colors[0] < 3900 && colors[1] < 1300 && colors[2] < 700);
    }

    @Override
    public double[] calcSpeed() {
        int[] colors = controller.calcColors();
        int red = colors[0];
        if (red > 3720) {
            controller.saveMove(new double[] {0, -800});
            return new double[] {0, 800};
        }
        controller.saveMove(new double[] {-800, -800});
        return new double[] {800, 800};
    }



}
