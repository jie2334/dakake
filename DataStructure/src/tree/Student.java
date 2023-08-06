package tree;

/**
 * @description: Student类实现Comparable接口
 * @author: 22783
 * @date: 2023/7/28
 **/
public class Student implements Comparable<Student> {
    private String name;

    private int id;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        int compareTo = this.name.compareTo(o.name);
        if (compareTo != 0) {
            return compareTo;
        }
        return Integer.compare(this.id,o.id);
    }
}
