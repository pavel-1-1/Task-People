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
                throw new IllegalArgumentException("Возраст не может быть меньше или равен 0!");
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
                throw new IllegalStateException("Поля имя и фамилия обязательны к заполнению!");
            }
            return new Person(this);
        }
    }
}
