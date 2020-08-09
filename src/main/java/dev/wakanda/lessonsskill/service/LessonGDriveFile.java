package dev.wakanda.lessonsskill.service;

import java.util.List;
import java.util.stream.Collectors;

import dev.wakanda.lessonsskill.domain.Lesson;

public class LessonGDriveFile {
	public static List<Lesson> convertToLessons(List<LessonGDriveFile> listGDriveFiles) {
		return listGDriveFiles.parallelStream()
				.map(Lesson::new)
				.collect(Collectors.toList());
	}
}
