package utils.computer;

import javax.imageio.ImageIO;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class C_��ͼ��λ�� {

    private BufferedImage screenShotImage;    //��Ļ��ͼ
    private BufferedImage keyImage;           //����Ŀ��ͼƬ
    private int scrShotImgWidth;              //��Ļ��ͼ���
    private int scrShotImgHeight;             //��Ļ��ͼ�߶�
    private int keyImgWidth;                  //����Ŀ��ͼƬ���
    private int keyImgHeight;                 //����Ŀ��ͼƬ�߶�
    private int[][] screenShotImageRGBData;   //��Ļ��ͼRGB����
    private int[][] keyImageRGBData;          //����Ŀ��ͼƬRGB����
    private int findX;            //���ҽ����Ŀ��ͼ��λ����Ļ��ͼ�ϵ�X��������
    private int findY;            //���ҽ����Ŀ��ͼ��λ����Ļ��ͼ�ϵ�Y��������

    /***
     * ��ʼ������
     *
     * @param p_ͼƬ��ַ
     */
    public C_��ͼ��λ��(String p_ͼƬ��ַ) {
        screenShotImage = this.getFullScreenShot();
        keyImage = this.getBfImageFromPath(p_ͼƬ��ַ);
        screenShotImageRGBData = this.getImageGRB(screenShotImage);
        keyImageRGBData = this.getImageGRB(keyImage);

        scrShotImgWidth = screenShotImage.getWidth();
        scrShotImgHeight = screenShotImage.getHeight();
        keyImgWidth = keyImage.getWidth();
        keyImgHeight = keyImage.getHeight();

        //��ʼ����
        this.findImage();

    }


    public C_��ͼ��λ��(String p_ͼƬ��ַ, int startX, int startY, int endX, int endY) {
        screenShotImage = this.getFullScreenShot();
        keyImage = this.getBfImageFromPath(p_ͼƬ��ַ);
        screenShotImageRGBData = this.getImageGRB(screenShotImage);
        keyImageRGBData = this.getImageGRB(keyImage);
        scrShotImgWidth = screenShotImage.getWidth();
        scrShotImgHeight = screenShotImage.getHeight();
        keyImgWidth = keyImage.getWidth();
        keyImgHeight = keyImage.getHeight();

        //��ʼ����
        this.findImage();

    }


    /**
     * ȫ����ͼ
     *
     * @return ����BufferedImage
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
     * �ӱ����ļ���ȡĿ��ͼƬ
     *
     * @param keyImagePath - ͼƬ����·��
     * @return ����ͼƬ��BufferedImage����
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
     * ����BufferedImage��ȡͼƬRGB����
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
                    //ʹ��getRGB(w, h)��ȡ�õ����ɫֵ��ARGB������ʵ��Ӧ����ʹ�õ���RGB��������Ҫ��ARGBת����RGB����bufImg.getRGB(w, h) & 0xFFFFFF��
                    result[h][w] = result[h][w] & 0xFFFFFF;
                }
            }
        }
        return result;
    }


    /**
     * ����ͼƬ
     */
    private void findImage() {
        //������Ļ��ͼ���ص�����
        for (int y = 0; y < scrShotImgHeight - keyImgHeight; y++) {
            for (int x = 0; x < scrShotImgWidth - keyImgWidth; x++) {
                //����Ŀ��ͼ�ĳߴ磬�õ�Ŀ��ͼ�ĸ���ӳ�䵽��Ļ��ͼ�ϵ��ĸ��㣬
                //�жϽ�ͼ�϶�Ӧ���ĸ�����ͼB���ĸ������ص��ֵ�Ƿ���ͬ��
                //�����ͬ�ͽ���Ļ��ͼ��ӳ�䷶Χ�ڵ����еĵ���Ŀ��ͼ�����еĵ���бȽϡ�
                if ((keyImageRGBData[0][0] ^ screenShotImageRGBData[y][x]) == 0
                        && (keyImageRGBData[0][keyImgWidth - 1] ^ screenShotImageRGBData[y][x + keyImgWidth -x 1]) == 0
                        && (keyImageRGBData[keyImgHeight - 1][keyImgWidth - 1] ^ screenShotImageRGBData[y + keyImgHeight - 1][x + keyImgWidth - 1]) == 0
                        && (keyImageRGBData[keyImgHeight - 1][0] ^ screenShotImageRGBData[y + keyImgHeight - 1][x]) == 0) {

                    boolean isFinded = isMatchAll(y, x);
                    //����ȽϽ����ȫ��ͬ����˵��ͼƬ�ҵ��������ҵ���λ���������ݵ����ҽ�����顣
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
            }
        }
    }

    /**
     * �ж���Ļ��ͼ��Ŀ��ͼӳ�䷶Χ�ڵ�ȫ�����Ƿ�ȫ����Сͼ�ĵ�һһ��Ӧ��
     *
     * @param y - ��Ŀ��ͼ���Ͻ����ص���ƥ�����Ļ��ͼy����
     * @param x - ��Ŀ��ͼ���Ͻ����ص���ƥ�����Ļ��ͼx����
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
                    continue; //������������õ�0������ȫ͸����ʱ�򣬼�����һ����
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


    /***************************************** �ṩ�ⲿ���÷��� ************************************************/
    public int m_��Ļ�Ŀ��() {
        return scrShotImgWidth;
    }

    public int m_��Ļ�ĸ߶�() {
        return scrShotImgHeight;
    }

    public int m_ͼƬ�Ŀ��() {
        return keyImgWidth;
    }

    public int m_ͼƬ�ĸ߶�() {
        return keyImgHeight;
    }

    public int m_ͼƬ��X����() {
        return findX;
    }

    public int m_ͼƬ��Y����() {
        return findY;
    }
}