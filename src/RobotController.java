import com.cyberbotics.webots.controller.Camera;
import com.cyberbotics.webots.controller.DifferentialWheels;

public class RobotController extends DifferentialWheels {
    private Camera camera;
    private int height;
    private int width;

    public RobotController(int sensorResponse) {

        camera = getCamera(getCameraName());
        camera.enable(sensorResponse);
        height = camera.getHeight();
        width = camera.getWidth();

        this.getAccelerometer(getAccelerometerName()).enable(sensorResponse);

        this.enableEncoders(sensorResponse);
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

    private int calcRed() {
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
        RobotController controller = new RobotController(10);
        controller.run();

    }

    public void run() {
        while (step(15) != -1) {
            Behaviour searchBall = new SearchBall();
            Behaviour driveToBall = new DriveToBall();
            Behaviour balanceBall = new BalanceBall();
            Behaviour partFromBall = new PartFromBall();

            if (partFromBall.activatable()) {

            } else if (balanceBall.activatable()) {

            } else if (driveToBall.activatable()) {

            } else if (searchBall.activatable()) {

            }
        }
    }
}
