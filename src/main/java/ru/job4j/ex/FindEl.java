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

    public static void main(String[] args) {
        String[] low = new String[]{"1", "2", "k"};
        try {
            System.out.println(FindEl.indexOf(low, "k"));
        } catch (ElementNoFoundExeption i) {
            i.printStackTrace();
        }
    }

}
