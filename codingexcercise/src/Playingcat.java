public class Playingcat {
    public static void main(String[] args) {
        System.out.println(isCatplaying(true, 38));

    }
    public static boolean isCatplaying (boolean summer, int temperature){
        if (summer == true){
            if (temperature>=25 && temperature<=45){
                return true;
            }
        }
        else if (temperature>=25&&temperature<=35)
            return true;

        return false;

    }
}
