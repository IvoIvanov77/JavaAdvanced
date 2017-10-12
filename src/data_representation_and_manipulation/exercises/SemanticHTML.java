package data_representation_and_manipulation.exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SemanticHTML {


    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder b = new StringBuilder();

        String line = reader.readLine();

        while (!line.equalsIgnoreCase("end")){
            b.append(line);
            b.append('\n');
            line = reader.readLine();
        }

        String text = b.toString();

        Matcher openTag = extractOpenDivTags(text);

        while(openTag.find()){
            text = text.replaceAll(openTag.group(0), replaceOpenTag(openTag.group(0)));
        }

        Matcher closeTag = extractCloseDivTags(text);

        while(closeTag.find()){
            text = text.replaceAll(closeTag.group(0),
                    "</" + closeTag.group(1) + ">");
        }

        System.out.println(text);
    }

    private static Matcher extractOpenDivTags(String line){
        return Pattern.compile("<div.*>").matcher(line);
    }

    private static Matcher extractCloseDivTags(String line){
        return Pattern.compile("</div>\\s*<!--\\s*([a-z]+)\\s*-->").matcher(line);
    }

    private static String extractSemanticTag(String line){
        Pattern regex = Pattern.compile("(id|class)\\s*=\\s*\"([a-z]+)\"");
        Matcher matcher = regex.matcher(line);

        if(matcher.find()){
            return matcher.group(2);
        }
        return null;
    }

    private static String replaceOpenTag(String tag){
        String semanticTag = "<" + extractSemanticTag(tag);
        return tag.replaceAll("<div", semanticTag)
                .replaceAll("(id|class)\\s*=\\s*\"([a-z]+)\"", "")
                .replaceAll("\\s+>", ">")
                .replaceAll("\\s{2,}", " ");
    }
}
