package picture;

import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List

/**
 * A class that represents a picture. This class inherits from SimplePicture and
 * allows the student to add functionality to the Picture class.
 *
 * @author Barbara Ericson ericson@cc.gatech.edu
 */
public class Picture extends SimplePicture {
    ///////////////////// constructors //////////////////////////////////

    /**
     * Constructor that takes no arguments
     */
    public Picture() {
        /* not needed but use it to show students the implicit call to super()
     * child constructors always call a parent constructor 
         */
        super();
    }

    /**
     * Constructor that takes a file name and creates the picture
     *
     * @param fileName the name of the file to create the picture from
     */
    public Picture(String fileName) {
        // let the parent class handle this fileName
        super(fileName);
    }

    /**
     * Constructor that takes the width and height
     *
     * @param height the height of the desired picture
     * @param width the width of the desired picture
     */
    public Picture(int height, int width) {
        // let the parent class handle this width and height
        super(width, height);
    }

    /**
     * Constructor that takes a picture and creates a copy of that picture
     *
     * @param copyPicture the picture to copy
     */
    public Picture(Picture copyPicture) {
        // let the parent class do the copy
        super(copyPicture);
    }

    /**
     * Constructor that takes a buffered image
     *
     * @param image the buffered image to use
     */
    public Picture(BufferedImage image) {
        super(image);
    }

    ////////////////////// methods ///////////////////////////////////////
    /**
     * Method to return a string with information about this picture.
     *
     * @return a string with information about the picture such as fileName,
     * height and width.
     */
    public String toString() {
        String output = "Picture, filename " + getFileName()
                + " height " + getHeight()
                + " width " + getWidth();
        return output;

    }

