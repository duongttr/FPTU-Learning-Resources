package Utils;

public class TextColor {
    private static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static String create(String text, Color color){
        if(color == Color.BLACK){
            return ANSI_BLACK + text + ANSI_RESET;
        }else if(color == Color.RED){
            return ANSI_RED + text + ANSI_RESET;
        }else if(color == Color.GREEN){
            return ANSI_GREEN + text + ANSI_RESET;
        }else if(color == Color.YELLOW){
            return ANSI_YELLOW + text + ANSI_RESET;
        }else if(color == Color.BLUE){
            return ANSI_BLUE + text + ANSI_RESET;
        }else if(color == Color.PURPLE){
            return ANSI_PURPLE + text + ANSI_RESET;
        }else if(color == Color.CYAN){
            return ANSI_CYAN + text + ANSI_RESET;
        }
        return text;
    }
}
