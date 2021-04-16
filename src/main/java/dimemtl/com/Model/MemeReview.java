package dimemtl.com.Model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Objects;

@DatabaseTable(tableName = "MemeReview")
public class MemeReview implements Model<Integer>{
    @DatabaseField
    private int id;
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private User user; //memeId
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Meme meme; //memeId
    @DatabaseField
    private LocalDate date;
    @DatabaseField
    private String rating;
    public MemeReview(){

    }


    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    public MemeReview(int id, User user, Meme meme, LocalDate date, String rating) {
        this.id = id;
        this.user = user;
        this.meme = meme;
        this.date = date;
        this.rating = rating;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Meme getMeme() {
        return meme;
    }

    public void setMeme(Meme meme) {
        this.meme = meme;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemeReview that = (MemeReview) o;
        return id == that.id && Objects.equals(user, that.user) && Objects.equals(meme, that.meme) && Objects.equals(date, that.date) && Objects.equals(rating, that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, meme, date, rating);
    }

    @Override
    public String toString() {
        return "MemeReview{" +
                "id=" + id +
                ", user=" + user +
                ", meme=" + meme +
                ", date=" + date +
                ", rating='" + rating + '\'' +
                '}';
    }
}
