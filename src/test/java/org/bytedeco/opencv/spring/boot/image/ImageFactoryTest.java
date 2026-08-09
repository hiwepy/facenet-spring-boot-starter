package org.bytedeco.opencv.spring.boot.image;

import static org.assertj.core.api.Assertions.assertThat;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * Tests for {@link ImageFactory}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 */
class ImageFactoryTest {

    @TempDir
    File tempDir;

    @Test
    @DisplayName("getRGBData returns null for null file")
    void getRGBDataNullFile() {
        assertThat(ImageFactory.getRGBData((File) null)).isNull();
    }

    @Test
    @DisplayName("getGrayData returns null for null file")
    void getGrayDataNullFile() {
        assertThat(ImageFactory.getGrayData((File) null)).isNull();
    }

    @Test
    @DisplayName("getRGBData returns null for null bytes")
    void getRGBDataNullBytes() {
        assertThat(ImageFactory.getRGBData((byte[]) null)).isNull();
    }

    @Test
    @DisplayName("getGrayData returns null for null bytes")
    void getGrayDataNullBytes() {
        assertThat(ImageFactory.getGrayData((byte[]) null)).isNull();
    }

    @Test
    @DisplayName("getRGBData returns null for null input stream")
    void getRGBDataNullStream() {
        assertThat(ImageFactory.getRGBData((InputStream) null)).isNull();
    }

    @Test
    @DisplayName("getGrayData returns null for null input stream")
    void getGrayDataNullStream() {
        assertThat(ImageFactory.getGrayData((InputStream) null)).isNull();
    }

    @Test
    @DisplayName("getRGBData returns ImageInfo for valid image file")
    void getRGBDataValidFile() throws IOException {
        File imageFile = createTestImage("test.png");
        ImageInfo info = ImageFactory.getRGBData(imageFile);
        assertThat(info).isNotNull();
        assertThat(info.getWidth()).isNotNull();
        assertThat(info.getHeight()).isNotNull();
        assertThat(info.getImageData()).isNotNull();
        assertThat(info.getImageFormat()).isEqualTo(ImageFormat.CP_PAF_BGR24);
    }

    @Test
    @DisplayName("getGrayData returns ImageInfo for valid image file")
    void getGrayDataValidFile() throws IOException {
        File imageFile = createTestImage("test.png");
        ImageInfo info = ImageFactory.getGrayData(imageFile);
        assertThat(info).isNotNull();
        assertThat(info.getWidth()).isNotNull();
        assertThat(info.getHeight()).isNotNull();
        assertThat(info.getImageData()).isNotNull();
        assertThat(info.getImageFormat()).isEqualTo(ImageFormat.CP_PAF_GRAY);
    }

    @Test
    @DisplayName("getRGBData returns ImageInfo for valid byte array")
    void getRGBDataValidBytes() throws IOException {
        byte[] imageBytes = createTestImageBytes();
        ImageInfo info = ImageFactory.getRGBData(imageBytes);
        assertThat(info).isNotNull();
        assertThat(info.getWidth()).isNotNull();
        assertThat(info.getHeight()).isNotNull();
    }

    @Test
    @DisplayName("getGrayData returns ImageInfo for valid byte array")
    void getGrayDataValidBytes() throws IOException {
        byte[] imageBytes = createTestImageBytes();
        ImageInfo info = ImageFactory.getGrayData(imageBytes);
        assertThat(info).isNotNull();
        assertThat(info.getWidth()).isNotNull();
        assertThat(info.getHeight()).isNotNull();
    }

    @Test
    @DisplayName("getRGBData returns ImageInfo for valid input stream")
    void getRGBDataValidStream() throws IOException {
        byte[] imageBytes = createTestImageBytes();
        InputStream stream = new ByteArrayInputStream(imageBytes);
        ImageInfo info = ImageFactory.getRGBData(stream);
        assertThat(info).isNotNull();
        assertThat(info.getWidth()).isNotNull();
        assertThat(info.getHeight()).isNotNull();
    }

    @Test
    @DisplayName("getGrayData returns ImageInfo for valid input stream")
    void getGrayDataValidStream() throws IOException {
        byte[] imageBytes = createTestImageBytes();
        InputStream stream = new ByteArrayInputStream(imageBytes);
        ImageInfo info = ImageFactory.getGrayData(stream);
        assertThat(info).isNotNull();
        assertThat(info.getWidth()).isNotNull();
        assertThat(info.getHeight()).isNotNull();
    }

