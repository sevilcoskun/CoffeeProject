package tdd;

public class WordWrap {

    public static String wrap(String line, int wrapLength){
        StringBuilder sb = new StringBuilder();
        final int lineLength = line.length();

        sb.append(line, 0, Math.min(lineLength, wrapLength));

        int splitLength = wrapLength;
        while(lineLength > splitLength){
            sb.append('\n');
            sb.append(line, splitLength, Math.min(splitLength + wrapLength, lineLength));
            splitLength += wrapLength;
        }

        return sb.toString();
    }
}
