import com.cyberbotics.webots.controller.Camera;
import com.cyberbotics.webots.controller.DifferentialWheels;

public class RobotController extends DifferentialWheels {
    private static RobotController controller;

    private RobotController(int sensorResponse, String... sensorNames) {
        for (String sensorName : sensorNames) {
            getDistanceSensor(sensorName).enable(sensorResponse);
        }
        getCamera(getCameraName()).enable(sensorResponse);
        getLightSensor("ls0").enable(sensorResponse);
        getLightSensor("ls1").enable(sensorResponse);
        getLightSensor("ls2").enable(sensorResponse);
        getLightSensor("ls3").enable(sensorResponse);
        getLightSensor("ls4").enable(sensorResponse);
        getLightSensor("ls5").enable(sensorResponse);
        getLightSensor("ls6").enable(sensorResponse);
        getLightSensor("ls7").enable(sensorResponse);


        this.getAccelerometer(getAccelerometerName()).enable(sensorResponse);

        this.enableEncoders(sensorResponse);
    }

    public static RobotController getInstance() {
        if (controller == null) {
            controller = new RobotController(10, "ps0", "ps1", "ps6", "ps7");
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
        int green = 0;
        int blue = 0;
        for (int i = getCameraWidth() / 3; i < 2 * getCameraWidth() / 3; i++) {
            for (int j = getCameraHeight() / 2; j < 3 * getCameraHeight() / 4; j++) {
                red += Camera.imageGetRed(image, getCameraWidth(), i, j);
                green += Camera.imageGetGreen(image, getCameraWidth(), i, j);
                blue += Camera.imageGetBlue(image, getCameraWidth(), i, j);
            }
        }
        System.out.println("RED: " + red);
        System.out.println("GREEN: " + green);
        System.out.println("BLUE: " + blue);
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
        Behaviour driveBack = new DriveBack();

        while (step(15) != -1) {

            double[] speedValues = new double[2];

            if (driveBack.activatable()) {
                System.out.println("Part from Ball.");
                speedValues = driveBack.calcSpeed();

            } else if (balanceBall.activatable()) {
                System.out.println("Balance Ball.");
                speedValues = balanceBall.calcSpeed();

            } else if (driveToBall.activatable()) {
                System.out.println("Drive to Ball.");
                speedValues = driveToBall.calcSpeed();

            } else if (searchBall.activatable()) {
                System.out.println("Search Ball.");
                speedValues =  searchBall.calcSpeed();

            }
            setSpeed(speedValues[0] > 1000 ? 1000 : speedValues[0], speedValues[1] > 1000 ? 1000 : speedValues[1]);
        }
    }
}
