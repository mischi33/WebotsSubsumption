import com.cyberbotics.webots.controller.Camera;
import com.cyberbotics.webots.controller.DifferentialWheels;
import com.cyberbotics.webots.controller.DistanceSensor;

public class RobotController extends DifferentialWheels {
    private Camera camera;
    private int height;
    private int width;
    private static RobotController controller;

    private RobotController(int sensorResponse, String... sensorNames) {
        for (String sensorName : sensorNames) {
            getDistanceSensor(sensorName).enable(sensorResponse);
        }
        camera = getCamera(getCameraName());
        camera.enable(sensorResponse);
        height = camera.getHeight();
        width = camera.getWidth();

        this.getAccelerometer(getAccelerometerName()).enable(sensorResponse);

        this.enableEncoders(sensorResponse);
    }

    public static RobotController getInstance() {
        if (controller == null) {
            controller = new RobotController(10, "ps0", "ps1", "ps2", "ps3", "ps4", "ps5", "ps6", "ps7");
            return controller;
        }
        return controller;
    }


    protected String getCameraName() {
        return "camera";
    }


    protected String getAccelerometerName() {
        return "accelerometer";
    }


    public int getCameraWidth() {
        return this.getCamera(getCameraName()).getWidth();
    }


    public int getCameraHeight() {
        return this.getCamera(getCameraName()).getHeight();
    }


    public int[] getCameraValues() {
        return this.getCamera(getCameraName()).getImage();
    }


    public double getXAccel() {
        return this.getAccelerometer(getAccelerometerName()).getValues()[0];
    }


    public double getYAccel() {
        return this.getAccelerometer(getAccelerometerName()).getValues()[1];
    }


    public double getZAccel() {
        return this.getAccelerometer(getAccelerometerName()).getValues()[2];
    }

    public double[] getEncoderValues() {
        return new double[]{this.getLeftEncoder(), this.getRightEncoder()};
    }

    public int calcRed() {
        int[] image = getCameraValues();
        int red = 0;
        for (int i = width / 3; i < 2 * width / 3; i++) {
            for (int j = height / 2; j < 3 * height / 4; j++) {
                red += Camera.imageGetRed(image, width, i, j);
            }
        }
        return red;
    }


    public static void main(String[] args) {
        RobotController controller = RobotController.getInstance();
        controller.run();

    }

    public void run() {
        Behaviour searchBall = new SearchBall();
        Behaviour driveToBall = new DriveToBall();
        Behaviour balanceBall = new BalanceBall();
        Behaviour partFromBall = new PartFromBall();

        while (step(15) != -1) {
            if (partFromBall.activatable()) {
                partFromBall.calcSpeed();
            } else if (balanceBall.activatable()) {
                balanceBall.calcSpeed();
            } else if (driveToBall.activatable()) {
                driveToBall.calcSpeed();
            } else if (searchBall.activatable()) {
                double[] speedValues =  searchBall.calcSpeed();
                setSpeed(speedValues[0], speedValues[1]);
            }
        }
    }
}
