package org.bytedeco.opencv.spring.boot.image;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * Tests for {@link Rect}.
 *
 * @author [@Loong Wan](https://github.com/loong10k)
 */
class RectTest {

    @Test
    @DisplayName("Default constructor initializes to zero")
    void defaultConstructor() {
        Rect rect = new Rect();
        assertThat(rect.getLeft()).isEqualTo(0);
        assertThat(rect.getTop()).isEqualTo(0);
        assertThat(rect.getRight()).isEqualTo(0);
        assertThat(rect.getBottom()).isEqualTo(0);
    }

    @Test
    @DisplayName("Constructor with coordinates sets values")
    void constructorWithCoordinates() {
        Rect rect = new Rect(10, 20, 30, 40);
        assertThat(rect.getLeft()).isEqualTo(10);
        assertThat(rect.getTop()).isEqualTo(20);
        assertThat(rect.getRight()).isEqualTo(30);
        assertThat(rect.getBottom()).isEqualTo(40);
    }

    @Test
    @DisplayName("Copy constructor copies values")
    void copyConstructor() {
        Rect original = new Rect(10, 20, 30, 40);
        Rect copy = new Rect(original);
        assertThat(copy.getLeft()).isEqualTo(10);
        assertThat(copy.getTop()).isEqualTo(20);
        assertThat(copy.getRight()).isEqualTo(30);
        assertThat(copy.getBottom()).isEqualTo(40);
    }

    @Test
    @DisplayName("Copy constructor with null initializes to zero")
    void copyConstructorWithNull() {
        Rect copy = new Rect(null);
        assertThat(copy.getLeft()).isEqualTo(0);
        assertThat(copy.getTop()).isEqualTo(0);
        assertThat(copy.getRight()).isEqualTo(0);
        assertThat(copy.getBottom()).isEqualTo(0);
    }

    @Test
    @DisplayName("Getter and setter for left")
    void leftGetterSetter() {
        Rect rect = new Rect();
        rect.setLeft(10);
        assertThat(rect.getLeft()).isEqualTo(10);
    }

    @Test
    @DisplayName("Getter and setter for top")
    void topGetterSetter() {
        Rect rect = new Rect();
        rect.setTop(20);
        assertThat(rect.getTop()).isEqualTo(20);
    }

    @Test
    @DisplayName("Getter and setter for right")
    void rightGetterSetter() {
        Rect rect = new Rect();
        rect.setRight(30);
        assertThat(rect.getRight()).isEqualTo(30);
    }

    @Test
    @DisplayName("Getter and setter for bottom")
    void bottomGetterSetter() {
        Rect rect = new Rect();
        rect.setBottom(40);
        assertThat(rect.getBottom()).isEqualTo(40);
    }

    @Test
    @DisplayName("toString returns formatted string")
    void toStringReturnsFormattedString() {
        Rect rect = new Rect(10, 20, 30, 40);
        String str = rect.toString();
        assertThat(str).contains("10");
        assertThat(str).contains("20");
        assertThat(str).contains("30");
        assertThat(str).contains("40");
    }
}
