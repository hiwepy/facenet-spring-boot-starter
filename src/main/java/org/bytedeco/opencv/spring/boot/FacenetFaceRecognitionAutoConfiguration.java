package org.bytedeco.opencv.spring.boot;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.bytedeco.javacpp.Loader;
import org.bytedeco.opencv.opencv_java;
import org.opencv.objdetect.CascadeClassifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

/**
 * Spring Boot auto-configuration for OpenCV-based face recognition (Facenet).
 * <p>Activates when {@code opencv.face.enabled=true} and registers the cascade
 * classifier face detector together with a {@link FacenetFaceRecognitionTemplate}
 * that provides face detection and matching operations.</p>
 *
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
@Configuration
@ConditionalOnProperty(prefix = FacenetFaceRecognitionProperties.PREFIX, value = "enabled", havingValue = "true")
@EnableConfigurationProperties({ FacenetFaceRecognitionProperties.class })
/**
 * <p>Auto-configuration for FacenetFaceRecognitionAutoConfiguration.</p>
 * @author <a href="https://github.com/loong10k">Loong Wan</a>
 * @since 1.0.0
 */
public class FacenetFaceRecognitionAutoConfiguration {

	@Value("classpath:haarcascades/haarcascade_frontalface_alt.xml")
	private Resource classifier;

	static {
		Loader.load(opencv_java.class);
		//new opencv_java();
	}

	/**
	 * Creates the Haar cascade face detector by materialising the bundled
	 * {@code haarcascade_frontalface_alt.xml} classifier into the configured temporary
	 * directory, which is required because packaged Spring Boot archives cannot be read
	 * directly from the classpath by the native OpenCV library.
	 * @param properties the face recognition properties providing the temp directory
	 * @return the configured cascade classifier
	 * @throws IOException if the classifier resource cannot be copied to disk
	 */
    @Bean
    /**
     * <p>Face detector.</p>
     * @param properties
     * @return the result
     */
    public CascadeClassifier faceDetector(FacenetFaceRecognitionProperties properties) throws IOException {
    	// 创建临时文件，因为boot打包后无法读取文件内的内容
    	File tempDir = new File(properties.getTemp());
    	if(!tempDir.exists()) {
    		tempDir.setReadable(true);
    		tempDir.setWritable(true);
    		tempDir.mkdir();
    	}
		File targetXmlFile = new File(tempDir, classifier.getFilename());
		FileUtils.copyInputStreamToFile(classifier.getInputStream(), targetXmlFile);
		//System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		return new CascadeClassifier(targetXmlFile.getPath());
	}

	/**
	 * Creates the face recognition template that wraps the face detector and properties
	 * to expose detection, smoothing and matching operations to application code.
	 * @param faceDetector the cascade classifier face detector bean
	 * @param properties the face recognition properties
	 * @return the face recognition template bean
	 */
	@Bean
	public FacenetFaceRecognitionTemplate openCVFaceRecognitionTemplate(CascadeClassifier faceDetector,
			FacenetFaceRecognitionProperties properties) {
		return new FacenetFaceRecognitionTemplate(faceDetector, properties);
	}

}
