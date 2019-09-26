package task.taskmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * заявка
 */
@Entity
public class Task {

	@Id //именно это поле  будем primary key
	@GeneratedValue(strategy = GenerationType.AUTO)//генерируется автоматически Id
	private Long id;// id заявки

	@NotNull(message = "number must be not null")
	private Integer number; // номер заявки
	@NotBlank(message = "name must be not blank")//- не пустая строка.
	private String name; // наименование заявки
	@NotBlank
	private String fromAddress;
	@NotBlank
	private String toAddress;
	@NotBlank
	private String status;
	public Task() {
	}

	public Task(Long id, @NotNull(message = "number must be not null") Integer number, @NotBlank(message = "name must be not blank") String name, @NotBlank String fromAddress, String toAddress, String status) {
		this.id = id;
		this.number = number;
		this.name = name;
		this.fromAddress = fromAddress;
		this.toAddress = toAddress;
		this.status = status;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Task task = (Task) o;
		return Objects.equals(id, task.id) &&
				Objects.equals(number, task.number) &&
				Objects.equals(name, task.name) &&
				Objects.equals(fromAddress, task.fromAddress) &&
				Objects.equals(toAddress, task.toAddress) &&
				Objects.equals(status, task.status);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, number, name, fromAddress, toAddress, status);
	}

	@Override
	public String toString() {
		return "Task{" +
				"id=" + id +
				", number=" + number +
				", name='" + name + '\'' +
				", fromAddress='" + fromAddress + '\'' +
				", toAddress='" + toAddress + '\'' +
				", status='" + status + '\'' +
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

	public String getFromAddress() {
		return fromAddress;
	}

	public void setFromAddress(String fromAddress) {
		this.fromAddress = fromAddress;
	}

	public String getToAddress() {
		return toAddress;
	}

	public void setToAddress(String toAddress) {
		this.toAddress = toAddress;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}