package Menu;

public class MenuItem {
    String name;
    MenuTask task;

    public MenuItem(String name, MenuTask task) {
        this.name = name;
        this.task = task;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MenuTask getTask() {
        return task;
    }

    public void setTask(MenuTask task) {
        this.task = task;
    }

}