    /**
     * Method to set the blue to 0
     */
    public void zeroBlue() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setBlue(0);
            }
        }
    }

    public void keepOnlyBlue() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setRed(0);
                pixelObj.setGreen(0);
            }
        }
    }

    public void negate() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setRed(255 - pixelObj.getRed());
                pixelObj.setGreen(255 - pixelObj.getGreen());
                pixelObj.setBlue(255 - pixelObj.getBlue());
            }
        }
    }

    public void grayscale() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setRed((pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3);
                pixelObj.setGreen((pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3);
                pixelObj.setBlue((pixelObj.getRed() + pixelObj.getGreen() + pixelObj.getBlue()) / 3);
            }
        }
    }

    public void fixUnderwater() {
        Pixel[][] pixels = this.getPixels2D();
        for (Pixel[] rowArray : pixels) {
            for (Pixel pixelObj : rowArray) {
                pixelObj.setGreen(pixelObj.getGreen() - 100);
                pixelObj.setBlue(pixelObj.getBlue() - 100);
            }
        }
    }

    /**
     * Method that mirrors the picture around a vertical mirror in the center of
     * the picture from left to right
     */
    public void mirrorVertical() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < width / 2; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    public void mirrorVerticalRightToLeft() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = width / 2; col < width; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][width - 1 - col];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
    }

    public void mirrorHorizontalTopToBottom() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int width = pixels[0].length;
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < getHeight() / 2; row++) {
                topPixel = pixels[row][col];
                bottomPixel = pixels[getHeight() - 1 - row][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

    public void mirrorHorizontalBottomToTop() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int width = pixels[0].length;
        for (int col = 0; col < width; col++) {
            for (int row = getHeight() / 2; row < getHeight(); row++) {
                topPixel = pixels[row][col];
                bottomPixel = pixels[getHeight() - 1 - row][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

    /**
     * Mirror just part of a picture of a temple
     */
    public void mirrorTemple() {
        int mirrorPoint = 276;
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        // loop through the rows
        for (int row = 27; row < 97; row++) {
            // loop from 13 to just before the mirror point
            for (int col = 13; col < mirrorPoint; col++) {
                count++;
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                rightPixel.setColor(leftPixel.getColor());
            }
        }
        System.out.println(count);
    }

    public void mirrorArms() {
        int mirrorPoint = 195;
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        for (int col = 104; col < 294; col++) {
            for (int row = 160; row < mirrorPoint; row++) {
                count++;
                topPixel = pixels[row][col];
                bottomPixel = pixels[mirrorPoint - row + mirrorPoint][col];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
        System.out.println(count);
    }

    public void mirrorDiagonal() {
        Pixel[][] pixels = this.getPixels2D();
        Pixel firstPixel = null;
        Pixel secondPixel = null;
        int width = pixels[0].length;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < row; col++) {
                firstPixel = pixels[row][col];
                secondPixel = pixels[col][row];
                secondPixel.setColor(firstPixel.getColor());
            }
        }
    }

    public void mirrorGull() {
        int mirrorPoint = 348;
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        int count = 0;
        Pixel[][] pixels = this.getPixels2D();

        for (int row = 232; row < 324; row++) {
            for (int col = 236; col < mirrorPoint; col++) {
                count++;
                topPixel = pixels[row][col];
                bottomPixel = pixels[row][mirrorPoint - col + mirrorPoint];
                bottomPixel.setColor(topPixel.getColor());
            }
        }
    }

    /**
     * copy from the passed fromPic to the specified startRow and startCol in
     * the current picture
     *
     * @param fromPic the picture to copy from
     * @param startRow the start row to copy to
     * @param startCol the start col to copy to
     */
    public void copy(Picture fromPic,
            int startRow, int startCol) {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int fromRow = 0, toRow = startRow;
                fromRow < fromPixels.length
                && toRow < toPixels.length;
                fromRow++, toRow++) {
            for (int fromCol = 0, toCol = startCol;
                    fromCol < fromPixels[0].length
                    && toCol < toPixels[0].length;
                    fromCol++, toCol++) {
                fromPixel = fromPixels[fromRow][fromCol];
                toPixel = toPixels[toRow][toCol];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }

    public void copyTwo(Picture fromPic,
            int startRow, int endRow, int startCol, int endCol,
            int toRow, int toCol) {
        Pixel fromPixel = null;
        Pixel toPixel = null;
        Pixel[][] toPixels = this.getPixels2D();
        Pixel[][] fromPixels = fromPic.getPixels2D();
        for (int initRow = startRow, toRowIndex = 0;
                initRow < endRow && toRowIndex + toRow < toPixels.length;
                initRow++, toRowIndex++) {
            for (int initCol = startCol, toColIndex = 0;
                    initCol < endCol && toColIndex + toCol < toPixels[0].length;
                    initCol++, toColIndex++) {
                fromPixel = fromPixels[initRow][initCol];
                toPixel = toPixels[toRow + toRowIndex][toCol + toColIndex];
                toPixel.setColor(fromPixel.getColor());
            }
        }
    }
    
    public void myCollage(){
        mirrorDiagonal();
        mirrorGull();
        copyTwo(new Picture("snowman.jpg"), 78, 298, 102, 295, 270, 387);
        copyTwo(new Picture("seagull.jpg"), 233, 323, 234, 355, 329, 72);
        copyTwo(new Picture("kitten2.jpg"), 81, 203, 116, 354, 365, 240);
    }

    /**
     * Method to create a collage of several pictures
     */
    public void createCollage() {
        Picture flower1 = new Picture("flower1.jpg");
        Picture flower2 = new Picture("flower2.jpg");
        this.copy(flower1, 0, 0);
        this.copy(flower2, 100, 0);
        this.copy(flower1, 200, 0);
        Picture flowerNoBlue = new Picture(flower2);
        flowerNoBlue.zeroBlue();
        this.copy(flowerNoBlue, 300, 0);
        this.copy(flower1, 400, 0);
        this.copy(flower2, 500, 0);
        this.mirrorVertical();
        this.write("collage.jpg");
    }

    /**
     * Method to show large changes in color
     *
     * @param edgeDist the distance for finding edges
     */
    public void edgeDetection(int edgeDist) {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0;
                    col < pixels[0].length - 1; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col + 1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor)
                        > edgeDist) {
                    leftPixel.setColor(Color.BLACK);
                } else {
                    leftPixel.setColor(Color.WHITE);
                }
            }
        }
    }
    
    public void edgeDetectionTwo(int edgeDist) {
        Pixel leftPixel = null;
        Pixel rightPixel = null;
        Pixel topPixel = null;
        Pixel bottomPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color rightColor = null;
        Color bottomColor = null;
        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[0].length - 1; col++) {
                leftPixel = pixels[row][col];
                rightPixel = pixels[row][col + 1];
                rightColor = rightPixel.getColor();
                if (leftPixel.colorDistance(rightColor)
                        > edgeDist) {
                    leftPixel.setColor(Color.BLACK);
                } else {
                    leftPixel.setColor(Color.WHITE);
                }
            }
        }
        for (int col = 0; col < pixels[0].length; col++) {
            for (int row = 0; row < pixels.length - 1; row++) {
                topPixel = pixels[row][col];
                bottomPixel = pixels[row + 1][col];
                bottomColor = bottomPixel.getColor();
                if (topPixel.colorDistance(bottomColor)
                        > edgeDist && topPixel.getColor().equals(Color.WHITE)) {
                    topPixel.setColor(Color.BLACK);
                } else {
                    //topPixel.setColor(Color.WHITE);
                }
            }
        }
    }
    
    public void blur(int x, int y, int w, int h){
        Pixel firstPixel = null;
        Pixel[][] pixels = this.getPixels2D();
        Color newColor = null;
        int rVal, gVal, bVal;
        int numCount;
        for(int col = x; col < x + w && col < pixels[0].length; col++){
            for(int row = y; row < y + h && row < pixels.length; row++){
                firstPixel = pixels[row][col];
                numCount = 0;
                rVal = 0;
                gVal = 0;
                bVal = 0;
                for(int i = -1; i <= 1 && row + i < pixels.length; i++){
                    for(int j = -1; j <= 1 && col + j < pixels[0].length; j++){
                        rVal += pixels[row+i][col+j].getColor().getRed();
                        gVal += pixels[row+i][col+j].getColor().getGreen();
                        bVal += pixels[row+i][col+j].getColor().getBlue();
                        numCount++;
                    }
                }
                rVal = rVal/numCount;
                gVal = gVal/numCount;
                bVal = bVal/numCount;
                newColor = new Color(rVal, gVal, bVal);
                firstPixel.setColor(newColor);
            }
        }
        
    }

    /* Main method for testing - each class in Java can have a main 
   * method 
     */
    public static void main(String[] args) {
        Picture beach = new Picture("skipper-dreamworks-animation-1.45.jpg");
        beach.explore();
        beach.zeroBlue();
        beach.explore();
    }

} // this } is the end of class Picture, put all new methods before this
