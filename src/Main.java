import java.util.*;

public class Main {

    public static void main(String[] args) {

        ArrayList<Album> albums = new ArrayList<>();

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

       LinkedList<Song> playList = new LinkedList<>();
        albums.get(0).addToPlayList("You can't do it right", playList);
        albums.get(0).addToPlayList("Holy man", playList);
        albums.get(0).addToPlayList("Speed king", playList);  // Does not exist
        albums.get(0).addToPlayList(9, playList);
        albums.get(1).addToPlayList(3, playList);
        albums.get(1).addToPlayList(2, playList);
        albums.get(1).addToPlayList(24, playList);  // There is no track 24
        play(playList);
    }

    private static void play(LinkedList<Song> playlist) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean forward = true;
        ListIterator<Song> iterator = playlist.listIterator();
        if (playlist.size() == 0) {
            System.out.println("There is no song in playlist");
            return;
        } else {
            System.out.println("Now playing-->" + iterator.next().toString());
        }
        printMenu();

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();

            switch(action){
                case 0:
                    System.out.println("Playlist completed");
                    quit = true;
                    break;
                case 1:
                    if(!forward){
                        if(iterator.hasNext()){
                            iterator.next();
                        }
                        forward = true;
                    } if(iterator.hasNext()){
                    System.out.println("Now playing-->" + iterator.next().toString());
                }else{
                    System.out.println("We have reached at the end of the list!!");
                    forward = false;
                }
                    break;
                case 2:
                    if(forward){
                        if(iterator.hasPrevious()){
                            iterator.previous();
                        }
                        forward =false;
                    }if(iterator.hasPrevious()){
                    System.out.println("Now playing-->" + iterator.previous().toString());
                }else{
                    System.out.println("We are at the beginning of the playlist!!");
                    forward = true;
                }
                    break;
                case 3:
                    if(forward){
                        if(iterator.hasPrevious()){
                            System.out.println("Replaying-->" + iterator.previous());
                            iterator.next();
                        }else {
                            System.out.println("We have reached at the beginning of the list!!");
                        }
                    }else if(!forward){
                        if (iterator.hasNext()){
                            System.out.println("Replaying-->" + iterator.next());
                            iterator.previous();
                        }else{
                            System.out.println("We have reached at the end of the list!!");
                        }
                    }


                    break;
                case 4:
                    printList(playlist);
                    break;
                case 5:
                    printMenu();
                    break;

            }
        }
    }
    private static void printMenu(){
        System.out.println("Available actions are:");
        System.out.println("0 - to quit\n" +
                "1 - to play next song\n" +
                "2 - to play previous song\n" +
                "3 - to replay the current song\n" +
                "4 - to list songs in the playlist\n" +
                "5 - print available actions");
    }

    private static void printList(LinkedList<Song> playlist){
        Iterator<Song> listIterator = playlist.listIterator();
        System.out.println("=============");
        int trackNumber = 1;
        while(listIterator.hasNext()){
            System.out.println(trackNumber + ". song:"+ listIterator.next().toString());
            trackNumber++;
        }

    }



}
