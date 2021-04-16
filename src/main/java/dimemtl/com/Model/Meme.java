package dimemtl.com.Model;


import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.time.LocalDate;
import java.util.Objects;

@DatabaseTable(tableName = "Meme")
public class Meme implements Model<Integer> {
    @DatabaseField
    private int id;
    @DatabaseField
    private String link;
    @DatabaseField
    private LocalDate date;

    public Meme(){
    }
    @Override
    public void setId(Integer id) {
        this.id = id;
    }
    @Override
    public Integer getId() {
        return id;
    }

    public Meme(int id, String link, LocalDate date) {
        this.id = id;
        this.link = link;
        this.date = date;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
        Meme meme = (Meme) o;
        return id == meme.id && Objects.equals(link, meme.link) && Objects.equals(date, meme.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, link, date);
    }

    @Override
    public String toString() {
        return "Meme{" +
                "id=" + id +
                ", link='" + link + '\'' +
                ", date=" + date +
                '}';
    }
}
