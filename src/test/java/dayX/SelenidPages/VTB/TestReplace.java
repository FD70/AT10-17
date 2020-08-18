package dayX.SelenidPages.VTB;


import org.apache.commons.lang3.StringUtils;

public class TestReplace {
    public static void main(String[] args) {
        String ggg = "7    140".replaceAll("\\s", "");
        System.out.println(ggg);
        System.out.println("1 20".replaceAll("\\s", ""));
        System.out.println(StringUtils.deleteWhitespace("cc  czv zcv zcx vz"));
    }
}
