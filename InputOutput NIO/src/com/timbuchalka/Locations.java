package com.timbuchalka;

import java.io.*;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

/**
 * Created by timbuchalka on 2/04/2016.
 */
public class Locations implements Map<Integer, Location> {
    private static Map<Integer, Location> locations = new LinkedHashMap<Integer, Location>();

    public static void main(String[] args) throws IOException {

        Path locPath = FileSystems.getDefault().getPath("locations.dat");
        try(ObjectOutputStream locfile = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(locPath)))){
            for(Location location :locations.values()){
                locfile.writeObject(location);
            }
        }

//        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
//        Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");
//        try (BufferedWriter locFile = Files.newBufferedWriter(locPath);
//             BufferedWriter dirFile = Files.newBufferedWriter(dirPath)) {
//            for (Location location : locations.values()){
//                locFile.write(location.getLocationID() + "," + location.getDescription() + "\n");
//                for (String direction : location.getExits().keySet()){
//                    dirFile.write(location.getLocationID() + "," + direction + ","+
//                            location.getExits().get(direction) + "\n");
//                }
//            }
//        } catch(IOException e) {
//            System.out.println("IOEception " + e.getMessage());
//        }
    }

    static {

        Path locPath = FileSystems.getDefault().getPath("locations.dat");
        try(ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(locPath)))) {
            boolean eof = false;
            while (!eof) {
                try{
                    Location location = (Location) locFile.readObject();
                    System.out.println("Imported -> " + location.getLocationID() + " -> " + location.getDescription());
                    locations.put(location.getLocationID(), location);
                }catch(EOFException e){
                    eof = true;
                    System.out.println("END OF File Reached");
                }
            }
        }catch(ClassNotFoundException e){
            System.out.println("ClassNotFoundEception !!! " + e.getMessage());
        }catch(IOException e){
            System.out.println("Static IOECEPTION Encountered " +e.getMessage());
        }

//        Path locPath = FileSystems.getDefault().getPath("locations_big.txt");
//        Path dirPath = FileSystems.getDefault().getPath("directions_big.txt");
//
//        try (Scanner scanner = new Scanner(Files.newBufferedReader(locPath))) {
//            scanner.useDelimiter(",");
//            while(scanner.hasNextLine()){
//                int locId = scanner.nextInt();
//                scanner.skip(scanner.delimiter());
//                String description = scanner.nextLine();
//                System.out.println("Imported Loc = " + locId +  "->" + description);
//                locations.put(locId , new Location(locId,description,null));
//
//            }
//        }catch (IOException e) {
//            System.out.println("IOEception Encontered " + e.getMessage());
//        }
//
//        try (BufferedReader dirFile = Files.newBufferedReader(dirPath)) {
//            String input;
//            while((input = dirFile.readLine()) != null){
//                String[] data = input.split(",");
//                int locId = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]) ;
//                locations.get(locId).addExit(direction,destination);
//            }
//        }catch (IOException e) {
//            System.out.println("IOEception Encontered " + e.getMessage());
//        }
    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location put(Integer key, Location value) {
        return locations.put(key, value);
    }

    @Override
    public Location remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location> m) {

    }

    @Override
    public void clear() {
        locations.clear();

    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location>> entrySet() {
        return locations.entrySet();
    }
}
