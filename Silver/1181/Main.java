import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++){
            set.add(br.readLine());
        }
        
        String[] words = set.toArray(new String[0]);
        Arrays.sort(words, new Comparator<String>(){
            @Override
            public int compare(String o1, String o2){
                if(o1.length() > o2.length()){
                    return 1;
                } else if (o1.length() < o2.length()){
                    return -1;
                }else{
                    return o1.compareTo(o2);
                }
            }
        } );
        for (int i = 0; i < words.length; i++){
            System.out.println(words[i]);
        }
        br.close();
    }
}
