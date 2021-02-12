import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.IntStream;


enum FILETYPE {
	music(new HashSet<>(Arrays.asList(".mp3", ".aac", ".flac"))), 
	images(new HashSet<>(Arrays.asList(".jpg", ".bmp", ".gif"))),
	movies(new HashSet<>(Arrays.asList(".mp4", ".avi", ".mkv"))), 
	other(null);

	private Set<String> extensions;

	private FILETYPE(Set<String> extensions) {
		this.extensions = extensions;
	}

	public Set<String> getExtensions() {
		return extensions;
	}
}

public class Task1 {
	public static String solution(String S) {
		if (Objects.isNull(S) || S.isEmpty())
			return null;
		
		Map<String, Long> catogeryBySize = new LinkedHashMap<>();
		Arrays.stream(FILETYPE.values()).forEach(file -> {
			catogeryBySize.put(file.toString(), 0l);
		});
		try {
			String newLineSplitter[] = S.split("\n");
			IntStream.range(0, newLineSplitter.length).forEach(x -> {
				
				String spaceSplitter[] = newLineSplitter[x].split(" ");
				String extension = spaceSplitter[0].substring(spaceSplitter[0].lastIndexOf('.'));
				FILETYPE fileType = null;
				if (FILETYPE.music.getExtensions().contains(extension)) {
					fileType = FILETYPE.music;
				} else if(FILETYPE.images.getExtensions().contains(extension)) {
					fileType = FILETYPE.images;
				} else if(FILETYPE.movies.getExtensions().contains(extension)) {
					fileType = FILETYPE.movies;
				} else {
					fileType = FILETYPE.other;
				}
				addFileSizeToMap(catogeryBySize, fileType.toString(), spaceSplitter[1]);
			});

		} catch (Exception e) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		catogeryBySize.keySet().forEach(key  -> {
			result.append(key).append(" ").append(catogeryBySize.get(key) + "b\n");
		});
		
		return result.toString();
	}

	private static void addFileSizeToMap(Map<String, Long> catogeryBySize, String type, String size) {
		long currentSize = Integer.parseInt(size.substring(0, size.length() - 1));
		catogeryBySize.put(type, catogeryBySize.get(type) + currentSize);
	}

	public static void main(String[] args) {
		System.out.println(solution("my.song.mp3 11b\n" + "greatSong.flac 1000b\n" + "not3.txt 5b\n" + "video.mp4 200b\n"
				+ "game.exe 100b\n" + "mov!e.mkv 10000b"));
	}
}
