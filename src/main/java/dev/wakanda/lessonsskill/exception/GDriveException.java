package dev.wakanda.lessonsskill.exception;

import java.io.IOException;

public class GDriveException extends Exception {
	public GDriveException(IOException e) {
		super(e);
	}

	private static final long serialVersionUID = 1L;
}
