import java.util.*;

public class Main {


    //Código cria uma lista com 2 albuns, cria uma playlist com musicas selecionadas destes albuns, e simula um tocador com a playlist criada

    private static ArrayList<Album> albums = new ArrayList<Album>();

    public static void main(String[] args) {

    //Cria album Stormbringer

        Album album = new Album("Stormbringer", "Deep Purple");
        album.addSong("Stormbringer", 4.6);
        album.addSong("Love don't mean a thing", 4.22);
        album.addSong("Holy man", 4.3);
        album.addSong("Hold on", 5.6);
        album.addSong("Lady double dealer", 3.21);
        album.addSong("You can't do it right", 6.23);
        album.addSong("High ball shooter", 4.27);
        album.addSong("The gypsy", 4.2);
        album.addSong("Soldier of fortune", 3.13);
        albums.add(album);

        //Cria Album For Those About To Rock

        album = new Album("For those about to rock", "AC/DC");
        album.addSong("For those about to rock", 5.44);
        album.addSong("I put the finger on you", 3.25);
        album.addSong("Lets go", 3.45);
        album.addSong("Inject the venom", 3.33);
        album.addSong("Snowballed", 4.51);
        album.addSong("Evil walks", 3.45);
        album.addSong("C.O.D.", 5.25);
        album.addSong("Breaking the rules", 5.32);
        album.addSong("Night of the long knives", 5.12);
        albums.add(album);

       //Imprime os Albuns Criados

        int a = 1;
        for (Album currentAlbum : albums) {
            System.out.println("Album " + a + " = " + currentAlbum.toString() + "\n");
            ArrayList<Song> albumSongs = albums.get(0).getAlbumSongs();
            for (int index = 0; index < albumSongs.size(); index++) {
                System.out.println(albumSongs.get(index).toString());
            }

        }


        //Cria Playlist

        LinkedList<Song> playList = new LinkedList<Song>();
        albums.get(0).addToPlayList("You can't do it right", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Speed king", playList);  // Does not exist
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList);  // There is no track 24




        //imprime a playlist

        System.out.println("\nPlaylist 1 \n");
        for (int index = 0; index < playList.size(); index++) {
            System.out.println(playList.get(index).toString());
        }
        System.out.println("\n");


        //toca a playlist
        play(playList);

    }

    private static void play(LinkedList<Song> playList) {
        Scanner scan = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        Song currentSong = null;

        ListIterator<Song> listIterator = playList.listIterator();

        if (playList.size() == 0) {
            System.out.println("This playlist is empty");
            return;
        } else {
            currentSong = listIterator.next();
            System.out.println("Now playing " + currentSong.toString());
            printMenu();

            while (!quit) {
                int option = -1;
                if (scan.hasNextInt()) {
                    option = scan.nextInt();
                    scan.nextLine();
                } else {
                    continue;
                }

                printNumber(option);
                switch (option) {
                    case 0:
                        System.out.println("Closing Playlist");
                        quit = true;
                        break;
                    case 1:
                        if (forward) {
                            if (listIterator.hasNext()) {
                                currentSong = listIterator.next();
                                System.out.println("(1)Now Playing " + currentSong.toString());

                            } else {
                                System.out.println("We have reached the End of the Playlist");
                            }
                        } else {
                            forward = true;
                            if (listIterator.hasNext()) {
                                listIterator.next();
                            }
                            if (listIterator.hasNext()) {
                                currentSong = listIterator.next();
                                System.out.println("(1)Now Playing " + currentSong.toString());

                            } else {
                                System.out.println("We have reached the End of the Playlist");
                            }
                        }
                        break;

                    case 2:
                        System.out.println("Now replaying " + currentSong.toString());
                        break;

                    case 3:
                        if (forward) {
                            if (listIterator.hasPrevious()) {
                                listIterator.previous();
                            }
                            if (listIterator.hasPrevious()) {
                                currentSong = listIterator.previous();
                                forward = false;
                                System.out.println("Now Playing " + currentSong.toString() + ".");

                            } else {
                                System.out.println("(We are at the Beginning of the Playlist.");
                            }
                        } else {
                            if (listIterator.hasPrevious()) {
                                currentSong = listIterator.previous();
                                System.out.println("Now Playing " + currentSong.toString() + ".");
                            } else {
                                System.out.println("We are at the Beginning of the Playlist.");
                            }
                        }
                        break;
                    case 4:

                        System.out.println("Deleting Song " + currentSong.toString() + " From Playlist.");
                        listIterator.remove();
                        if (listIterator.hasNext()) {
                            currentSong = listIterator.next();
                            forward = true;

                        } else if (listIterator.hasPrevious()) {
                            currentSong = listIterator.previous();
                            forward = false;
                        }

                        if (playList.size() == 0) {
                            System.out.println("The Playlist is empty");
                            currentSong = null;
                            quit = true;
                        } else {
                            System.out.println("Now Playing " + currentSong.toString() + ".");
                        }


                        break;
                    case 5:
                        printList(playList);
                        break;
                    case 6:
                        printMenu();
                        break;
                }


            }
        }


    }


    private static void printMenu() {

        System.out.println("\n"+
                "Available Options: \n" +
                "0: Quit\n" +
                "1: Play Next Song\n" +
                "2: Replay Current Song\n" +
                "3: Play Last Song\n" +
                "4: Delete Current Song\n" +
                "5: Print Songs in the Playlist\n" +
                "6: Print Available Options");
    }

    private static void printList(LinkedList<Song> playList) {
        Iterator<Song> iterator = playList.iterator();
        System.out.println("================================");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("================================");
    }


    private static void printNumber(int i) {
        System.out.println("number is " + i);
    }

}

