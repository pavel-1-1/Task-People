import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Person {
    private final String name;
    private final String surName;
    private int age;
    private String address;

    private Person(PersonBuilder builder) {
        this.name = builder.name;
        this.surName = builder.surName;
        this.age = builder.age;
        this.address = builder.address;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean hasAge() {
        return age != 0;
    }

    public boolean hasAddress() {
        return address != null;
    }

    public void happyBirthday() {
        if (hasAge()) {
            age++;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return new EqualsBuilder().append(age, person.age).append(name, person.name)
                .append(surName, person.surName).append(address, person.address).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(name)
                .append(surName).append(age).append(address).toHashCode();
    }

    @Override
    public String toString() {
        return name + " " + surName;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder().setSurName(this.getSurName()).setAge(this.getAge()).setAddress(this.getAddress());
    }

    public static class PersonBuilder {
        private String name;
        private String surName;
        private int age;
        private String address;

        public PersonBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder setSurName(String surName) {
            this.surName = surName;
            return this;
        }

        public PersonBuilder setAge(int age) {
            if (age <= 0) {
                throw new IllegalArgumentException("?????????????? ???? ?????????? ???????? ???????????? ?????? ?????????? 0!");
            }
            this.age = age;
            return this;
        }

        public PersonBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Person build() {
            if (name == null & surName == null) {
                throw new IllegalStateException("???????? ?????? ?? ?????????????? ?????????????????????? ?? ????????????????????!");
            }
            return new Person(this);
        }
    }
}
