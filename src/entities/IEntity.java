package entities;

public interface IEntity extends Comparable<IEntity> {
	Integer getId();
	void setId(int id);
}
