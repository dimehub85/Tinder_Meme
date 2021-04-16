package dimemtl.com.Model;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.time.LocalDate;
import java.util.Objects;

@DatabaseTable (tableName = "UserInteraction")
public class UserInteraction implements Model<Integer>{
    @DatabaseField
    int id;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    User source;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    User target;
    @DatabaseField
    private String reaction;
    @DatabaseField
    private LocalDate date;

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public UserInteraction(int id, User source, User target, String reaction, LocalDate date) {
        this.id = id;
        this.source = source;
        this.target = target;
        this.reaction = reaction;
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getSource() {
        return source;
    }

    public void setSource(User source) {
        this.source = source;
    }

    public User getTarget() {
        return target;
    }

    public void setTarget(User target) {
        this.target = target;
    }

    public String getReaction() {
        return reaction;
    }

    public void setReaction(String reaction) {
        this.reaction = reaction;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInteraction that = (UserInteraction) o;
        return id == that.id && Objects.equals(source, that.source) && Objects.equals(target, that.target) && Objects.equals(reaction, that.reaction) && Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, source, target, reaction, date);
    }

    @Override
    public String toString() {
        return "UserInteraction{" +
                "id=" + id +
                ", source=" + source +
                ", target=" + target +
                ", reaction='" + reaction + '\'' +
                ", date=" + date +
                '}';
    }
}
