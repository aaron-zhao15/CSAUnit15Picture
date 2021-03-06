package picture;

/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 *
 * @author Barbara Ericson
 */
public class PictureTester {

    public static void test() {
        Picture temple = new Picture("redMotorcycle.jpg");
        temple.explore();
    }

    /**
     * Method to test zeroBlue
     */
    public static void testZeroBlue() {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

    public static void testKeepOnlyBlue() {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.keepOnlyBlue();
        beach.explore();
    }

    public static void testNegate() {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.negate();
        beach.explore();
    }

    public static void testGrayscale() {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        beach.grayscale();
        beach.explore();
    }

    public static void testFixUnderwater() {
        Picture beach = new Picture("water.jpg");
        beach.explore();
        beach.fixUnderwater();
        beach.explore();
    }

    /**
     * Method to test mirrorVertical
     */
    public static void testMirrorVertical() {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorVertical();
        caterpillar.explore();
    }

    public static void testMirrorVerticalRightToLeft() {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorVerticalRightToLeft();
        caterpillar.explore();
    }

    public static void testMirrorHorizontalTopToBottom() {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorHorizontalTopToBottom();
        caterpillar.explore();
    }

    public static void testMirrorHorizontalBottomToTop() {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorHorizontalBottomToTop();
        caterpillar.explore();
    }

    /**
     * Method to test mirrorTemple
     */
    public static void testMirrorTemple() {
        Picture temple = new Picture("temple.jpg");
        temple.explore();
        temple.mirrorTemple();
        temple.explore();
    }

    public static void testMirrorArms() {
        Picture temple = new Picture("snowman.jpg");
        temple.explore();
        temple.mirrorArms();
        temple.explore();
    }

    public static void testMirrorDiagonal() {
        Picture temple = new Picture("beach.jpg");
        temple.explore();
        temple.mirrorDiagonal();
        temple.explore();
    }

    public static void testMirrorGull() {
        Picture temple = new Picture("seagull.jpg");
        temple.explore();
        temple.mirrorGull();
        temple.explore();
    }

    public static void testCopyTwo() {
        Picture first = new Picture("seagull.jpg");
        Picture second = new Picture("snowman.jpg");
        first.explore();
        first.copyTwo(second, 78, 298, 102, 295, 170, 387);
        first.explore();
    }

    public static void testMyCollage() {
        Picture first = new Picture("seagull.jpg");
        first.explore();
        first.myCollage();
        first.explore();
    }

    /**
     * Method to test the collage method
     */
    public static void testCollage() {
        Picture canvas = new Picture("640x480.jpg");
        canvas.createCollage();
        canvas.explore();
    }

    /**
     * Method to test edgeDetection
     */
    public static void testEdgeDetection() {
        Picture swan = new Picture("swan.jpg");
        swan.explore();
        swan.edgeDetection(10);
        swan.explore();
    }

    public static void testEdgeDetection2() {
        Picture swan = new Picture("swan.jpg");
        swan.explore();
        swan.edgeDetectionTwo(10);
        swan.explore();
    }

    public static void testBlur(int x, int y, int w, int h, int n) {
        Picture redMoto = new Picture("redMotorcycle.jpg");
        redMoto.explore();
        for (int i = 0; i < n; i++) {
            redMoto.blur(x, y, w, h);
        }
        redMoto.explore();
    }

    /**
     * Main method for testing. Every class can have a main method in Java
     */
    public static void main(String[] args) {
        // uncomment a call here to run a test
        // and comment out the ones you don't want
        // to run
        test();
//        testZeroBlue();
//        testKeepOnlyBlue();
        //testKeepOnlyRed();
        //testKeepOnlyGreen();
//        testNegate();
//        testGrayscale();
//        testFixUnderwater();
//        testMirrorVertical();
//        testMirrorVerticalRightToLeft();
//        testMirrorHorizontalTopToBottom();
//        testMirrorHorizontalBottomToTop();
//        testMirrorTemple();
//        testMirrorArms();
//        testMirrorGull();
//        testMirrorDiagonal();
//        testCollage();
//        testCopy();
//        testCopyTwo();
//        testMyCollage();
//        testEdgeDetection();
//        testEdgeDetection2();
        testBlur(158, 184, 23, 23, 10);
        //testChromakey();
        //testEncodeAndDecode();
        //testGetCountRedOverValue(250);
        //testSetRedToHalfValueInTopHalf();
        //testClearBlueOverValue(200);
        //testGetAverageForColumn(0);
    }
}
