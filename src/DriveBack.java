import java.util.ArrayList;

public class DriveBack extends Behaviour {
    private boolean reachedWall = false;
    private int driveBackValue = 300;
    private int counter = 0;
    ArrayList<double[]> getWay;

    @Override
    public boolean activatable() {

        //||(controller.getDistanceSensor("ps0").getValue()<80 && controller.getDistanceSensor("ps7").getValue() > 1900) ||(controller.getDistanceSensor("ps7").getValue()<80 && controller.getDistanceSensor("ps0").getValue() > 1900
        //if ((controller.getZAccel() > 9.82 && controller.getZAccel() < 13 && (controller.getYAccel() < -4.5 || controller.getYAccel() >4.5))) {
        if (((controller.getZAccel() > 9.82 && controller.getYAccel() < -4) || controller.getYAccel() > 4.5 || controller.getZAccel() > 10) && controller.getZAccel() < 12 && controller.getYAccel() > -7 && controller.getZAccel() > 9.8) {
            //if(!((controller.getZAccel()>=12 && controller.getZAccel()<=14) && (controller.getYAccel()<=-6 && controller.getYAccel()>=-7)) ) {
            System.out.println(controller.getYAccel());
            System.out.println(controller.getZAccel());
            reachedWall = true;
            getWay = controller.getWay();
            counter = getWay.size() - 1;

            //}
        }

        if (counter > -10 && reachedWall && controller.getDistanceSensor("ps4").getValue() < 2000 && controller.getDistanceSensor("ps3").getValue() < 2000) {
            // driveBackValue--;
            counter--;
            return true;
        }
        if (reachedWall && counter == -10 || controller.getDistanceSensor("ps4").getValue() > 2000 || controller.getDistanceSensor("ps3").getValue() > 2000) {
            //driveBackValue = 300;
            controller.deleteWay();
            System.out.println("uuppppssiiiii");
            reachedWall = false;
        }
        return false;
    }

    @Override
    public double[] calcSpeed() {

//        if (driveBackValue <= 10) {
//            return new double[]{-100, -100};
//        }
        if(counter>=0) {
            return getWay.get(counter);
        }
        else{
            return new double[]{1000,100};
        }
    }
}
