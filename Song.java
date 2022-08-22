/* 
Song Object to be added to Albums.
It has two variables: title, duration
It has a simples constructor with all variables
It has a getTitle
Override toString to return title+duration as String

*/


//Objeto Song a ser utilizado por albums.
//Contem duas variaves: title e duration
//Contem um construtor com as variaveis title e duration
//Contem getter
//Override to String para retornar titulo mais duração como String

public class Song {

    private String title;
    private double duration;

    public Song(String title, double duration) {
        this.title = title;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return (title + ": "+ duration);

    }
}



/* 2.Song

         It has two fields, a String called title and a double called duration.

         -A constructor that accepts a String (title of the song) and a double (duration of the song). It initialises title and duration.

         -And two methods, they are:

         -getTitle(), getter for title.

         -toString(), Songs overriding toString method. Returns a String in the following format: "title: duration" */
