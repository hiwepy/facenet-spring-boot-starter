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
 * Pixel format constants describing how image samples are laid out in memory.
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
public enum ImageFormat {
    /**
     * NV21 format: 8-bit Y plane followed by an interleaved 2x2 subsampled V/U plane.
     */
    CP_PAF_NV21(2050),
    /**
     * NV12 format: 8-bit Y plane followed by an interleaved 2x2 subsampled U/V plane.
     */
    CP_PAF_NV12(2049),
    /**
     * I420 format: 8-bit Y plane followed by separate 2x2 subsampled U and V planes.
     */
    CP_PAF_I420(1537),
    /**
     * YUYV format: packed YUV with U and V subsampled 2x1 horizontally, laid out as Y0, U0, Y1, V0.
     */
    CP_PAF_YUYV(1281),
    /**
     * BGR24 format: packed RGB with components ordered B, G, R.
     */
    CP_PAF_BGR24(513),
    /**
     * Grayscale format: single 8-bit luma channel per pixel.
     */
    CP_PAF_GRAY(1793),

    /**
     * 16-bit unsigned depth format.
     */
    CP_PAF_DEPTH_U16(3074);


    private int value;

    /**
     * Creates a format constant with the given numeric identifier.
     * @param value the numeric identifier of the format
     */
    ImageFormat(int value) {
        this.value = value;
    }

    /**
     * Returns the numeric identifier of this format.
     * @return the numeric identifier
     */
    public int getValue() {
        return value;
    }
}
