package ru.job4j.ex;

public class FindEl {

    public static int indexOf(String[] value, String key) throws ElementNoFoundExeption {
        int rsl = -1;
        for (int i = 0; i < value.length; i++) {
            if (value[i].equals(key)) {
                rsl = i;
                break;
            }
        }
        if (rsl == -1) {
            throw new ElementNoFoundExeption("Element not Found");
        }
        return rsl;
    }

    public static boolean sent(String value, String[] abuses) throws ElementNoFoundExeption {
        if (abuses[0].equals(value)) {
            throw new ElementAbuseExeption("Недопустимое значение!");
        }
        return true;
    }

    public static void process(String[] values, String key, String[] abuses) {
        try {
            if (indexOf(values, key) != -1) {
                sent(key, abuses);
                System.out.println(key);
            }
        } catch (ElementAbuseExeption e) {
            e.printStackTrace();
        } catch (ElementNoFoundExeption e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        String[] low = new String[]{"1", "2", "k"};
        String[] abuses = new String[]{"k"};
        process(low, "4", abuses);
    }

}
