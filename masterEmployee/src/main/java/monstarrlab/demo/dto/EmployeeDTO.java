package monstarrlab.demo.dto;

import monstarrlab.demo.model.Position;

import javax.validation.constraints.NotBlank;

public class EmployeeDTO {
    private long id;
    @NotBlank(message = "Không được để trống")
    private String name;
    @NotBlank(message = "Không được để trống")
    private String birthday;
    private long position;

    public EmployeeDTO(long id, String name, String birthday, long position) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
        this.position = position;
    }

    public EmployeeDTO(String name, String birthday, long position) {
        this.name = name;
        this.birthday = birthday;
        this.position = position;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public long getPosition() {
        return position;
    }

    public void setPosition(long position) {
        this.position = position;
    }
}
