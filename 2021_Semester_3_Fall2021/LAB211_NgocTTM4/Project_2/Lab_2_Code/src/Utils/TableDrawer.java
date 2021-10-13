package Utils;
import java.util.List;
import java.util.stream.IntStream;

import Utils.Message.MessageKind;

import java.util.ArrayList;

public class TableDrawer {
    String[] header;
    List<String[]> items;
    int colSize;

    private int[] maxTextSize;
    public TableDrawer(String... header){
        this.header = header;
        this.colSize = header.length;
        items = new ArrayList<>();
        this.maxTextSize = new int[colSize];
        initialize();
    }

    private void initialize(){
        for(int i = 0; i < this.header.length;i++){
            if(this.header[i].length() > maxTextSize[i])
                // set maxTextSize in current column
                maxTextSize[i] = this.header[i].length();
        }
    }

    public void remove(int linePosition){
        if(linePosition >= 0 && linePosition < items.size()){
            items.remove(linePosition);
        }
    }

    public void add(String... inputItem){
        String[] item = new String[colSize];
        try{
            for(int i = 0; i < colSize; i++){
                item[i] = inputItem[i];
                if(item[i].length() > this.maxTextSize[i]){
                    // set maxTextSize in current column
                    maxTextSize[i] = item[i].length();
                }
            }
        }catch(Exception e){
            // nothing to do
        }finally{
            items.add(item);
        }
    }

    

    public void show(boolean showTotalCount){
        resize();
        int sumLength = IntStream.of(maxTextSize).sum();
        // drawing header line
        System.out.println("┏" + sequence('━', sumLength + colSize - 1) + "┓");
        // drawing header
        System.out.print('┃');
        System.out.print(String.join("│", header));
        System.out.println('┃');
        
        // drawing under-header line
        System.out.println("┠" + sequence('─', sumLength + colSize -1) + "┨");

        // drawing item
        for(String[] item: items){
            System.out.print('┃');
            System.out.print(String.join("│", item));
            System.out.println('┃');
        }

        //drawing footer line
        System.out.println("┗" + sequence('━', sumLength + colSize - 1) + "┛");
        if(showTotalCount)
            Message.show("COUNTS: " + items.size(), MessageKind.INFORMATION);
    }

    private void resize(){
        for(int i = 0; i < header.length;i++){
            header[i] = String.format("%-"+maxTextSize[i]+"s", header[i]);
        }

        
        for(int j = 0; j < items.size();j++){
            String[] item = items.get(j);
            for(int i = 0; i < items.get(j).length;i++){
                item[i] = String.format("%-"+maxTextSize[i]+"s", item[i]);
            }
        }

    
    }

    private String sequence(char ch, int time){
        String ret = "";
        for(int i = 0; i < time;i++)
            ret += ch;
        return ret;
    }
}
