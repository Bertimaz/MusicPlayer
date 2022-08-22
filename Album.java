import java.util.ArrayList;
import java.util.LinkedList;

/*
Objeto Album
Contem Variaveis: name, artist e um objeto SongList implementado como innerclass
Contem Construtor com variaves name e artist
Override toString para retornar name e duration como string
Métodos:
addSong: adicina musica ao album
addToPlaylist: Adiciona musica selecionada do album a uma playlist fornecida
getAlbumSongs: Retorna o objeto Songlist



*/

public class Album {
    private String name;
    private String artist;
    private SongList songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new SongList();
    }

    @Override
    public String toString() {
        return ("Album name: " + this.name + ". Artist: " + artist);
    }

    public boolean addSong(String title, double duration) { //
        //*addSong(), has two parameters of type String (title of song), double (duration of song) and returns a boolean. Returns true if the song was added successfully or false otherwise. *//*
        return this.songs.add(new Song(title, duration));
    }
    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist) /*Adiciona musica pelo numero */ {
        //Confere se a musica existe no album
        Song checkedSong = this.songs.findSong(trackNumber);
        if (checkedSong != null) /*Se existe, adiciona */ {
            playlist.add(checkedSong);
            return true;
        }
        /*Caso não exista imprime mensagem de erro*/
        System.out.println("there is no track number " + trackNumber + " in the album: " + this.name);
        return false;
    }
    public boolean addToPlayList(String title, LinkedList<Song> playlist) /*Adicina musica pelo titulo*/ {
        //Confere se a musica existe no album
        Song checkedSong = songs.findSong(title);
        if (checkedSong == null) /*Se não existir, imprime erro*/ {
            System.out.println("The song " + title + " is not in the album: " + this.name);
            return false;
        }
        /*Se existir, adicina a playlist*/
        playlist.add(checkedSong);
        return true;

    }
    public ArrayList<Song> getAlbumSongs() {

        return songs.getAlbumSongs();
    }



    /*
     * Objeto Song List contem as músicas do Album
     *
     *
     * */


    private class SongList {
        private ArrayList<Song> songs;

        public SongList()
        {
            this.songs = new ArrayList<Song>();
        }
        public boolean add(Song song) //Contem um parametro do tipo Song. Adiciona a Song caso ela ainda não esteja na lista
        {
            if (songs.contains(song)) {
                return false;
            }
            songs.add(song);
            return true;
        }
        private Song findSong(int trackNumber)/*findSong() Tem uma parametro do tipo int(trackNumber). Retorna a Song se ela existir, nulo se não existir*/
        {
            int indexNumber = trackNumber - 1;
            if (indexNumber >= 0 && indexNumber < this.songs.size()) {
                return songs.get(indexNumber);
            }
            return null;
        }
        private Song findSong(String title) /*findSong() Tem uma parametro do tipo String (titulo). Retorna a Song se ela existir, nulo se não existir*/
        {
            int i = 0;
            while (i < songs.size()) {

                if (title.contentEquals(songs.get(i).getTitle())) {
                    return songs.get(i);
                } else i++;
            }
            return null;
        }
        private ArrayList<Song> getAlbumSongs() {
            return songs;
        }
    }
}




