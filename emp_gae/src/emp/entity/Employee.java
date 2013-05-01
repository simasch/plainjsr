package emp.entity;

import static javax.persistence.CascadeType.ALL;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.google.appengine.api.datastore.Key;

@Entity
public class Employee {

    @Id
    @GeneratedValue
    private Key id;
    private String firstName;
    private String lastName;
    
    @OneToMany(cascade = ALL)
    private Set<Phone> phones = new HashSet<Phone>();

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }

	public Key getId() {
		return id;
	}

	public void setId(Key id) {
		this.id = id;
	}

}
