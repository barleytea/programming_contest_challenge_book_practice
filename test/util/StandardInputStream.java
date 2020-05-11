package util;

import java.io.InputStream;

public class StandardInputStream extends InputStream {
    private static final String lf = System.getProperty("line.separator");
    private final StringBuilder sb = new StringBuilder();

    /**
     *
     */
    public void inputln(String str){
        sb.append(str).append(lf);
    }

    @Override
    public int read() {
        if (sb.length() == 0) {
            return -1;
        }
        final int result = sb.charAt(0);
        sb.deleteCharAt(0);
        return result;
    }
}