    @Test
    @DisplayName("getBestRect returns null for null source rect")
    void getBestRectNullSource() {
        assertThat(ImageFactory.getBestRect(100, 100, null)).isNull();
    }

    @Test
    @DisplayName("getBestRect adjusts rect that overflows bounds")
    void getBestRectOverflow() {
        Rect srcRect = new Rect(-10, -10, 50, 50);
        Rect result = ImageFactory.getBestRect(100, 100, srcRect);
        assertThat(result).isNotNull();
        assertThat(result.getLeft()).isGreaterThanOrEqualTo(0);
        assertThat(result.getTop()).isGreaterThanOrEqualTo(0);
        assertThat(result.getRight()).isLessThanOrEqualTo(100);
        assertThat(result.getBottom()).isLessThanOrEqualTo(100);
    }

    @Test
    @DisplayName("getBestRect expands rect with padding")
    void getBestRectExpands() {
        Rect srcRect = new Rect(20, 20, 40, 40);
        Rect result = ImageFactory.getBestRect(100, 100, srcRect);
        assertThat(result).isNotNull();
        assertThat(result.getLeft()).isLessThanOrEqualTo(20);
        assertThat(result.getTop()).isLessThanOrEqualTo(20);
        assertThat(result.getRight()).isGreaterThanOrEqualTo(40);
        assertThat(result.getBottom()).isGreaterThanOrEqualTo(40);
    }

    @Test
    @DisplayName("getBestRect handles small image with large rect")
    void getBestRectSmallImage() {
        Rect srcRect = new Rect(0, 0, 50, 50);
        Rect result = ImageFactory.getBestRect(30, 30, srcRect);
        assertThat(result).isNotNull();
        assertThat(result.getLeft()).isGreaterThanOrEqualTo(0);
        assertThat(result.getTop()).isGreaterThanOrEqualTo(0);
    }

    @Test
    @DisplayName("getRGBData returns null for non-existent file")
    void getRGBDataNonExistentFile() {
        File nonExistent = new File(tempDir, "nonexistent.png");
        assertThat(ImageFactory.getRGBData(nonExistent)).isNull();
    }

    @Test
    @DisplayName("getGrayData returns null for non-existent file")
    void getGrayDataNonExistentFile() {
        File nonExistent = new File(tempDir, "nonexistent.png");
        assertThat(ImageFactory.getGrayData(nonExistent)).isNull();
    }

    @Test
    @DisplayName("getRGBData returns null for invalid image bytes")
    void getRGBDataInvalidBytes() {
        byte[] invalidBytes = new byte[]{0, 1, 2, 3};
        assertThat(ImageFactory.getRGBData(invalidBytes)).isNull();
    }

    @Test
    @DisplayName("getGrayData returns null for invalid image bytes")
    void getGrayDataInvalidBytes() {
        byte[] invalidBytes = new byte[]{0, 1, 2, 3};
        assertThat(ImageFactory.getGrayData(invalidBytes)).isNull();
    }

    @Test
    @DisplayName("getRGBData returns null for invalid input stream")
    void getRGBDataInvalidStream() {
        InputStream stream = new ByteArrayInputStream(new byte[]{0, 1, 2, 3});
        assertThat(ImageFactory.getRGBData(stream)).isNull();
    }

    @Test
    @DisplayName("getGrayData returns null for invalid input stream")
    void getGrayDataInvalidStream() {
        InputStream stream = new ByteArrayInputStream(new byte[]{0, 1, 2, 3});
        assertThat(ImageFactory.getGrayData(stream)).isNull();
    }

    private File createTestImage(String filename) throws IOException {
        BufferedImage image = new BufferedImage(8, 8, BufferedImage.TYPE_3BYTE_BGR);
        File file = new File(tempDir, filename);
        ImageIO.write(image, "png", file);
        return file;
    }

    private byte[] createTestImageBytes() throws IOException {
        BufferedImage image = new BufferedImage(8, 8, BufferedImage.TYPE_3BYTE_BGR);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "png", baos);
        return baos.toByteArray();
    }
}
