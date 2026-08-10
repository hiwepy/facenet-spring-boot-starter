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
package org.bytedeco.opencv.spring.boot;

import org.apache.commons.lang3.SystemUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Configuration properties for OpenCV-based face recognition, bound under the
 * {@value #PREFIX} prefix.
 * <p>Controls whether the face recognition auto-configuration is enabled and where
 * intermediate image and classifier files are written.</p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@ConfigurationProperties(FacenetFaceRecognitionProperties.PREFIX)
public class FacenetFaceRecognitionProperties {

	/** Configuration property prefix for OpenCV face recognition options. */
	public static final String PREFIX = "opencv.face";

	/** Whether OpenCV face recognition should be enabled. */
	private boolean enabled = false;
	/** Temporary directory used to store image and classifier files during processing. */
	private String temp = SystemUtils.getUserDir().getAbsolutePath();

	/**
	 * Returns whether OpenCV face recognition is enabled.
	 * @return {@code true} if face recognition is enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * Enables or disables OpenCV face recognition.
	 * @param enabled whether face recognition should be enabled
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * Returns the temporary directory used for intermediate files.
	 * @return the temporary directory path
	 */
	public String getTemp() {
		return temp;
	}

	/**
	 * Sets the temporary directory used for intermediate files.
	 * @param temp the temporary directory path
	 */
	public void setTemp(String temp) {
		this.temp = temp;
	}

}
