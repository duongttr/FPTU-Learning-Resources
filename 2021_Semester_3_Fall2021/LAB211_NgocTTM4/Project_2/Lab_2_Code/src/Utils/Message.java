package Utils;

public class Message {
    
    public enum MessageKind{
        WARNING,
        ERROR,
        SUCCESS,
        INFORMATION
    }

    // warning message, yellow color
    public static void show(String message, MessageKind kind){
        if(kind == MessageKind.WARNING){
            System.out.println(TextColor.create(message, Color.YELLOW));
        }else if(kind == MessageKind.ERROR){
            System.out.println(TextColor.create(message, Color.RED));
        }else if(kind == MessageKind.INFORMATION)
            System.out.println(TextColor.create(message, Color.BLUE));
        else System.out.println(TextColor.create(message, Color.GREEN));
    }
}
