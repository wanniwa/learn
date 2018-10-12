package 注解Annotation.自定义注解;
@Table("tb_student")
public class Student {
    @MyField(columnName = "id", type = "long", length = 10)
    private Long id;
    @MyField(columnName = "id", type = "varchar", length = 10)
    private String name;
    @MyField(columnName = "age", type = "int", length = 3)
    
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
