package Utils;

public class Message {
    
    public enum MessageKind{
        WARNING,
        ERROR,
        SUCCESS
    }

    // warning message, yellow color
    public static void show(String message, MessageKind kind){
        if(kind == MessageKind.WARNING){
            System.out.println(TextColor.create(message, Color.YELLOW));
        }else if(kind == MessageKind.ERROR){
            System.out.println(TextColor.create(message, Color.RED));
        }
        System.out.println(TextColor.create(message, Color.GREEN));
    }
}
