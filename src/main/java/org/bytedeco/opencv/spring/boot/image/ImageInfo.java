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

import java.io.InputStream;

import lombok.Data;

/**
 * Container holding the raw pixel data and metadata of a decoded image.
 *
 * @author <a href="https://github.com/loong10k">@Loong Wan</a>
 * @since 1.0.0
 */
@Data
public class ImageInfo {

	/** Raw pixel data of the image. */
	private byte[] imageData;
    /** Optional stream representation of the image. */
    private InputStream imageStream;
    /** Image width in pixels. */
    private Integer width;
    /** Image height in pixels. */
    private Integer height;
    /** Pixel format of {@link #imageData}. */
    private ImageFormat imageFormat;

}
