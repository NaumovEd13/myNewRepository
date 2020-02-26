import java.util.Date;

public class Entity implements Comparable<Entity>{//сущность, которая представляет из себя набор свойств найденных файлов
    private String name;
    private long size;
    private Date date;
    private final String sp = System.getProperty("line.separator");
    public Entity(String name, long size, Date date){
        this.name=name;
        this.size=size;
        this.date=date;
    }
    public String toString(){// в таком виде происходит запись в текстовый файл.
        return "file= "+name+sp+
                " date: "+date+sp+
                " size: "+size+ "bytes";
    }

    @Override
    public int compareTo(Entity o) {// класс реализует Comparable для того, чтобы в итоговом списке происходила сортировка, и это нужно для того, чтобы каждый последующий файл
        //был одинаково упорядочен, а не происходила запись в файл тупо в том же порядке, как запустились потоки и отработали свой run.
        return this.name.compareTo(o.name);
    }
}