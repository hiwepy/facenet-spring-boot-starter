package org.bytedeco.opencv.spring.boot.image;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link ImageInfo}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 */
class ImageInfoTest {

    private ImageInfo imageInfo;

    @BeforeEach
    void setUp() {
        imageInfo = new ImageInfo();
    }

    @Test
    @DisplayName("Default values are null")
    void defaultValues() {
        assertThat(imageInfo.getImageData()).isNull();
        assertThat(imageInfo.getImageStream()).isNull();
        assertThat(imageInfo.getWidth()).isNull();
        assertThat(imageInfo.getHeight()).isNull();
        assertThat(imageInfo.getImageFormat()).isNull();
    }

    @Test
    @DisplayName("Getter and setter for imageData")
    void imageDataGetterSetter() {
        byte[] data = new byte[]{1, 2, 3};
        imageInfo.setImageData(data);
        assertThat(imageInfo.getImageData()).isEqualTo(data);
    }

    @Test
    @DisplayName("Getter and setter for imageStream")
    void imageStreamGetterSetter() {
        InputStream stream = new ByteArrayInputStream(new byte[]{1, 2, 3});
        imageInfo.setImageStream(stream);
        assertThat(imageInfo.getImageStream()).isEqualTo(stream);
    }

    @Test
    @DisplayName("Getter and setter for width")
    void widthGetterSetter() {
        imageInfo.setWidth(640);
        assertThat(imageInfo.getWidth()).isEqualTo(640);
    }

    @Test
    @DisplayName("Getter and setter for height")
    void heightGetterSetter() {
        imageInfo.setHeight(480);
        assertThat(imageInfo.getHeight()).isEqualTo(480);
    }

    @Test
    @DisplayName("Getter and setter for imageFormat")
    void imageFormatGetterSetter() {
        imageInfo.setImageFormat(ImageFormat.CP_PAF_BGR24);
        assertThat(imageInfo.getImageFormat()).isEqualTo(ImageFormat.CP_PAF_BGR24);
    }

    @Test
    @DisplayName("equals and hashCode work correctly")
    void equalsAndHashCode() {
        ImageInfo info1 = new ImageInfo();
        info1.setWidth(640);
        info1.setHeight(480);
        info1.setImageFormat(ImageFormat.CP_PAF_BGR24);

        ImageInfo info2 = new ImageInfo();
        info2.setWidth(640);
        info2.setHeight(480);
        info2.setImageFormat(ImageFormat.CP_PAF_BGR24);

        assertThat(info1).isEqualTo(info2);
        assertThat(info1.hashCode()).isEqualTo(info2.hashCode());
    }

    @Test
    @DisplayName("toString returns string representation")
    void toStringReturnsString() {
        imageInfo.setWidth(640);
        imageInfo.setHeight(480);
        String str = imageInfo.toString();
        assertThat(str).contains("640");
        assertThat(str).contains("480");
    }
}
