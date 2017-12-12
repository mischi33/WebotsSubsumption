public class SearchBall extends Behaviour{
    @Override
    public boolean activatable() {
        return true;
    }

    @Override
    public double[] calcSpeed() {

        return new double[0];
    }


//    private int calcRed() {
//        int[] image = camera.getImage();
//        int red = 0;
//        for (int i = width / 3; i < 2 * width / 3; i++) {
//            for (int j = height / 2; j < 3 * height / 4; j++) {
//                red += Camera.imageGetRed(image, width, i, j);
//            }
//        }
//        return red;
//    }
}
