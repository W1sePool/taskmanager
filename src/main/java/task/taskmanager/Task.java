package task.taskmanager;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * заявка
 */
public class Task {
	private Long id;// id заявки

	@NotNull(message = "number must be not null")
	private Integer number; // номер заявки
	@NotBlank(message = "name must be not blank")
	private String name; // наименование

	public Task() {
	}

	public Task(Long id, Integer number, String name) {
		this.id = id;
		this.number = number;
		this.name = name;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Task task = (Task) o;
		return Objects.equals(id, task.id) &&
				Objects.equals(number, task.number) &&
				Objects.equals(name, task.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, number, name);
	}

	@Override
	public String toString() {
		return "Task{" +
				"id=" + id +
				", number=" + number +
				", name='" + name + '\'' +
				'}';
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}