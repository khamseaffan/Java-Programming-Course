package com.company;

import java.io.*;
import java.util.*;

public class Locations implements Map<Integer, Location> {
    private static Map<Integer,Location> locations = new LinkedHashMap<Integer, Location>();


//notion Contain old Io Methode


    public static void main(String[] args) {
        try(ObjectOutputStream locfile = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("locations.dat")))){
            for(Location location : locations.values()){
                locfile.writeObject(location);
            }
        }catch(IOException e){
            System.out.println("File Not Found!!!");
        }

    }


//    public static void main(String[] args) {
//        try( BufferedWriter locationFile = new BufferedWriter (new FileWriter("Location_new.txt")) ;
//             BufferedWriter directionFile= new BufferedWriter(new FileWriter("Direction_new.txt")))
//        {
//            for (Location location : locations.values()){
//                locationFile.write(location.getLocationId() + "," + location.getDescription() + "\n");
//                for (String direction : location.getExits().keySet()){
//                    if (!direction.equalsIgnoreCase("Q")) {
//                        directionFile.write(location.getLocationId() + "," + direction + "," + location.getExits().get(direction) + "\n");
//                    }
//                }
//            }
//        }catch(IOException e){
//            System.out.println("Exception is Running");
//        }
//    }

    static{

        try(ObjectInputStream locFile = new ObjectInputStream(new BufferedInputStream(new FileInputStream("locations.dat")))){
            boolean eof = false;
            while ((!eof)){

                Location location = (Location) locFile.readObject();
                System.out.println("Read location -> " + location.getLocationId() + ", Description -> " + location.getDescription());
                System.out.println("\tTotal " + location.getExits().size() + " Exist");
                locations.put(location.getLocationId(), location);
            }
        }catch(IOException e){
            System.out.println("IOException !!!!!!");
        }catch (ClassNotFoundException c) {
            System.out.println("ClassNotFound !!!!!!");
        }
    }


//    static {
//
//        try(BufferedReader locFile = (new BufferedReader(new FileReader("locations_big.txt"))))
//        {
////            scanner = new Scanner(new FileReader("locations_big.txt"));  //this line is slower
////            scanner.useDelimiter(",");
//            String input;
//            while ((input = locFile.readLine()) != null){  //scanner.hasNextLine()
////                int loc = scanner.nextInt();
////                scanner.skip(scanner.delimiter());
////                String description = scanner.nextLine();
////                System.out.println(loc + "  : " + description);
//                String[] data = input.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String description = data[1];
//                Map<String, Integer> tempExit = new HashMap<>();
//                System.out.println(loc + "  : " + description);
//
//                locations.put(loc,new Location(loc,description,tempExit));
//            }
//        }catch (IOException e){
//            System.out.println("Static Exception\n");
//        }
//
////         Trying TO read Exit File
//        try(BufferedReader dirFile = (new BufferedReader(new FileReader("directions_big.txt"))))
//        {
//            String inputs;
//            while((inputs = dirFile.readLine()) != null){
//                String[] data = inputs.split(",");
//                int loc = Integer.parseInt(data[0]);
//                String direction = data[1];
//                int destination = Integer.parseInt(data[2]);
//
//                System.out.println("Location " + loc +" : " + direction +" => " + destination);
//                Location location = locations.get(loc);
//                location.addExit(direction, destination);
//            }
//        }catch (IOException e){
//            e.printStackTrace();
//        }
//    }


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
        return locations.put(key,value);
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
