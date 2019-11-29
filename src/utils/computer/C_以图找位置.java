package utils.computer;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class C_以图找位置 {

    private BufferedImage screenShotImage;    //屏幕截图
    private BufferedImage keyImage;           //查找目标图片
    private int scrShotImgWidth;              //屏幕截图宽度
    private int scrShotImgHeight;             //屏幕截图高度
    private int keyImgWidth;                  //查找目标图片宽度
    private int keyImgHeight;                 //查找目标图片高度
    private int[][] screenShotImageRGBData;   //屏幕截图RGB数据
    private int[][] keyImageRGBData;          //查找目标图片RGB数据
    private int findX;            //查找结果，目标图标位于屏幕截图上的X坐标数据
    private int findY;            //查找结果，目标图标位于屏幕截图上的Y坐标数据

    /***
     * 初始化数据
     *
     * @param p_图片地址
     */
    public C_以图找位置(String p_图片地址) {
        screenShotImage = this.getFullScreenShot();
        keyImage = this.getBfImageFromPath(p_图片地址);
        screenShotImageRGBData = this.getImageGRB(screenShotImage);
        keyImageRGBData = this.getImageGRB(keyImage);

        scrShotImgWidth = screenShotImage.getWidth();
        scrShotImgHeight = screenShotImage.getHeight();
        keyImgWidth = keyImage.getWidth();
        keyImgHeight = keyImage.getHeight();

        //开始查找
        this.findImage();

    }


    public C_以图找位置(String p_图片地址, int startX, int startY, int endX, int endY) {
        screenShotImage = this.getFullScreenShot();
        keyImage = this.getBfImageFromPath(p_图片地址);
        screenShotImageRGBData = this.getImageGRB(screenShotImage);
        keyImageRGBData = this.getImageGRB(keyImage);
        scrShotImgWidth = screenShotImage.getWidth();
        scrShotImgHeight = screenShotImage.getHeight();
        keyImgWidth = keyImage.getWidth();
        keyImgHeight = keyImage.getHeight();

        //开始查找
        this.findImage();

    }


    /**
     * 全屏截图
     *
     * @return 返回BufferedImage
     */
    private BufferedImage getFullScreenShot() {
        BufferedImage bfImage = null;
        int width = (int) Toolkit.getDefaultToolkit().getScreenSize().getWidth();
        int height = (int) Toolkit.getDefaultToolkit().getScreenSize().getHeight();
        try {
            Robot robot = new Robot();
            bfImage = robot.createScreenCapture(new Rectangle(0, 0, width, height));
        } catch (AWTException e) {
            e.printStackTrace();
        }
        return bfImage;
    }

    /**
     * 从本地文件读取目标图片
     *
     * @param keyImagePath - 图片绝对路径
     * @return 本地图片的BufferedImage对象
     */
    private BufferedImage getBfImageFromPath(String keyImagePath) {
        BufferedImage bfImage = null;
        try {
            bfImage = ImageIO.read(new File(keyImagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bfImage;
    }

    /**
     * 根据BufferedImage获取图片RGB数组
     *
     * @param bfImage
     * @return
     */
    private int[][] getImageGRB(BufferedImage bfImage) {
        int width = bfImage.getWidth();
        int height = bfImage.getHeight();
        int[][] result = new int[height][width];
        for (int h = 0; h < height; h++) {
            for (int w = 0; w < width; w++) {
                result[h][w] = bfImage.getRGB(w, h);
                int A = (result[h][w] >> 24) & 0xff;
//                int R = (result[h][w] >> 16) & 0xff;
//                int G = (result[h][w] >> 8) & 0xff;
//                int B = (result[h][w] & 0xff);
                if (A == 0) {
                    result[h][w] = 0;
                }
                {
                    //使用getRGB(w, h)获取该点的颜色值是ARGB，而在实际应用中使用的是RGB，所以需要将ARGB转化成RGB，即bufImg.getRGB(w, h) & 0xFFFFFF。
                    result[h][w] = result[h][w] & 0xFFFFFF;
                }
            }
        }
        return result;
    }


    /**
     * 查找图片
     */
    private void findImage() {
        //遍历屏幕截图像素点数据
        for (int y = 0; y < scrShotImgHeight - keyImgHeight; y++) {
            for (int x = 0; x < scrShotImgWidth - keyImgWidth; x++) {
                //根据目标图的尺寸，得到目标图四个角映射到屏幕截图上的四个点，
                //判断截图上对应的四个点与图B的四个角像素点的值是否相同，
                //如果相同就将屏幕截图上映射范围内的所有的点与目标图的所有的点进行比较。
//                if ((keyImageRGBData[0][0] ^ screenShotImageRGBData[y][x]) == 0
//                        && (keyImageRGBData[0][keyImgWidth - 1] ^ screenShotImageRGBData[y][x + keyImgWidth -x 1]) == 0
//                        && (keyImageRGBData[keyImgHeight - 1][keyImgWidth - 1] ^ screenShotImageRGBData[y + keyImgHeight - 1][x + keyImgWidth - 1]) == 0
//                        && (keyImageRGBData[keyImgHeight - 1][0] ^ screenShotImageRGBData[y + keyImgHeight - 1][x]) == 0) {

                    boolean isFinded = isMatchAll(y, x);
                    //如果比较结果完全相同，则说明图片找到，填充查找到的位置坐标数据到查找结果数组。
                    if (isFinded) {
                        //0
                        int minY = y;
                        int maxY = y + keyImgHeight;
                        findY = ((minY + maxY) / 2);
                        //1
                        int minX = x;
                        int maxX = x + keyImgWidth;
                        findX = ((minX + maxX) / 2);
                        return;
                    }
                }
//            }
        }
    }

    /**
     * 判断屏幕截图上目标图映射范围内的全部点是否全部和小图的点一一对应。
     *
     * @param y - 与目标图左上角像素点想匹配的屏幕截图y坐标
     * @param x - 与目标图左上角像素点想匹配的屏幕截图x坐标
     * @return
     */
    private boolean isMatchAll(int y, int x) {
        int biggerY = 0;
        int biggerX = 0;
        int xor = 0;
        for (int smallerY = 0; smallerY < keyImgHeight; smallerY++) {
            biggerY = y + smallerY;
            for (int smallerX = 0; smallerX < keyImgWidth; smallerX++) {
                if (keyImageRGBData[smallerX][smallerY] == 0) {
                    continue; //如果是上面设置的0，代表全透明的时候，继续下一个点
                }
                biggerX = x + smallerX;
                if (biggerY >= scrShotImgHeight || biggerX >= scrShotImgWidth) {
                    return false;
                }
                xor = keyImageRGBData[smallerY][smallerX] ^ screenShotImageRGBData[biggerY][biggerX];
                if (xor != 0) {
                    return false;
                }
            }
            biggerX = x;
        }
        return true;
    }


    /***************************************** 提供外部调用方法 ************************************************/
    public int m_屏幕的宽度() {
        return scrShotImgWidth;
    }

    public int m_屏幕的高度() {
        return scrShotImgHeight;
    }

    public int m_图片的宽度() {
        return keyImgWidth;
    }

    public int m_图片的高度() {
        return keyImgHeight;
    }

    public int m_图片的X坐标() {
        return findX;
    }

    public int m_图片的Y坐标() {
        return findY;
    }
}