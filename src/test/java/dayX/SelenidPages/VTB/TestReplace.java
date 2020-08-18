package dayX.SelenidPages.VTB;


import org.apache.commons.lang3.StringUtils;

public class TestReplace {
    public static void main(String[] args) {
        String ggg = "7    14,0".replaceAll("\\s", "").replace(",",".");
        System.out.println(ggg);
        System.out.println("1 20".replaceAll("\\s", ""));
        System.out.println(StringUtils.deleteWhitespace("cc  czv zcv zcx vz"));
        Double nnn = Double.parseDouble(ggg);
        System.out.println(nnn);
    }
}
