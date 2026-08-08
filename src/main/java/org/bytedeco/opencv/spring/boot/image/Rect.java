/*
 * Copyright (c) 2018, hiwepy (https://github.com/hiwepy).
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package org.bytedeco.opencv.spring.boot.image;

/**
 * Represents the position of a detected face as an axis-aligned rectangle.
 *
 * @author <a href="https://github.com/loong10k">@Loong Wan</a>
 * @since 1.0.0
 */
public class Rect {
    /** Left coordinate of the face rectangle. */
    public int left;
    /** Top coordinate of the face rectangle. */
    public int top;
    /** Right coordinate of the face rectangle. */
    public int right;
    /** Bottom coordinate of the face rectangle. */
    public int bottom;

    /**
     * Creates an empty rectangle with all coordinates initialised to zero.
     */
    public Rect() {
    }

    /**
     * Creates a rectangle from the given left, top, right and bottom bounds.
     * @param left  the left coordinate
     * @param top   the top coordinate
     * @param right the right coordinate
     * @param bottom the bottom coordinate
     */
    public Rect(int left, int top, int right, int bottom) {
        this.left = left;
        this.top = top;
        this.right = right;
        this.bottom = bottom;
    }

    /**
     * Creates a new rectangle as a deep copy of the given source rectangle.
     * @param r the source rectangle, may be {@code null}
     */
    public Rect(Rect r) {
        if (r == null) {
            this.left = this.top = this.right = this.bottom = 0;
        } else {
            this.left = r.left;
            this.top = r.top;
            this.right = r.right;
            this.bottom = r.bottom;
        }

    }

    /**
     * Returns a formatted representation of this rectangle.
     * @return a formatted rectangle string
     */
    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append("com.arcsoft.face.Rect(");
        sb.append(this.left);
        sb.append(", ");
        sb.append(this.top);
        sb.append(" - ");
        sb.append(this.right);
        sb.append(", ");
        sb.append(this.bottom);
        sb.append(")");
        return sb.toString();
    }

    /**
     * Returns the left coordinate.
     * @return the left coordinate
     */
    public int getLeft() {
        return left;
    }

    /**
     * Sets the left coordinate.
     * @param left the left coordinate
     */
    public void setLeft(int left) {
        this.left = left;
    }

    /**
     * Returns the top coordinate.
     * @return the top coordinate
     */
    public int getTop() {
        return top;
    }

    /**
     * Sets the top coordinate.
     * @param top the top coordinate
     */
    public void setTop(int top) {
        this.top = top;
    }

    /**
     * Returns the right coordinate.
     * @return the right coordinate
     */
    public int getRight() {
        return right;
    }

    /**
     * Sets the right coordinate.
     * @param right the right coordinate
     */
    public void setRight(int right) {
        this.right = right;
    }

    /**
     * Returns the bottom coordinate.
     * @return the bottom coordinate
     */
    public int getBottom() {
        return bottom;
    }

    /**
     * Sets the bottom coordinate.
     * @param bottom the bottom coordinate
     */
    public void setBottom(int bottom) {
        this.bottom = bottom;
    }
}
