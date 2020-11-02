package com.wjq.web;

import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

/**
 *
 * @author wangjianqiang24
 * @date 2020/10/9
 */
public class MyHttpMessageConverter implements HttpMessageConverter {
	/**
	 * Indicates whether the given class can be read by this converter.
	 * @param clazz the class to test for readability
	 * @param mediaType the media type to read (can be {@code null} if not specified);
	 * typically the value of a {@code Content-Type} header.
	 * @return {@code true} if readable; {@code false} otherwise
	 */
	@Override
	public boolean canRead(Class clazz, MediaType mediaType) {
		return false;
	}

	/**
	 * Indicates whether the given class can be written by this converter.
	 * @param clazz the class to test for writability
	 * @param mediaType the media type to write (can be {@code null} if not specified);
	 * typically the value of an {@code Accept} header.
	 * @return {@code true} if writable; {@code false} otherwise
	 */
	@Override
	public boolean canWrite(Class clazz, MediaType mediaType) {
		return false;
	}

	/**
	 * Return the list of {@link MediaType} objects supported by this converter.
	 * @return the list of supported media types, potentially an immutable copy
	 */
	@Override
	public List<MediaType> getSupportedMediaTypes() {
		return null;
	}

	/**
	 * Read an object of the given type from the given input message, and returns it.
	 * @param clazz the type of object to return. This type must have previously been passed to the
	 * {@link #canRead canRead} method of this interface, which must have returned {@code true}.
	 * @param inputMessage the HTTP input message to read from
	 * @return the converted object
	 * @throws IOException in case of I/O errors
	 * @throws HttpMessageNotReadableException in case of conversion errors
	 */
	@Override
	public Object read(Class clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
		return null;
	}

	/**
	 * Write an given object to the given output message.
	 * @param o the object to write to the output message. The type of this object must have previously been
	 * passed to the {@link #canWrite canWrite} method of this interface, which must have returned {@code true}.
	 * @param contentType the content type to use when writing. May be {@code null} to indicate that the
	 * default content type of the converter must be used. If not {@code null}, this media type must have
	 * previously been passed to the {@link #canWrite canWrite} method of this interface, which must have
	 * returned {@code true}.
	 * @param outputMessage the message to write to
	 * @throws IOException in case of I/O errors
	 * @throws HttpMessageNotWritableException in case of conversion errors
	 */
	@Override
	public void write(Object o, MediaType contentType, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {

	}
}
