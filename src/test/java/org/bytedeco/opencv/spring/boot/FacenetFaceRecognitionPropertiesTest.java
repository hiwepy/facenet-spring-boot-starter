package org.bytedeco.opencv.spring.boot;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link FacenetFaceRecognitionProperties}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 */
class FacenetFaceRecognitionPropertiesTest {

    private FacenetFaceRecognitionProperties properties;

    @BeforeEach
    void setUp() {
        properties = new FacenetFaceRecognitionProperties();
    }

    @Test
    @DisplayName("Default prefix is opencv.face")
    void defaultPrefix() {
        assertThat(FacenetFaceRecognitionProperties.PREFIX).isEqualTo("opencv.face");
    }

    @Test
    @DisplayName("Default enabled is false")
    void defaultEnabled() {
        assertThat(properties.isEnabled()).isFalse();
    }

    @Test
    @DisplayName("Default temp is user directory")
    void defaultTemp() {
        assertThat(properties.getTemp()).isNotNull();
        assertThat(properties.getTemp()).isNotEmpty();
    }

    @Test
    @DisplayName("Getter and setter for enabled")
    void enabledGetterSetter() {
        properties.setEnabled(true);
        assertThat(properties.isEnabled()).isTrue();
        properties.setEnabled(false);
        assertThat(properties.isEnabled()).isFalse();
    }

    @Test
    @DisplayName("Getter and setter for temp")
    void tempGetterSetter() {
        properties.setTemp("/tmp/test");
        assertThat(properties.getTemp()).isEqualTo("/tmp/test");
    }
}
