import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

class Functions implements ourInterface{
    String input;
    String path;
    String file_content;
    String[] array_of_words;
    List<String> words = new ArrayList<String>();
    HashMap<String, Integer> counter;

    public Functions(String path) {
        this.path = path;
        this.read_my_file();
        this.split_words_into_pieces();
        this.turn_words_to_lowercase();
        this.count_words(10);
    }

    public void read_my_file() {
        Path file_path = Paths.get(this.path);
        try {
            byte[] file_content_in_bytes = Files.readAllBytes(file_path);
            String file_content = new String(file_content_in_bytes, StandardCharsets.UTF_8);
            this.file_content = file_content;
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void split_words_into_pieces() {
        this.words = Arrays.asList(file_content.split(" "));
    }

    public void turn_words_to_lowercase() {
        this.words.replaceAll(String::toLowerCase);
    }   

    public int count_words(int number){
        int count = 0;
        for (String word : this.words) {
            if(word.length() > number){
                count++;
            }
        }
        return count;
    }
}

interface ourInterface{
    public void read_my_file();
    public void split_words_into_pieces();
    public void turn_words_to_lowercase();
    public int count_words();
}