public abstract class Behaviour {
    protected RobotController controller;

    public Behaviour() {
        controller = RobotController.getInstance();
    }


    public abstract boolean activatable();

    public abstract double[] calcSpeed();
}
