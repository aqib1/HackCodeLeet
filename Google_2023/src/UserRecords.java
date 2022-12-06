record UserRecords(int id, String name) {

    UserRecords {
        if(name.isBlank()) throw new IllegalArgumentException();
    }

    public int getId() {return this.id;}
    public String name(){return this.name;}
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserRecord{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}